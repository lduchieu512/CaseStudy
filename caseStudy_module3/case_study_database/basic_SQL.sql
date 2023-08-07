use furama;

-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các
-- ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select * 
from nhan_vien
where 
	SUBSTRING_INDEX(ho_va_ten,' ', - 1)
	REGEXP '^[HTK]'
	AND LENGTH(SUBSTRING_INDEX(ho_va_ten,' ', - 1)) <= 15;

-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở
-- “Đà Nẵng” hoặc “Quảng Trị”.
select
		* 
from 
	khach_hang 
where 
	year(now()) - year(ngay_sinh) between 18 AND 50
    and(dia_chi regexp 'Đà Nẵng' or dia_chi regexp 'Quảng Trị');
    -- c2
SELECT 
    *
FROM
    khach_hang k
WHERE
    (k.dia_chi LIKE '% Quảng Trị'
        OR k.dia_chi LIKE '% Đà Nẵng')
        AND ((YEAR(NOW()) - YEAR(ngay_sinh) BETWEEN 18 AND 50));

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị 
-- được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có 
-- Tên loại khách hàng là “Diamond”.
select 
	count(KH.ma_khach_hang)as so_luong,
    KH.ho_va_ten,
    LK.ten_loai_khach,
    HD.ngay_lam_hop_dong,HD.ngay_ket_thuc,HD.tien_dat_coc
from 
	loai_khach LK 
join 
	khach_hang KH on KH.ma_loai_khach = LK.ma_loai_khach
join
	hop_dong HD on HD.ma_khach_hang = KH.ma_khach_hang
where LK.ten_loai_khach ='Diamond'
group by KH.ma_khach_hang;

-- 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu,
-- ngay_lam_hop_dong, ngay_ket_thuc, tong_tien (Với tổng tiền được tính theo công thức như sau:
-- Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem,
-- hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa 
-- từng đặt phòng cũng phải hiển thị ra).

-- chua lam dc S0S S0S S0S S0S S0S S0S S0S
select 
	ho_va_ten, ifnull(sum(so_luong * gia) + tmp.tong_chi_phi_thue, 0) tong_tien  
from 
	khach_hang kh
left join 
	hop_dong hd using (ma_khach_hang)
left join 
	hop_dong_chi_tiet using (ma_hop_dong)
left join 
	dich_vu_di_kem using (ma_dich_vu_di_kem)
left join 
(
	select 
		ma_khach_hang, sum(chi_phi_thue) tong_chi_phi_thue 
    from 
		khach_hang kh1 
	join 
        hop_dong using (ma_khach_hang) 
	join
		dich_vu using (ma_dich_vu) 
	group by hop_dong.ma_khach_hang) tmp using (ma_khach_hang)
group by hd.ma_khach_hang;
-- chua lam dc S0S S0S S0S S0S S0S S0S S0S

-- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của 
-- tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021
-- (Quý 1 là tháng 1, 2, 3). 
select 
	dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu 
from 
	dich_vu dv 
join 
	loai_dich_vu ldv on ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu
where not exists (select * 
	from 
		hop_dong hd
	where 
		hd.ma_dich_vu = dv.ma_dich_vu
        and ngay_lam_hop_dong between '2021-01-01' and '2021-03-31');
    
   -- 
   
SELECT 
    dv.ma_dich_vu,
    dv.ten_dich_vu,
    dv.dien_tich,
    dv.chi_phi_thue,
    ldv.ten_loai_dich_vu
FROM
    dich_vu dv
        JOIN
    loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
        JOIN
    hop_dong hd ON hd.ma_dich_vu = dv.ma_dich_vu
WHERE
    dv.ma_dich_vu NOT IN (SELECT 
            dv.ma_dich_vu
        FROM
            dich_vu dv
                JOIN
            hop_dong hd ON hd.ma_dich_vu = dv.ma_dich_vu
        WHERE
            ((MONTH(hd.ngay_lam_hop_dong) BETWEEN 1 AND 3)
                AND YEAR(hd.ngay_lam_hop_dong) = '2021')
        GROUP BY dv.ten_dich_vu)
GROUP BY dv.ten_dich_vu
ORDER BY dv.dien_tich DESC;
    
    
-- 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, 
-- ten_loai_dich_vu của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 
-- nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
select 
	dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.so_nguoi_toi_da, dv.chi_phi_thue,
	ldv.ten_loai_dich_vu
from
	dich_vu dv 
join loai_dich_vu ldv using(ma_loai_dich_vu)
where  exists
		(select * 
		from 
			hop_dong hd 
		where hd.ma_dich_vu = dv.ma_dich_vu
			and year(ngay_lam_hop_dong)= '2020')
	and not exists (select * 
		from 
			hop_dong hd 
		where hd.ma_dich_vu = dv.ma_dich_vu
			and year(ngay_lam_hop_dong) =  '2021');
	
-- 8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.
-- c1
select
	kh.ho_va_ten 
from 
	khach_hang kh 
group by kh.ho_va_ten ;
-- c2
select DISTINCT
	kh.ho_va_ten 
from 
	khach_hang kh ;
 -- c3  
select
	kh.ho_va_ten 
from 
	khach_hang kh 
union
select
	kh.ho_va_ten 
from 
	khach_hang kh ;

-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021
-- thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select 
	month(ngay_lam_hop_dong) as thang ,count(ma_khach_hang)
from 
	hop_dong 
join
	khach_hang using(ma_khach_hang)
where 
	year(ngay_lam_hop_dong) =2021
group by thang
order by thang;
-- c2
SELECT 
    MONTH(hop_dong.ngay_lam_hop_dong) thang,
    COUNT(ngay_lam_hop_dong) so_luong_khach_hang
FROM
    hop_dong
WHERE
    YEAR(hop_dong.ngay_lam_hop_dong) = '2021'
GROUP BY MONTH(hop_dong.ngay_lam_hop_dong)
ORDER BY thang;

-- 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm.
-- Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc,
-- so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
select 
	hd.ma_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc,
     ifnull(sum(ct.so_luong),0)  as so_luong_dich_vu_di_kem
from 
	hop_dong hd
left join
	hop_dong_chi_tiet ct using(ma_hop_dong)
left join 
	dich_vu_di_kem dk using(ma_dich_vu_di_kem)
group by hd.ma_hop_dong
order by hd.ma_hop_dong;
-- 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có
-- ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
select
	kh.ho_va_ten,
    dk.ma_dich_vu_di_kem,
    dk.ten_dich_vu_di_kem,
    dk.gia,
    dk.don_vi,
    dk.trang_thai
from 
	loai_khach lk 
join 
	khach_hang kh using(ma_loai_khach)
join 
	hop_dong using(ma_khach_hang)
join 
	hop_dong_chi_tiet ct using(ma_hop_dong)
join 
	dich_vu_di_kem dk using(ma_dich_vu_di_kem)
where 
	lk.ten_loai_khach ='Diamond' and  (kh.dia_chi like '%Vinh'
        or kh.dia_chi like '%Quảng Ngãi');
	
-- 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng),
-- so_dien_thoai (khách hàng), ten_dich_vu, so_luong_dich_vu_di_kem (được tính dựa trên việc 
-- sum so_luong ở dich_vu_di_kem), tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng
-- đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.
select 
	hd.ma_hop_dong, nv.ho_va_ten as ho_ten_nhan_vien,
    kh.ho_va_ten as ho_ten_khach_hang, kh.so_dien_thoai, dv.ten_dich_vu,
    ifnull( sum(ct.so_luong),0) as so_luong_dich_vu_di_kem ,
    hd.tien_dat_coc
 from 
	nhan_vien nv
 join 
	hop_dong hd using(ma_nhan_vien)
 join 
	khach_hang kh using(ma_khach_hang)
join 
	dich_vu dv using(ma_dich_vu)
left join 
	hop_dong_chi_tiet ct using(ma_hop_dong)
where 
	(month(ngay_lam_hop_dong) between 10 and 12 
    and year(ngay_lam_hop_dong) = 2020)
    and ngay_lam_hop_dong not in ((month(ngay_lam_hop_dong) between 1 and 6)
	and year(ngay_lam_hop_dong) = 2021) 
  	group by ma_hop_dong;
-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.
--  (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
select 
	dk.ma_dich_vu_di_kem,dk.ten_dich_vu_di_kem,sum(ct.so_luong) as so_lan
from 
	hop_dong_chi_tiet ct 
join 
	dich_vu_di_kem dk using(ma_dich_vu_di_kem)
group by ma_dich_vu_di_kem
having so_lan >= all( select so_luong from hop_dong_chi_tiet  );

-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.
-- Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, 
-- so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).
select 
	hd.ma_hop_dong , ldv.ten_loai_dich_vu, dk.ten_dich_vu_di_kem, 
    count(ma_dich_vu_di_kem) as so_lan_su_dung
from 
	loai_dich_vu ldv 
join 	
	dich_vu dv using(ma_loai_dich_vu)
join
	hop_dong hd using(ma_dich_vu)
join 	
	hop_dong_chi_tiet ct using(ma_hop_dong)
join 
	dich_vu_di_kem dk using(ma_dich_vu_di_kem)
 group by 
	ma_dich_vu_di_kem
having so_lan_su_dung = 1 
order by ma_hop_dong ;

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do,
-- ten_bo_phan, so_dien_thoai, dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.
select 
	nv.ma_nhan_vien, nv.ho_va_ten, td.ten_trinh_do, bp.ten_bo_phan,nv.so_dien_thoai,nv.dia_chi
     , count(ngay_lam_hop_dong) as so_lan
from
	nhan_vien nv
 join 
	bo_phan bp using(ma_bo_phan)
 join 
	trinh_do td using(ma_trinh_do)
 join 
	hop_dong hd using(ma_nhan_vien)
where 
	year(ngay_lam_hop_dong) between 2020 and 2021
group by 
	ma_nhan_vien
having so_lan <=3;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
delete from nhan_vien 
where ma_nhan_vien not in(
 select ma_nhan_vien
 from hop_dong 
 where year(ngay_lam_hop_dong) between 2019 and 2021
 group by ma_nhan_vien);
-- 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 
-- là lớn hơn 10.000.000 VNĐ.
update khach_hang kh
set kh.ma_loai_khach = 1
where ma_khach_hang in (select tmp.ma_khach_hang from (select
	kh.ma_khach_hang,sum(dk.gia * ct.so_luong + dv.chi_phi_thue) as tong_tien
from khach_hang kh
join 
	hop_dong hd using(ma_khach_hang)
join
	dich_vu dv using(ma_dich_vu)
join 
	hop_dong_chi_tiet ct using(ma_hop_dong)
join 
	dich_vu_di_kem dk using(ma_dich_vu_di_kem)
where 
	kh.ma_loai_khach =2 and year(hd.ngay_lam_hop_dong) = 2021 
group by 
	ma_loai_khach 
having tong_tien > 10000000 )as tmp);
;

-- 18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
DELETE
FROM
	khach_hang WHERE NOT EXISTS (
		SELECT
			*
		FROM
			hop_dong
		WHERE
			YEAR(ngay_lam_hop_dong) >= 2021
			AND hop_dong.ma_khach_hang = khach_hang.ma_khach_hang);

-- 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
update dich_vu_di_kem
set gia = gia*2
where  ma_dich_vu_di_kem in (select tmp.ma_dich_vu_di_kem from( 
select sum(ct.so_luong) as so_lan, hd.ma_hop_dong,dk.ma_dich_vu_di_kem,dk.ten_dich_vu_di_kem
from hop_dong hd
join 
	hop_dong_chi_tiet ct using(ma_hop_dong)
join	
	dich_vu_di_kem dk using(ma_dich_vu_di_kem)
where  year(ngay_lam_hop_dong) = 2020
group by ma_dich_vu_di_kem
having  so_lan > 10) tmp);
	
-- 20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, 
-- thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai,
-- ngay_sinh, dia_chi.
select  ma_nhan_vien as id,ho_va_ten, email, so_dien_thoai,email,ngay_sinh,dia_chi
from nhan_vien
union all
select  ma_khach_hang as id,ho_va_ten, email, so_dien_thoai,email,ngay_sinh,dia_chi
from khach_hang
;


