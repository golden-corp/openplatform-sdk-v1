<?php
/**
 * Created by PhpStorm.
 * User: lf
 * Date: 2018/9/6
 * Time: 上午11:41
 */
use Gd\Sdk;

require __DIR__ . "/../autoload.php";

$obj = new Sdk("testappkey111", "testappsecret", "test");

$post = ["ticket_code"=>"150003529999","ticket_sn"=>"06454658","check_code"=>"203719","ticket_money"=>"17241","ticket_date"=>"2019-03-11"];
$result = $obj->httpRequest("/invoice/verify", $post);
var_dump($result);
print_r($obj->getLog());