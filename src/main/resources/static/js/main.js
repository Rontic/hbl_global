var $ =jQuery =layui.jquery;
$(function(){
    initPageData();
});

function initPageData() {
    layui.config({
        base : "js/"
    }).use(['element','jquery'],function(){
        var  element = layui.element;

        //直接取index页面的module数据，避免再次请求
        var liList = $("#leftModule",parent.document).find("li");
        var mainList = $("#mainDiv").find(".panel");
        var sumTotalPoint = 0;
        var sumRealPoint = 0 ;
        for(var i=0;i<liList.length;i++){
            var moduleName = liList.eq(i).find(".moduleName").val();
            var moduleId = liList.eq(i).find(".moduleId").val();
            var realPoint = Number(liList.eq(i).find(".realPoint").val());
            var totalPoint = Number(liList.eq(i).find(".totalPoint").val());
            var itemNum = Number(liList.eq(i).find(".itemNum").val());
            mainList.eq(i).find(".realPoint").text(realPoint);
            mainList.eq(i).find(".totalPoint").text(totalPoint);
            mainList.eq(i).find(".itemNum").text('材料数：'+itemNum+'条');
            mainList.eq(i).find(".moduleName").html(moduleName);
            var percentNumber1 = (realPoint/totalPoint*100).toFixed(0)+'%';
            var percentHtml1="<div class='layui-progress-bar layui-bg-green' lay-percent="+percentNumber1+">0%</div>";
            $(".perProgress"+i).append(percentHtml1);
            element.progress('demo'+i,percentNumber1);
            $(".perProgress"+i).children('.layui-progress-bar').html(percentNumber1);
            mainList.eq(i).find(".moduleName").html(moduleName);
            sumTotalPoint+=totalPoint;
            sumRealPoint+=realPoint;

            $("#module_"+(i+1)).attr("href","/moduleShow/list.do?moduleId="+moduleId+"&moduleName="+moduleName+"&realPoint="+realPoint+"&totalPoint="+totalPoint);
        }
        initPage(sumTotalPoint,sumRealPoint);
    });
}
function initPage(totalPoint,realPoint) {
    layui.config({
        base : "js/"
    }).use(['element','jquery'],function(){
          var  element = layui.element,
            $ = layui.jquery;
        var percentNumber=(realPoint/totalPoint*100).toFixed(0)+'%';
        // $("#getScore").html("得分情况:"+realPoint+"/"+totalPoint);
        $("#allScore").html(realPoint+"/"+totalPoint);
        var percentHtml="<div class='layui-progress-bar layui-bg-green' lay-percent="+percentNumber+">0%</div>";
        $("#demoPercent").append(percentHtml);
        element.progress('demo',percentNumber);
        $('#demoPercent').children('.layui-progress-bar').html(percentNumber);
    });
}

