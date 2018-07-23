/**
 * 表格显示列
 */
var showColumns = [];

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

                $.ajax({
                    type: "GET",
                    url: APP_NAME + "/sys/dataCenter/colums?tableName=" + table,
                    async: false,
                    success: function (r) {
                        vm.columns = r.columns;
                    }
                });


            // 刷新表格数据
                bsTable.createBootStrapTable(vm.columns, APP_NAME + "/sys/" + vm.moduleName + "/list?tableName=" + table + "&rnd=" + Math.random(), vm.queryOption);
            }

            ,save: function () {
                var table = $('#tableNameId').selectpicker('val');
                var url = APP_NAME + "/sys/dataCenter/export?tableName=" + table;
                window.location.href = url;
            }

        }

    })
;

/**
 * 页面初始化执行
 */
$(function () {
    // 创建BootStrapTable

    // $.ajax({
    //     type: "GET",
    //     url: APP_NAME + "/sys/dataCenter/colums",
    //     async: false,
    //     success: function (r) {
    //         vm.columns = r.columns;
    //     }
    // });
    //
    // bsTable.createBootStrapTable(vm.columns, APP_NAME + "/sys/" + vm.moduleName + "/list?rnd=" + Math.random(), vm.queryOption)
});
