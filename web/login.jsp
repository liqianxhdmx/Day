<%@page pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>登录页面</title>
    <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap-3.3.7/bootstrap.min.css">
    <script src="bootstrap/javascripts/jquery-2.2.0/jquery-2.2.0.min.js"></script>
    <script src="bootstrap/javascripts/bootstrap-3.3.7/bootstrap.min.js"></script>
</head>
<body>
<div>
    <div class="container-fluid">
        <form action="login.do" method="post">
            <div class="form-group">
                <label class="col-sm-2 control-label">账号:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="adminCode" value="${param.adminCode }">
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">密码:</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" name="password">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-8 col-sm-4">
                    <input type="submit">
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
