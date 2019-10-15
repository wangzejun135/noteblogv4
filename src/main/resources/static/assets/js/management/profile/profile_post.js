/** Created By Wuwenbin https://wuwenbin.me
 * mail to wuwenbinwork@163.com

 * if you use the code,  please do not delete the comment
 * 如果您使用了此代码，请勿删除此头部注释
 * */
layui.use(['element', 'form', 'layer'], function () {
    var form = layui.form;
    var element = layui.element;
    var $ = layui.$;
    element.render();
    form.render();


    var post = function (data) {
        //markdown文本
        data.field.mdContent = editorMd.getMarkdown();
        //html文本
        data.field.content = editorMd.getHTML();
        $.ajax({
            type: "post"
            , url: BMY.url.prefix + "/profile/create"
            , dataType: "json"
            , data: data.field
            , success: function (json) {
                BMY.msgHandle(json, function () {
                    if (json.code === 200) {
                        location.hash = vipspa.stringifyDefault("/profile");
                    }
                })
            }
        });
    };


    //监听提交
    form.on('submit(profilePostSubmit)', function (data) {
        post(data);
        return false;
    });

});


$(function () {
    $("#profile-content-editor").append("<div id='editormd'></div>");
    $.getScript("/static/plugins/editormd/editormd.min.js", function () {
        editorMd = editormd("editormd", {
            height: 640,
            watch: true,
            codeFold: true,
            toolbarIcons: function () {
                return [
                    "undo", "redo", "|",
                    "bold", "del", "italic", "quote", "ucwords", "uppercase", "lowercase", "|",
                    "h1", "h2", "h3", "h4", "h5", "h6", "|",
                    "list-ul", "list-ol", "hr", "|",
                    "link", "reference-link", "image", "code", "preformatted-text", "code-block", "table", "datetime", "html-entities", "pagebreak", "|",
                    "goto-line", "watch", "preview", "fullscreen", "clear", "search", "|",
                    "help", "info"
                ]
            },
            pluginPath: '/static/plugins/editormd/plugins/',
            markdown: "",
            path: '/static/plugins/editormd/lib/',
            placeholder: '请在此书写你的内容',
            saveHTMLToTextarea: true,
            imageUpload: true,
            imageFormats: ["jpg", "jpeg", "gif", "png", "bmp"],
            imageUploadURL: BMY.url.prefix + "/upload/editorMD?reqType=lay",
            onfullscreen: function () {
                $(".layui-header").css("z-index", "-1");
                $("#left-menu").css("z-index", "-1");
                $(".layui-form-item>label,.layui-form-item>div:not(#profile-content-editor)").css("z-index", -1);
                $(".layui-card").css("z-index", "-1");
            },
            onfullscreenExit: function () {
                $(".layui-header").css("z-index", "999");
                $("#left-menu").css("z-index", "999");
                $(".layui-form-item>label,.layui-form-item>div:not(#profile-content-editor)").css("z-index", "");
                $(".layui-card").css("z-index", "999");
            }
        });
    });
});



