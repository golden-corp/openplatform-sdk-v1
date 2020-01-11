<?php
/**
 * Created by PhpStorm.
 * User: lf
 * Date: 2018/9/6
 * Time: 上午11:40
 */
namespace Gd;

use GuzzleHttp\Client;

class Sdk
{

    private $env;

    private $appkey;

    private $appsecret;

    public $baseUrl = [
        "test" => "http://182.254.219.106:8400",
        "prod" => "https://openapi.fapiaoer.cn"
    ];

    public $log = [];

	public function setBaseUrl($url){
		if(!is_string($url))
		    throw new \Exception("地址不能为空");
		$this->baseUrl = $url;
	}

	public function getBaseUrl(){
	    if(is_string($this->baseUrl)){
	        return $this->baseUrl;
        }
        return $this->baseUrl[$this->getEnv()];
    }
    /**
     * Sdk constructor.
     * @param $appkey
     * @param $appsecret
     * @param string $env 环境，只能为test或者prod
     * @throws \Exception
     */
    public function __construct($appkey, $appsecret, $env='test')
    {
        $this->setEnv($env);
        $this->setAppkey($appkey);
        $this->setAppsecret($appsecret);
    }

    /**
     * @param $env
     * @throws \Exception
     */
    public function setEnv($env)
    {
        if( !in_array($env, ['test', 'prod']) ) throw new \Exception("env must be test or prod");
        $this->env = $env;
    }

    /**
     * @return string
     */
    public function getEnv()
    {
        return $this->env;
    }

    /**
     * @return string
     */
    public function getAppkey()
    {
        return $this->appkey;
    }

    /**
     * @return string
     */
    public function getAppsecret()
    {
        return $this->appsecret;
    }

    /**
     * @param $appkey
     */
    public function setAppkey($appkey)
    {
        $this->appkey = $appkey;
    }

    /**
     * @param $appsecret
     */
    public function setAppsecret($appsecret)
    {
        $this->appsecret = $appsecret;
    }

    /**
     * @param $timestamp
     * @param array $data
     * @return string
     */
    public function sign($timestamp, array $data)
    {
        $originStr = $this->getAppkey() . $timestamp;
        ksort($data);
        $encodeStr = rawurlencode(call_user_func(function () use ($data) {
                $str = "";
                foreach ($data as $k => $v) {
                    if (is_array($v)) {
                        $v = json_encode($v, JSON_UNESCAPED_UNICODE);
                    }
                    $str .= $k . '=' . $v . '&';
                }
                $str = rtrim($str, '&');
                return $str;
            })
        );
        $originStr .= $encodeStr . $this->getAppsecret();
        $sign = strtoupper(md5($originStr));
        return $sign;
    }

    private function setLog($log)
    {
        if( $this->getEnv() == 'test' ) {
            $this->log[] = $log;
        }
    }

    public function getLog()
    {
        return $this->log;
    }

    public function httpRequest($url, array $data)
    {

        $baseUri = self::getBaseUrl();
        $timestamp = time();
        $sign = $this->sign($timestamp, $data);
        $url .= "?signature=" . $sign . "&appkey=" . $this->getAppkey() . "&timestamp=" . $timestamp;
        $requestUri = $baseUri . $url;
        $this->setLog("高灯请求地址:" . $requestUri);
        $this->setLog("高灯请求参数:" . print_r($data, true));
        $this->setLog("高灯签名值:" . $sign);
        $result = Util::httpPost($requestUri, $data, 'json');
        if( $result !== false ) $result = json_decode($result, true);
        return $result;
    }

}