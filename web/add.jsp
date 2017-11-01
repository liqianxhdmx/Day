<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <meta charset="utf-8">
    <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap-3.3.7/bootstrap.min.css">
    <script src="bootstrap/javascripts/jquery-2.2.0/jquery-2.2.0.min.js"></script>
    <script src="bootstrap/javascripts/bootstrap-3.3.7/bootstrap.min.js"></script>
  </head>
  <body>
  <form class="form-horizontal" action="add.do" method="post">
    <div class="form-group">
      <label class="col-sm-2 control-label">学号:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" name="studentId">
      </div>
    </div>
    <div class="form-group">
      <label class="col-sm-2 control-label">姓名:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" name="studentName">
      </div>
    </div>
    <div class="form-group">
      <label class="col-sm-2 control-label">性别:</label>
      <div class="col-sm-10">
        <input type="radio" name="studentSex" value="male">male
        <input type="radio" name="studentSex" value="female">female
      </div>
    </div>
    <div class="form-group">
      <label class="col-sm-2 control-label">年龄:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" name="studentAge">
      </div>
    </div>
    <div class="form-group">
      <label class="col-sm-2 control-label">学历:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" name="studentEducation">
      </div>
    </div>
    <div class="form-group">
      <div class="col-sm-offset-8 col-sm-4">
        <input type="reset" value="取消">
        <input type="submit" value="提交">
      </div>
    </div>
  </form>
  </body>
</html>
