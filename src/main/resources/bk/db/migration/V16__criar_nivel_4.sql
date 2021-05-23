CREATE TABLE d13_nivel4_m(
	d13_cdempresa BIGINT(20),
	d13_cdnivel1 BIGINT(20),
	d13_cdnivel2 BIGINT(20),
	d13_cdnivel3 BIGINT(20),
	d13_cdnivel4 BIGINT(20),
	d13_nmnivel4 VARCHAR(200),



PRIMARY KEY (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4),
FOREIGN KEY(d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3) REFERENCES d12_nivel3_m(d12_cdempresa, d12_cdnivel1, d12_cdnivel2, d12_cdnivel3)

) Engine=InnoDB;

INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 1, 1, 1, 'Conte�do do mapa da propriedade');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 1, 1, 2, 'As informa��es do macrozoneamento correspondem � realidade de campo');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 1, 2, 1, 'AMF');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 1, 2, 2, 'UPA');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 1, 3, 1, 'Picadas de orienta��o');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 1, 3, 2, 'Informa��es levantadas');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 1, 3, 3, 'Etiquetagem');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 1, 3, 4, 'Mapa do microzoneamento');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 1, 4, 1, 'Corte pr�-explorat�rio');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 1, 5, 1, 'Estradas principais e de acesso');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 1, 5, 2, 'Estradas secund�rias');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 1, 5, 3, 'P�tios');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 1, 5, 4, 'Bueiros/Pontes');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 1, 5, 5, 'Detalhes gerais da constru��o');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 1, 5, 6, 'Danos e res�duos');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 1, 5, 7, 'Infra-estrutura nos mapas');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 2, 1, 1, 'Mapa de corte');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 2, 1, 2, 'Planejamento');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 2, 1, 3, 'T�cnica');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 2, 1, 4, 'Etiquetagem');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 2, 1, 5, 'Legalidade');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 2, 2, 1, 'Planejamento de arraste');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 2, 2, 2, 'Opera��es');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 2, 2, 3, 'Qualidade');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 2, 3, 1, 'Desperd�cio');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 2, 3, 2, 'Romaneio');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 2, 3, 3, 'Legalidade ');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 2, 4, 1, 'Seguran�a');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 2, 4, 2, 'Legalidade');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 3, 1, 1, 'Silvicultura p�s-colheita.');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 3, 1, 2, 'Monitoramento da floresta e da AMF.');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 3, 2, 1, 'Inc�ndios');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 3, 2, 2, 'Invas�o');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 3, 2, 3, 'Ca�a');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 3, 2, 4, 'Lixo inorg�nico');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 3, 3, 1, 'Equipamento de Prote��o Individual');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 3, 3, 2, 'Procedimentos');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 3, 3, 3, 'Provid�ncias gerais');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 3, 3, 4, 'Sinaliza��o');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 3, 4, 1, 'Localiza��o');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 3, 4, 2, 'Moradia');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 3, 4, 3, 'Higiene');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 3, 4, 4, 'Lixo e res�duos');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 1, 1, 'Conte�do do mapa da propriedade');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 1, 2, 'As informa��es do macrozoneamento correspondem � realidade de campo');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 2, 1, 'AMF');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 2, 2, 'UPA');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 3, 1, 'Picadas de orienta��o');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 3, 2, 'Informa��es levantadas');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 3, 3, 'Etiquetagem');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 3, 4, 'Mapa do microzoneamento');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 4, 1, 'Corte pr�-explorat�rio');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 5, 1, 'Estradas principais e de acesso');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 5, 2, 'Estradas secund�rias');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 5, 3, 'P�tios');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 5, 4, 'Bueiros/Pontes');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 5, 5, 'Detalhes gerais da constru��o');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 5, 6, 'Danos e res�duos');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 5, 7, 'Infra-estrutura nos mapas');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 6, 1, 'Mapa de corte');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 6, 2, 'Planejamento');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 6, 3, 'T�cnica');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 6, 4, 'Etiquetagem');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 6, 5, 'Legalidade');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 7, 1, 'Planejamento de arraste');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 7, 2, 'Opera��es');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 7, 3, 'Qualidade');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 8, 1, 'Desperd�cio');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 8, 2, 'Romaneio');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 8, 3, 'Legalidade ');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 9, 1, 'Seguran�a');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 9, 2, 'Legalidade');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 10, 1, 'Silvicultura p�s-colheita.');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 10, 2, 'Monitoramento da floresta e da AMF.');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 11, 1, 'Inc�ndios');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 11, 2, 'Invas�o');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 11, 3, 'Ca�a');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 11, 4, 'Lixo inorg�nico');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 12, 1, 'Equipamento de Prote��o Individual');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 12, 2, 'Procedimentos');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 12, 3, 'Provid�ncias gerais');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 12, 4, 'Sinaliza��o');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 13, 1, 'Localiza��o');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 13, 2, 'Moradia');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 13, 3, 'Higiene');
INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1,d13_cdnivel2,d13_cdnivel3,d13_cdnivel4,d13_nmnivel4) VALUES (1, 1, 4, 13, 4, 'Lixo e res�duos');