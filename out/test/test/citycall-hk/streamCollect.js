/**
* 收集实例
**/
var tenant = window.tenant || {};
var cs = new Cs({
    aid: tenant.id || '', // 租户id
    clt: tenant.tenantType || 'pc', //终端类型(pc | server | app| h5 )
    pf: tenant.makeDomain || 'demo', // 所属平台
    uid: tenant.userId || '', //用户id
    lc: tenant.loginMode || "" // 登录方式
});
// cs.stream({
//         eid:"测试",
//         tpc:"300mmm",
//         data:{
//             "属性":"12"
//         }
// });



