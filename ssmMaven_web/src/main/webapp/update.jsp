<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <title>修改学生信息</title>
</head>

<body>
    <h1>修改学生信息</h1>

    <form action="${pageContext.request.contextPath}/student/update.do" method="post">
        <input type="hidden" name="id" value="${stu.id}">

        <label for="name">学生姓名：</label>
        <input id="name" type="text" name="name" value="${stu.name}"><br/>

        学生性别：
        <label for="male">男</label>
        <input id="male" type="radio" name="sex" value="1" <c:if test="${stu.sex==1}">checked</c:if>>
        <label for="female">女</label>
        <input id="female" type="radio" name="sex" value="0" <c:if test="${stu.sex==0}">checked</c:if>><br/>

        <label for="age">学生年龄：</label>
        <input id="age" type="text" name="age" value="${stu.age}"><br/>

        <label for="address">学生地址：</label>
        <input id="address" type="text" name="address" value="${stu.address}"><br/>

        <button type="submit">修改</button>
    </form>
</body>
</html>
