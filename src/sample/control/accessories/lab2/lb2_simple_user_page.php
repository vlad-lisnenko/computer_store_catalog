<?php
session_start();

$servername = "localhost";
$username = "root";
$password = "";
$database = "labdb";

$conn = new mysqli($servername, $username, $password, $database);

if ($conn -> connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$currentUser = $_GET['id'];

$sql = "SELECT id, first_name, last_name, password, role_id, photo FROM users WHERE id='$currentUser'";
$result = $conn->query($sql);

while($row = $result->fetch_assoc()) {
    $currentUserName =  $row["first_name"];
    $currentUserLastName = $row["last_name"];
    $currentUserRole = $row["role_id"];
    $currentUserPhoto = $row["photo"];
    $currentUserPass = $row["password"];
}

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

<form action="lb2_simple_update_ex_user.php" method="POST" enctype="multipart/form-data">
    <input type="hidden" name="userId" value="<?=$currentUser;?>" >
        
    Select image to upload: 
    <input type="file" name="fileToUpload" id="fileToUpload" value="<?=$currentUserPhoto;?>">
    <div class="form-group">
        <label for="fName">First Name:</label>
        <input type="name" class="form-control" placeholder="Enter your name" name="name" required pattern="[A-Za-z0-9]{2,}" value="<?=$currentUserName;?>">
    </div>
    <div class="form-group">
        <label for="sName">Surame:</label>
        <input type="name" class="form-control" placeholder="Enter new surname" name="surname" required pattern="[A-Za-z0-9]{2,}" value="<?=$currentUserLastName;?>">
    </div>
    <div class="form-group">
        <label for="password">First Name:</label>
        <input type="name" class="form-control" placeholder="Enter new password" name="password" required pattern="[A-Za-z0-9]{6,}" value="<?=$currentUserPass;?>">
    </div>

    <input type="submit" value="Update" name="submit" class="btn btn-default">
    <a href="lb2_main.php" class="btn btn-default">Back</a>
</form>

</body>
</html>