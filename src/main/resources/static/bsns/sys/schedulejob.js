/**
 * Created by huaijie on 2017/9/25.
 */

/**
 * 表格显示列
 */
var showColumns = [
    {
        checkbox: true, width: "2%"
    }
    , {
        title: "序号",
        field: "id",
        width: "3%",
        align: "center",
        formatter: function (value, row, index) { // 设置列序号值，index从0开始
            return index + 1;
        }
    }
    , {
        field: "jobName",
        title: "名称",
        width: "20%"
    }
    , {
        field: "jobGroup",
        title: "分组",
        width: "10%"
    }
    , {
        field: "jobStatus",
        title: "状态",
        width: "7%",
        formatter: function (value, row, index) {
            if (value == '0') {
                return "<span class='label label-danger'>停用</span>";
            } else {
                return "<span class='label label-success'>启用</span>";
            }
        }
    }
    , {
        field: "cronExpression",
        title: "cron表达式",
        width: "10%"
    }
    , {
        field: "description",
        title: "描述",
        width: "20%",
    }
    , {
        field: "springId",
        title: "类名",
        width: "15%",
    }
    , {
        field: "methodName",
        title: "方法名",
        width: "15%",
    }
];



// 通用表格对象
var bsTable = new BootStrapTable();
// 如果有特殊表格需要处理，此处可以覆写覆写自己的表格属性 BootStrapTable.prototype.initBootstrapTable = function (columns, url, queryOpt) {}

// 定义vue实例
var vm = new Vue({
    el: "#" + VUE_EL
    , data: {

        /* 定义bootstrap-table表格参数 */
        queryOption: {}
        , columns: showColumns

        /* 定义页面操作参数 */
        , show: true// 切换页面中的查询和新建（编辑）页面
        , showPwd: true // 显示修改密码框
        , errorMessage: null // 异常信息
        , title: null // 标题
        , vueQueryParam: { // 查询参数
            keyword: null,
        }
        , model: {} //实体对象(用于新建、修改页面)
        , roles: [] // 加载角色列表对象
        , userRoles: [] // 用户选择的角色
        , permission: []
        , cityInfo:false

        // 定义模块名称
        , moduleName: "schedulejob"
    }
    // 定义方法
    , methods: {

        // 点击“查询”按钮事件
        query: function () {
            vm.reload();
        }

        // 点击“新增”按钮
        , save: function (event) {
            // 1. 隐藏表格，显示添加页面
            vm.showPwd = true;
            vm.show = false;
            vm.errorMessage = null;

            // 2. 设置标题
            vm.title = PAGE_INSERT_TITLE;
            // 3. 清空表单数据
            vm.model = {};

        }

        // 点击“确定”按钮
        , commit: function (el) {
            if (vm.model.jobName==null||vm.model.jobName==""){
                vm.errorMessage="请输入任务名称";
                return;
            }
            if (vm.model.jobGroup==null||vm.model.jobGroup==""){
                vm.errorMessage="请输入任务分组";
                return;
            }
            if (vm.model.cronExpression==null||vm.model.cronExpression==""){
                vm.errorMessage="请输入cron表达式";
                return;
            }
            if (vm.model.description==null||vm.model.description==""){
                vm.errorMessage="请输入描述";
                return;
            }
            if (vm.model.springId==null||vm.model.springId==""){
                vm.errorMessage="请输入spring bean";
                return;
            }
            if (vm.model.methodName==null||vm.model.methodName==""){
                vm.errorMessage="请输入方法名";
                return;
            }

            vm.model.isConcurrent=0

            // 执行新增操作
            if (vm.model.id == null) {
                vm.doSave();
                return;
            }

            // 执行修改操作
            vm.doUpdate();
        }
        // 执行保存操作
        ,
        doSave: function () {

            // 1. 入库
            $.ajax({
                type: "POST",
                url: APP_NAME + "/sys/" + vm.moduleName + "/insert",
                contentType: "application/json",
                data: JSON.stringify(vm.model),
                success: function (r) {
                    if (r.code === 0) {
                        alert(PAGE_OPERATOR_SUCCESS, function (index) {
                            vm.reload();
                        });
                    } else if (r.code) {
                        alert(r.msg);
                    } else {
                        alert(r.msg);
                    }
                }
            });
            vm.vueQueryParam.keyword = null;
        }
        // 显示修改页面
        ,
        update: function () {

            // 隐藏密码框
            vm.showPwd = false;
            vm.errorMessage = null;

            // 获取所选择选择数据行的ID（可能选择多行）
            var ids = bsTable.getMultiRowIds();

            // 校验只能选择一行
            if (ids.length != 1) {
                alert(PAGE_SELECT_ONE);
                return;
            }
            $.get(APP_NAME + "/sys/" + vm.moduleName + "/" + ids[0], function (r) {
                vm.show = false;
                vm.title = PAGE_UPDATE_TITLE;
                vm.model = r.model;
            });
        }
        // 执行修改操作
        ,
        doUpdate: function () {

            // 执行修改
            $.ajax({
                type: "POST",
                url: APP_NAME + "/sys/" + vm.moduleName + "/update",
                contentType: "application/json",
                data: JSON.stringify(vm.model),
                success: function (r) {
                    if (r.code === 0) {
                        alert(PAGE_OPERATOR_SUCCESS, function (index) {
                            vm.reload();
                        });
                    } else if (r.code) {
                        alert(r.msg);
                    } else {
                        alert(r.msg);
                    }
                }
            });
            vm.vueQueryParam.keyword = null;
        }

        // 点击“删除”按钮
        ,
        del: function (event) {

            // 获取选择记录ID
            var ids = bsTable.getMultiRowIds();

            // 校验未选择任何一行
            if (ids == null || ids.length <= 0) {
                alert(PAGE_SELECT_ONE);
                return;
            }

            confirm(PAGE_ARE_YOU_SURE_DEL, function () {
                $.ajax({
                    type: "POST",
                    url: APP_NAME + "/sys/" + vm.moduleName + "/delete",
                    contentType: "application/json",
                    data: JSON.stringify(ids),
                    success: function (r) {
                        if (r.code == 0) {
                            alert(PAGE_OPERATOR_SUCCESS, function (index) {
                                vm.reload();
                            });
                        } else if (r.code) {
                            alert(r.msg);
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        }

        // 定时器启用按钮
        ,
        changeStart: function (event) {

            // 获取选择记录ID
            var ids = bsTable.getMultiRowIds();

            // 校验只能选择一行
            if (ids.length != 1) {
                alert(PAGE_SELECT_ONE);
                return;
            }

            confirm(PAGE_ARE_YOU_SURE_DEL, function () {
                $.ajax({
                    type: "POST",
                    url: APP_NAME + "/sys/" + vm.moduleName + "/changeJobStart",
                    contentType: "application/json",
                    data: JSON.stringify(ids),
                    success: function (r) {
                        if (r.code == 0) {
                            alert(PAGE_OPERATOR_SUCCESS, function (index) {
                                vm.reload();
                            });
                        } else if (r.code) {
                            alert(r.msg);
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        }

        // 定时器启用按钮
        ,
        changeStop: function (event) {

            // 获取选择记录ID
            var ids = bsTable.getMultiRowIds();

            // 校验未选择任何一行
            if (ids == null || ids.length <= 0) {
                alert(PAGE_SELECT_ONE);
                return;
            }

            confirm(PAGE_ARE_YOU_SURE_DEL, function () {
                $.ajax({
                    type: "POST",
                    url: APP_NAME + "/sys/" + vm.moduleName + "/changeJobStop",
                    contentType: "application/json",
                    data: JSON.stringify(ids),
                    success: function (r) {
                        if (r.code == 0) {
                            alert(PAGE_OPERATOR_SUCCESS, function (index) {
                                vm.reload();
                            });
                        } else if (r.code) {
                            alert(r.msg);
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        }

        // 重新加载(ok)
        ,
        reload: function () {

            // 展示查询列表
            vm.show = true;

            // 查询条件
            var queryOpt = {
                'keyword': vm.vueQueryParam.keyword == null ? "" : vm.vueQueryParam.keyword.trim(),
            };

            vm.queryOption = queryOpt;

            // 刷新表格数据
            bsTable.createBootStrapTable(showColumns, APP_NAME + "/sys/" + vm.moduleName + "/list?rnd=" + Math.random(), vm.queryOption);
        }

    }
});
//
// $(function () {
//     $("#jqGrid").jqGrid({
//         url: '../sys/schedulejob/list',
//         datatype: "json",
//         colModel: [
//             { label: 'id', name: 'id', index: 'id', width: 50, key: true ,hidden: true  },
//             { label: '', name: 'jobId', index: 'job_id', width: 80 ,hidden: true },
//             { label: '名称', name: 'jobName', index: 'job_name', width: 80 },
//             { label: '分组', name: 'jobGroup', index: 'job_group', width: 80 },
//             { label: '状态', name: 'jobStatus', index: 'job_status', width: 50 , formatter: function(value, options, row){
//                 return value === '0' ?
//                     '<span class="label label-danger">停用</span>' :
//                     '<span class="label label-success">启用</span>';
//             }},
//             { label: 'cron表达式', name: 'cronExpression', index: 'cron_expression', width: 90 },
//             { label: '描述', name: 'description', index: 'description', width: 80 },
//             { label: '类路径', name: 'beanClass', index: 'bean_class', width: 80 },
//             { label: '并行运行', name: 'isConcurrent', index: 'is_concurrent', width: 60 ,formatter: function(value, options, row){
//                 return value === '0' ?
//                     '<span class="label label-success">是</span>' :
//                     '<span class="label label-danger">否</span>';
//             } },
//             { label: 'spring bean', name: 'springId', index: 'spring_id', width: 80 },
//             { label: '方法名', name: 'methodName', index: 'method_name', width: 90 },
//             { label: '创建时间', name: 'createTime', index: 'create_time', width: 110 },
//             { label: '更新时间', name: 'updateTime', index: 'update_time', width: 110 }
//         ],
//         viewrecords: true,
//         height: 385,
//         rowNum: 10,
//         rowList : [10,30,50],
//         rownumbers: true,
//         rownumWidth: 25,
//         autowidth:true,
//         multiselect: true,
//         pager: "#jqGridPager",
//         jsonReader : {
//             root: "page.list",
//             page: "page.currPage",
//             total: "page.totalPage",
//             records: "page.totalCount"
//         },
//         prmNames : {
//             page:"page",
//             rows:"limit",
//             order: "order"
//         },
//         gridComplete:function(){
//             //隐藏grid底部滚动条
//             $("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
//         }
//     });
// });
//
// var vm = new Vue({
//     el:'#rrapp',
//     data:{
//         showList: true,
//         title: null,
//         bgSysScheduleJob: {
//             queryData:null
//         }
//     },
//     methods: {
//         query: function () {
//             vm.reload();
//         },
//         add: function(){
//             vm.showList = false;
//             vm.title = "新增";
//             vm.bgSysScheduleJob = {isConcurrent:"1"};
//         },
//         update: function (event) {
//             var id = getSelectedRow();
//             if(id == null){
//                 return ;
//             }
//             $.ajax({
//                 type:"GET",
//                 url:"../sys/schedulejob/info/"+id,
//                 contentType:"application/json",
//                 success: function (r) {
//                     if(r.code==='0'){
//                         vm.bgSysScheduleJob= r.bgSysScheduleJob;
//                         vm.showList = false;
//                         vm.title = "修改";
//                     }else if (r.code) {
//                         alert(ERROR_CODE_MSG[r.code]);
//                     }else{
//                         alert(r.msg);
//                     }
//
//                 }
//             });
//
//         },
//         saveOrUpdate: function (event) {
//             var url = vm.bgSysScheduleJob.id == null ? "../sys/schedulejob/save" : "../sys/schedulejob/update";
//             $.ajax({
//                 type: "POST",
//                 url: url,
//                 contentType: "application/json",
//                 data: JSON.stringify(vm.bgSysScheduleJob),
//                 success: function(r){
//                     if(r.code === '0' ){
//                         alert('操作成功', function(index){
//                             vm.reload();
//                         });
//                     }else if (r.code) {
//                         alert(ERROR_CODE_MSG[r.code]);
//                     }else{
//                         alert(r.msg);
//                     }
//                 }
//             });
//         },
//         del: function (event) {
//             var id = getSelectedRow();
//             if(id == null){
//                 return ;
//             }
//
//             confirm('确定要删除选中的记录？', function(){
//                 $.ajax({
//                     type: "POST",
//                     url: "../sys/schedulejob/delete",
//                     contentType: "application/json",
//                     data: JSON.stringify(id),
//                     success: function(r){
//                         if(r.code == '0' ){
//                             alert('操作成功', function(index){
//                                 $("#jqGrid").trigger("reloadGrid");
//                             });
//                         }else if (r.code) {
//                             alert(ERROR_CODE_MSG[r.code]);
//                         }else{
//                             alert(r.msg);
//                         }
//                     }
//                 });
//             });
//         },
//         changeStart: function (event) {
//             var id = getSelectedRow();
//             if(id == null){
//                 return ;
//             }
//
//
//             $.ajax({
//                 type: "POST",
//                 url: "../sys/schedulejob/changeJobStart",
//                 contentType: "application/json",
//                 data: JSON.stringify(id),
//                 success: function(r){
//                     if(r.code == '0' ){
//                         alert('操作成功', function(index){
//                             $("#jqGrid").trigger("reloadGrid");
//                         });
//                     }else if (r.code) {
//                         alert(ERROR_CODE_MSG[r.code]);
//                     }else{
//                         alert(r.msg);
//                     }
//                 }
//             });
//
//         },
//         changeStop: function (event) {
//             var id = getSelectedRow();
//             if(id == null){
//                 return ;
//             }
//
//
//             $.ajax({
//                 type: "POST",
//                 url: "../sys/schedulejob/changeJobStop",
//                 contentType: "application/json",
//                 data: JSON.stringify(id),
//                 success: function(r){
//                     if(r.code == '0' ){
//                         alert('操作成功', function(index){
//                             $("#jqGrid").trigger("reloadGrid");
//                         });
//                     }else if (r.code) {
//                         alert(ERROR_CODE_MSG[r.code]);
//                     }else{
//                         alert(r.msg);
//                     }
//                 }
//             });
//
//         },
//         getInfo: function(id){
//             $.get("../sys/schedulejob/info/"+id, function(r){
//                 vm.bgSysScheduleJob = r.bgSysScheduleJob;
//             });
//         },
//         reload: function (event) {
//             vm.showList = true;
//             $("#jqGrid").jqGrid('setGridParam',{
//                 postData:{
//                     queryData: vm.bgSysScheduleJob.queryData == null ? "":vm.bgSysScheduleJob.queryData.trim()
//                 },
//                 page:1
//             }).trigger("reloadGrid");
//         }
//     }
// });

/**
 * 页面初始化执行
 */
$(function () {

    // 创建BootStrapTable
    bsTable.createBootStrapTable(vm.columns, APP_NAME + "/sys/" + vm.moduleName + "/list?rnd=" + Math.random(), vm.queryOption)
});