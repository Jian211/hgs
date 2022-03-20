import csv
from sqlite3 import Cursor
import pymysql

# DB 연결
conn = pymysql.connect(
    host= 'localhost',
    user= 'jian',
    password= 'jian',
    db= 'hgs',
)
cursor = conn.cursor(pymysql.cursors.DictCursor)


# 데이터 조작하기
select_sql = "select * from hgs.admins"
insert_sql = 'insert into hgs.places (admin_idx, title, subject_category, affiliation, old_address, new_address, homepage, phone) values(1,%s,%s,%s,%s,%s,%s,%s)' 

#cursor.execute(select_sql)
#result = cursor.fetchall()

# 파일 읽기 
f = open('220131_dogCafeList.csv', 'r', encoding='utf-8')
rd = csv.reader(f)

for line in rd:
    cursor.execute(insert_sql, ( line[0],line[1], line[2], line[4], line[3], line[5], line[6])) 
conn.commit()
conn.close()
f.close