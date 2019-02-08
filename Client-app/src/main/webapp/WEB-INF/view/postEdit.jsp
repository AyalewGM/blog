<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Personal posts</title>
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
      <a class="navbar-brand" href="/">Book Club</a>
    </div>
    <div id="navbar" class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
      <li><a  class="active" href="${contextPath}/posts"><span class="glyphicon glyphicon-home"></span>Home</a></li>
        <li><a href="${contextPath}/postForm">New Post</a></li>
        <li><a href="${contextPath}/editPost">My Posts</a></li>
        <li><a href="${contextPath}/aboutUs">About Us</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        
        <li><a href="${contextPath}/login" >Login</a></li>
        <li><a href="${contextPath}/logout"  >Logout</a></li>
      </ul>
    </div>
</nav>
<div class="container">
	<h1>Here are your recent posts</h1>
	<p><a href="${contextPath}/postForm"><button class="btn btn-xs btn-primary">Post Something</button></a></p>
    <c:forEach var="post" items ="${userPosts}">
    <h2>${post.title}</h2>
   <p> Post Date: ${post.created}</p>
<p>${post.content}</p><a href="posts/${post.id}/onePost"><button class="btn btn-xs btn-primary">edit</button></a>
    </c:forEach>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>