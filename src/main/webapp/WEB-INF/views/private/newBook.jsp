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
			<li><a href="/Amazin/private/menu"><spring:message code="start" text="default" /></a></li>
			<li><a href="http://miw.uniovi.es"><spring:message code="contact"/></a></li>
			<li><a href="mailto:dd@email.com"><spring:message code="about"/></a></li>
			<li><a href="logout"><spring:message code="logout"/></a></li>
		</ul>
	</nav>
	<section>
		<a href="?language=en"><spring:message code="ingles"/></a>|<a href="?language=es"><spring:message code="espanol"/></a><br></br>
		
		<article>
			<label class="mytitle"><spring:message code="newBook.title"/></label><br />
			
			<form:form modelAttribute="book">
				<form:errors path="" />
				<br />
				<spring:message code="newBook.bookTitle"/> <form:input path="title" />
				<form:errors path="title" />
				<br />
				<spring:message code="newBook.bookDescription"/> <form:input path="description" />
				<form:errors path="description" />
				<br />
				<spring:message code="newBook.bookAuthor"/> <form:input path="author" />
				<form:errors path="author" />
				<br />
				<spring:message code="newBook.basePrice"/> <form:input path="basePrice" />
				<form:errors path="basePrice" />
				<br />
				<input type="submit" />
			</form:form>
			<p style="color: red;">
				<c:out value="${message}" />
			</p>
		</article>
	</section>
	<footer>
		<strong><spring:message code="footer1"/></strong><br /> <em><spring:message code="footer2"/> </em>
	</footer>
</body>