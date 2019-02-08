<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>single post</title>
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
        <li><a href="${contextPath}/login" >Login</a></li>
        <li><a href="${contextPath}/logout" >Logout</a></li>
      </ul>
    </div>
    <!--/.nav-collapse -->
  </div>
</nav>
	
	<div class ="container">
	<h2>Edit Your post</h2>
	<div class="row">
	<div class="col-sm-6">
    <form action ="${contextPath}/${user.id}/posts/${onePost.id}" method ="post">
      <div class="form-group">
    <label for="title"> Title</label>
    <input type="text" class="form-control" id="title" name ="title" value="${onePost.title}" >
      </div>
   <%--  Title <input type="text" value="${onePost.title}" name ="title"></br> --%>
    <div class="form-group">
       <label for="content">Content</label>
       <input type="text" class="form-control" id="content" name ="content" value="${onePost.content}" >
       </div>
   <%--  Content <input type="text" value="${onePost.content}" name ="content"> --%>
     <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
    <button class="btn btn-primary" type="submit" >update</button>
    </form>
    <form action="${contextPath}/delete?postId=${onePost.id}&userId=${user.id}" method ="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
    <button class="btn btn-warning" type="submit" >Delete</button>
    </form>
    
    </div>
    </div>
    </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>