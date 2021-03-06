

function addTeacher(theCaption,data,theIndex) {
    console.log("addTeacher");
    var box = $(".box");

    var body = $("body");
    var overlay = body.find("#lui_table_list_2")[0];
    overlay.style.display = "block";
    box[0].style.display = "block";
    box[0].className = "box boxHover";

    var top = document.createElement("div");
    top.className = "top";
    var topSpan = document.createElement("span");
    topSpan.className = "title";
    var closeSpan = document.createElement("span");
    closeSpan.className = "close";
    closeSpan.id = "closeBox";
    closeSpan.style.right = "0.3em";
    box[0].appendChild(top);
    top.appendChild(topSpan);
    top.appendChild(closeSpan);

    var closeBox = $("#closeBox")[0];
    var title = box.find(".title")[0];
    title.innerHTML = theCaption;

    var caption = ['教师姓名','职位','性别','授课班级','联系方式','登陆密码/工号'];
    var optionClass = [];
    var optionWork = ['班主任','老师','保育员'];

    $.ajax({
        type: "get",
        url: "http://"+IPADDRESS+"/kindergarden/ClassShow",
        dataType: "JSON",
        contentType:"application/x-www-form-urlencoded;charset=UTF-8",
        beforeSend: function (xhr) {
            xhr.withCredentials = true;
            xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");

            var adding = document.createElement("p");
            adding.className = "adding";
            adding.innerHTML = "数据加载中。。。";
            $(".box")[0].appendChild(adding);
        },
        success: function (classData) {
            $(".adding").remove();
            optionClass[0] = " ";
            for(var clas=1;clas<classData.length;clas++){
                optionClass[clas] = classData[clas].cName;
            }
            
            
            
            for(var i=0;i<caption.length;i++){
                if (caption[i] == "职位"){
                    var theBoxWork = document.createElement("div");
                    theBoxWork.className = "boxInput";
                    box[0].appendChild(theBoxWork);

                    var spanWork = document.createElement("span");
                    spanWork.innerHTML = caption[i];
                    theBoxWork.appendChild(spanWork);
                    var selectWork = document.createElement("select");
                    theBoxWork.appendChild(selectWork);
                    for (var w=0;w<optionWork.length;w++){
                        var workOption = document.createElement("option");
                        selectWork.appendChild(workOption);
                        workOption.innerHTML = optionWork[w];
                    }
                }else if (caption[i] == "性别"){
                    var theBoxSex = document.createElement("div");
                    theBoxSex.className = "boxInput";
                    box[0].appendChild(theBoxSex);

                    var spanSex = document.createElement("span");
                    spanSex.innerHTML = caption[i];
                    theBoxSex.appendChild(spanSex);
                    var selectSex = document.createElement("select");
                    theBoxSex.appendChild(selectSex);
                    var optionSex = ['女','男'];
                    for (var s=0;s<optionSex.length;s++){
                        var sexOption = document.createElement("option");
                        selectSex.appendChild(sexOption);
                        sexOption.innerHTML = optionSex[s];
                    }
                }else if(caption[i] == "授课班级"){
                    var theBoxClass = document.createElement("div");
                    theBoxClass.className = "boxInput";
                    box[0].appendChild(theBoxClass);

                    var spanClass = document.createElement("span");
                    spanClass.innerHTML = caption[i];
                    theBoxClass.appendChild(spanClass);
                    var selectClass = document.createElement("input");
                    theBoxClass.appendChild(selectClass);
                    selectClass.type = "text";
                    selectClass.value = "未分配";
                    selectClass.readOnly = true;
                    theBoxClass.appendChild(selectClass);
                    // for (var c=0;c<optionClass.length;c++){
                    //     var classOption = document.createElement("option");
                    //     selectClass.appendChild(classOption);
                    //     classOption.innerHTML = optionClass[c];
                    // }
                    theBoxClass.style.display = "none";
                }else {
                    var boxInput = document.createElement("div");
                    boxInput.className = "boxInput";
                    var span = document.createElement("span");
                    span.innerHTML = caption[i];
                    var input = document.createElement("input");
                    input.type = "text";
                    input.placeholder = caption[i];

                    box[0].appendChild(boxInput);
                    boxInput.appendChild(span);
                    boxInput.appendChild(input);

                    if (caption[i] == "登陆密码"){
                        input.value  = "123456";
                    }
                }
            }

            //按钮
            var theButton = document.createElement("div");
            theButton.className = "theButton";
            var inputSure = document.createElement("input");
            inputSure.type = "button";
            inputSure.value = "确定";
            var inputCancel = document.createElement("input");
            inputCancel.type = "button";
            inputCancel.value = "取消";

            box[0].appendChild(theButton);
            theButton.appendChild(inputSure);
            theButton.appendChild(inputCancel);

            //关闭添加框
            var buttonInput = $(".theButton");
            var cancel = buttonInput.find("input")[1];
            closeBox.addEventListener("click",closeTheBox);
            cancel.addEventListener("click",closeTheBox);
            function closeTheBox() {
                var theBox = $(".box");
                overlay.style.display = "none";
                theBox.hide(800);

                theBox.find("div").remove();
            }


            if (theCaption == "编辑"){
                var rowData = data[theIndex-1];
                var editId = rowData.tId;
                var boxEdit = $(".boxInput");
                var theBoxInput = boxEdit.find("input");
                var theBoxSelect = boxEdit.find("select");
                theBoxInput[0].value = rowData.tName;
                theBoxInput[2].value = rowData.tPhone;
                theBoxInput[3].value = rowData.tPassword;

                theBoxSelect[0].id = "tWork";//班级信息
                for(var t=0;t<optionWork.length;t++){
                    if (rowData.tgrade == optionWork[t]){
                        $("#tWork").find("option")[t].selected = true;
                    }
                }

                theBoxSelect[1].id = "theSex";
                var theSex = $("#theSex");
                console.log(rowData);
                if (rowData.tSex == "男"){
                    console.log("nan");
                    theSex.find("option")[1].selected = true;
                }else {
                    theSex.find("option")[0].selected = true;
                }

                // theBoxSelect[2].id = "className";//班级信息
                // for(var o=0;o<optionClass.length;o++){
                //     if (rowData.cId == optionClass[o]){
                //         $("#className").find("option")[o].selected = true;
                //     }
                // }


                var edit = buttonInput.find("input")[0];
                edit.addEventListener("click",function () {
                    editSubmit(editId);
                });
            }

            if (theCaption == "添加"){
                var add = buttonInput.find("input")[0];
                add.addEventListener("click",addSubmit);
            }
        },
        error: function (err) {
            console.log(err.status);
            alert("出现错误："+err.status);
        }
    });
    
}






//提交
function addSubmit() {
    var values;
    var boxInput = $(".boxInput");
    var theBoxInput = boxInput.find("input");
    var theBoxSelect = boxInput.find("select");

    // var className = theBoxSelect[2].value;
    // var classNameT = className.substring(0,1),
        // classNameC = className.substring(1);
    // var cName = classNameT+","+classNameC;
    console.log(theBoxInput);
    console.log(theBoxSelect);

    if(theBoxInput[0].value === ""){
        alert("教师名字不能为空！");
    }else if(theBoxSelect[0].value ===""){
        alert("授课班级不能为空！");
    }else if(theBoxInput[2].value.length !== 11){
        alert("电话号码必须为11位数字！");
    }else if(theBoxInput[3].value === ""){
        alert("登陆密码/工号不能为空！");
    }else {
        values = {
            cId: "未,分配",
            tId: null,
            tName: theBoxInput[0].value,
            tPhone: theBoxInput[2].value,
            tSex: theBoxSelect[1].value,
            tgrade: theBoxSelect[0].value,
            tWorkId: theBoxInput[3].value
        };

        $.ajax({
            type:"post",
            url:"http://"+IPADDRESS+"/kindergarden/Teacheradd",
            data:"TeacherJson="+JSON.stringify(values),
            contentType:"application/x-www-form-urlencoded;charset=utf-8",
            beforeSend: function (xhr) {
                xhr.withCredentials = true;
                xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
            },
            success: function (res) {
                if(res == "ok"){
                    alert("添加成功！");
                }else {
                    alert(res);
                }
                console.log(values);
                var box = $(".box");
                box.hide(800);
                window.location.reload();
            },
            error: function (err) {
                alert("出现错误："+err.status);
                console.log(err.status);
            }
        });
    }


}


//编辑
function editSubmit(theId) {
    var values;
    var boxInput = $(".boxInput");
    var theBoxInput = boxInput.find("input");
    var theBoxSelect = boxInput.find("select");

    var className = theBoxInput[1].value;
    var classNameT = className.substring(0,1),
        classNameC = className.substring(1);
    var cName = classNameT+","+classNameC;
    // var isPhone = /^1[3,5,8]\d{9}$/;
    if(theBoxInput[0].value === ""){
        alert("教师名字不能为空！");
    }else if(theBoxSelect[0].value ===""){
        alert("授课班级不能为空！");
    }else if(theBoxInput[2].value.length != 11){
        alert("电话号码必须为11位数字！");
    }else if(theBoxInput[3].value === ""){
        alert("登陆密码/工号不能为空！");
    }else {
        values = {
            cId: cName,
            tId: theId,
            tName: theBoxInput[0].value,
            tPhone: theBoxInput[2].value,
            tSex: theBoxSelect[1].value,
            tgrade: theBoxSelect[0].value,
            tWorkId: theBoxInput[3].value
        };
        console.log(values);

        $.ajax({
            type:"post",
            url:"http://"+IPADDRESS+"/kindergarden/TeacherUpdate",
            // dataType:"JSON",
            data:"TeacherJson="+JSON.stringify(values),
            contentType:"application/x-www-form-urlencoded;charset=UTF-8",
            beforeSend: function (xhr) {
                xhr.withCredentials = true;
                xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
            },
            success: function () {
                alert("修改成功！");
                var box = $(".box");
                box.hide(800);
                window.location.reload();
            },
            error: function (err) {
                alert("出现错误："+err.status);
                alert("出现错误："+err.status);
            }
        });
    }

}



function delTeacher(data,theIndex) {
    var delData = data[theIndex-1];
    var delId = delData.tId;

    $.ajax({
        type: "post",
        url: "http://"+IPADDRESS+"/kindergarden/TeacherDelete",
        contentType:"application/x-www-form-urlencoded;charset=UTF-8",
        data: "id="+delId,
        beforeSend: function (xhr) {
            xhr.withCredentials = true;
            xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
        },
        success: function () {
            alert("删除成功！");
            window.location.reload();//刷新页面
            // $("#table_list_2").trigger("reloadGrid");
        },
        error: function (err) {
            console.log(err.status);
            alert("出现错误："+err.status);
        }
    });
    
}