/** Created By Wuwenbin https://wuwenbin.me
 * mail to wuwenbinwork@163.com

 * if you use the code,  please do not delete the comment
 * 如果您使用了此代码，请勿删除此头部注释
 * */
layui.use(['form', 'jquery'], function () {
    var form = layui.form;
    window.$ = layui.$;
    form.verify({
        username: function (value) {
            if (!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)) {
                return '用户名不能有特殊字符';
            }
            if (/(^\_)|(\__)|(\_+$)/.test(value)) {
                return '用户名首尾不能出现下划线\'_\'';
            }
            if (/^\d+\d+\d$/.test(value)) {
                return '用户名不能全为数字';
            }
            if (value.length < 4 || value.length > 12) {
                return "用户名必须4~12位，且不能包含空格";
            }
        }
        , pass: [
            /^[\S]{6,12}$/
            , '密码必须6到12位，且不能出现空格'
        ]
    });

    form.on('submit(bmySubmit)', function (data) {
        data.field.bmyPass = md5(data.field.bmyPass);
        data.field.requestType = "simple";
        BMY.ajax("/login", data.field, function (resp) {
                if (resp.code === BMY.status.ok) {
                    layer.msg("登录成功！");
                    setTimeout(function () {
                        location.href = BMY.url.manage_index;
                    }, 1000);
                } else if (resp.code === -1) {
                    location.reload();
                } else {
                    $("#NB-user-vercode").trigger("click");
                    layer.msg("登录失败，" + resp.message);
                }
            }
        );
        return false;
    });

});

//验证码图片刷新
function captchaRefresh(img) {
    $(img).attr("src", "/image/code?t=" + Math.random());
}