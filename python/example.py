import golden

sdk=golden.Sdk('testappkey111','testappsecret','test')
para=dict()

inner_para=dict()
inner_para['name']='sss'
inner_para['sdfsdfsdf']='sss'
para['ss']=inner_para
para['aaa']="~"
para['buyer_title']="gold"
para['family']="fff@dd.c*+ om"

ret=sdk.httpPost('/merchant/search',para)
print('ret',ret)