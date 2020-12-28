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

if(count($_POST) > 0) {

    $sql = "SELECT id, password, first_name, last_name, photo, role_id FROM users";

    $result = $conn->query($sql);
    
    while($row = $result->fetch_assoc()) {
        if(($row["first_name"] == $_POST["first_name"]) && ($row["password"] == $_POST["password"])) {
            $_SESSION['user_id'] = $row["id"];
            $_SESSION['first_name'] = $_POST["first_name"];
            $_SESSION['last_name'] = $row["last_name"];
            $_SESSION['photo'] = $row["photo"];
            $_SESSION['role_id'] = $row["role_id"];
            $_SESSION['auth'] = true;
            if($row['role_id'] == 1) {
                
                header('Location: lb2_main_adm.php');    
            } else {
                header('Location: lb2_main.php');
            }
        break;
        } else {
            $_SESSION['auth'] = false;
        }
    }
    
}


?>