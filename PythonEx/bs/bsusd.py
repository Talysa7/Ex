from bs4 import BeautifulSoup
import urllib.request as req
url = "https://finance.naver.com/marketindex/exchangeList.nhn"
res = req.urlopen( url ).read()
result = res.decode("euc-kr")
# print( result )
soup = BeautifulSoup( result, "html.parser" )
price = soup.select_one("td.sale").string
print( price )

# 통화명 매매기준율
sale = soup.select("td.sale")
tit = soup.select("td.tit")
for i in range( len(sale) ) :
    print( "{0} : {1}".format( tit[i].string.strip(), sale[i].string ) )
    