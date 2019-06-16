<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <title>学生信息列表</title>
    <script>
		// 全选/全不选
		function selectAll(select) {
			var ids = document.getElementsByName("ids");
			for (var i=0; i < ids.length; i++) {
				ids[i].checked = select;
			}
		}
		// 反选
		function selectRes() {
			var ids = document.getElementsByName("ids");
			for (var i=0; i < ids.length; i++) {
				ids[i].checked = ids[i].checked !== true;
			}
		}
		// 批量删除方法
		function dels() {
			var ids = document.getElementsByName("ids");
			var arr = [];
			//alert(arr);
			//alert(arr.length);
			for (var i = 0; i < ids.length; i++) {
				if (ids[i].checked) {
					arr.push(ids[i].value);
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

<table border="1" cellspacing="0">
    <tr>
        <th>
            <button onclick="selectAll(true)">全选</button>
            <button onclick="selectAll(false)">全不选</button>
            <button onclick="selectRes()">反选</button>
        </th>
        <th>学生id</th>
        <th>学生名称</th>
        <th>学生性别</th>
        <th>学生年龄</th>
        <th>居住地址</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${list}" var="stu">
        <tr>
            <th>
                <label><input type="checkbox" name="ids" value="${stu.id}"></label>
            </th>
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
    <tr>
        <th colspan="1"><button onclick="dels()">批量删除</button></th>
        <th colspan="5">项目作者：<a href="https://gitee.com/cnsdhh">https://gitee.com/cnsdhh</a></th>
        <th colspan="1"><a href="${pageContext.request.contextPath}/add.jsp">新增</a></th>
    </tr>
</table>
</body>
</html>
