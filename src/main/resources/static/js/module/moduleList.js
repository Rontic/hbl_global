var $ =jQuery =layui.jquery;
$(function(){
    $.ajax({
        url: "/moduleShow/getItemList.do",
        async: false,
        data:{moduleId:$("#moduleId").val()},
        type:"post",
        success:function(data){
            if(data.success){
                initDate(data.data);
            }
        }
    });
});

function initDate(itemList) {
    var dataHtml = "";
    for(var i=0;i<itemList.length;i++){
        dataHtml += '<tr>'
            +'<td align="center">'+itemList[i].moduleId+'</td>'
            +'<td align="left" class="moduleName" style="text-align: left;">'+itemList[i].moduleName+'</td>'
            +'<td align="center">'+itemList[i].totalPoint+'</td>'
            +'<td align="center">'+itemList[i].realPoint+'</td>'
            +'<td>'
            +  '<a class="layui-btn layui-btn-normal layui-btn-mini" onclick="showFile(\''+itemList[i].moduleId+'\')"><i class="layui-icon">&#xe61e;</i>查看相关成果</a>'
            +'</td>'
            +'</tr>';
    }
    $(".list_content").append(dataHtml);


    //静态table 转 datagrid
    layui.use('table', function(){
        var table = layui.table;
        table.init('listTable', { //转化静态表格
            //height: 'full-500'
        });
        //添加编辑监听
        var moduleId;
        table.on('edit(listTable)', function(obj){
            var value = obj.value //得到修改后的值
                ,data = obj.data //得到所在行所有键值
                ,field = obj.field; //得到字段
            if(Number(value) > Number(data.totalPoint)){
                layer.msg('你输入的分数大于总分,请重新输入!');
            }else if(Number(value) <= 0){
                layer.msg('你输入的分数不合法,请重新输入!');
            }else if(!isRealNum(value)){
                layer.msg('您的输入不合法,请输入数字!');
            }else{
                editPoint(data.moduleId,value);
            }
        });
    });
}

function editPoint(moduleId,point) {
    var baseModule={};
    baseModule.moduleId = moduleId;
    baseModule.realPoint = point;
    $.ajax({
        url: "/moduleShow/editPoint.do",
        contentType: "application/json; charset=utf-8",
        data:JSON.stringify(baseModule),
        type:"post",
        success:function(data){
            layer.msg(data.msg);
        }
    });
}

function isRealNum(val){
    // isNaN()函数 把空串 空格 以及NUll 按照0来处理 所以先去除
    if(val === "" || val ==null){
        return false;
    }
    if(!isNaN(val)){
        return true;
    }else{
        return false;
    }
}

function showFile(moduleId) {
    window.location.href = "/moduleShow/goFile.do?moduleId="+moduleId+"&realPoint="+$("#hiddenRealPoint").val()+"&totalPoint="+$("#hiddenTotalPoint").val()+"&moduleName="+$("#moduleName").text();
}