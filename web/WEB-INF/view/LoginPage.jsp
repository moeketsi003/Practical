<%-- 
    Document   : LoginPage
    Created on : May 19, 2017, 10:06:37 AM
    Author     : Mega
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></link>
        <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
        
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
        <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
        <title>Project List Login</title>
    </head>
    <body>
        <div class="form-container" style="width: 40%; margin: auto;">
     
            <h1 style="text-align: center;">Login</h1>
            
            <h5 style="text-align: center;">${message}</h5>

            <form:form method="POST" modelAttribute="user" class="form-horizontal">

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="control-lable" for="username">Username</label>
                        <div>
                            <form:input type="text" path="username" id="username" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="username" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="control-lable" for="password">Password</label>
                        <div>
                            <form:input type="password" path="password" id="password" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="password" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <div class="form-actions" style="float: right;">
                            <input type="submit" value="Login" class="btn btn-primary btn-sm">
                        </div>
                    </div>
                </div>
            </form:form>
        </div>
    </body>
</html>
