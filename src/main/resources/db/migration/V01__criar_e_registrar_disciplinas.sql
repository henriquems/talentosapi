Create table disciplina (
	cod_dis Int NOT NULL AUTO_INCREMENT,
	des_dis Varchar(100) NOT NULL,
	UNIQUE (des_dis),
Primary Key (cod_dis)) ENGINE = InnoDB;

INSERT INTO DISCIPLINA (des_dis) VALUES ('ANATOMIA I');
INSERT INTO DISCIPLINA (des_dis) VALUES ('ANATOMIA II');
INSERT INTO DISCIPLINA (des_dis) VALUES ('ANATOMIA III');