Create table [disciplina](
	[cod_dis] Integer Identity NOT NULL,
	[des_dis] Varchar(100) NOT NULL, UNIQUE ([des_dis]),
	Primary Key ([cod_dis])
)

INSERT INTO DISCIPLINA VALUES ('ANATOMIA I')
INSERT INTO DISCIPLINA VALUES ('ANATOMIA II')
INSERT INTO DISCIPLINA VALUES ('ANATOMIA III')