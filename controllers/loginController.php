<?php

session_start();
include('../config.php');
if(isset($_SESSION['user'])){
    include('../views/myAccount.php');
}
else{
    include('../views/login.php');
}

?>
