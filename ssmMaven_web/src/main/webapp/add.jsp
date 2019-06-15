<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <title>添加学生信息</title>
</head>

<body>
    <h1>添加学生信息</h1>

    <form action="${pageContext.request.contextPath}/student/add.do" method="post">
        <label for="name">学生姓名：</label>
        <input id="name" type="text" name="name"><br/>

        学生性别：
        <label for="male">男</label>
        <input id="male" type="radio" name="sex" value="1">
        <label for="female">女</label>
        <input id="female" type="radio" name="sex" value="0"><br/>

        <label for="age">学生年龄：</label>
        <input id="age" type="text" name="age"><br/>

        <label for="address">学生地址：</label>
        <input id="address" type="text" name="address"><br/>

        <button type="submit">新增</button>
    </form>
</body>
</html>
