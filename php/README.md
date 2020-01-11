使用方法
========

1.使用composer（推荐）
--------------------
composer config secure-http false && composer require golden/golden-open-platform-sdk
```php
use Gd\Sdk;

require __DIR__ . "/../autoload.php";

$obj = new Sdk("testappkey111", "testappsecret", "test");

$post = ['buyer_title' => "高灯"];
$result = $obj->httpRequest("/merchant/search", $post);
var_dump($result);
print_r($obj->getLog());
```

2.手动加载
-----------
下载源码到目录，假设放置在/path/to/golden目录中
```php
use Gd\Sdk;

require "/path/to/golden/autoload.php";

$obj = new Sdk("testappkey111", "testappsecret", "test");

$post = ['buyer_title' => "高灯"];
$result = $obj->httpRequest("/merchant/search", $post);
var_dump($result);
print_r($obj->getLog());
```

运行example
==========
```bash
    composer run-script example
```