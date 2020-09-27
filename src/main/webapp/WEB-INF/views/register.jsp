<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html >
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<head>
<title>Amazin</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
	<header>
		<h1 class="header">Amazin.com</h1>
		<h2 class="centered">
			<spring:message code="welcome"/>
		</h2>
	</header>
	<nav>
		<ul>
			<li><a href="login"><spring:message code="start"/></a></li>
			<li><a href="http://miw.uniovi.es"><spring:message code="about"/></a></li>
			<li><a href="mailto:dd@email.com"><spring:message code="contact"/></a></li>
		</ul>
	</nav>
	<section>
			<a href="?language=en"><spring:message code="ingles"/></a>|<a href="?language=es"><spring:message code="espanol"/></a><br></br>
	
		<article>
			<label class="mytitle"><spring:message code="login.title"/>:</label><br />
			
	<form:form modelAttribute="user" action="register" method="POST">	
	
		<table>
			<tr>
				<td><spring:message code="register.name"/>:</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" style="color: red;"/></td>
			</tr>
			<tr>
				<td><spring:message code="register.surname"/>:</td>
				<td><form:input path="surname" /></td>
				<td><form:errors path="surname" style="color: red;"/></td>
			</tr>
			<tr>
				<td><spring:message code="register.login"/>:</td>
				<td><form:input path="login" /></td>
				<td><form:errors path="login" style="color: red;"/></td>
			</tr>
			<tr>
				<td><spring:message code="register.mail"/>:</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" style="color: red;"/></td>
			</tr>
			<tr>
				<td><spring:message code="register.age"/>:</td>
				<td><form:input path="age" /></td>
				<td><form:errors path="age" style="color: red;"/></td>
			</tr>
			<tr>
				<td><spring:message code="register.phone"/>:</td>
				<td><form:input path="phone" /></td>
				<td><form:errors path="phone" style="color: red;"/></td>
			</tr>
			<tr>
				<td><spring:message code="register.password"/>:</td>
				<td><form:password path="password"/></td>
				<td><form:errors path="password" style="color: red;"/></td>
			</tr>
			<tr>
				<td><spring:message code="register.repeatPassword"/>:</td>
				<td><form:password path="repeatPassword"/></td>
				<td><form:errors path="repeatPassword" style="color: red;"/></td>
			</tr>
			<tr>
				<td><button type="submit" ><spring:message code="register.send"/></button></td>
				<td></td>
			</tr>
			
		</table>
	</form:form>
			
		</article>
	</section>
	<footer>
		<strong><spring:message code="footer1"/></strong><br />
		<em><spring:message code="footer2"/></em>
	</footer>
</body>