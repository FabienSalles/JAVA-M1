create table Enseignant(
 numen integer not null,
 nom varchar(50),
 prenom varchar(50),
 login varchar(50) unique,
 password varchar(50),
 primary key (numen)
);

create table Etudiant(
  netudiant varchar(50) not null,
  nom varchar(50),
  prenom varchar(50),
  login varchar(50) unique,
  password varchar(50),
  primary key (netudiant)
);

create table Module(
  id integer not null,
  intitule varchar(50),
  numen integer,
  primary key(id),
  constraint fk_enseignant foreign key (numen) references Enseignant(numen)
);

create table Note(
  id_module integer not null,
  netudiant varchar(50) not null,
  note number(4,2),
  primary key (id_module, netudiant),
  constraint fk_module foreign key (id_module) references Module(id),
  constraint fk_etudiant foreign key (netudiant) references Etudiant(netudiant)
);

insert into Etudiant values('num1', 'toto', 'tata', 'log1', 'pwd1');
insert into Etudiant values('num2', 'titi', 'test2', 'log2', 'pwd2');
insert into Etudiant values('num3', 'test3', 'prenom', 'log3', 'pwd3');
insert into Etudiant values('num4', 'test4', 'prenom2', 'log4', 'pwd1');
insert into Etudiant values('num5', 'salles', 'fabien', 'fabien', 'salles');

insert into Enseignant values(1234, 'enseignant1', 'charles', 'toto', 'toto');
insert into Enseignant values(5678, 'enseignant2', 'henry', 'login', 'pwd2');
insert into Enseignant values(91011, 'enseignant4', 'Georges', 'test', 'pwd3');
insert into Enseignant values(1214, 'enseignant5', 'Paul', 'titi', 'pwd1');
insert into Enseignant values(12155, 'Philipe', 'Jean', 'log', 'test');

insert into Module values (1, 'Math', 12155);
insert into Module values (2, 'Geo', 12155);
insert into Module values (3, 'Java', 12155);
insert into Module values (4, 'Franaçais', 12155);
insert into Module values (5, 'PHP', 12155);
insert into Module values (6, 'HTML', 12155);
insert into Module values (7, 'compta', 12155);
insert into Module values (8, 'Math', 1234);
insert into Module values (9, 'JS', 1234);

insert into Note values (1, 'num1', 2.55);
insert into Note values (1, 'num2', 0);
insert into Note values (1, 'num3', 1);
insert into Note values (1, 'num4', 19);
insert into Note values (1, 'num5', 18);
insert into Note values (2, 'num1', 17);
insert into Note values (2, 'num2', 16);
insert into Note values (2, 'num3', 12);
insert into Note values (2, 'num4', 11);
insert into Note values (2, 'num5', 13);
insert into Note values (3, 'num5', 8.50);
insert into Note values (3, 'num4', 10.5);
insert into Note values (4, 'num5', 15);
insert into Note values (2, 'num3', 10);
insert into Note values (2, 'num4', 10);

commit;