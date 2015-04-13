<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${allLanguages}" var = "language">

${language.id} : ${language.languageName} : ${language.country.countryName}<br> 

</c:forEach>
</body>
</html>