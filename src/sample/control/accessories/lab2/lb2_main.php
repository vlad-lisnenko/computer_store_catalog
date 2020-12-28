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
?>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets\styles\main-page-style.css">
    <title>Document</title>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <div class="jumbotron text-center">
        <h1>User Service</h1>
    </div>
    
    <div class="top-panel">
    <?php 
    if ($_SESSION['auth'] == true) {
        echo $_SESSION['first_name'] . "  |  " . <<< HTML
        <a href="lb2_logout.php">Log out</a><br>
        HTML;
        $userId = $_SESSION['user_id'];
        echo '<a href="' . htmlspecialchars("lb2_simple_user_page.php?id=" . urlencode($userId)) . '">'. "Change my Profile" . '</a>';
    } else {
        echo <<< HTML
        <a href="lb2_login.php">Log in.</a>
        HTML;
    }
    ?>
    </div>

    <h2>All users:</h2>
    <div class="containe">
    <table class="table">
    <thead>
      <tr>
        <th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Role</th>
      </tr>
    </thead>
    <tbody>
    <?php 
    
    $sql = "SELECT id, first_name, last_name, role_id FROM users";

    $result = $conn->query($sql);
    
    while($row = $result->fetch_assoc()) {
        echo '<tr>';
        echo '<td>ID: ' . $row["id"] . '</td>';
        echo '<td>User name: ' . $row["first_name"] . '</td>';
        echo '<td>User last name: ' . $row["last_name"] . '</td>';
        if($row["role_id"] == 1) {
            echo '<td>User role: Admin</td>';
        } else {
            echo '<td>User role: User</td>';
        }
        echo '</tr>';
    }
    ?>
    </tbody>
    </table>
    </div>

</body>
</html>