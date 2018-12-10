# http://api.aoikujira.com/time/get.php
import requests
r = requests.get( "http://api.aoikujira.com/time/get.php" )
text = r.text               # 텍스트 형식
print( text )
bin = r.content             # 바이너리 형식
print( bin )

# http://wikibook.co.kr/wikibook.png
rs = requests.get( "http://wikibook.co.kr/wikibook.png" )
with open( "test.png", "wb" ) as f :
    f.write( rs.content )
rs = requests.get( "https://img3.daumcdn.net/thumb/R658x0.q70/?fname=https://t1.daumcdn.net/news/201812/05/spotvnews/20181205094123945ttfl.jpg" )
with open( "test.jpg", "wb" ) as f :
    f.write( rs.content )
print( "끝" )    








