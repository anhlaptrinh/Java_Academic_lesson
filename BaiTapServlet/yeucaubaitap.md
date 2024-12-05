Cho csdl sau đây 

CREATE DATABASE NewsDB;

USE NewsDB;

CREATE TABLE news (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    image_url VARCHAR(255) NOT NULL,
    publish_date DATE NOT NULL
);

INSERT INTO news (title, content, image_url, publish_date) VALUES
('iPhone 16 Pro độ vỏ giá từ 139 triệu đồng', 'Ngoài bản Emerald Empire, G'ACE cũng giới thiệu bản Gold Bar Signature với vỏ ngoài bằng vàng 18K, biến iPhone 16 Pro và 16 Pro Max giống một thỏi vàng. Thiết kế này khiến máy to và dày hơn do phần camera không lồi lên và khung sườn hơi bo cong. Giá của phiên bản này là từ 114 triệu cho 16 Pro và 135 triệu đồng cho 16 Pro Max.', 'https://i1-sohoa.vnecdn.net/2024/09/30/IMG20240930160323-1727712544.jpg?w=1200&h=0&q=100&dpr=2&fit=crop&s=fYXJHsuFBLNMs-3AiA_gNQ', '2024-09-28'),
('Google xây trung tâm dữ liệu một tỷ USD ở Thái Lan', 'Google sẽ xây trung tâm dữ liệu đầu tiên tại Thái Lan nhằm đáp ứng nhu cầu ngày càng tăng về dịch vụ đám mây, AI trong khu vực.

Ngày 30/9, Google thông báo sẽ đầu tư 36 tỷ baht, tương đương một tỷ USD, vào Thái Lan để xây dựng trung tâm dữ liệu, dự kiến đặt tại một khu công nghiệp ở tỉnh Chonburi.', 'https://i1-sohoa.vnecdn.net/2024/10/01/Google-2-8743-1727743080.jpg?w=680&h=0&q=100&dpr=2&fit=crop&s=OxU-XPr21q17PXpGbDY31A', '2024-09-29'),
('Người Việt chi hơn 1,1 nghìn tỷ đồng mua iPhone 16 ngày đầu', 'Nhận nhiều ý kiến trái chiều về các nâng cấp nhưng iPhone 16 vẫn đem đến doanh thu khổng lồ cho các hệ thống bán lẻ tại thị trường Việt Nam. Dựa theo số lượng máy kích hoạt (active), đại diện một đơn vị nhập khẩu ước tính có ít nhất 37.000 chiếc iPhone 16 đã tới tay người dùng chỉ trong ngày đầu mở bán, đa số là iPhone 16 Pro Max và iPhone 16 Pro, với tổng doanh thu trên 1,1 nghìn tỷ đồng.', 'https://i1-sohoa.vnecdn.net/2024/09/30/a1-5220-1727636105.jpg?w=680&h=0&q=100&dpr=2&fit=crop&s=2rcrjVA5wscht_XQMR_IEw', '2024-09-30');

1) Viết servlet /news sử dụng giao diện index.html
2) Truy vấn dữ liệu và hiển thị động tin tức lên giao diện.
