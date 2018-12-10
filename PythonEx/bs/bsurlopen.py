from bs4 import BeautifulSoup
import urllib.request as req
import urllib.parse as ps
url = "http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp"
values = {
    "stnid" : "109"
}
params = ps.urlencode( values )
url = url + "?" + params  
res = req.urlopen( url ).read()
result = res.decode( "utf-8" )
soup = BeautifulSoup(result, "html.parser")

# title = soup.find("title").string
# pubdate = soup.find("pubdate").string
# wf = soup.find("wf").string
# print( "제목 : ", title )
# print( "날짜 : ", pubdate )
# print( "예보 : ", wf )

locs = soup.find_all("location" )
for loc in locs :
    print( "<<", loc.city.string, ">>" )
    for dt in loc.data :
        print( dt.string )










