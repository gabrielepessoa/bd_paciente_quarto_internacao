create schema hospital;
use hospital;

create table paciente (
codpac integer not null,
nomepac varchar(30),
datanascpac date,
primary key (codpac));

create table leito(
numleito integer not null,
numquarto integer,
tipoleito varchar(20),
primary key (numleito));

create table internacao(
codpac integer not null,
numerointern integer not null,
databaixa date,
dataalta date,
numleito integer,
primary key (codpac, numerointern),
foreign key (codpac) references paciente(codpac) on delete cascade on update cascade,
foreign key (numleito) references leito(numleito) on delete cascade on update cascade);

insert into paciente (codpac, nomepac, datanascpac) values (001, 'Lisandra Sousa da Cruz', '1994-07-30'), 
														   (002, 'Gabriele Pessoa', '1993-10-01'),
													       (003, 'Raissa Costa', '1991-07-20');
                                                  
insert into leito (numleito, numquarto, tipoleito) values (01, 10, 'a'),
														  (02, 20, 'b'),
                                                          (03, 30, 'c');
                                                          
insert into internacao (codpac, numerointern, databaixa, dataalta, numleito) values (001, 001, '2015-07-01', '2015-07-10', 01),
                                                                       				(002, 002, '2015-07-01', '2015-07-10', 02),
                                                                                    (003, 003, '2015-07-01', '2015-07-10', 03);
                                                                                    
                                                                                    