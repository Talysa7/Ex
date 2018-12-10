# 이미지 다운로드
import urllib.request
url = "http://cdn.emetro.co.kr/imagebank/2018/12/03/0640/20181203000110.jpg"
savename = "test.jpg"
urllib.request.urlretrieve( url, savename )
print( "저장했습니다." )

url = "https://t1.daumcdn.net/news/201812/03/newsen/20181203062233026ugcf.jpg"
savefile = "hb.jpg"
mem = urllib.request.urlopen( url ).read()
with open( savefile, mode="wb" ) as f :
    f.write( mem )
print( "저장했습니다" )    