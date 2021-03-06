/**
 * Created by Sunshine on 2017/5/15.
 */
$(window).on("load",function () {
    var body = $("body");
    var addAlbumsBox = $(".addAlbumsBox");
    var gray = $(".gray");

    var addPhotos = $("input.buttonAdd");
    var close = $(".close");
    var cancle = $("input.cancle");

    addPhotos.click(function () {
        gray.show();
        // body.css("overflow","hidden");
        addAlbumsBox.show(400);
    });
    close.click(function () {
        closeAddAlbumsBox();
    });
    cancle.click(function () {
        closeAddAlbumsBox();
    });


    function closeAddAlbumsBox() {
        gray.hide();
        // body.css("overflow","scroll");
        addAlbumsBox.hide(400);
    }





    var sure = $("input.sure");

    sure.click(function () {
        addPhotoAjax();
    });


    var delPhoto = $("input.buttonDel");

    delPhoto.click(function () {
        $("input.photoCancle").show(200);
        $("input.photoCancle").parent().append("<span class='theAttentionP' style='margin: 13px'>请选择需要删除的相册</span>");
        delPhotos();
    })



});

function delPhotos() {
    var divImgs = $("#main").find(".pic");
    console.log(divImgs);
    for (var j=0;j<divImgs.length;j++){
        var oI = document.createElement("i");
        oI.className = "manageImg";
        divImgs[j].appendChild(oI);
    }

    var iManagement = $("i.manageImg");
    var iIndex = 0;
    iManagement.each(function () {
        this.setAttribute("data-i",iIndex);
        iIndex++;
    });
    console.log(iManagement);
    iManagement.each(function () {
        this.addEventListener("click",function () {
            var thisImg = $(this).parent().find("img")[0];
            var delId = thisImg.getAttribute("data-id");

            var message = confirm("确定要删除此相册吗？");
            if(message){
                $.ajax({
                    type: "post",
                    url: "http://"+IPADDRESS+"/kindergarden/PictureContentDlete",
                    data: "PidJson="+delId,
                    beforeSend: function (xhr) {
                        xhr.withCredentials = true;
                        xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
                    },
                    success: function () {
                        console.log("success");
                        alert("删除成功！");
                        window.location.reload();

                    },
                    error: function (err) {
                        console.log(err.status);
                        alert("出现错误："+err.status);
                    }
                });
            }


        });
    });


    var cancle = $("input.photoCancle");
    cancle.click(function () {
        $(".theAttentionP").remove();
        $("i.manageImg").remove();
        $(this).hide(200);
    })
}

function addPhotoAjax() {
    var inputs = $(".inputs");
    var input = inputs.find("input");
    var textarea = inputs.find("textarea");


    //权限
    var cid = "";
    var usertype = sessionStorage.getItem("nub");  //0为老师，1为校长
    var teacherData = sessionStorage.getItem("teacherData");

    //园长
    if (usertype == 1){
        cid = 1;
    }else {
        var teacher = JSON.parse(teacherData);
        console.log(teacher);
        cid = teacher.cId;
    }

    var value = {
        picid: null,
        picname: input.val(),
        picmdescribe: textarea.val(),
        picface: null,
        cid: cid
    };

    if(input.val() == ""){
        alert("请输入相册名称！");
    }else  if(textarea.val() == ""){
        alert("请输入相册描述");
    }else {
        $.ajax({
            type: "post",
            url: "http://"+IPADDRESS+"/kindergarden/PcAdd",
            data: "PictureContentJson="+JSON.stringify(value),
            beforeSend: function (xhr) {
                xhr.withCredentials = true;
                xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
            },
            success: function () {
                console.log("success");
                alert("相册创建成功，请进入相册添加照片");
                window.location.reload();
            },
            error: function (err) {
                console.log(err.status);
                alert("出现错误："+err.status);
            }
        });
    }






}


