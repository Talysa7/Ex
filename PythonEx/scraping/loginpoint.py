# 한빛 네트워크 로그인 / 포인트 가져오기
# http://www.hanbit.co.kr/member/login_proc.php
# m_id 
# m_passwd

# http://www.hanbit.co.kr/myhanbit/myhanbit.html 
# 마일리지 mileage_section1    이코인 mileage_section2

import requests
from bs4 import BeautifulSoup
from urllib.parse import urljoin
session = requests.session()
logininfo = {
    "m_id" : "",                 # 진짜 아이디
    "m_passwd" : "",     # 진짜 비밀번호
}
urllogin = "http://www.hanbit.co.kr/member/login_proc.php"
res = session.post( urllogin, logininfo )
res.raise_for_status()                  # 오류 시 예외

urlmypage = "http://www.hanbit.co.kr/myhanbit/myhanbit.html"
res = session.get( urlmypage )
res.raise_for_status()

soup = BeautifulSoup( res.text, "html.parser" )
mileage = soup.select_one(".mileage_section1").get_text()
ecoin = soup.select_one(".mileage_section2").get_text()
print( mileage )
print( ecoin )


































