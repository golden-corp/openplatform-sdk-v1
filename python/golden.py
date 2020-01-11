import hashlib
import json
import time
import sys
class Sdk:
    def __init__(self,appkey,appsecret,env):
        self.appkey = appkey
        self.appsecret =appsecret
        self.env = env
    def sort_bykeyV2(self,para):
        from collections import OrderedDict
        orderDict = OrderedDict()
        sort_key= sorted(para)
        for key in sort_key:
            orderDict[key]=para[key]
        return orderDict

    def sort_bykey(self,para):
        sort_key= sorted(para)
        return {key:para[key] for key in sort_key}

    def md5_convert(self,string):
        hashmd5 = hashlib.md5()
        hashmd5.update(string.encode())
        return hashmd5.hexdigest()
        
    def genereateSign(self,postString,timestamp):
        replace_token={'!': '%21', '*': '%2A', "'": '%27', '(': '%28', ')': '%29', ';': '%3B', ':': '%3A', '@': '%40', '&': '%26', 
         '=': '%3D', '+': '%2B', '$': '%24', ',': '%2C', '/': '%2F', '?': '%3F', '#': '%23', '[': '%5B', ']': '%5D'}


        ###replace
        postString=postString.replace("*", "%2A").replace("+", "%20").replace("%7E", "~")
        for i,j in replace_token.items():
            postString=postString.replace(i,j)

        originStr=self.appkey+ timestamp+ postString + self.appsecret;
        sign=str.upper(self.md5_convert(originStr))
        return sign
    
    def httpPostV3(self,url,para):
        from urllib import request, parse
        timestamp=str(int(time.time()))
        
        postString=parse.urlencode(self.sort_bykey(para))
        
        sign=self.genereateSign(postString,timestamp)
        
        if self.env=='test':
            requestUrl='http://182.254.219.106:8400'
        else:
            requestUrl='https://openapi.fapiaoer.cn'
        requestUrl =requestUrl+ url + "?signature=" + sign + "&appkey=" + self.appkey + "&timestamp=" + timestamp;
        req=request.Request(requestUrl)
        with request.urlopen(req, data=parse.urlencode(para).encode('utf-8')) as f:
            data=f.read().decode('utf-8')
        return json.loads(data)

    def httpPostV2(self,url,para):
        import urllib2
        import urllib
        
        timestamp=str(int(time.time()))
        postString=urllib.urlencode(self.sort_bykeyV2(para))
        
        sign=self.genereateSign(postString,timestamp)
        print('timestamp',timestamp,'sign',sign,'postString',postString)
        if self.env=='test':
            requestUrl='http://182.254.219.106:8400'
        else:
            requestUrl='https://openapi.fapiaoer.cn'
            
        requestUrl =requestUrl+ url + "?signature=" + sign + "&appkey=" + self.appkey + "&timestamp=" + timestamp;
        request = urllib2.Request(requestUrl)
        response = urllib2.urlopen(requestUrl, urllib.urlencode(para))
        data=response.read()
        return json.loads(data.decode('unicode-escape'))
    
    def httpPost(self,url,para):
        if sys.version > '3':
            return self.httpPostV3(url,para)
        else:
            return self.httpPostV2(url,para)       