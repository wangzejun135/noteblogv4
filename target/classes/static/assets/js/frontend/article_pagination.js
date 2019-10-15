/** Created By Wuwenbin https://wuwenbin.me
 * mail to wuwenbinwork@163.com

 * if you use the code,  please do not delete the comment
 * 如果您使用了此代码，请勿删除此头部注释
 * */
layui.define(function (exports) {
    exports('articlePagination', function (page, size, tpl, first) {
        return nextPage(page, size, tpl, first)
    });
});

var ani =
    '{{# layui.each(d.pageArticle.content, function(index, item){ }}' +
    '<div class="layui-collapse layui-panel layui-article animated fadeInUp">' +
    '   <div class="layui-colla-item">' +
    '       <div class="layui-colla-content layui-show layui-article">' +
    '           <fieldset class="layui-elem-field layui-field-title">' +
    '               <legend class="center-to-head">' +
    '                   <span class="layui-badge" style="background: #F44336;"> {{ item.cate.cnName }}</span>' +
    '                   {{# if(item.top){ }}' +
    '                   <span class="layui-badge layui-bg-cyan"> 置顶</span>' +
    '                   {{# } }}' +
    '       {{# if(item.urlSequence != null && item.urlSequence !=""){ }}' +
    '       <a href="/article/u/{{ item.urlSequence }}">{{ item.title }}</a>' +
    '       {{# }else{ }}' +
    '       <a href="/article/{{ item.id }}">{{ item.title }}</a>' +
    '       {{# } }}' +
    '         </legend>' +
    '               {{# if(item.cover === null || item.cover === ""){ }}' +
    '               <div class="layui-field-box">' +
    '                   &nbsp;&nbsp;&nbsp;&nbsp;{{ item.summary }}...&nbsp;' +
    '       {{# if(item.urlSequence != null && item.urlSequence !=""){ }}' +
    '<a class="loading" href="/article/u/{{ item.urlSequence }}">更多<i class="fa fa-angle-double-right"></i> </a>' +
    '       {{# }else{ }}' +
    '<a class="loading" href="/article/{{ item.id }}">更多<i class="fa fa-angle-double-right"></i> </a>' +
    '       {{# } }}' +
    '               </div>' +
    '               {{# } }}' +
    '               {{# if(item.cover !== null && item.cover !== ""){ }}' +
    '               <div class="layui-field-box has-pic">' +
    '                   <div class="layui-row layui-col-space10">' +
    '                       <div class="layui-col-lg10 layui-col-md10 layui-col-sm10 layui-col-xs12">' +
    '                           &nbsp;&nbsp;&nbsp;&nbsp;{{ item.summary }}...&nbsp;' +
    '       {{# if(item.urlSequence != null && item.urlSequence !=""){ }}' +
    '<a class="loading" href="/article/u/{{ item.urlSequence }}">更多<i class="fa fa-angle-double-right"></i> </a>' +
    '       {{# }else{ }}' +
    '<a class="loading" href="/article/{{ item.id }}">更多<i class="fa fa-angle-double-right"></i> </a>' +
    '       {{# } }}' +
    '                       </div>' +
    '                       <div class="layui-col-lg2 layui-col-md2 layui-col-sm2">' +
    '                           <img src="{{ item.cover }}" class="panel-pic">' +
    '                       </div>' +
    '                   </div>' +
    '               </div>' +
    '               {{# } }}' +
    '               <div class="operation">' +
    '                   <div class="tags">' +
    '                       {{# layui.each(d.articleTagsMap[item.id], function(index1, item1){ }}' +
    '                       <span class="layui-badge-rim" onclick="searchTag(this)"><i class="fa fa-tag"></i> {{ item1.name }}</span>' +
    '                       {{# }); }}' +
    '                   </div>' +
    '                   <div class="info">' +
    '                       <span class="views"><i class="fa fa-thermometer-half"></i> {{ item.view }}<code style="font-family: cursive;">℃</code></span>' +
    '                       <span class="datetime"><i class="fa fa-bullhorn"></i> {{ BMY.dateFormatter(item.post) }}</span>' +
    '                   </div>' +
    '               </div>' +
    '           </fieldset>' +
    '       </div>' +
    '   </div> ' +
    '</div>' +
    '{{# });  }}';

function nextPage(page, size, tpl, first) {
    var s = BMY.getParam("s");
    var c = BMY.getParam("c");
    var t = BMY.getParam("t");
    $.post("/next", {
        limit: size || 10,
        page: page,
        searchStr: s,
        cateId: c,
        tagSearch: t
    }, function (json) {
        if (json.code === BMY.status.ok) {
            tpl(ani).render(json.data, function (html) {
                $("#article-list>.layui-article").remove();
                $("#article-list").prepend(html);
            });
            if (BMY.affix !== undefined && BMY.affix !== null) {
                BMY.affix.reinit();
            }
            if (s !== "" && s !== undefined && s !== null
                || c !== "" && c !== undefined && c !== null) {
                BMY.indexVM.quote.showSearch = true;
                BMY.indexVM.quote.searchCount = json.data.pageArticle.totalElements;
            }
            $(window).resize();
        }

    });
}

function searchTag(span) {
    var s = $(span).text();
    s = s.substring(1);
    location.href = "/index?t=" + s;
}