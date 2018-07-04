<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Log-In</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="/res/css/style.css" type="text/css" rel="stylesheet">
</head>
<body>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


<style>
    body{padding-top:5%;}
    .recsenha{ text-align: center; margin-top:15px; color:#444;}
    .recsenha a,
    .recsenha a:hover,
    .recsenha a:visited,
    .recsenha a:active {text-decoration: none; color:#444;}
    .container {border:none; box-shadow: none;}
    .mybtn-action {margin-top:25px;}
</style>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Login</h3>
                </div>
                <div class="panel-body">
                    <form accept-charset="UTF-8" role="form" method="post" action="/login" >
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="Username" name="user" type="text">
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Password" name="pwd" type="password" value="">
                            </div>

                            <input class="btn btn-lg btn-success btn-block mybtn-action" type="submit" value="LOG IN">
                        </fieldset>
                        <div class="recsenha">
                            <label><a href="">Forgot Password?</a></label>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>