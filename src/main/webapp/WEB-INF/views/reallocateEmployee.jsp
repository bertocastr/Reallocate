<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
  <title><fmt:message key="title"/></title>
  <style>
    .error { color: red; }
  </style>  
</head>
<body>
<h1><fmt:message key="reallocateEmployee.heading"/></h1>
<form:form method="post" commandName="changeOffice">
  <table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="5">
    <tr>
      <td align="right" width="20%">Oficina:</td>
        <td width="20%">
        <p>Oficina del empleado: <%=request.getParameter("id2") %></p>
        <br>
          <form:input path="idOffice"/>
        </td>
        <td width="60%">
          <form:errors path="idOffice" cssClass="error"/>
        </td>
    </tr>
    <tr>
      <td align="right" width="20%">DNI:</td>
        <td width="20%">
        <p>DNI del empleado a modificar: <%=request.getParameter("id1") %></p>
        <br>
          <form:input path="dniEmployee"/>
        </td>
        <td width="60%">
          <form:errors path="dniEmployee" cssClass="error"/>
        </td>
    </tr>
    
  </table>
  <br>
  <input type="submit" value="Execute">
</form:form>
<a href="<c:url value="hello.htm"/>">Home</a>
</body>
</html>