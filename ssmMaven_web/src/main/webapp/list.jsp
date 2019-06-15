<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <title>学生信息列表</title>
    <script>
        // 全选方法
        function selectAll() {
	        var elementsByName = document.getElementsByName("ids");
	        for (var i = 0; i < elementsByName.length; i++) {
	        	if (elementsByName[i].checked) {
	        		elementsByName[i].removeAttribute("checked")
                } else {
			        elementsByName[i].setAttribute("checked", "checked");
                }
            }
        }
        // 批量删除方法
		function dels() {
			var elementsByName = document.getElementsByName("ids");
			var arr = [];
			//alert(arr);
			//alert(arr.length);
            for (var i = 0; i < elementsByName.length; i++) {
                if (elementsByName[i].checked) {
                    arr.push(elementsByName[i].value);
                    console.log(arr);
                }
            }
            //alert(arr);
            //alert(arr.length);
            if (arr.length !== 0) {
                location.href = "${pageContext.request.contextPath}/student/delete.do?ids=" + arr;
            } else {
				alert("未选中要删除的条目，请选中后再执行【批量删除】")
            }
		}
    </script>
</head>

<body>
    <h1>学生信息列表</h1>

    <a href="${pageContext.request.contextPath}/add.jsp">新增</a>
    &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
    <button onclick="dels()">批量删除</button>

    <table border="1" cellspacing="0">
        <tr>
            <th><input type="checkbox" name="selectAll" onclick="selectAll()"></th>
            <th>学生id</th>
            <th>学生名称</th>
            <th>学生性别</th>
            <th>学生年龄</th>
            <th>居住地址</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${list}" var="stu">
            <tr>
                <td>
                    <input type="checkbox" name="ids" value="${stu.id}">
                </td>
                <td>${stu.id}</td>
                <td>${stu.name}</td>
                <td>
                    <%--<c:if test="${stu.sex==1}">男</c:if>--%>
                    <%--<c:if test="${stu.sex==0}">女</c:if>--%>
                    ${stu.sex==1?'男':stu.sex==0?'女':'其他'}
                </td>
                <td>${stu.age}</td>
                <td>${stu.address}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/student/findOne.do?id=${stu.id}">修改</a>
                    &nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/student/delete.do?ids=${stu.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
