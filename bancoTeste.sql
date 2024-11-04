create database note_treino_teste;
use note_treino_teste;

create table treino(
id int auto_increment primary key,
nome_treino varchar(20),
nome_musculo varchar(10),
qtd_serie int
);
create table serie (
id int auto_increment primary key,
peso float,
repeticoes int,
treino_id int,
foreign key (treino_id) references treino(id)
);

select*from treino;