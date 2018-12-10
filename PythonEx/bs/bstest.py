from bs4 import BeautifulSoup
html =  '''
        <html>
            <body>
                <h2> 스크랩핑이란 </h2>
                <p> 웹 페이지를 분석하는 것 </p>
                <p> 원하는 부분을 추출하는 것 </p>
            </body>
        </html>
        '''
soup = BeautifulSoup( html, "html.parser" )
h2 = soup.html.body.h2
p1 = soup.html.body.p
p2 = p1.next_sibling.next_sibling
print( "h2 : ", h2 )
print( "p1 : ", p1 )
print( "p2 : ", p2 )
print( "h2 : ", h2.string )
print( "p1 : ", p1.string )
print( "p2 : ", p2.string )




        