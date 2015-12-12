<html>
    <head>
        <title>IFStore | Buy shit.</title>
        <link rel="stylesheet" type="text/css" href="<?php echo Config::get('assetsPath'); ?>css/main.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    </head>
    <body>
        <form method="post" action="<?php echo Config::get('controllersPath');?>loginController.php">
            Login plis. <br />
            Username: <input type="text"></input>
            Password: <input type="password"></input>
            <input type="submit"></input>
        </form>
    </body>
</html>
