CREATE TABLE t_board_cmt_1(
	i_cmt INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	i_board INT UNSIGNED,
	ctnt VARCHAR(200) NOT NULL,
	FOREIGN KEY (i_board) REFERENCES t_board_1(i_board)
);
CREATE TABLE t_board_cmt_2(
	i_cmt INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	i_board INT UNSIGNED,
	ctnt VARCHAR(200) NOT NULL,
	FOREIGN KEY (i_board) REFERENCES t_board_2(i_board)
);
CREATE TABLE t_board_cmt_3(
	i_cmt INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	i_board INT UNSIGNED,
	ctnt VARCHAR(200) NOT NULL,
	FOREIGN KEY (i_board) REFERENCES t_board_3(i_board)
);
