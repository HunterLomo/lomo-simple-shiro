<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>简易shiro登录页</title>
</head>
<body>
<h1>登录页面---${message}</h1>
<form:form action="/login" commandName="userEntity" method="post">
  <%--隐藏的：<form:input path="hideInfo" type="hidden"/>--%>
  <%--<br/>--%>
  用户名：<form:input path="userName"/>
  <form:errors path="userName" cssClass="error"/>
  <br/>
  密&nbsp;&nbsp;码：<form:password path="password"/>
  <form:errors path="password" cssClass="error"/>
  <br/>
  <form:button name="button">提交</form:button>
</form:form>
</body>
</html>
