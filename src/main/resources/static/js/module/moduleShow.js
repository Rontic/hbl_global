var map;   //地域展示的map
var markers = {}; //地域展示的点集合
var tipForm;  //地域展示的类别勾选项
var roadMap; //路线展示的map
var roadMarker, lineArr; //路线展示的寝室点和路线点的list
var driving; //路线操作类
var iconMap = {}; //地域展示  地图点类别集合
var imageData;  //图文数据
var roadData;   //线路数据
var imgIndex = 0;
var imgLen = 0;
$(function () {
    showFile();
    var list = window.location.href.split("&");
    var realPoints = list[1].split("=")[1];
    var totalPoints = list[2].split("=")[1];
    var percentNumber = (realPoints / totalPoints * 100).toFixed(0) + '%';
    var percentHtml = "<div class='layui-progress-bar layui-bg-green' lay-percent=" + percentNumber + " style= width:" + percentNumber + "></div>" + realPoints + ' / ' + totalPoints;
    $("#demoPercent").append(percentHtml);

});
window.onload = function () {
    $('.closeBtn').click(function () {
        if ($('.closeBtn span').text() == '点击收起地标') {
            $('.echartIconBox').slideUp();
            $('.closeBtn i').attr('title', '展开').css({'transform': 'rotate(180deg)'});
            $('.closeBtn span').text('点击展开地标');
        } else {
            $('.echartIconBox').slideDown();
            $('.closeBtn i').attr('title', '收起').css({'transform': 'rotate(0deg)'});
            $('.closeBtn span').text('点击收起地标');
        }
    });
    //删除景点弹出框
    $(".showDet").on("click", "li", function () {
        $(".historyMap").parents(".layui-layer-page").remove();
    });

    $(".imgUl").on('click', 'li', function () {
        imgIndex = $(this).index();
        $(".imgCenter").attr("src", $(".imgUl li").eq(imgIndex).find('img').attr('src'));
        $(".imgThis img").attr("src", $(".imgCenter").attr('src'));
        $(".imageDivText").text($(".imgUl li").eq(imgIndex).attr('data-content'))
    });
    $(".imgNext").on('click',function () {
        imgIndex++;
        if(imgIndex > imgLen){
            imgIndex = 0;
        }
        $(".imgCenter").attr("src", $(".imgUl li").eq(imgIndex).find('img').attr('src'));
        $(".imgThis img").attr("src", $(".imgCenter").attr('src'));
        $(".imageDivText").text($(".imgUl li").eq(imgIndex).attr('data-content'))
    })
    $(".imgLast").on('click',function () {
        imgIndex--;
        if(imgIndex < 0){
            imgIndex = imgLen;
        }
        $(".imgCenter").attr("src", $(".imgUl li").eq(imgIndex).find('img').attr('src'));
        $(".imgThis img").attr("src", $(".imgCenter").attr('src'));
        $(".imageDivText").text($(".imgUl li").eq(imgIndex).attr('data-content'))
    })
};

function initTab() {
    $("#dataTab").addClass("layui-this");
    $("#dataDiv").addClass("layui-show");
    $("#dataTab").show();
    $("#fileTab").show();
    $("#mapTab").show();
    $("#imageTab").show();
    $("#roadTab").show();
    $("#mapDiv").removeClass("layui-show");
    $("#fileDiv").removeClass("layui-show");
    $("#imageDiv").removeClass("layui-show");
    $("#roadDiv").removeClass("layui-show");
}

function hideTab(type) {
    $("#" + type + "Tab").removeClass("layui-this");
    $("#" + type + "Tab").hide();
    $("#" + type + "Div").removeClass("layui-show");
}

function showTab(type) {
    $(".layui-tab-title").find("li").each(function () {
        $(this).removeClass("layui-this");
    });
    $(".layui-tab-item").each(function () {
        $(this).removeClass("layui-show");
    });
    $("#" + type + "Tab").addClass("layui-this");
    $("#" + type + "Div").addClass("layui-show");
}

//取得该模块的展示数据
function showFile() {
    $.ajax({
        url: "/moduleShow/getModuleData.do",
        async: false,
        data: {moduleId: $("#moduleId").val()},
        type: "post",
        success: function (data) {
            if (data.success) {
                data = data.data;
                layer.open({
                    type: 1,
                    shade: false,
                    title: false,
                    closeBtn: 0,
                    offset: ['0'],
                    area: ['100%', '100%'],//不显示标题
                    content: $(".attachmentPage")//捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
                });
                initPdf(data.pdfDetails, data.pdfFlg);
                initMap(data.mapData, data.mapFlg);
                initItemPercent(data.itemPercentMap, data.statisticsFlg);
                initImage(data.imageDetails, data.imageFlg);
                initRoad(data.roadDetails, data.roadFlg);
            } else {
                layer.msg(data.msg);
            }
        }
    });
}

//pdf文档展示初始化
function initPdf(data, flg) {
    if (!flg || data.length <= 0) {
        hideTab("file");
    } else {
        var list = '';
        for (var i = 0, len = data.length; i < len; i++) {
            list += '<li class="layui-timeline-item">';
            list += '  <i class="layui-icon layui-timeline-axis"></i>';
            list += '  <div class="layui-timeline-content layui-text">';
            list += '     <div class="layui-timeline-title"><img src="/images/pdf.png"><a id="pdf_' + i + '" href="' + data[i].fileUrl + '" class="pdfContainer7" target="pdfContainer" onclick="addClick(this)">' + data[i].fileName + '</a></div>';
            //list+='     <p><span>'+data[i].readNumber+'人阅读</span><span>'+data[i].pageNumber+'页</span></p>';
            list += '   </div>';
            list += '  </li>';

        }
        $(".pdfList").empty();
        $(".pdfList").append(list);
        var sideHeight = $('.relativeList').height(),
            autoHeight = $(window).height() - 55;
        $(".relativeList").css("height", (sideHeight > autoHeight) ? sideHeight : autoHeight);
        $("#pdfContainer").css("height", (sideHeight > autoHeight) ? sideHeight : autoHeight);
        $('#pdfContainer').attr("src", data[0].fileUrl);
        $("#pdf_0").addClass('current');
        showTab("file");
    }
}

//图文展示初始化
function initImage(data, flg) {
    imageData = data;
    if (!flg || data.length <= 0) {
        hideTab("image");
    } else {
        console.log(data)
        var imageList = "";
        for (var i = 0; i < data.length; i++) {
            //imageList += '<div><img src="'+data[i].imageUrl+'"></div>';
            // imageList += '<li class="layui-timeline-item">';
            // imageList += '  <i class="layui-icon layui-timeline-axis"></i>';
            // imageList += '  <div class="layui-timeline-content layui-text">';
            // imageList += '     <div class="layui-timeline-title"><img src="/images/image.png"><a href="javascript:void(0)" class="image_a" id="image_' + i + '" onclick="imageClick(' + i + ')">' + data[i].imageName + '</a></div>';
            // imageList += '   </div>';
            // imageList += '  </li>';

            imageList += '<li data-content="'+data[i].content+'"><div><img src="' + data[i].imageUrl + '"/></div><span>' + data[i].imageName + '</span></li>'
        }
        imgLen = data.length - 1;
        $(".imgUl").append(imageList);
        $(".imgCenter").attr("src", data[0].imageUrl);
        $(".imgThis img").attr("src", data[0].imageUrl);
        $(".imageDivText").text(data[0].content)



        var sideHeight = $('.relativeList').height(),
            autoHeight = $(window).height() - 52;
        $(".relativeList").css("height", (sideHeight > autoHeight) ? sideHeight : autoHeight);
        $("#showImage").attr("src", data[0].imageUrl);
        $("#showImageText").html("&nbsp;&nbsp;" + data[0].content);
        $("#imageList").empty();
        $("#imageList").append(imageList);
        $("#image_0").addClass('current');
        showTab("image");
    }
}

//路线展示初始化
function initRoad(data, flg) {
    roadData = data;
    if (!flg || data.length <= 0) {
        hideTab("road");
    } else {
        var roadList = "";
        for (var i = 0; i < data.length; i++) {
            //imageList += '<div><img src="'+data[i].imageUrl+'"></div>';
            roadList += '<li class="layui-timeline-item">';
            roadList += '  <i class="layui-icon layui-timeline-axis"></i>';
            roadList += '  <div class="layui-timeline-content layui-text">';
            roadList += '     <div class="layui-timeline-title"><img src="/images/road.png"><a href="javascript:void(0)" class="road_a" id="road_' + i + '" onclick="roadClick(' + i + ')">' + data[i].roadName + '</a></div>';
            roadList += '   </div>';
            roadList += '  </li>';
        }
        var sideHeight = $('.relativeList').height(),
            autoHeight = $(window).height() - 52;
        $(".relativeList").css("height", (sideHeight > autoHeight) ? sideHeight : autoHeight);
        $("#roadList").empty();
        $("#roadList").append(roadList);
        $("#road_0").addClass('current');
        initRoadMap(data[0]);
        showTab("road");
    }
}

//路线切换
function roadClick(index) {
    $(".road_a").each(function () {
        $(this).attr("class", "road_a");
    });
    $("#road_" + index).addClass('current');
    initRoadMap(roadData[index]);
}

//路线地图初始化
function initRoadMap(data) {
    if (roadMap == null) {
        roadMap = new AMap.Map("roadMap", {
            resizeEnable: true,
            center: [114.305725, 31.002174],
            mapStyle: 'amap://styles/bbde795ba1fefec82b1e20cd18766713',
            zoom: 14
        });
        var drivingOption = {
            policy: AMap.DrivingPolicy.LEAST_TIME, // 其它policy参数请参考 https://lbs.amap.com/api/javascript-api/reference/route-search#m_DrivingPolicy
            ferry: 1, // 是否可以使用轮渡
            province: '鄂', // 车牌省份的汉字缩写
            map: roadMap,
            panel: 'panel'
        }

        // 构造路线导航类
        driving = new AMap.Driving(drivingOption);
    } else {
        roadMarker.setMap(null);
    }

    // 根据起终点经纬度规划驾车导航路线
    driving.search(new AMap.LngLat(data.startLon, data.startLat), new AMap.LngLat(data.endLon, data.endLat), function (status, result) {
        console.info(result);
        if (status === 'complete') {
            roadMarker, lineArr = getLineArray(result.routes[0].steps);
            console.info(lineArr);
        } else {
            log.error('获取驾车数据失败：' + result)
        }
    });

    roadMarker = new AMap.Marker({
        map: roadMap,
        position: [data.startLon, data.startLat],
        icon: "https://webapi.amap.com/images/car.png",
        offset: new AMap.Pixel(-26, -13),
        autoRotation: true,
        angle: -90,
    });

    // 绘制轨迹
    var polyline = new AMap.Polyline({
        map: roadMap,
        path: lineArr,
        showDir: true,
        strokeColor: "#28F",  //线颜色
        // strokeOpacity: 1,     //线透明度
        strokeWeight: 6,      //线宽
        // strokeStyle: "solid"  //线样式
    });

    var passedPolyline = new AMap.Polyline({
        map: roadMap,
        // path: lineArr,
        strokeColor: "#AF5",  //线颜色
        // strokeOpacity: 1,     //线透明度
        strokeWeight: 6,      //线宽
        // strokeStyle: "solid"  //线样式
    });


    roadMarker.on('moving', function (e) {
        passedPolyline.setPath(e.passedPath);
    });

    roadMap.setFitView();
}

function startAnimation() {
    roadMarker.moveAlong(lineArr, 200);
}

function pauseAnimation() {
    roadMarker.pauseMove();
}

function resumeAnimation() {
    roadMarker.resumeMove();
}

function stopAnimation() {
    roadMarker.stopMove();
}

function getLineArray(roadData) {
    var lineData = new Array();
    for (var i = 0; i < roadData.length; i++) {
        for (var j = 0; j < roadData[i].path.length; j++) {
            lineData.push(roadData[i].path[j]);
        }
    }
    return lineData;
}

//地域展示初始化
function initMap(data, flg) {
    if (!flg) {
        hideTab("map");
    } else {
        initMapTips(data.poiTypes, data.mapType);
        initMapItem(data);
        console.info(data);
        showTab("map");
    }
}

//地图点类型列表初始化
function initMapTips(data, mapType) {
    if ($(".echartIconBox").find("li").length <= 0) {
        var liString = "";
        for (var i = 0; i < data.length; i++) {
            // liString += "<li><div class='layui-input-block layui-form layui-form-item'><input type='checkbox' lay-filter='choose' class='mapTipsCheck'  name='" + data[i].id + "'></div><span>" + data[i].name + "</span></li>";
            // iconMap[data[i].id] = data[i].icon;

            liString += "<li><div class='layui-input-block layui-form layui-form-item'><input type='checkbox' lay-skin='primary' lay-filter='choose' class='mapTipsCheck'  name='" + data[i].id + "' title='" + data[i].name + "'></div></li>";
            iconMap[data[i].id] = data[i].icon;
            // if(i+1 == data.length){
            //     liString += "</li>"
            // }else{
            //     liString +=  "<div class='layui-input-block layui-form layui-form-item' data-icon="+data[i+1].icon+"><input type='checkbox' lay-filter='choose' class='mapTipsCheck'  name='"+data[i+1].id+"'><i class='iconfont' style='color:"+data[i+1].color+"'>"+data[i+1].icon+"</i>"+data[i+1].name+"</div></li>"
            //     iconMap[data[i+1].id] = data[i+1].icon;
            // }
        }
        $(".echartIconBox").append(liString);
    }
    $(".mapTipsCheck").each(function () {
        if (checkType(mapType, $(this).attr("name"))) {
            $(this).prop("checked", true);
        } else {
            $(this).removeAttr("checked");
        }
    });
    //初始化checkbox form
    if (!tipForm) {
        layui.config({
            base: "/js/"
        }).use(['form'], function () {
            tipForm = layui.form;
        });
    }
    tipForm.render();

    //checkbox 添加点击事件
    tipForm.on("checkbox(choose)", function (data) {
        console.log('checkbox-----------')
        if (data.elem.checked == true) {
            historyMap[data.elem.name] = true;
            showMaker(data.elem.name, positions);
        } else {
            for (var i = 0; i < markers[data.elem.name].length; i++) {
                markers[data.elem.name][i].setMap(null);
                historyMap[data.elem.name] = false;
            }
        }
        // uploadMapHistory();
    });
}

function checkType(type, code) {
    var typeArray = type.toString().split(",");
    var result;
    if (typeArray.indexOf(code) != -1) {
        result = true;
    } else {
        result = false;
    }
    return result;
}

//初始化地域展示地图
function initMapItem(mapdata) {
    var ordinaryPois = mapdata.ordinaryPois;
    var positions = new Array();
    if (ordinaryPois != null && ordinaryPois.length > 0) {
        for (var i = 0; i < ordinaryPois.length; i++) {
            var ordinaryPoi = {
                position: ordinaryPois[i].realGPS,
                type: Number(ordinaryPois[i].typeId),
                name: ordinaryPois[i].name,
                images: ordinaryPois[i].images,
                imagesTitle: ordinaryPois[i].images.split(";")[0],
                tel: ordinaryPois[i].tel,
                addr: ordinaryPois[i].addr,
                content: ordinaryPois[i].summary,
                star: ordinaryPois[i].star,
                tableNum: ordinaryPois[i].tableNum,
                wcNum: ordinaryPois[i].wcNum,
                officialUrl: ordinaryPois[i].officialUrl,
            }
            positions.push(ordinaryPoi);
        }
    }


    if (map == null) {
        map = new AMap.Map('echartBox', {
            resizeEnable: true,
            center: [114.305725, 31.002174],
            mapStyle: 'amap://styles/bbde795ba1fefec82b1e20cd18766713',
            pitch: 0,
            viewMode: '3D',
            zoom: 10
        });


        //设置只显示黄陂区
        initPro();


        //checkbox 添加点击事件
        tipForm.on("checkbox(choose)", function (data) {
            if (data.elem.checked == true) {
                showMaker(data.elem.name, positions);
            } else {
                for (var i = 0; i < markers[data.elem.name].length; i++) {
                    markers[data.elem.name][i].setMap(null);
                }
                markers[data.elem.name] = new Array();
            }
        });
    } else {
        for (var poiType in markers) {
            for (var i = 0; i < markers[poiType].length; i++) {
                markers[poiType][i].setMap(null);
            }
        }
    }
    //显示该模块的地图点
    showMaker(mapdata.mapType, positions);
    map.setFitView();
}

//显示地图点
function showMaker(type, positions) {
    console.log(positions)
    var resultObject = {};
    var typeArray = type.split(",");
    for (var i = 0; i < typeArray.length; i++) {
        resultObject[typeArray[i]] = new Array();
    }
    AMapUI.loadUI(['overlay/SimpleMarker'], function (SimpleMarker) {
        var markerTemp = new Array();
        for (var i = 0, marker11; i < positions.length; i++) {
            if (array_contain(typeArray, positions[i].type)) {
                marker11 = new SimpleMarker({
                    iconLabel: {
                        innerHTML: '<i class="iconfont  iconMap" style="color:' + judgeColor(positions[i].type) + ';text-indent: 2px;margin-top: 6px;">' + iconMap[positions[i].type] + '</i>'
                    },
                    iconStyle: '<i class="iconfont" style="color:' + judgeColor(positions[i].type) + ';font-size:40px;text-shadow: 0px 4px 5px rgba(0,0,0,.34);">&#xe650;</i>',
                    map: map,
                    position: positions[i].position
                });
                resultObject[positions[i].type].push(marker11);
                !function (i) {
                    //设置点击事件
                    marker11.on('click', function (e) {
                        $(".historyMap").parents(".layui-layer-page").remove();
                        map.setCenter(positions[i].position);
                        var contentString = "";
                        contentString += '<div class="historyMap"><div class="historyMapHead">';
                        contentString += '<span>' + positions[i].name + '</span> <div id="score"></div> </div> <div class="historyMapScroll"><div class="historyMapCon">';
                        if(positions[i].addr != null){
                            contentString += '<span class="location">' + positions[i].addr + '</span>';
                        }
                        if(positions[i].tel != null){
                            contentString += '<span class="mobile">' + positions[i].tel + '</span>';
                        }
                        if(positions[i].tableNum != null){
                            contentString += '<span class="tableNum">' + positions[i].tableNum + '</span>';
                        }
                        if(positions[i].wcNum != null){
                            contentString += '<span class="wcNum">' + positions[i].wcNum + '</span>';
                        }
                        if(positions[i].officialUrl != null){
                            contentString += '<a class="goHome" href="'+positions[i].officialUrl+'" target="_blank">官网</a>';
                        }
                        contentString += '</div> <div class = "historyMapImg" ><img src = "' + positions[i].imagesTitle + '" ><a id="mapImage_' + positions[i].no + '" style="display: block" onclick="showPhoto(\'' + positions[i].images + '\')">查看图片</a>';
                        contentString += '</div><p class="historyMapDetT">' + positions[i].content + '</p> </div> </div>';
                        layer.open({
                            type: 1,
                            shade: false,
                            title: false, //不显示标题
                            // area:['320px','480px'],
                            offset: ['88px', '8px'],
                            //<img src="'+positions[i].images+'" style="width:100px;height:100px;margin-top:10px;">
                            // content: '<div class="markerMap" style="padding:10px;"><span style="display:flex;height:25px;line-height:25px;border-bottom:1px solid #ccc">'
                            // +positions[i].name+'</span><img src="'+positions[i].imagesTitle+'" style="width:100px;height:100px;margin-top:10px;"><a id="mapImage_'
                            // +positions[i].no+'" style="display: block" onclick="showPhoto(\''+positions[i].images
                            // +'\')">查看相册</a><a id="mapImage_'+positions[i].no+'" style="display: block">查看简介</a><a href="http://www.mltc.cn/" target="new_window" id="mapImage_'
                            // +positions[i].no+'" style="display: block">前往官网</a></div>'//捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响

                            content: contentString
                                //'<div class="historyMap"><div class="historyMapHead">'
                               // + '<span>' + positions[i].name + '</span> <div id="score"></div> </div> <div class="historyMapScroll">'
                                //+ '<div class="historyMapCon"> <span>' + positions[i].addr + '</span><span>' + positions[i].tel + '</span>'
                               // + '<a class="goHome" href="'+positions[i].officialUrl+'" target="_blank">官网</a></div> <div class = "historyMapImg" ><img src = "' + positions[i].imagesTitle + '" >'
                              //  + '<a id="mapImage_' + positions[i].no + '" style="display: block" onclick="showPhoto(\'' + positions[i].images + '\')">查看图片</a>'
                               // + '</div><p class="historyMapDetT">' + positions[i].content + '</p> </div> </div>'
                        });

                        layui.use(['rate'], function () {
                            var rate = layui.rate;
                            //只读
                            rate.render({
                                elem: '#score'
                                , value: positions[i].star
                                , readonly: true
                            });

                        });
                        if(isFirefox=navigator.userAgent.indexOf("Firefox")>0){
                            console.log("Firefox")
                            $(".historyMapScroll").css('padding-right','5px');
                            $(".historyMap").css('padding-right','5px');
                        }
                    });
                }(i);
            }
        }
        for (var p in resultObject) {
            markers[p] = resultObject[p];
        }
    });
}

//显示相册
function showPhoto(imageList) {
    var photoData = new Object();
    photoData.title = "";
    photoData.id = "1";
    photoData.start = 0;
    var photoList = new Array();
    var imageList = imageList.split(';');
    for (var i = 0; i < imageList.length; i++) {
        var photo = new Object();
        photo.alt = "";
        photo.pid = i;
        photo.src = imageList[i];
        photo.thumb = imageList[i];
        photoList.push(photo);
    }
    photoData.data = photoList;
    layer.photos({
        photos: photoData //格式见API文档手册页
        , anim: 5 //0-6的选择，指定弹出图片动画类型，默认随机
    });
}

//pdf点击事件
function addClick(e) {
    $(".pdfContainer7").each(function () {
        $(this).attr("class", "pdfContainer7");
    });
    $(e).addClass('current');
}

//图文列表点击事件
function imageClick(index) {
    $(".image_a").each(function () {
        $(this).attr("class", "image_a");
    });
    $("#showImage").attr("src", imageData[index].imageUrl);
    $("#showImageText").html(imageData[index].content);
    $("#image_" + index).addClass('current');
}

//统计展示初始化
function initItemPercent(itemData, flg) {
    if (!flg || itemData.yearList.length <= 0) {
        hideTab("data");
    } else {
        $("#graphBox").empty();
        showTab("data");
        loadItemPercentData(itemData);
    }
}

function judgeColor(type) {
    //console.log(type);
    if (type == "1" || type == "3" || type == "4" || type == "5" || type == "13" || type == "15" || type == "16") {
        return "#ff9f3a";//导游点
    } else if (type == "10" || type == "11" || type == "12" || type == "14" || type == "14") {
        return "#40aa24";//景区点
    } else if (type == "2" || type == "6" || type == "7" || type == "8" || type == "9" || type == "17") {
        return "#2b81ff";//普通点
    }
}


function array_contain(array, obj) {
    for (var i = 0; i < array.length; i++) {
        if (array[i] == obj)//如果要求数据类型也一致，这里可使用恒等号===
            return true;
    }
    return false;
}

// 创建行政区图层
function initPro() {
    var disProvince;
    var adCode = 420116;
    var depth = 2;

    disProvince && disProvince.setMap(null);

    disProvince = new AMap.DistrictLayer.Province({
        zIndex: 12,
        adcode: [adCode],
        depth: depth,
        styles: {
            'fill': function (properties) {
                return 'rgb(200,200,200,0.8)'
            },
            'province-stroke': 'cornflowerblue',
            'city-stroke': 'white', // 中国地级市边界
            'county-stroke': 'rgba(255,255,255,0.9)' // 中国区县边界
        }
    });
    disProvince.setMap(map);
}

function setImgCon() {
    console.log($(this).index())
}

