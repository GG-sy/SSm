<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <title>登陆页面</title>
</head>

<body>
    <h1>登陆页面</h1>

    <form action="${pageContext.request.contextPath}/user/login.do" method="post">
        <label for="username">用户：</label>
        <input id="username" type="text" name="username"><br/>

        <label for="password">密码：</label>
        <input id="password" type="text" name="password"><br/>

        <button type="submit">登陆</button>
        ${msg}
    </form>
</body>
</html>
