<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
			<li><a href="#"><spring:message code="start"/></a></li>
			<li><a href="http://miw.uniovi.es"><spring:message code="about"/></a></li>
			<li><a href="mailto:dd@email.com"><spring:message code="contact"/></a></li>
		</ul>
	</nav>
	<section>
		
		<a href="?language=en"><spring:message code="ingles"/></a>|<a href="?language=es"><spring:message code="espanol"/></a><br></br>
	
		<a href="register"><spring:message code="register"/>:</a><br /> 
		<article>
			<label class="mytitle"><spring:message code="login.title"/>:</label><br />
			
	<form:form name='loginForm' modelAttribute="loginForm"
		action="send" method='POST'>
		<table>
			<tr>
				<td><spring:message code="login.user"/>:</td>
				<td><form:input type='text' path='login'></form:input></td>
			</tr>
			<tr>
				<td><spring:message code="login.password"/>:</td>
				<td><form:input type='password' path='password' /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="<spring:message code="login.submit"/>"/></td>
				<td><input name="reset" type="reset" value="<spring:message code="login.reset"/>"/></td>
			</tr>
			<tr><form:errors path="password" style="color: red;"/></tr>
		</table>

	</form:form>
			
		</article>
	</section>
	<footer>
		<strong><spring:message code="footer1"/></strong><br />
		<em><spring:message code="footer2"/></em>
	</footer>
</body>