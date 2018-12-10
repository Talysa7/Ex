# 네이버 로그인 #
# from selenium import webdriver
# driver = webdriver.Chrome( "C:\Python35\Lib\site-packages\selenium\webdriver\chrome\chromedriver.exe" )
# driver.implicitly_wait( 3 )

# driver.get( "https://logins.daum.net/accounts/loginform.do" )
# driver.find_element_by_name( "id" ).send_keys("encore_kim")             # id 입력
# driver.find_element_by_name( "pw" ).send_keys("yC9Dh4Q2LSVEPLS")        # pw 입력
   
# naver.com        프로그램 로그인 불가능

# 다음 로그인 #
# from selenium import webdriver
# driver = webdriver.Chrome( "C:\Python35\Lib\site-packages\selenium\webdriver\chrome\chromedriver.exe" )
# driver.implicitly_wait( 3 )

# # 로그인 버튼 클릭
# loginbutton = driver.find_element_by_css_selector("button.btn_comm[type=submit]")
# loginbutton.submit()

# daum.net        프로그램 로그인 가능. 메일 페이지 접근 불가능

from selenium import webdriver
import time
driver = webdriver.Chrome( "C:\Python35\Lib\site-packages\selenium\webdriver\chrome\chromedriver.exe" )
driver.implicitly_wait( 3 )

driver.get( "https://accounts.google.com/signin/v2/identifier" )
driver.find_element_by_name( "identifier" ).send_keys("")      # id 입력
loginbutton = driver.find_element_by_id("identifierNext")
time.sleep( 2 )
loginbutton.click()

# driver.get( "https://accounts.google.com/signin/v2/sl/pwd" )
driver.find_element_by_name( "password" ).send_keys("")          # pw 입력
passwdbutton = driver.find_element_by_id("passwordNext")
time.sleep( 2 )
passwdbutton.click()

time.sleep( 2 )
driver.get( "https://mail.google.com" )
time.sleep( 2 )
titles = driver.find_elements_by_css_selector( "span.bog" )
for title in titles :
    print( "-", title.text )
driver.quit()    































