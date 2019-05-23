Create table [usuario]
(
	[cod_usu] Integer Identity NOT NULL,
	[ema_usu] Varchar(100) NOT NULL, UNIQUE ([ema_usu]),
	[sen_usu] Varchar(200) NOT NULL,
	[sta_usu] Varchar(10) NOT NULL,
Primary Key ([cod_usu])) 

Create table [permissao]
(
	[cod_per] Integer Identity NOT NULL,
	[des_per] Varchar(100) NOT NULL,
Primary Key ([cod_per])) 

Create table [usuario_permissao]
(	
	[cod_usu] Integer NOT NULL,
	[cod_per] Integer NOT NULL,
Primary Key ([cod_per],[cod_usu]))

Alter table [usuario_permissao] add  foreign key([cod_per]) references [permissao] ([cod_per]) on update no action on delete no action 
Alter table [usuario_permissao] add  foreign key([cod_usu]) references [usuario] ([cod_usu]) on update no action on delete no action 

INSERT INTO usuario values ('henrique.simoes@feluma.org.br', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.', 'ATIVO');
INSERT INTO usuario values ('maria@gmail.com', '$2a$10$Zc3w6HyuPOPXamaMhh.PQOXvDnEsadztbfi6/RyZWJDzimE8WQjaq', 'ATIVO');

INSERT INTO permissao values ('ROLE_PESQUISAR_DISCIPLINA');
INSERT INTO permissao values ('ROLE_CADASTRAR_DISCIPLINA');
INSERT INTO permissao values ('ROLE_ALTERAR_DISCIPLINA');
INSERT INTO permissao values ('ROLE_EXCLUIR_DISCIPLINA');

INSERT INTO permissao values ('ROLE_PESQUISAR_USUARIO');
INSERT INTO permissao values ('ROLE_CADASTRAR_USUARIO');
INSERT INTO permissao values ('ROLE_ALTERAR_USUARIO');
INSERT INTO permissao values ('ROLE_EXCLUIR_USUARIO');

--henrique
INSERT INTO usuario_permissao values (1, 1);
INSERT INTO usuario_permissao values (1, 2);
INSERT INTO usuario_permissao values (1, 3);
INSERT INTO usuario_permissao values (1, 4);
INSERT INTO usuario_permissao values (1, 5);
INSERT INTO usuario_permissao values (1, 6);
INSERT INTO usuario_permissao values (1, 7);
INSERT INTO usuario_permissao values (1, 8);

-- maria
INSERT INTO usuario_permissao values (2, 1);