<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html >
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<head>
<title>Amazin</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $("#locales").change(function () {
        var selectedOption = $('#locales').val();
        if (selectedOption != ''){
            window.location.replace('menu?lang=' + selectedOption);
        }
    });
});
</script>
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
			<li><a href="#"><spring:message code="start" text="default" /></a></li>
			<li><a href="http://miw.uniovi.es"><spring:message code="contact"/></a></li>
			<li><a href="mailto:dd@email.com"><spring:message code="about"/></a></li>
			<li><a href="logout"><spring:message code="logout"/></a></li>
		</ul>
	</nav>
	<section>
	
		<a href="?language=en"><spring:message code="ingles"/></a>|<a href="?language=es"><spring:message code="espanol"/></a><br></br>
			
		<article id="a01">
			<label class="mytitle"><spring:message code="index.chooseOption"/>:</label><br /> 
			<a href="showBooks"><spring:message code="index.showCatalog"/></a><br /> 
			<a href="showSpecialOffer"><spring:message code="index.showSpecialOffers"/></a><br />  
			<spring:message code="index.visits"/>: <c:out value="${loginCounter.logins}"/>
		</article>
	</section>
	<footer>
		<strong><spring:message code="footer1" text="default"/></strong><br /> <em><spring:message code="footer2"/> </em>
	</footer>
</body>
