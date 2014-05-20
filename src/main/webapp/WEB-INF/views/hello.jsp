<%@ include file="/WEB-INF/views/include.jsp"%>

<html>
<head>
<title><fmt:message key="title" /></title>
</head>
<body>
	<h1>
		<fmt:message key="heading" />
	</h1>
	<p>
		<fmt:message key="greeting" />
		<c:out value="${model.now}" />
	</p>
	<h3>List of the all employees</h3>
	<c:forEach items="${model.allEmployees}" var="allEmplo">
		<br>
		<a
			href="<c:url value="reallocateEmployee.htm?id1=${allEmplo.idEmployee}&id2=${allEmplo.office.id}"/>">
			Employee:  ${allEmplo.idEmployee}  ${allEmplo.name}   -->   Office: 
			${allEmplo.office.name}  ${allEmplo.office.id}</a>
		<br>
		<br>
	</c:forEach>
</body>
</html>