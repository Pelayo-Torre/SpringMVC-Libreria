<!DOCTYPE html >
<%@ page contentType="text/html; charset=iso-8859-1"
	pageEncoding="iso-8859-1" language="java"
	import="java.util.*, com.miw.model.Book,com.miw.presentation.book.*"
	errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<li><a href="/Amazin/private/newBook"><spring:message code="shoppingCart.addNew"/></a></li>
			<li><a href="/Amazin/private/menu"><spring:message code="start" text="default" /></a></li>
			<li><a href="http://miw.uniovi.es"><spring:message code="contact"/></a></li>
			<li><a href="mailto:dd@email.com"><spring:message code="about"/></a></li>
			<li><a href="/Amazin/private/logout"><spring:message code="logout"/></a></li>
		</ul>
	</nav>
	<section>
		<h2><spring:message code="shoppingCart.title"/></h2>
		<a href="?language=en"><spring:message code="ingles"/></a>|<a href="?language=es"><spring:message code="espanol"/></a><br></br>
		<article>
			<form:form method="POST" action="addCart" modelAttribute="booksSelected">
				<form:checkboxes items="${booklist}" path="seleccionados" itemValue="id" itemLabel="title"/>
				<button type="submit" ><spring:message code="register.send"/></button>
			</form:form>
			
		</article>
	</section>
	<footer>
		<strong><spring:message code="footer1"/></strong><br /> <em><spring:message code="footer2"/> </em>
	</footer>
</body>