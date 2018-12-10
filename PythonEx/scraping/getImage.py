# http://api.aoikujira.com/time/get.php

import requests
result=requests.get("http://api.aoikujira.com/time/get.php")
text=result.text
print(text)

result=requests.get("https://imgnews.pstatic.net/image/421/2018/12/05/0003724896_001_20181205101540410.jpg")
with open("test.jpg", "wb") as f:
    f.write(result.content)
print("끝")