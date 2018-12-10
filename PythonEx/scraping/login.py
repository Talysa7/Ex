# http://www.hanbit.co.kr/member/login_proc.php
# http://www.hanbit.co.kr/myhanbit/myhanbit.html
# div class=sm_mymileage dl class=mileage_section1

import requests
from bs4 import BeautifulSoup
from urllib import parse

session=requests.session()

login_info={
    "m_id":"",
    "m_passwd":""
}
url_login="http://www.hanbit.co.kr/member/login_proc.php"
url_mypage="http://www.hanbit.co.kr/myhanbit/myhanbit.html"

result=session.post(url_login, data=login_info)
result.raise_for_status()

result=session.get(url_mypage)
result.raise_for_status()

# print(result.text)
soup=BeautifulSoup(result.text, "html.parser")

mileage=soup.select_one(".mileage_section1").get_text()
ecoin=soup.select_one(".mileage_section2").get_text()

print(mileage, ecoin)