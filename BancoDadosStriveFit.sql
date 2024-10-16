create database NoteTreino;
use NoteTreino;
create table usuario (
id int auto_increment primary key,
nome varchar (30),
idade int,
peso float
);
create table treino(
id int auto_increment primary key,
nome_treino varchar(20),
nome_musculo varchar(10),
qtd_serie int,
usuario_id int,
foreign key (usuario_id) references usuario(id)
);
create table serie (
id int auto_increment primary key,
peso float,
repeticoes int,
treino_id int,
foreign key (treino_id) references treino(id)
);

insert into usuario (nome, idade, peso) values ('Matheus Dantas Carvalo', 19, 55);
select * from usuario;
 
insert into treino (nome_treino, nome_musculo, qtd_serie, usuario_id) values ('Supino inclinado', 'Peitoral', 4, 1);
insert into serie (peso, repeticoes, treino_id) values (40, 10, 1);
insert into serie (peso, repeticoes, treino_id) values (45, 8, 1);
insert into serie (peso, repeticoes, treino_id) values (45, 9, 1);
insert into serie (peso, repeticoes, treino_id) values (45, 11, 1);
 
 
SELECT 
    u.nome AS nome_usuario,
    t.nome_treino,
    t.qtd_serie,
    s.peso,
    s.repeticoes
FROM 
    usuario u
JOIN 
    treino t ON u.id = t.usuario_id
JOIN 
    serie s ON t.id = s.treino_id;