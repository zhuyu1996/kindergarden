var teacherData;

$(function(){
  username = sessionStorage.getItem("user");
  usertype = sessionStorage.getItem("nub");  //0为老师，1为校长，2位家长

  console.log(usertype);
  console.log(username);

  if (usertype == null||usertype == "") {
    window.location.href = "logIn.html";
  };
  
  if (usertype == 1){//园长



  }else if (usertype == 0) {

    teacherData = sessionStorage.getItem("teacherData");
    var data = JSON.parse(teacherData);
    console.log(data);
    var username = data.tName;
    $("#awd-site-logo span").html(username);

    $(".theClassChose").remove();


  }else if (usertype == 2) {

    teacherData = sessionStorage.getItem("teacherData");
    var data = JSON.parse(teacherData);
    console.log(data);
    console.log(data.Object.sName);

    var username = data.Object.sName;
    $(".classtable table caption span").html(username);
    username = username+"家长";
    $("#awd-site-logo span").html(username);

    $(".enterBack").remove();
    $(".theClassChose").remove();
  }

  allClass();
})

function allClass(){
  //加载班级
  $.ajax({
    type: "post",
    url: "http://"+IPADDRESS+"/kindergarden/ClassShow",
    contentType:"application/x-www-form-urlencoded;charset=UTF-8",
    beforeSend: function (xhr) {
      xhr.withCredentials = true;
      xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
    },
    success: function (classdata) {
      if (usertype == 0){//老师,家长
        var data = JSON.parse(teacherData);
        var classId = data.cId;
      }else if (usertype == 2) {
        var data = JSON.parse(teacherData);
        var classId = data.Object.cId;
      }

      
      var classData = JSON.parse(classdata);
      var classlang = classData.length-2;

      for(var i=0;i<classlang;i++){
        if (usertype == 0){
          if (classData[i].cId == classId) {
            $(".classtable table caption span").html(classData[i].cName);
          };
        }else if(usertype == 1){
          if (i == 0) {
            $(".classtable table caption span").html(classData[i].cName);
          };
        }else if(usertype == 2){
          if (classData[i].cId == classId) {
            $(".classtable table caption span").attr("name",classData[i].cName);
          };
        }
        
        $("#selectClass.selectpicker").append("<option value='"+classData[i].cName+"'>"+classData[i].cName+"</option>")
        // $(".formytest").append("<option value='"+classData[i].cName+"'>"+classData[i].cName+"</option>")
        // $(".addNewClass").append("<option value='"+classData[i].cName+"'>"+classData[i].cName+"</option>")
      }
      $("#selectClass").selectpicker('refresh');
    },
    error: function (err) {
      console.log(err.status);
    }
  });
}