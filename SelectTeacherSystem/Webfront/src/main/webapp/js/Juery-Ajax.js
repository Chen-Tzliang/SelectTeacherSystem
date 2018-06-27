function LoginCheck() {
    $(document).ready(function(){

        var studentName = $("#studentName").val();
        if (studentName == null || studentName ==="") {
            alert("学生姓名不能为空！");
        }
        else {
            $.post("/Student/nameCheck", {
                "studentName" : studentName
            }, function(data) {
                alert(data);
            }, "text");
        }

    });
}
function test() {
    $.ajax({
        url: "/Student/addStudent",
        contentType: "json",
        data: $('#Register').serialize(),
        success: function (data) {
            if (data.result === "success") {
                alert("注册账号成功！返回首页！");
                window.location.href = 'Admin/adminIndex.jsp';
            } else {
                alert("注册账号失败！重新输入");
                window.location.href = 'Admin/adminAddStudentAccount.jsp';
            }
        }, error: function () {
            alert("网络错误！");
        }
    });
}
function deteleStudent(id){
    $.get("/Student/deleteStudent?studentId=" + id,function(data){
        if("success" === data.result){
            alert("删除成功");
            window.history.back(0);
        }else{
            alert("删除失败");
        }
    });
}
function LoginCheck2() {
    $(document).ready(function(){

        var courseTeachername = $("#teacherName").val();

        if (courseTeachername === null || courseTeachername === "") {
            alert("教师帐号不能为空！");
        }
        else {
            $.post("/Teacher/idCheck", {
                "courseTeachername" : courseTeachername
            }, function(data) {
                alert(data);
            }, "text");
        }

    });
}
function deteleTeacher(id){
    $.get("/Teacher/deleteTeacher?teacherId=" + id,function(data){
        if("success" === data.result){
            alert("删除成功");
            window.history.back(0);
        }else{
            alert("删除失败");
        }
    });
}
function LoginCheck3() {
    $(document).ready(function(){

        var courseId = $("#courseId").val();
        var reg = /^[\d]+$/g;

        if (courseId === null || courseId === "") {
            $("#courseIdCheck").html("课题号不能为空！");
        }else if(!reg.test(courseId)){
            $("#courseIdCheck").html("只能输入数字！");
        }
        else {
            $.post("/Course/idCheck", {
                "courseId" : courseId
            }, function(data) {
                $("#courseIdCheck").html(data);
            }, "text");
        }

    });
}
function LoginCheck4() {
    $(document).ready(function(){

        var courseTeachername = $("#courseTeachername").val();

        if (courseTeachername == null || courseTeachername === "") {
           alert("指导教师不能为空！");
        }
        else {
            $.post("/Teacher/nameCheck", {
                "courseTeachername" : courseTeachername
            }, function(data) {
                alert(data);
            }, "text");
        }

    });
}
