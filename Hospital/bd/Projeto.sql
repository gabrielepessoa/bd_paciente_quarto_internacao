create schema hospital;
use hospital;

create table paciente (
codpac varchar(45) not null,
nomepac varchar(30),
datanascpac date,
primary key (codpac));

create table leito(
numleito integer not null,
numquarto integer,
tipoleito varchar(20),
primary key (numleito));

create table internamento(
codpac varchar(45) not null,
numerointern integer not null,
databaixa date,
dataalta date,
numleito integer,
primary key (codpac, numerointern),
foreign key (codpac) references paciente(codpac) on delete cascade on update cascade,
foreign key (numleito) references leito(numleito) on delete cascade on update cascade);

insert into paciente (codpac, nomepac, datanascpac) values ('09000000000', 'Lisandra Cruz', '1994-07-30'), 
														   ('09000000001', 'Gabriele Pessoa', '1993-10-01'),
													       ('09000000002', 'Raissa Costa', '1991-07-19'), 
                                                           ('09000000003', 'Luis Delando', '1995-06-03'), 
                                                           ('09000000004','Mayza Costa', '1993-01-24'),
                                                           ('09000000005','Lucas Cruz', '2000-03-09'),
                                                           ('09000000006', 'Joana', '2000-03-09'),
                                                           ('09000000007', 'Roberta Macêdo', '1990-03-09'),      
                                                           ('09000000008', 'Danillo Pércio', '1990-03-09'); 
                                                           
                                                  
insert into leito (numleito, numquarto, tipoleito) values (01, 10, 'Enfermaria'),
														  (02, 20, 'Apartamento'),
                                                          (03, 30, 'Quarto'),
                                                          (04, 40, 'Enfermaria'),
                                                          (05, 40, 'Quarto'),
                                                          (06, 40, 'Apartamento'),
                                                          (07, 40, 'Enfermaria'),
                                                          (08, 40, 'Enfermaria'),
                                                          (09, 50, 'Apartamento');
                                                          
insert into internamento (codpac, numerointern, databaixa, dataalta, numleito) values ('09000000000', 001, '2015-07-05', '2015-07-10', 01),
                                                                       				  ('09000000001', 002, '2015-07-01', '2015-07-06', 02),
                                                                                      ('09000000002', 003, '2015-07-01', '2015-07-10', 03),
                                                                                      ('09000000003', 004, '2015-01-02', '2015-02-10', 04),
                                                                                      ('09000000004', 005, '2015-03-06', '2015-04-11', 05);
                                                                                    
-- visão para listar os pacientes                                                                                    
create view pacientessistema (CPF, Nome, DataNascimento) as
select p.codpac, p.nomepac, p.datanascpac
from paciente as p;                     

-- listar todos os sistemas
create view leitossistema (NumeroLeito, NumeroQuarto, TipoLeito) as
select l.numleito, l.numquarto, l.tipoleito
from leito as l;

-- consultar internados
create view internadossistema (CPF, NumeroInternamento, DataBaixa, DataAlta, NumeroLeito) as
select i.codpac, i.numerointern, i.databaixa, i.dataalta, i.numleito
from internamento as i, paciente as p, leito as l
where i.codpac=p.codpac and l.numleito=i.numleito;