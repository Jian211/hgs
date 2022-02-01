SELECT * FROM hgs.places;
/* 
	
    카페 총 갯수 500개  1~500(idx)
    공원 총 갯수 17313개 501~17813(idx)
    동물병원 총 갯수 4851개 17814~22664(idx)
    
*/
-- ai 초기화 코드
ALTER TABLE hgs.places AUTO_INCREMENT=501;

select * from hgs.places where subject_category = "동물병원";

-- 행 갯수 확인
select count(*) from hgs.places; -- 전체 행 갯수
select count(*) from hgs.places where subject_category = "공원"; -- 공원 행 갯수 
select count(*) from hgs.places where subject_category = "동물병원";

-- 공원데이터 전부 삭제
DELETE FROM hgs.places WHERE admin_idx = 1 and subject_category = "공원";

-- affiliation에 null값이 들어갔는지 확인
select * from hgs.places where affiliation = null;