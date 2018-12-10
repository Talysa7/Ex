from bs4 import BeautifulSoup
html =  '''
        <html>
            <body>
                <div id="lst">
                    <h2> 도서목록 </h2>
                    <ul class="books">
                        <li> Python 프로그래밍 </li>
                        <li> Python 머신러닝 </li>
                        <li> Tensorflow 딥러닝 </li>
                    </ul>
                </div>    
            </body>
        </html>
        '''
soup = BeautifulSoup( html, "html.parser" )
# select_one()        선택자 하나
# select()            선택자 여러개를 리스트로 
h2 = soup.select_one("h2").string
print( "<<", h2, ">>" )
lilist = soup.select("ul.books > li")       # ul 태그이면서 class가 books인 경우
for li in lilist :
    print( li.string )











        