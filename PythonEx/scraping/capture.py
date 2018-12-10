# C:\Python35\Lib\site-packages\selenium\webdriver\chrome\chromedriver.exe
from selenium import webdriver
url = "http://www.naver.com"
chromedriver = "C:\Python35\Lib\site-packages\selenium\webdriver\chrome\chromedriver.exe"
browser = webdriver.Chrome( chromedriver )
browser.implicitly_wait( 3 )
browser.get( url )

browser.save_screenshot( "naver.png" )
browser.quit()