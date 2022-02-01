import csv
from sqlite3 import Cursor
import pymysql

# DB 연결
conn = pymysql.connect(
    host= 'localhost',
    user= 'jian',
    password= 'jian',
    db= 'hgs',
    # charset= 'uft-8' # 현재 이것 때문에 오류가 발생 이유 모름
)
cursor = conn.cursor(pymysql.cursors.DictCursor)

# 데이터 조작하기
insert_sql = 'insert into hgs.places (admin_idx, title, subject_category, affiliation, old_address, new_address, latitude, longitude, phone) values(1,%s,"동물병원",%s,%s,%s,%s,%s,%s)' 


# 파일 읽기 
f = open('animal_hospital.csv', 'r', encoding='utf-8')
rd = csv.reader(f)

for line in rd:
    if line[10] == "정상" and len(line[18]) > 0 :
        cursor.execute(insert_sql, ( line[21],line[18].split(" ")[0], line[18], line[19],line[26],line[27], line[15]))
conn.commit()
conn.close()
f.close