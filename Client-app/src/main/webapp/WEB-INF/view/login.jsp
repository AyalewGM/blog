
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <title>Log in with your account</title>

    

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
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
        <li><a href="${contextPath}/logout" >Logout</a></li>
      </ul>
    </div>
    <!--/.nav-collapse -->
  </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-body">
                    <h5 class="text-center">
                        SIGN UP</h5>
                    <form class="form form-signup" role="form" method="POST" action="<c:url value="/j_spring_security_check"></c:url>" >
                    <c:if test="${param.error != null}"> 
	              <p>Invalid username / password</p>
                 </c:if>
                    
                    <div class="form-group" ${error != null ? 'has-error' : ''}>
                        <span>${message}</span>
                     
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span>
                            </span>
                            <input type="text" name="j_username" class="form-control" placeholder="username" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                             <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                            <input type="password" name="j_password" class="form-control" placeholder="Password" />
                   
                  <span>    <c:if test="${param.error ne null}"></c:if>
                        </div>
                    </div>
                
                  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
               <button class="btn btn-sm btn-primary btn-block" type="submit">
                    SUBMIT</button>
                     <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
                    </form>
                    </div>
            </div>
        </div>
    </div>
</div>
 
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
 
</body>
</html>
