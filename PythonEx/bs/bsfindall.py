from bs4 import BeautifulSoup
html =  '''
        <html>
            <body>
                <p> 스크랩핑이란 </p>
                <p> 웹 페이지를 분석하는 것 </p>
                <p> 원하는 부분을 추출하는 것 </p>
            </body>
        </html>
        '''
soup = BeautifulSoup( html, "html.parser")
ps = soup.find_all("p")
msg = ""
for p in ps :
    msg += p.string + "\n"
print( msg )            