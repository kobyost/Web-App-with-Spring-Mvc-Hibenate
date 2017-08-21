<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>

<head>
	<title>Save Customer</title>
	
	<!-- reference our style sheet -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css"/>
		  
		  <link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
		  
		 
		  

</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Management</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Customer</h3>
		
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
		<!-- need to associate this data with customer id -->
		<form:hidden path="id"/>
		
		
		<table>
			<tbody>
			<c:set var = "firstName" scope = "session" value = "firstName"/>
			<c:set var = "lastName" scope = "session" value = "lastName"/>
			<c:set var = "email" scope = "session" value = "email"/>
				<tr>
					<td><label>First Name:</label></td>
					<td><form:input path="firstName"/>
					<c:choose>
         
			         <c:when test = "${ empty errorMap.get(firstName)}">
			           
			         </c:when>
		
			         <c:otherwise>
			          <span style="color:red;">${errorMap.get(firstName)}</span>   
			         </c:otherwise>
			      </c:choose>
					</td>
				</tr>
				<tr>
					<td><label>Last Name:</label></td>
					<td><form:input path="lastName"/>
					
					<c:choose>
         
			         <c:when test = "${ empty errorMap.get(lastName)}">
			           
			         </c:when>
				     
			         <c:otherwise>
			          <span style="color:red;">${errorMap.get(lastName)}</span>   
			         </c:otherwise>
			      </c:choose>
					
					</td>
					
				</tr>
				<tr>
					<td><label>Email:</label></td>
					<td><form:input path="email"/>
					<c:choose>
			         <c:when test = "${ empty errorMap.get(email)}">
			           
			         </c:when>
		
			         <c:otherwise>
			          <span style="color:red;">${errorMap.get(email)}</span>   
			         </c:otherwise>
			      </c:choose>
					
					</td>
					
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" class="save"></td>
					
				</tr>
				
			</tbody>
			
		</table>
		
		
		</form:form>
		
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
		</p>
	
	</div>

</body>



</html>