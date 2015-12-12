<html>
    <head>
        <title>IFStore | Buy shit.</title>
        <link rel="stylesheet" type="text/css" href="assets/css/main.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    </head>
    <body>
        <div class="wrapper">
            <div class="topBar">
            </div>
            <div class="banner">
                <h1 class="bannerText">
                    IF Store.
                </h1>
            </div>
            <div class="mainText">
                <div class="mainTextContent submit">
                    Submit
                </div>
                <div class="mainTextContent search">
                    <form method="GET" action="results.php" id="search-form">
                        <input class="search-box" type="text" name="search" placeholder="Search">
                        <div class="submit-button"><i class="fa fa-3x fa-search"></i></div>
                        <div id="search-suggestions">
                            <?php
                                foreach($defaultSearchSuggestions as $item){
                                    echo $item;
                                }
                            ?>
                        </div>
                    </form>
                </div>
                <div class="mainTextContent login">
                    Login <span class = "ifBig">/</span> <span class="small">Sign Up</span>
                </div>
            </div>
            <div class="allContent">
                <div class="contentBox">
                    <div class="contentTitle">F<br>e<br>a<br>t<br>u<br>r<br>e<br>d</div>
                    <div class="contentBoxContent"></div>
                </div>
                <div class="contentBox">
                    <div class="contentTitle">I<br>F<br><br>C<br>o<br>m<br>i<br>c<br>s</div>
                    <div class="contentBoxContent"></div>
                </div>
                <div class="contentBox">
                    <div class="contentTitle">T<br>o<br>p<br><br>S<br>h<br>e<br>l<br>f</div>
                    <div class="contentBoxContent"></div>
                </div>
                <div class="contentBox">
                    <div class="contentTitle"><br>P<br>o<br>p<br>u<br>l<br>a<br>r</div>
                    <div class="contentBoxContent"></div>
                </div>
            </div>
        </div>
        <script type="text/javascript" src="assets/js/scripts.js"></script>
    </body>
</html>
