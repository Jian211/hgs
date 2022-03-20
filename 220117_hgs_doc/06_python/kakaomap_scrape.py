from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from bs4 import BeautifulSoup
from selenium.webdriver.support.ui import Select
import csv
import time

from soupsieve import select

browser = webdriver.Chrome("./chromedriver.exe")  # 같은 경로안에 있으면 경로를 안적어 주어도 ok
browser.maximize_window()   # 창 최대화
# 파일 생성
file_name = "test444.csv"  #"220131_dogCafeList.csv"
f = open(file_name, "w", encoding="utf-8-sig", newline="")
writer = csv.writer(f)

# 항목 구문( DB columns : 가게이름, 애견카페, 시, 지번, 도로명, 홈페이지, 번호)
#title = "title  subject_category  affiliation  old_address  new_address  homepage  phone".split("  ")
#writer.writerow(title)

# 카카오 맵으로 이동 
browser.get("https://map.kakao.com/")

# 지도 사이즈 축소 
for i in range(10):
    elem = browser.find_element(By.XPATH,'//*[@id="view.map"]/div[15]/div[1]/div/button[2]')
    elem.send_keys(Keys.ENTER)
    time.sleep(0.5)

# 현 지도 내 장소검색 클릭
elem = browser.find_element(By.XPATH,'//*[@id="boundscheck"]')
if elem.is_selected() == False:
    browser.execute_script("arguments[0].click();", elem)


# 2. 검색창에 "애견카페" 입력 후 검색
box = browser.find_element(By.XPATH,'//*[@id="search.keyword.query"]')
box.send_keys("애견카페")
box.send_keys(Keys.ENTER)
time.sleep(1)


# 3. 리스트 받아오기
page = 1
while True:  #페이지가 없을 때까지 계속
    html = browser.page_source                           # 현재 페이지 저장
    soup = BeautifulSoup(html,"html.parser")             # 동기적처리를 위한 연결

    # 5. 리스트 받아오기
    cafe_list = soup.select(".placelist > .PlaceItem") 
    print("-------------------------------------------------------------")
    print("page : ",page, "cafe_list :",len(cafe_list))
    print("-------------------------------------------------------------")

    for cafe in cafe_list:
        cafe_name = cafe.find("div",attrs={"class":"head_item"}).find("strong",attrs={"class":"tit_name"}).find("a",attrs={"class":"link_name"}).get_text()
        addr_info = cafe.find("div",attrs={"class":"info_item"}).find("div",attrs={"class":"addr"})
        old_addr = addr_info.find_all("p")[0].get_text()
        new_addr = addr_info.find_all("p")[1].get_text()
        affiliation = old_addr.split(" ")[0]
        
        contact = cafe.find("div",attrs={"class":"info_item"}).find("div",attrs={"class":"contact"})
        homepage = contact.find("a",attrs={"class":"homepage"}).attrs["href"]
        phone = contact.find("span",attrs={"class":"phone"}).get_text()

        #가게이름, 애견카페, 시, 지번, 도로명, 홈페이지, 번호
        data = [cafe_name,"애견카페",affiliation,old_addr,new_addr,homepage,phone]
        writer.writerow(data)
        # print(cafe_name)
        # print(old_addr)
        # print(new_addr)
        # print(phone)
        # print(homepage)
        # print("----------------")

    if page == 1 :        #최초의 한번만 실행, next 버튼이 생성됨
        browser.find_element(By.ID,"info.search.place.more").send_keys(Keys.ENTER)
        time.sleep(1)
    page += 1

    if page % 5 == 0:   # next 버튼
        browser.find_element("id","info.search.page.next").send_keys(Keys.ENTER)  
        time.sleep(1)

    else:   # 1,2,3,4 중 버튼누르기
        id = "info.search.page.no{}".format(page % 5)   # 링크 아이디 값
        next = browser.find_element("id", id)
        next.send_keys(Keys.ENTER)
        #if soup.find(class_ = "INACTIVE HIDDEN"): break
        time.sleep(1)

    # print(page)
    if page == 35 : break


