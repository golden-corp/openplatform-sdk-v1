使用方法
========
go get -insecure gitlab.gaopeng.com/brian.liu/open_platform_sdk.git

```go
package main

import (
	"fmt"
	"github.com/json-iterator/go"
	"gitlab.gaopeng.com/brian.liu/open_platform_sdk.git/go"
	"os"
)

type Merchant struct {
	BuyerTitle string `json:"buyer_title"`
	BuyerTaxCode string `json:"buyer_taxcode"`
}

type Response struct {
	Code int `json:"code"`
	Msg string `json:"msg"`
	Data []Merchant `json:"data"`
}

func main()  {
	var sdk *golden.Sdk
	sdk = golden.NewSdk("testappkey111", "testappsecret", "test")

	detail := map[string]interface{}{//仅做示例
		"b":"xxxx",
		"c":"ffff",
		"a":"ddd",
	}
	var list [1]map[string]interface{}
	list[0] = detail//仅做示例

	postData := map[string]interface{}{
		"dd":"dddd*` ",//仅做示例
		"buyer_title":"高灯",
		"list": list,//仅做示例
		"c": float64(12.565),//仅做示例
		"a":true,//仅做示例
		"b":123,//仅做示例
	}

	resp,err := sdk.HttpPost("/merchant/search", postData)

	if err != nil {
		fmt.Println(err)
		fmt.Println(resp.StatusCode)
		os.Exit(1)
	}

	var jsonResult Response
	jsoniter.NewDecoder(resp.Body).Decode(&jsonResult)

	fmt.Println(jsonResult)
}
```

运行example
==========
```bash
    cd examples && go run main.go
```