Create table usuario (
	cod_usu Int NOT NULL AUTO_INCREMENT,
	ema_usu Varchar(100) NOT NULL,
	sen_usu Varchar(200) NOT NULL,
	sta_usu Varchar(10) NOT NULL,
	UNIQUE (ema_usu),
Primary Key (cod_usu)) ENGINE = InnoDB; 

Create table permissao (
	cod_per Int NOT NULL AUTO_INCREMENT,
	des_per Varchar(100) NOT NULL,
Primary Key (cod_per)) ENGINE = InnoDB;

Create table usuario_permissao (
	cod_usu Int NOT NULL,
	cod_per Int NOT NULL,
Primary Key (cod_usu,cod_per)) ENGINE = InnoDB;

Alter table usuario_permissao add Foreign Key (cod_per) references permissao (cod_per) on delete  restrict on update  restrict;
Alter table usuario_permissao add Foreign Key (cod_usu) references usuario (cod_usu) on delete  restrict on update  restrict;

INSERT INTO usuario (ema_usu, sen_usu, sta_usu) values ('henrique.simoes@feluma.org.br', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.', 'ATIVO');
INSERT INTO usuario (ema_usu, sen_usu, sta_usu) values ('maria@gmail.com', '$2a$10$Zc3w6HyuPOPXamaMhh.PQOXvDnEsadztbfi6/RyZWJDzimE8WQjaq', 'ATIVO');

INSERT INTO permissao (des_per) values ('ROLE_PESQUISAR_DISCIPLINA');
INSERT INTO permissao (des_per) values ('ROLE_CADASTRAR_DISCIPLINA');
INSERT INTO permissao (des_per) values ('ROLE_ALTERAR_DISCIPLINA');
INSERT INTO permissao (des_per) values ('ROLE_EXCLUIR_DISCIPLINA');

INSERT INTO permissao (des_per) values ('ROLE_PESQUISAR_USUARIO');
INSERT INTO permissao (des_per) values ('ROLE_CADASTRAR_USUARIO');
INSERT INTO permissao (des_per) values ('ROLE_ALTERAR_USUARIO');
INSERT INTO permissao (des_per) values ('ROLE_EXCLUIR_USUARIO');

--henrique
INSERT INTO usuario_permissao (cod_usu, cod_per) values (1, 1);
INSERT INTO usuario_permissao (cod_usu, cod_per) values (1, 2);
INSERT INTO usuario_permissao (cod_usu, cod_per) values (1, 3);
INSERT INTO usuario_permissao (cod_usu, cod_per) values (1, 4);
INSERT INTO usuario_permissao (cod_usu, cod_per) values (1, 5);
INSERT INTO usuario_permissao (cod_usu, cod_per) values (1, 6);
INSERT INTO usuario_permissao (cod_usu, cod_per) values (1, 7);
INSERT INTO usuario_permissao (cod_usu, cod_per) values (1, 8);

-- maria
INSERT INTO usuario_permissao (cod_usu, cod_per) values (2, 1);