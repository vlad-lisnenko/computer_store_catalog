<?php 

session_start();

$_SESSION['auth'] = false;

header('Location: lb2_main.php');

?>