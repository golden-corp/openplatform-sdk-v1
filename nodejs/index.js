const axios = require("axios")
const crypto = require('crypto')
var urlencode = require('urlencode')

function Sdk(appkey, appsecret, env="test"){

    this.appkey = appkey;
    this.appsecret = appsecret;
    this.env = env;
    this.baseUrl = {
        "test" : "http://182.254.219.106:8400",
        "prod" : "https://openapi.fapiaoer.cn"
    }

    this.getBaseUrl = function(){
        return this.baseUrl[this.env]
    }

    this.generateSign = function(timestamp, post){

        let originString = this.appkey + timestamp
        let arr = []
        for( var key in post ){
            arr.push(key)
        }
        arr.sort()
        var str = ""
        for(var key in arr){
            let type = typeof post[arr[key]]
            if( type === "array" || type === "object" ){
                let tempStr = JSON.stringify( post[arr[key]] )
                tempStr = tempStr.replace(/\//g, "\\/")
                str += arr[key] + "=" + tempStr + "&"
            }else{
                str += arr[key] + "=" + post[arr[key]] + "&"
            }
        }
        str = str.substring(0, str.length - 1)
        str = urlencode(str)
        str = str.replace(/\(/g, "%28").replace(/\)/g, "%29").replace(/\*/g, "%2A").replace(/'/g, "%27")
        originString += str + this.appsecret
        this.debug("高灯签名原串", originString)

        let sign =  crypto.createHash('md5').update(originString).digest("hex")
        sign = sign.toUpperCase()
        this.debug("高灯签名值", sign)
        return sign

    }

    this.httpRequest = function(path, options)
    {
        let timestamp = Date.parse( new Date() ).toString();
        let sign = this.generateSign(timestamp, options.post)
        let url = this.getBaseUrl() + path + "?signature=" + sign + "&appkey=" + this.appkey + "&timestamp=" + timestamp
        this.debug("高灯请求地址", url)
        return axios.post(url, options.post)
    }

    this.debug = function(...info){
        if( this.env == 'test' ){
            console.log(info)
        }
    }

}

module.exports=Sdk
