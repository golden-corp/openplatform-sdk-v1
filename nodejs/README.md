使用方法
========

```javascript
const sdk = require("../index");

var golden = new sdk("testappkey111", "testappsecret", "test");

let post = {
    buyer_title:"11@高灯"
}

golden.httpRequest("/merchant/search", {post:post}).then(function(data){
    console.log("接口返回结果", data.data)
})
```

运行example
==========
```bash
    npm run example
```