from bs4 import BeautifulSoup
import urllib.request as req
import time

url = "https://news.naver.com/main/main.nhn?mode=LSD&mid=shm&sid1=101"
res = req.urlopen( url ).read()
result = res.decode( "euc-kr" )
# print( result )
soup = BeautifulSoup( result, "html.parser" )
# heads = soup.select( "h2.cluster_head_topic" )
# for head in heads :
#     spans = head.select("span")
#     for span in spans :
#         print( span.string )
#     print()    
articles = soup.select( "a.cluster_text_headline" )    
for article in articles :
    print( article.string )  
    article_url = article.attrs["href"]
    print( article_url )  
    response = req.urlopen( article_url ).read()
    article_result = response.decode( "euc-kr" )
    article_soup = BeautifulSoup(article_result, "html.parser")
    content = article_soup.select_one("#articleBodyContents")
#     print( content.contents )
#     print()
    output = ""
    for item in content.contents :
        stripitem = str(item).strip()
        if stripitem == "" :
            continue
        if stripitem not in ["<br />", "[", "]", "<", ">", "/", "//", "</", "<script>", "</script>", "function", "_flash"] :
            output += stripitem
    print( output )
    print()
    time.sleep(3)
    
    
    
    
    
    
    
    
    
    
    
    
    