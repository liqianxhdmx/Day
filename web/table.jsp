<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="refresh" content="20">
        <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap-3.3.7/bootstrap.min.css">
        <script src="bootstrap/javascripts/jquery-2.2.0/jquery-2.2.0.min.js"></script>
        <script src="bootstrap/javascripts/bootstrap-3.3.7/bootstrap.min.js"></script
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    </head>
    <body>
        <script >
            function deleteF(id){
                var confirm=window.confirm("确定删除么?");
                if(confirm){
                    location.href="deleteStudent.do?id="+id;
                }
            }
        </script>
        <h3 style="text-align: center;color: grey">学生信息</h3>
        <div class="container">
            <div class="row">
                <%--这里必须跳转到addStudent.do，完成请求和响应，而不能直接跳转add.jsp。--%>
                <input type="button" value="新增" class="btn btn-success" onclick="location.href='addStudent.do';" />
                <input type="button" value="查询" class="btn btn-info" onclick="">
                <input type="text" name="inquire">
            </div>
            <div class="row" style="margin-top: 15px">
                <form>
                    <table class="table table-bordered table-responsive table-striped">
                        <thead>
                        <tr>
                            <th>serialId</th>
                            <th>studentId</th>
                            <th>studentName</th>
                            <th>studentSex</th>
                            <th>studentAge</th>
                            <th>studentEducation</th>
                            <th>message</th>
                        </tr>
                        <c:forEach items="${students}" var="s" varStatus="status">
                        <tr>
                            <th>${status.index+1}</th>
                            <th>${s.studentId}</th>
                            <th>${s.studentName}</th>
                            <th>${s.studentSex}</th>
                            <th>${s.studentAge}</th>
                            <th>${s.studentEducation}</th>
                            <td>
                                <input type="button" value="修改" class="btn btn-warning"
                                        onclick="location.href='toUpdate.do?id=${s.studentId}';"/>
                                <input type="button" value="删除" class="btn btn-danger" style="margin-left: 8px"
                                       onclick="deleteF(${s.studentId});"/>
                            </td>
                        </tr>
                        </c:forEach>
                        </thead>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>



