<?php
session_start();
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="assets\styles\main-page-style.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <div class="jumbotron text-center">
        <h1>User Service</h1>
    </div>
    <form action="lb2_new_user.php" method="POST" enctype="multipart/form-data">
    Select image to upload:
    <input type="file" name="fileToUpload" id="fileToUpload">
    <div class="form-group">
        <label for="fName">First Name:</label>
        <input type="name" class="form-control" placeholder="Enter your name" name="name" required pattern="[A-Za-z0-9]{2,}">
    </div>
    <div class="form-group">
        <label for="sName">Surname:</label>
        <input type="name" class="form-control" placeholder="Enter your surname" name="surname" required pattern="[A-Za-z0-9]{2,}" >
    </div>
    <div class="form-group">
        <label for="password">Password:</label>
        <input type="text" class="form-control" placeholder="Create your password" name="password" required pattern="[A-Za-z0-9]{6,}" >
    </div>
    <div class="form-group">
    <select name="role_id">
    <option value="0">USER</option>
    <option value="1">ADMIN</option>
    </select>
    </div>
    
    <input type="submit" value="Register" name="submit" class="btn btn-default">
    </form>
    <a href="lb2_main.php" class="btn btn-default">Back</a>
</body>
</html>