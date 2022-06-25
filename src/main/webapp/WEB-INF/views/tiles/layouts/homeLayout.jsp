<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <title><tiles:getAsString name="title"/></title>

  <link href="<c:url value="/assets/css/app.css"/>" rel="stylesheet" type="text/css"/>
  <link href="<c:url value="/assets/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css"/>
  <link href="<c:url value="/assets/css/bootstrap-icons.css"/>" rel="stylesheet"/>

  <script src="<c:url value="/assets/js/jquery-3.6.0.min.js"/>"></script>
  <script src="<c:url value="/assets/js/popper.min.js"/>"></script>
  <script src="<c:url value="/assets/js/bootstrap.min.js"/>"></script>
</head>

<style>
  .bd-navbar {
    padding: .75rem 0;
    background-color: transparent;
    background-image: linear-gradient(to bottom, rgba(116, 49, 249, 1), rgba(116, 49, 249, 0.95));
  }

  .navbar-brand {
    font-size: 1.25rem;
    color: #FFFFFF;
    white-space: nowrap;
    box-shadow: none !important;
  }

  .bd-placeholder-img {
    font-size: 1.125rem;
    text-anchor: middle;
    -webkit-user-select: none;
    -moz-user-select: none;
    user-select: none;
  }

  @media (min-width: 768px) {
    .bd-placeholder-img-lg {
      font-size: 3.5rem;
    }
  }

  .b-example-divider {
    height: 3rem;
    background-color: rgba(0, 0, 0, .1);
    border: solid rgba(0, 0, 0, .15);
    border-width: 1px 0;
    box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
  }

  .b-example-vr {
    flex-shrink: 0;
    width: 1.5rem;
    height: 100vh;
  }

  .bi {
    vertical-align: -.125em;
    fill: currentColor;
  }

  .nav-scroller {
    position: relative;
    z-index: 2;
    height: 2.75rem;
    overflow-y: hidden;
  }

  .nav-scroller .nav {
    display: flex;
    flex-wrap: nowrap;
    padding-bottom: 1rem;
    margin-top: -1px;
    overflow-x: auto;
    text-align: center;
    white-space: nowrap;
    -webkit-overflow-scrolling: touch;
  }
</style>

<body>
<div>
  <tiles:insertAttribute name="header"/>
  <div class="container-fluid">
    <div class="row">
      <main>
        <tiles:insertAttribute name="body"/>
      </main>
    </div>
  </div>
  <tiles:insertAttribute name="footer"/>
</div>
</body>
</html>
