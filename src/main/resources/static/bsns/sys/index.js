var vm = new Vue({
    el: '#app',
    data: {
        menus: {} // 用户授权菜单
        , loginUserName: null //登陆用户名称
    }
    , methods: {

        // 加载用户授权菜单
        loadMenus: function () {
            $.getJSON(APP_NAME + "/loadMenus", function (r) {
                if (r.code == 0) {
                    vm.menus = r.page;
                } else if (r.code) {
                    alert(r.msg);
                } else {
                    alert(r.msg);
                }
            });
        },
        // 加载用户授权菜单
        getLoginUser: function () {
            $.getJSON(APP_NAME + "/loginUserName", function (r) {
                if (r.code == 0) {
                    vm.loginUserName = r.loginUserName;
                } else if (r.code) {
                    alert(r.msg);
                } else {
                    alert(r.msg);
                }
            });
        }
        ,exit: function(){
            $.ajax({
                type: "POST"
                , url: APP_NAME + "/exit"
                , success: function (r) {

                    // 跳转到登陆页
                    window.location.href = APP_NAME + "/html/sys/login.html";
                }
                , error: function (r) {
                    vm.message = "请求异常";
                }

            });
        }
    },
    created: function () { // vue实例化后执行
        // $.get(APP_NAME + "/sys/menu/queryPermissionByUserName", function (r) {
        //     shiro.menu_permissions = r.model;
        // });
        this.loadMenus();
        this.getLoginUser();
    }

});