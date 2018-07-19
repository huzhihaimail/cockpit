/**
 * 表格显示列
 */
var showColumns = [
    {
        checkbox: true, width: "2%"
    }
    , {
        title: "序号",
        field: "index",
        width: "3%",
        align: "center",
        formatter: function (value, row, index) { // 设置列序号值，index从0开始
            return index + 1;
        }
    }
    // , {
    //     field: "id",
    //     title: "关系号",
    //     width: "10%",
    //     sortable: false,
    //     sortName: "id" // sortName的值，需配置和数据库保持一致
    // }

    , {
        field: "cityName",
        title: "城市名称",
        width: "20%"
    }
    , {
        field: "jscProjName",
        title: "驾驶舱项目名称",
        width: "15%"
    }
    , {
        field: "jscProjType",
        title: "项目类型",
        width: "15%"
    }
    , {
        field: "jscProjPhase",
        title: "项目阶段",
        width: "15%"
    }
    , {
        field: "yxProjName",
        title: "营销管理系统",
        width: "15%"
    }
    , {
        field: "jyProjName",
        title: "经营管理平台-项目",
        width: "15%"
    }
    , {
        field: "cbProjName",
        title: "成本管理系统",
        width: "15%"
    }
    , {
        field: "cwProjName",
        title: "财务收入预算",
        width: "15%"
    }
    , {
        field: "stId",
        title: "状态",
        width: "15%",
        formatter: function (value, row, index) {
            switch (value) {
                case 1:
                    return "<span class='label label-success'>有效</span>";
                    break;
                case 0:
                    return "<span class='label label-warning'>无效</span>";
                    break;
            }
        }
    }
    // , {
    //     field: "createUser",
    //     title: "创建人ID",
    //     width: "15%",
    //     sortable: false,
    //     sortName: "create_user"
    // }
    , {
        field: "createUserName",
        title: "创建人",
        width: "15%",
        sortable: false,
        sortName: "create_user_name"
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
    //     field: "modifyUser",
    //     title: "修改人",
    //     width: "15%",
    //     sortable: false,
    //     sortName: "modify_user"
    // }
    , {
        field: "modifyDate",
        title: "修改时间",
        width: "20%",
        formatter: function (value, row, index) {
            return new moment(value).format('YYYY-MM-DD HH:mm:ss');
        }
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
            , show: true
            , errorMessage: null // 异常信息
            , title: null // 标题
            , vueQueryParam: { // 查询参数
                keyword: null,
            }
            , model: {} //实体对象(用于新建、修改页面)
            ,tableName: {}
            // 定义模块名称
            , moduleName: "dataCenter"
        }
        , created: function () {
            //加载下拉框表名称
            $.get(APP_NAME + "/sys/dataCenter/tableName", function (r) {
                vm.tableName = r.name;
            });

        }
        ,updated: function () {
            this.$nextTick(function () {//由于数据更改导致的虚拟 DOM 重新渲染和打补丁，在这之后会调用该钩子
                $("#tableNameId").selectpicker('refresh');
                $('#tableNameId').selectpicker('render');
            })
        }
        // 定义方法
        ,methods: {

            // 点击“查询”按钮事件
            query: function () {
                vm.reload();
            }

            ,reload: function () {

                var table = $('#tableNameId').selectpicker('val');

                // 查询条件
                var queryOpt = {
                    'keyword': vm.vueQueryParam.keyword == null ? "" : vm.vueQueryParam.keyword.trim(),
                };

                vm.queryOption = queryOpt;

                // 刷新表格数据
                bsTable.createBootStrapTable(showColumns, APP_NAME + "/sys/" + vm.moduleName + "/list?rnd=" + Math.random(), vm.queryOption);
            }

        }

    })
;

/**
 * 页面初始化执行
 */
$(function () {
    // 创建BootStrapTable
    //bsTable.createBootStrapTable(vm.columns, APP_NAME + "/sys/" + vm.moduleName + "/list?rnd=" + Math.random(), vm.queryOption)
});
