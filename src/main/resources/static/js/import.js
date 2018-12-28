var pdfUpload;
var mapUpload;
var roadUpload;
var imageUpload;
var uploadLoadingIndex;
$(function(){
    initImportUploader();
});
function initImportUploader() {
    if(!pdfUpload) {
        layui.use('upload', function () {
            pdfUpload = layui.upload;
            //选完文件后不自动上传
            var pdfList = pdfUpload.render({
                elem: '#importPdf'
                , url: '/import/importPdf.do'
                , auto: false
                , accept: 'file'
                , exts: 'xlsx'
                //,multiple: true
                , bindAction: '#doImportPdf'
                , before: function () {
                    uploadLoadingIndex = layer.load();
                }
                , done: function (res) {
                    layer.close(uploadLoadingIndex);
                    layer.msg(res.msg);
                    pdfList.config.elem.next()[0].value = '';
                }
            });

            mapUpload = layui.upload;
            //选完文件后不自动上传
            var mapList = mapUpload.render({
                elem: '#importMap'
                , url: '/import/importMap.do'
                , auto: false
                , accept: 'file'
                , exts: 'xlsx'
                //,multiple: true
                , bindAction: '#doImportMap'
                , before: function () {
                    uploadLoadingIndex = layer.load();
                }
                , done: function (res) {
                    layer.close(uploadLoadingIndex);
                    layer.msg(res.msg);
                    mapList.config.elem.next()[0].value = '';
                }
            });

            roadUpload = layui.upload;
            //选完文件后不自动上传
            var roadList = roadUpload.render({
                elem: '#importRoad'
                , url: '/import/importRoad.do'
                , auto: false
                , accept: 'file'
                , exts: 'xlsx'
                //,multiple: true
                , bindAction: '#doImportRoad'
                , before: function () {
                    uploadLoadingIndex = layer.load();
                }
                , done: function (res) {
                    layer.close(uploadLoadingIndex);
                    layer.msg(res.msg);
                    roadList.config.elem.next()[0].value = '';
                }
            });

            imageUpload = layui.upload;
            //选完文件后不自动上传
            var imageList = imageUpload.render({
                elem: '#importImage'
                , url: '/import/importImage.do'
                , auto: false
                , accept: 'file'
                , exts: 'xlsx'
                //,multiple: true
                , bindAction: '#doImportImage'
                , before: function () {
                    uploadLoadingIndex = layer.load();
                }
                , done: function (res) {
                    layer.close(uploadLoadingIndex);
                    layer.msg(res.msg);
                    imageList.config.elem.next()[0].value = '';
                }
            });
        });
    }else{
        pdfUpload.render();
        mapUpload.render();
        roadUpload.render();
        imageUpload.render();
    }
}