import urllib.request
import urllib.parse
url = "http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp"
values = {
    "stnid" : "109"
    }
# 전국 108            서울경기 109     강원도 105        충청북도 131     충청남도 133 
# 전라북도 146         전라남도 156     경상북도 143       경상남도 159     제주도 184
params = urllib.parse.urlencode( values )
url = url + "?" + params
print( url )
data = urllib.request.urlopen( url ).read()
txt = data.decode( "utf-8" )
print( txt )