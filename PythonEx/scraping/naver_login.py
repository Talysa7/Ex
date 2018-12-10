from selenium import webdriver

chrome_driver=webdriver.Chrome("C:\Python35\Lib\site-packages\selenium\webdriver\chrome\chromedriver.exe")
chrome_driver.implicitly_wait(3)
chrome_driver.get("https://nid.naver.com/nidlogin.login")
chrome_driver.find_element_by_name("id").send_keys("")
chrome_driver.find_element_by_name("pw").send_keys("")
loginbutton=chrome_driver.find_element_by_css_selector("input.btn_global[type=submit]")
loginbutton.submit()