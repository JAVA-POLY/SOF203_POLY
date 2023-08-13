CREATE DATABASE sof203_video_2;
GO
USE sof203_video_2
GO
CREATE TABLE cong_viec
(
    id bigint IDENTITY(0,1) NOT NULL,
    ten_cong_viec nvarchar(100) NULL,
    ten_the_loai nvarchar(100) NULL,
    trang_thai int NULL,
    thoi_gian_hoan_thanh datetime2(0) NULL,
    CONSTRAINT cong_viec_PK PRIMARY KEY (id),
);
GO
INSERT INTO cong_viec
    ( ten_cong_viec,ten_the_loai, trang_thai, thoi_gian_hoan_thanh)
VALUES( N'Ăn và chơi',N'Loại 1', 1, '2023-08-05 10:30:00.000');
INSERT INTO cong_viec
    ( ten_cong_viec,ten_the_loai, trang_thai, thoi_gian_hoan_thanh)
VALUES( N'Đi bốc phét',N'Loại 3', 1, '2023-08-05 10:30:00.000');
INSERT INTO cong_viec
    ( ten_cong_viec,ten_the_loai, trang_thai, thoi_gian_hoan_thanh)
VALUES( N'Học tập',N'Loại 2', 2, '2023-08-05 10:30:00.000');
