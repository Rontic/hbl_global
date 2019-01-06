var $ = jQuery = layui.jquery;
//屏幕宽度自适应
(function (doc, win) {
    var docEl = doc.documentElement,
        resizeEvt =
            "orientationchange" in window ? "orientationchange" : "resize",
        recalc = function () {
            var clientWidth = docEl.clientWidth;
            if (!clientWidth) return;
            docEl.style.fontSize = clientWidth / 16 + "px";
        };
    if (!doc.addEventListener) return;
    win.addEventListener(resizeEvt, recalc, false);
    doc.addEventListener("DOMContentLoaded", recalc, false);
})(document, window);

$(function () {
    layui.config({
        base: "js/"
    }).use(['element', 'jquery'], function () {
        var element = layui.element,
            $ = layui.jquery;
        $.ajax({
            url: "/moduleShow/getMainData.do",
            async: false,
            type: "post",
            success: function (data) {
                if (data.success) {
                    var lineData = data.data.lineData;
                    data = data.data.moduleList;
                    console.log(data)
                    var mainList = $("#mainDiv").find(".panel");
                    var totalPoint = 0;
                    var realPoint = 0;
                    for (var i = 0; i < data.length; i++) {
                        mainList.eq(i).find(".realPoint").text(data[i].realPoint);
                        mainList.eq(i).find(".totalPoint").text(data[i].totalPoint);
                        mainList.eq(i).find(".itemNum").text('材料数：' + data[i].itemNum + '条');
                        mainList.eq(i).find(".moduleName").html(data[i].moduleName);
                        var percentNumber1 = (data[i].realPoint / data[i].totalPoint * 100).toFixed(0) + '%';
                        var percentHtml1 = "<div class='layui-progress-bar layui-bg-green' lay-percent=" + percentNumber1 + ">0%</div>";
                        $(".perProgress" + i).append(percentHtml1);
                        element.progress('demo' + i, percentNumber1);
                        $(".perProgress" + i).children('.layui-progress-bar').html(percentNumber1);
                        mainList.eq(i).find(".moduleName").html(data[i].moduleName);
                        totalPoint += data[i].totalPoint;
                        realPoint += data[i].realPoint;

                        $("#module_" + (i + 1)).attr("href", encodeURI("/moduleShow/list.do?moduleId=" + data[i].moduleId + "&realPoint=" + data[i].realPoint+ "&totalPoint=" + data[i].totalPoint+ "&moduleName=" + data[i].moduleName));

                        var color = ["#14D56C", "#F55438", "#F39502", "#10A9E3", "#9B58B7", "#4E5C64", "#F30291", " #009688"];
                        var myChart1 = document.getElementById("circularGraph" + (i + 1));
                        var option = setDate(color[i], data[i].totalPoint, data[i].realPoint);
                        myChartContainer(myChart1);
                        var myChart = echarts.init(myChart1);
                        myChart.setOption(option);
                        // console.log(data[i].totalPoint+'----'+data[i].realPoint)
                    }
                    initPage(totalPoint, realPoint);
                    initLine(lineData);
                } else {
                    layer.msg(data.msg);
                }
            }
        });
    });
});

function initPage(totalPoint, realPoint) {
    layui.config({
        base: "js/"
    }).use(['element', 'jquery'], function () {
        var element = layui.element,
            $ = layui.jquery;
        var percentNumber = (realPoint / totalPoint * 100).toFixed(0) + '%';
        // $("#getScore").html("得分情况:"+realPoint+"/"+totalPoint);
        $("#allScore").html(realPoint + "/" + totalPoint);
        console.log(realPoint + "/" + totalPoint);
        // " + realPoint + "/" + totalPoint + "
        // var percentHtml = "<div class='layui-progress-bar layui-bg-red' lay-percent='100/300'></div>";
        var percentHtml="<div class='layui-progress-bar layui-bg-green' lay-percent="+percentNumber+"></div>"+realPoint + ' / '+ totalPoint;
        $("#demoPercent").append(percentHtml);

        element.progress('demo', percentNumber);
        // $('#demoPercent').children('.layui-progress-bar').html(percentNumber);
        // $("#demoPercent div").text("");
    });
}

function goModule(moduleId, moduleName) {
    $("#childFrame").attr("src", "/moduleShow/list.do?moduleId=" + moduleId + "&moduleName=" + moduleName+"&realPoint="+$("#hiddenRealPoint").val());
}

//自适应宽高
var myChartContainer = function (myChart2) {
    myChart2.style.width = myChart2.style.width;
    myChart2.style.height = myChart2.style.height;
};

function setDate(colors, totalPoint, realPoint) {
    var texts = ((realPoint / totalPoint) * 100).toFixed(2) + "%";
    var option = {
        color: [colors, "#F1F1F1"],
        title: {
            text: texts,
            left: "center",
            top: "center",
            textStyle: {
                color: "rgba(0,0,0,0.72)",
                fontSize: 18,
                align: "center"
            }
        },

        series: [
            {
                name: "人数",
                type: "pie",
                radius: ["75%", "100%"],
                hoverAnimation: false,
                itemStyle: {
                    normal: {
                        label: {
                            show: false
                        },
                        labelLine: {
                            show: false
                        }
                    }
                },

                data: [
                    {
                        value: parseInt(realPoint),
                        name: "成绩",
                        itemStyle: {
                            emphasis: {
                                color: "#14D56C"
                            }
                        }
                    },
                    {
                        value: parseInt(totalPoint),
                        name: "其他",
                        itemStyle: {
                            emphasis: {
                                color: "#F1F1F1"
                            }
                        }
                    }
                ]
            }
        ]
    };
    return option;
}

function initLine(data) {
    var option = {
        xAxis: {
            type: 'category',
            data: data.dateArray
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: data.numArray,
            type: 'line'
        }]
    };
    var lineChart = echarts.init(document.getElementById('lineDiv'));
   lineChart.setOption(option);
}
// layui.use("element", function () {
//
// });

