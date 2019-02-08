
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false"
        aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
      <a class="navbar-brand" href="#">Book Club</a>
    </div>
<div id="navbar" class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
      <li><a  class="active" href="${contextPath}/posts"><span class="glyphicon glyphicon-home"></span>Home</a></li>
        <li><a href="${contextPath}/postForm">New Post</a></li>
        <li><a href="${contextPath}/editPost">My Posts</a></li>
        <li><a href="${contextPath}/aboutUs">About Us</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="${contextPath}/registration">Register</a></li>
        <li><a href="${contextPath}/login" >Login</a></li>
        <li><a href="${contextPath}/logout">Logout</a></li>
      </ul>
    </div>
    <!--/.nav-collapse -->
  </div>
</nav>

<div class="container">
  <sec:authorize access="hasRole('ROLE_USER')">
          <a href="postForm"><button class="btn btn-primary">New Post</button></a>
           </sec:authorize>

<c:forEach var="post" items ="${posts}">

<h4>${post.title}</h4>
<p>Posted By:${post.user.name} &nbsp; Post Date: ${post.created}</p>

<p>${post.content}</p>
<p><a href="posts/${post.id}"><button class="btn btn-xs btn-primary">comments</button></a></p>
</c:forEach>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>