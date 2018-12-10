# 텍스트 다운로드
import urllib.request
url = "http://api.aoikujira.com/ip/ini"
txt = urllib.request.urlopen( url )
data = txt.read()       # 바이너리
msg = data.decode( "utf-8" )
print( msg )

url = "http://playdata.io/academy/jobsearch/bigdata_flatform26"
txt = urllib.request.urlopen( url )
data = txt.read()       # 바이너리
msg = data.decode( "utf-8" )
# print( msg )
with open( "playdata.txt", mode="wt" ) as f :
    f.write( msg )
print( "저장했습니다" )   