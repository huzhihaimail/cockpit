
//工具集合Tools
window.T = {};

/**
 * shiro权限
 */
function hasPermission(permission) {
    if (window.parent.permissions.indexOf(permission) > -1) {
        return true;
    } else {
        return false;
    }
}