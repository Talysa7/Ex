# http://docs.python.org/3.5/library/
# HTML download
from idlelib.IOBinding import encoding
from bs4 import BeautifulSoup
from urllib.request import *
from urllib.parse import *
from os import makedirs
import os.path, time, re

procfiles={}

def downfile(url):
    o=urlparse(url)
    savepath="./"+o.netloc+o.path
    if re.search(r"/$", savepath):
        savepath+="index.html"
    savedir=os.path.dirname(savepath)
    if os.path.exists(savepath):
        return savepath
    if not os.path.exists(savedir):
        print("mkdir:", savedir)
        makedirs(savedir)
    try:
        print("download:", savepath)
        urlretrieve(url, savepath)
        time.sleep(1)
        return savepath
    except:
        print("error:", url)
        return None
    
def enumlinks(html, base):
    soup=BeautifulSoup(html, "html.parser")
    links=soup.select("link[rel='stylesheet']")
    links+=soup.select("a[href]")
    result=[]
    for a in links:
        href=a.attrs["href"]
        url=urljoin(base, href)
        result.append(url)
    return result

def downhtml(url, rooturl):
    savepath=downfile(url)
    if savepath is None:
        return
    if savepath in procfiles:
        return
    procfiles[savepath]=True
    print("downhtml:", url)
    html=open(savepath, "r", encoding="utf-8").read()
    links=enumlinks(html, url)
    for link in links:
        if link.find(rooturl)!=0:
            if not re.search(r".css$", link):
                continue
        if re.search(r".(html|htm)$", link):
            downhtml(link, rooturl)
            continue
        downfile(link)

if __name__ == '__main__':
    url="http://docs.python.org/3.5/library/"
    downhtml(url, url)