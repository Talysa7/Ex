# https://docs.python.org/3.5/library/ 다운로드
from bs4 import BeautifulSoup
from urllib.request import *
from urllib.parse import *
from os import makedirs
import os.path, time, re

procfiles = {}

def downfile( url ) :
    o = urlparse( url )
    savepath = "./" + o.netloc + o.path
    if re.search(r"/$", savepath ) :                    # 폴더라면 index.html
        savepath += "index.html"
    savedir = os.path.dirname( savepath )
    if os.path.exists( savepath ) :                     # 전부 다운로드 했으면
        return savepath    
    if not os.path.exists( savedir ) :                  # 다운로드 폴더 생성
        print( "mkdir : ", savedir )
        makedirs( savedir )
    try :
        print( "download : ", savepath )
        urlretrieve(url, savepath)
        time.sleep(1)
        return savepath
    except :
        print( "error : ", url )
        return None
            
def enumlinks( html, base ) :                           # HTML 페이지, url 
    soup = BeautifulSoup( html, "html.parser" )
    links = soup.select("link[rel='stylesheet']")       # css 파일
    links += soup.select("a[href]")                     # 링크 경로
    result = []                                        
    for a in links :                                    # 상대경로를 절대경로 변환
        href = a.attrs["href"]
        url = urljoin(base, href)
        result.append(url)
    return result    
    
def downhtml( url, rooturl ) :
    savepath = downfile( url )
    if savepath is None :           # 처리할 수 없는 파일
        return
    if savepath in procfiles :      # 이미 처리된 파일
        return
    procfiles[savepath] = True
    print( "downhtml : ", url )
    html = open( savepath, "r", encoding="utf-8").read()
    links = enumlinks( html, url )
    
    for link in links :
        if link.find(rooturl) != 0 :       # 루트 이외의 경로를 나타내면 무시
            if not re.search(r".css$", link ) :
                continue 
        if re.search(r".(html|htm)$", link ) :  # 링크가 HTML 이면
            downhtml( link, rooturl )
            continue
        downfile( link )                # 이 외의 파일
    
if __name__ == '__main__' :
    url = "http://docs.python.org/3.5/library/"
    downhtml( url, url )
    
    
    
    
    
    