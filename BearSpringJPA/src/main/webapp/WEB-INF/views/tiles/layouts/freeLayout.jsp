<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

  <title><tiles:getAsString name="title"/></title>

  <link href="<c:url value="/assets/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css"/>
  <link href="<c:url value="/assets/css/app.css"/>" rel="stylesheet" type="text/css"/>

  <script src="<c:url value="/assets/js/jquery-3.6.0.min.js"/>"></script>
  <script src="<c:url value="/assets/js/popper.min.js"/>"></script>
  <script src="<c:url value="/assets/js/bootstrap.min.js"/>"></script>
</head>

<body>
<div class="container-fluid">
  <article>
    <tiles:insertAttribute name="body"/>
  </article>
</div>
</body>
</html>
