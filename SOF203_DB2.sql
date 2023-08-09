CREATE DATABASE sof203_video_2;
GO
USE sof203_video_2
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
    ten_cong_viec nvarchar(100) NULL,
    trang_thai int NULL,
    thoi_gian_hoan_thanh datetime2(0) NULL,
    CONSTRAINT cong_viec_PK PRIMARY KEY (id),
);
GO
CREATE TABLE the_loai_cong_viec
(
    id bigint IDENTITY(0,1) NOT NULL,
    the_loai_id bigint NULL,
    cong_viec_id bigint NULL,
    CONSTRAINT the_loai_cong_viec_PK PRIMARY KEY (id),
    CONSTRAINT the_loai_cong_viec_FK FOREIGN KEY (cong_viec_id) REFERENCES cong_viec(id),
    CONSTRAINT the_loai_cong_viec_FK_1 FOREIGN KEY (the_loai_id) REFERENCES the_loai(id)
);

GO
INSERT INTO the_loai
    ( ten_the_loai)
VALUES(N'Ăn và lăn');
INSERT INTO the_loai
    ( ten_the_loai)
VALUES( N'Học tập');
INSERT INTO the_loai
    (ten_the_loai)
VALUES( N'Chơi bời');

GO
INSERT INTO cong_viec
    ( ten_cong_viec, trang_thai, thoi_gian_hoan_thanh)
VALUES( N'Ăn và chơi', 1, '2023-08-05 10:30:00.000');
INSERT INTO cong_viec
    (ten_cong_viec, trang_thai, thoi_gian_hoan_thanh)
VALUES( N'Đi bốc phét', 1, '2023-08-05 10:30:00.000');
INSERT INTO cong_viec
    ( ten_cong_viec, trang_thai, thoi_gian_hoan_thanh)
VALUES( N'Học tập', 2, '2023-08-05 10:30:00.000');

GO
INSERT INTO the_loai_cong_viec
    ( the_loai_id, cong_viec_id)
VALUES( 1, 1);
INSERT INTO the_loai_cong_viec
    ( the_loai_id, cong_viec_id)
VALUES( 1, 2);
INSERT INTO the_loai_cong_viec
    ( the_loai_id, cong_viec_id)
VALUES( 2, 2);
INSERT INTO the_loai_cong_viec
    ( the_loai_id, cong_viec_id)
VALUES(3, 1);
