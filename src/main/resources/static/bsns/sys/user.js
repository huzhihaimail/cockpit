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
        field: "userName",
        title: "用户名称",
        width: "10%"
    }
    , {
        field: "nickName",
        title: "昵称",
        width: "10%"
    }
    , {
        field: "mobile",
        title: "手机号",
        width: "20%"
    }
    , {
        field: "email",
        title: "邮箱",
        width: "15%"
    }
    , {
        field: "createDate",
        title: "创建时间",
        width: "20%",
        formatter: function (value, row, index) {
            return new moment(value).format('YYYY-MM-DD HH:mm:ss');
        }
    }
    // , {
    //     field: "updateDate",
    //     title: "最近修改时间",
    //     width: "20%",
    //     formatter: function (value, row, index) {
    //         return new moment(value).format('YYYY-MM-DD HH:mm:ss');
    //     }
    // }
    // , {
    //     field: "operate",
    //     title: "操作",
    //     width: "15%",
    //     formatter: function () {
    //         return '<a href="#" class="btn btn-success btn-sm" @click="initPassword"><i class="fa fa-floppy-o"></i>密码初始化</a>';
    //     }
    // }
];

var setting = {
    view: {
        selectedMulti: false
    },
    check: {
        enable: true
    },
    data: {
        simpleData: {
            enable: true,
            idKey: "menuId",
            pIdKey: "parentId",
            rootPId: -1
        }
    },
    edit: {
        enable: false
    }
};

var ztree;

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
            , btnAdd: true
            , btnUpdate: true
            , btnDelete: true
            , btnInitPassword: true
            , model: {} //实体对象(用于新建、修改页面)
            , roles: [] // 加载角色列表对象
            , userRoles: [] // 用户选择的角色
            , permission: []

            // 定义模块名称
            , moduleName: "user"
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
                vm.userRoles = [];

                // 4. 加载角色列表
                vm.loadRoles();

                //5.加载树控件
                vm.loadTreeCompany('add');
            }

            // 点击“确定”按钮
            , commit: function (el) {
                if (vm.model.id == null) {
                    // 用户名
                    if (vm.model.userName == null || vm.model.userName == "") {
                        vm.errorMessage = "请输入用户名";
                        return;
                    } else {
                        // 用户名
                        if (vm.model.userName.trim() == null || vm.model.userName.trim() == "") {
                            vm.errorMessage = "请输入用户名";
                            return;
                        } else {
                            var flag = null;
                            //判断是否重复
                            $.ajax({
                                url: APP_NAME + "/sys/" + vm.moduleName + "/queryUserInfoByUserName",
                                dataType: 'JSON',
                                async: false,
                                type: 'POST',
                                data: {
                                    "userName": vm.model.userName.trim()
                                },
                                success: function (data, status) {
                                    if (data.code != 0) {
                                        vm.errorMessage = "用户名已重复";
                                        flag = false;
                                    }
                                }
                            });
                            if (flag != null && !flag) {
                                flag = null;
                                return;
                            }
                        }
                    }
                }
                // 用户昵称
                if (vm.model.nickName == null || vm.model.nickName == "") {
                    vm.errorMessage = "请输入用户昵称";
                    return;
                } else {
                    if (vm.model.nickName.trim() == null || vm.model.nickName.trim() == "") {
                        vm.errorMessage = "请输入用户昵称";
                        return;
                    } else {
                        if (vm.model.nickName.length > 6) {
                            vm.errorMessage = "昵称长度不能大于6位";
                            return;
                        }
                    }
                }
                if (vm.model.id == null) {
                    // 密码
                    if (vm.model.password == null || vm.model.password == "") {
                        vm.errorMessage = "请输入密码";
                        return;
                    } else {
                        if (vm.model.password.trim() == null || vm.model.password.trim() == "") {
                            vm.errorMessage = "请输入密码";
                            return;
                        } else {
                            if (vm.model.password.length < 6 || vm.model.password.length > 16) {
                                vm.errorMessage = "密码长度不能小于6位且不能大于16位";
                                return;
                            }
                        }
                    }
                    // 重复密码
                    if (vm.model.newPassword == null || vm.model.newPassword == "") {
                        vm.errorMessage = "请输入确认密码";
                        return;
                    }
                    else {
                        if (vm.model.newPassword.trim() == null || vm.model.newPassword.trim() == "") {
                            vm.errorMessage = "请输入确认密码";
                            return;
                        } else {
                            if (vm.model.newPassword != vm.model.password) {
                                vm.errorMessage = "两次密码输入不一致";
                                return;
                            }
                        }
                    }
                }
                // 邮箱
                if (vm.model.email == null || vm.model.email == "") {
                    vm.errorMessage = "请输入邮箱";
                    return;
                } else {
                    if (vm.model.email.trim() == null || vm.model.email.trim() == "") {
                        vm.errorMessage = "请输入邮箱";
                        return;
                    } else {
                        // 定义校验规则
                        var regEmail = /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/;
                        flag = regEmail.test(vm.model.email);
                        // 规则校验：不符合规则则给出提示
                        if (!flag) {
                            vm.errorMessage = "请正确填写邮箱";
                            return;
                        }
                    }
                }

                // 手机号码
                if (vm.model.mobile == null || vm.model.mobile == "") {
                    vm.errorMessage = "请输入手机号码";
                    return;
                } else {
                    if (vm.model.mobile.trim() == null || vm.model.mobile.trim() == "") {
                        vm.errorMessage = "请输入手机号码";
                        return;
                    } else {
                        // 定义校验规则
                        var regPhone = /^1[3|4|5|6|7|8|9]\d{9}$/;
                        flag = regPhone.test(vm.model.mobile);
                        // 规则校验：不符合规则则给出提示
                        if (!flag) {
                            vm.errorMessage = "请正确填写手机号码";
                            return;
                        }
                    }
                }

                // 角色
                if (vm.userRoles == null || vm.userRoles == "") {
                    vm.errorMessage = "请选择角色";
                    return;
                }

                // 城市公司
                var nodes = ztree.getCheckedNodes(true);
                if (nodes == null || nodes == "") {
                    vm.errorMessage = "请选择城市公司";
                    return;
                }

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
                // 获取到的用户配置的角色列表添加到后台参数
                vm.model.userRoles = vm.userRoles;

                var nodes = ztree.getCheckedNodes(true);

                var orgIdList = new Array();
                for (var i = 0; i < nodes.length; i++) {
                    orgIdList.push(nodes[i].menuId);
                }
                vm.model.orgIdList = orgIdList;

                // 2. 入库
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
                // 加载角色列表
                vm.loadRoles();

                $.get(APP_NAME + "/sys/" + vm.moduleName + "/" + ids[0], function (r) {
                    vm.show = false;
                    vm.title = PAGE_UPDATE_TITLE;
                    vm.model = r.model;
                    vm.userRoles = r.model.rolesList;
                });

                //加载城市公司信息
                vm.loadTreeCompany('update');

            }
            // 执行修改操作
            ,
            doUpdate: function () {
                vm.model.userRoles = vm.userRoles;

                var nodes = ztree.getCheckedNodes(true);

                var orgIdList = new Array();
                for (var i = 0; i < nodes.length; i++) {
                    orgIdList.push(nodes[i].menuId);
                }
                vm.model.orgIdList = orgIdList;
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

            // 加载角色列表
            ,
            loadRoles: function () {
                $.get(APP_NAME + "/sys/" + vm.moduleName + "/loadRoles", function (r) {
                    vm.roles = r.page;
                });
            }
            ,
            loadTreeCompany: function (type) {
                function getMenuJson(url, data) {
                    var zNodes;
                    var user = {id: data};
                    $.ajax({
                        url: url,
                        dataType: 'JSON',
                        type: 'POST',
                        data: user,
                        async: false,
                        success: function (data, status) {
                            var nodes = JSON.stringify(data.model);
                            zNodes = eval(nodes);
                        }
                    });
                    return zNodes;
                }

                if (type == 'add') {
                    var data = null;
                    ztree = $.fn.zTree.init($("#menuTree"), setting, getMenuJson(APP_NAME + "/sys/org/queryOrgTreeForUser", data));
                }
                else if (type == 'update') {
                    var ids = bsTable.getMultiRowIds();
                    var data = ids[0];
                    ztree = $.fn.zTree.init($("#menuTree"), setting, getMenuJson(APP_NAME + "/sys/org/queryOrgTreeForUpdateUser", data));
                }

            }
            ,
            initPassword: function () {
                // 获取所选择选择数据行的ID（可能选择多行）
                var ids = bsTable.getMultiRowIds();
                // 校验只能选择一行
                if (ids.length != 1) {
                    alert(PAGE_SELECT_ONE);
                    return;
                }
                $.ajax({
                    type: "POST",
                    url: APP_NAME + "/sys/" + vm.moduleName + "/initPassword",
                    contentType: "application/json",
                    data: JSON.stringify(ids),
                    success: function (r) {
                        if (r.code == 0) {
                            alert("初始化成功，密码重置为：111111", function (index) {
                                vm.reload();
                            });
                        } else if (r.code) {
                            alert(r.msg);
                        }
                    }
                });

            }
        }
    })
;

/**
 * 页面初始化执行
 */
$(function () {

    // 创建BootStrapTable
    bsTable.createBootStrapTable(vm.columns, APP_NAME + "/sys/" + vm.moduleName + "/list?rnd=" + Math.random(), vm.queryOption)
});




