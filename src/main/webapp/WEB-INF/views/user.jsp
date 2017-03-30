<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
  <title>用户列表</title>
</head>
<body>
<h1>${message}</h1>

<h2>-----------------权限列表-----------------</h2>
<shiro:authenticated>用户已经登录显示此内容</shiro:authenticated>
<br/>
<shiro:hasRole name="manager">manager角色显示</shiro:hasRole>
<br/>
<shiro:hasRole name="admin">admin角色显示</shiro:hasRole>
<br/>
<shiro:hasRole name="normal">normal角色显示</shiro:hasRole>
<br/>

<shiro:hasAnyRoles name="manager,admin">**manager or admin角色用户登录显示**</shiro:hasAnyRoles>
<br/>
<shiro:principal/>=====显示当前登录用户名
<br/>
<shiro:hasPermission name="add">add权限</shiro:hasPermission>
<br/>
<shiro:hasPermission name="query">query权限</shiro:hasPermission>
<br/>
<shiro:hasPermission name="del">del权限</shiro:hasPermission>

<h2>-----------------用户列表-----------------</h2>

<h2><a href="/user/add">添加用户</a>--<a href="/logout">退出登录</a></h2>
<table>
  <tr>
    <th>序号</th>
    <th>id</th>
    <th>userName</th>
    <th>password</th>
  </tr>
  <c:forEach items="${userEntityList}" var="userEntityList_loop" varStatus="userEntityList_status">
    <tr>
      <td>${userEntityList_status.index + 1}</td>
      <td>${userEntityList_loop.id}</td>
      <td>${userEntityList_loop.userName}</td>
      <td>${userEntityList_loop.password}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
