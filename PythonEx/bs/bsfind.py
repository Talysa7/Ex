from bs4 import BeautifulSoup
html =  '''
        <html>
            <body>
                <h2 id="title"> 스크랩핑이란 </h2>
                <p id="content1"> 웹 페이지를 분석하는 것 </p>
                <p id="content2"> 원하는 부분을 추출하는 것 </p>
            </body>
        </html>
        '''
soup = BeautifulSoup( html, "html.parser" )
title = soup.find(id="title").string
content1 = soup.find(id="content1").string 
content2 = soup.find(id="content2").string
print( "제목 : ", title )
print( "내용 : {0} {1}".format( content1, content2 ) )
        