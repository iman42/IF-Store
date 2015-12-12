<?php
class Config{
    private static $config = [
        'assetsPath' => 'http://localhost/IF-Store/assets/',
        'controllersPath' => 'http://localhost/IF-Store/controllers/'
    ];
    public static function get($query){
        return self::$config[$query];
    }
}
?>
