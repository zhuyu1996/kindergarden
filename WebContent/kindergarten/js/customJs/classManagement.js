/**
 * Created by Sunshine on 2017/4/17.
 */
function classManagenment(data) {
    var addClass = $(".addClass");
    var creatNewClass = addClass.find("button");
    var classInput = addClass.find("input");

    var index = $("#table_list_2").jqGrid("getGridParam", "selrow");

    var addNewClass = creatNewClass[0],
        upgradeClass = classInput[0],
        delClass = classInput[1];



    addNewClass.addEventListener("click",addTheNewClass);
    upgradeClass.addEventListener("click",function () {
        var message = confirm("此操作不可恢复！确定要升级班级吗？");
        if(message){
            upgradeTheClass();
        }
    });
    
    showClassDetails(data);

    delClass.onclick = function () {
        index = $("#table_list_2").jqGrid("getGridParam", "selrow");
        if (index == null){
           alert("请选择要删除的行！");
        }else {
            var message = confirm("确定要删除吗？");
            if(message){
                delTheClass();
            }
        }
      
    };



    function showClassDetails(classData) {
        var buttons = $("#table_list_2").find("input.theDetails");
        for(var b=0;b<buttons.length;b++){
            buttons[b].setAttribute("data-classShow",b);
            buttons[b].onclick = function () {
                var index = this.getAttribute("data-classShow");
                var rows = classData[index];
                console.log(rows);
                var theRow = rows.cId + "," + rows.cName + "," + rows.tTeacher;
                if (window.sessionStorage) {
                    sessionStorage.setItem("row", theRow);
                } else {
                    document.Cookie.write("row", theRow);
                }
                // document.cookie = "row="+theRow;
                window.location.href = "classDetails.html";
            }
        }


    }

    function addTheNewClass() {
        console.log("add");
        console.log(window.location.href);


    }
    function upgradeTheClass() {
        console.log("upgrade");
        $.ajax({
            type: "post",
            url: "http://"+IPADDRESS+"/kindergarden/ClassUp",
            beforeSend: function (xhr) {
                xhr.withCredentials = true;
                xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
            },
            success: function () {
                $.ajax({
                    type: "post",
                    url: "http://"+IPADDRESS+"/kindergarden/StudentShowAll",
                    beforeSend: function (xhr) {
                        xhr.withCredentials = true;
                        xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
                    },
                    success: function () {
                        alert("升级成功");
                        window.location.reload();//刷新页面
                    },
                    error: function (err) {
                        console.log(err.status);
                    }
                });
            },
            error: function (err) {
                console.log(err.status);
                alert("出现错误："+err.status);
            }
        });
        
    }
    function delTheClass() {
        var delId = data[index-1].cId;
        $.ajax({
            type: "post",
            url: "http://"+IPADDRESS+"/kindergarden/ClassDelete",
            data: "classDelete="+delId,
            beforeSend: function (xhr) {
                xhr.withCredentials = true;
                xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
            },
            success: function () {
                alert("删除成功！");
                window.location.reload();//刷新页面
            },
            error: function (err) {
                console.log(err.status);
                alert("出现错误："+err.status);
            }
        });
    }
}



