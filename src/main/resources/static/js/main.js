var $ =jQuery =layui.jquery;
$(function(){
    layui.config({
        base : "js/"
    }).use(['element','jquery'],function(){
        var  element = layui.element,
            $ = layui.jquery;
    $.ajax({
        url: "/moduleShow/getMainData.do",
        async: false,
        type:"post",
        success:function(data){
            if(data.success){
                data = data.data;
                var mainList = $("#mainDiv").find(".panel");
                var totalPoint = 0;
                var realPoint = 0 ;
                for(var i=0;i<data.length;i++){
                    mainList.eq(i).find(".realPoint").text(data[i].realPoint);
                    mainList.eq(i).find(".totalPoint").text(data[i].totalPoint);
                    mainList.eq(i).find(".itemNum").text('材料数：'+data[i].itemNum+'条');
                    mainList.eq(i).find(".moduleName").html(data[i].moduleName);
                    var percentNumber1 = (data[i].realPoint/data[i].totalPoint*100).toFixed(0)+'%';
                    var percentHtml1="<div class='layui-progress-bar layui-bg-green' lay-percent="+percentNumber1+">0%</div>";
                    $(".perProgress"+i).append(percentHtml1);
                    element.progress('demo'+i,percentNumber1);
                    $(".perProgress"+i).children('.layui-progress-bar').html(percentNumber1);
                    mainList.eq(i).find(".moduleName").html(data[i].moduleName);
                    totalPoint+=data[i].totalPoint;
                    realPoint+=data[i].realPoint;

                    $("#module_"+(i+1)).attr("href","/moduleShow/list.do?moduleId="+data[i].moduleId+"&moduleName="+data[i].moduleName);
                }
                initPage(totalPoint,realPoint);
            }else{
                layer.msg(data.msg);
            }
        }
    });
    });
});

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

function goModule(moduleId,moduleName) {
    $("#childFrame").attr("src","/moduleShow/list.do?moduleId="+moduleId+"&moduleName="+moduleName);
}

