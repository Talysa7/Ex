from bs4 import BeautifulSoup
import urllib.request as req
import os.path
url = "http://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108"
filename = "forecast.xml"
if not os.path.exists( filename ) :
    req.urlretrieve( url, filename )

xmldoc = open( filename, "rt", encoding="utf-8").read()
soup = BeautifulSoup( xmldoc, "html.parser" )
# print( xmldoc )

info = {}
for location in soup.find_all( "location" ) :
#     print( location )
    name = location.find("city").string
    weather = location.find("wf").string
#     print( weather )
    if not weather in info :
        info[weather] = []
    info[weather].append( name )
    
msg = ""    
for weather in info.keys() :
    print( "+", weather )
    msg += "+" + weather +"\n"
    for name in info[weather] :
        print( "-", name ) 
        msg += "-" + name + "\n"       

savefile = "forecast.txt"
open( savefile, mode="wt", encoding="utf-8" ).write( msg ) 
    
    
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    