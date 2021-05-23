CREATE TABLE d12_nivel3_m(
	d12_cdempresa BIGINT(20),
	d12_cdnivel1 BIGINT(20),
	d12_cdnivel2 BIGINT(20),
	d12_cdnivel3 BIGINT(20),
	d12_nmnivel3 VARCHAR(200),



PRIMARY KEY (d12_cdempresa,d12_cdnivel1,d12_cdnivel2,d12_cdnivel3),
FOREIGN KEY(d12_cdempresa,d12_cdnivel1,d12_cdnivel2) REFERENCES d11_nivel2_m(d11_cdempresa, d11_cdnivel1, d11_cdnivel2)

) Engine=InnoDB;

INSERT INTO d12_nivel3_m (d12_cdempresa,d12_cdnivel1,d12_cdnivel2,d12_cdnivel3,d12_nmnivel3) VALUES (1, 1, 1, 1, 'Macrozoneamento');
INSERT INTO d12_nivel3_m (d12_cdempresa,d12_cdnivel1,d12_cdnivel2,d12_cdnivel3,d12_nmnivel3) VALUES (1, 1, 1, 2, 'Delimita��o e identifica��o da AMF,UPA e UT');
INSERT INTO d12_nivel3_m (d12_cdempresa,d12_cdnivel1,d12_cdnivel2,d12_cdnivel3,d12_nmnivel3) VALUES (1, 1, 1, 3, 'Invent�rio florestal 100%');
INSERT INTO d12_nivel3_m (d12_cdempresa,d12_cdnivel1,d12_cdnivel2,d12_cdnivel3,d12_nmnivel3) VALUES (1, 1, 1, 4, 'Corte de cip�s');
INSERT INTO d12_nivel3_m (d12_cdempresa,d12_cdnivel1,d12_cdnivel2,d12_cdnivel3,d12_nmnivel3) VALUES (1, 1, 1, 5, 'Instala��o da Infra estrutura');
INSERT INTO d12_nivel3_m (d12_cdempresa,d12_cdnivel1,d12_cdnivel2,d12_cdnivel3,d12_nmnivel3) VALUES (1, 1, 2, 1, 'Derruba');
INSERT INTO d12_nivel3_m (d12_cdempresa,d12_cdnivel1,d12_cdnivel2,d12_cdnivel3,d12_nmnivel3) VALUES (1, 1, 2, 2, 'Arraste');
INSERT INTO d12_nivel3_m (d12_cdempresa,d12_cdnivel1,d12_cdnivel2,d12_cdnivel3,d12_nmnivel3) VALUES (1, 1, 2, 3, 'Opera��es de p�tio');
INSERT INTO d12_nivel3_m (d12_cdempresa,d12_cdnivel1,d12_cdnivel2,d12_cdnivel3,d12_nmnivel3) VALUES (1, 1, 2, 4, 'Transporte');
INSERT INTO d12_nivel3_m (d12_cdempresa,d12_cdnivel1,d12_cdnivel2,d12_cdnivel3,d12_nmnivel3) VALUES (1, 1, 3, 1, 'Silvicultura p�s explorat�ria e monitoramento da AMF e do desenvolvimento da floresta');
INSERT INTO d12_nivel3_m (d12_cdempresa,d12_cdnivel1,d12_cdnivel2,d12_cdnivel3,d12_nmnivel3) VALUES (1, 1, 3, 2, 'Prote��o florestal');
INSERT INTO d12_nivel3_m (d12_cdempresa,d12_cdnivel1,d12_cdnivel2,d12_cdnivel3,d12_nmnivel3) VALUES (1, 1, 3, 3, 'Seguran�a no trabalho');
INSERT INTO d12_nivel3_m (d12_cdempresa,d12_cdnivel1,d12_cdnivel2,d12_cdnivel3,d12_nmnivel3) VALUES (1, 1, 3, 4, 'Infra-estrutura do acampamento');
INSERT INTO d12_nivel3_m (d12_cdempresa,d12_cdnivel1,d12_cdnivel2,d12_cdnivel3,d12_nmnivel3) VALUES (1, 1, 4, 1, 'Macrozoneamento');
INSERT INTO d12_nivel3_m (d12_cdempresa,d12_cdnivel1,d12_cdnivel2,d12_cdnivel3,d12_nmnivel3) VALUES (1, 1, 4, 2, 'Delimita��o e identifica��o da AMF,UPA e UT');
INSERT INTO d12_nivel3_m (d12_cdempresa,d12_cdnivel1,d12_cdnivel2,d12_cdnivel3,d12_nmnivel3) VALUES (1, 1, 4, 3, 'Invent�rio florestal 100%');
INSERT INTO d12_nivel3_m (d12_cdempresa,d12_cdnivel1,d12_cdnivel2,d12_cdnivel3,d12_nmnivel3) VALUES (1, 1, 4, 4, 'Corte de cip�s');
INSERT INTO d12_nivel3_m (d12_cdempresa,d12_cdnivel1,d12_cdnivel2,d12_cdnivel3,d12_nmnivel3) VALUES (1, 1, 4, 5, 'Instala��o da Infra estrutura');
INSERT INTO d12_nivel3_m (d12_cdempresa,d12_cdnivel1,d12_cdnivel2,d12_cdnivel3,d12_nmnivel3) VALUES (1, 1, 4, 6, 'Derruba');
INSERT INTO d12_nivel3_m (d12_cdempresa,d12_cdnivel1,d12_cdnivel2,d12_cdnivel3,d12_nmnivel3) VALUES (1, 1, 4, 7, 'Arraste');
INSERT INTO d12_nivel3_m (d12_cdempresa,d12_cdnivel1,d12_cdnivel2,d12_cdnivel3,d12_nmnivel3) VALUES (1, 1, 4, 8, 'Opera��es de p�tio');
INSERT INTO d12_nivel3_m (d12_cdempresa,d12_cdnivel1,d12_cdnivel2,d12_cdnivel3,d12_nmnivel3) VALUES (1, 1, 4, 9, 'Transporte');
INSERT INTO d12_nivel3_m (d12_cdempresa,d12_cdnivel1,d12_cdnivel2,d12_cdnivel3,d12_nmnivel3) VALUES (1, 1, 4, 10, 'Silvicultura p�s explorat�ria e monitoramento da AMF e do desenvolvimento da floresta');
INSERT INTO d12_nivel3_m (d12_cdempresa,d12_cdnivel1,d12_cdnivel2,d12_cdnivel3,d12_nmnivel3) VALUES (1, 1, 4, 11, 'Prote��o florestal');
INSERT INTO d12_nivel3_m (d12_cdempresa,d12_cdnivel1,d12_cdnivel2,d12_cdnivel3,d12_nmnivel3) VALUES (1, 1, 4, 12, 'Seguran�a no trabalho');
INSERT INTO d12_nivel3_m (d12_cdempresa,d12_cdnivel1,d12_cdnivel2,d12_cdnivel3,d12_nmnivel3) VALUES (1, 1, 4, 13, 'Infra-estrutura do acampamento');