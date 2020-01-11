const sdk = require("../index");

var golden = new sdk("testappkey111", "testappsecret", "test");

let post = {
    buyer_title:"11@高灯",
    qq:[{
        email:"sss@ss.com",
        ff:[{"ss":"ddd11/(+)-&^%$'”）&*……%￥#@！~#@*`+~"}]
    }]
}

golden.httpRequest("/merchant/search", {post:post}).then(function(data){
    console.log("接口返回结果", data.data)
})

