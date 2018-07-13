// var shiro = new Vue({
//     el: '#toolbar',
//
//     data: {
//         // menupermissions: []
//     },
//     methods: {
//         // isInArray: function (value) {
//         //     if (shiro.menupermissions.indexOf && typeof(shiro.menupermissions.indexOf) == 'function') {
//         //         var index = shiro.menupermissions.indexOf(value);
//         //         console.log(shiro.menupermissions[0]);
//         //         if (index >= 0) {
//         //             return true;
//         //         }
//         //     }
//         //     return false;
//         // }
//     }
// });

//
// /**
//  * shiro权限
//  */
// function hasPermission(permission) {
//     if (window.parent.permissions.indexOf(permission) > -1) {
//         return true;
//     } else {
//         return false;
//     }
// }
//
// function isInArray(value) {
//     if (window.parent.MENU_PERMISSIONS.indexOf && typeof(window.parent.MENU_PERMISSIONS.indexOf) == 'function') {
//         var index = window.parent.MENU_PERMISSIONS.indexOf(value);
//         console.log(window.parent.MENU_PERMISSIONS[0]);
//         if (index >= 0) {
//             return true;
//         }
//     }
//     return false;
// }