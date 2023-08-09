CREATE DATABASE sof203_video;
GO
USE sof203_video
GO
CREATE TABLE the_loai
(
    id bigint IDENTITY(0,1) NOT NULL,
    ten_the_loai nvarchar(100) NULL,
    CONSTRAINT the_loai_PK PRIMARY KEY (id)
);
GO
CREATE TABLE cong_viec
(
    id bigint IDENTITY(0,1) NOT NULL,
    the_loai_id bigint NULL,
    ten_cong_viec nvarchar(100) NULL,
    trang_thai int NULL,
    thoi_gian_hoan_thanh datetime2(0) NULL,
    CONSTRAINT cong_viec_PK PRIMARY KEY (id),
    CONSTRAINT cong_viec_FK FOREIGN KEY (the_loai_id) REFERENCES the_loai(id)
);

GO
INSERT INTO the_loai
    ( ten_the_loai)
VALUES(N'Loại 1');
INSERT INTO the_loai
    ( ten_the_loai)
VALUES( N'Loại 2');
INSERT INTO the_loai
    (ten_the_loai)
VALUES( N'Loại 3');

GO
INSERT INTO cong_viec
    (the_loai_id, ten_cong_viec, trang_thai, thoi_gian_hoan_thanh)
VALUES(1, N'Ăn và chơi', 1, '2023-08-05 10:30:00.000');
INSERT INTO cong_viec
    (the_loai_id, ten_cong_viec, trang_thai, thoi_gian_hoan_thanh)
VALUES(1, N'Đi bốc phét', 1, '2023-08-05 10:30:00.000');
INSERT INTO cong_viec
    ( the_loai_id, ten_cong_viec, trang_thai, thoi_gian_hoan_thanh)
VALUES( 2, N'Học tập', 2, '2023-08-05 10:30:00.000');
