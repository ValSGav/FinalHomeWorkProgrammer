DROP DATABASE IF EXISTS human_friends;


CREATE DATABASE human_friends;

SHOW DATABASES;

USE human_friends;


CREATE TABLE camel (id INT AUTO_INCREMENT,
                           name VARCHAR(50),
                                birthdate DATE, commands VARCHAR(300),
                                                         PRIMARY KEY(id));


CREATE TABLE horse LIKE camel;


CREATE TABLE dunkey LIKE camel;


CREATE TABLE cat LIKE camel;


CREATE TABLE dog LIKE camel;


CREATE TABLE hamster LIKE camel;

DESC camel;

DESC horse;

DESC dunkey;

DESC cat;

DESC dog;

DESC hamster;


INSERT INTO camel (name, birthdate, commands)
VALUES ('verblud1', '20040120', 'ledjat, stoyat, bedjat'),
       ('verblud2', '20050210', 'ledjat, stoyat'),
       ('verblud3', '20120317', 'stoyat, bedjat');


INSERT INTO horse (name, birthdate, commands)
VALUES ('loshad1', '20040122', 'ledjat, stoyat, bedjat, igogo'),
       ('loshad2', '20070610', 'ledjat, stoyat'),
       ('loshad3', '20020517', 'stoyat, igogo');


INSERT INTO dunkey (name, birthdate, commands)
VALUES ('osel1', '20140812', 'iaia, bedjat'),
       ('osel2', '20170310', 'ledjat, stoyat, iaia'),
       ('osel3', '20120217', 'iaia');


INSERT INTO cat (name, birthdate, commands)
VALUES ('koshka1', '20200802', 'meow, brys, ya_tebe_seychas'),
       ('koshka2', '20190510', 'meow'),
       ('koshka3', '20220907', 'ya_tebe_seychas');


INSERT INTO dog (name, birthdate, commands)
VALUES ('sobaka1', '20100812', 'day_lapu, golos, sidet'),
       ('sobaka2', '20080404', 'golos'),
       ('sobaka3', '20161007', 'fas, sidet, horoshiy_malchik');


INSERT INTO hamster (name, birthdate, commands)
VALUES ('homyak1', '20140812', 'na_na_na'),
       ('homyak2', '20220319', 'na_na_na, begay, chto_s_nim'),
       ('homyak3', '20220319', 'chto_s_nim');


SELECT *
FROM cat;


SELECT *
FROM dog;


SELECT *
FROM hamster;


SELECT *
FROM horse;


SELECT *
FROM dunkey;


SELECT *
FROM camel;

TRUNCATE camel;


SELECT *
FROM camel;


DROP TABLE IF EXISTS horse_and_dunkey;


CREATE TABLE horse_and_dunkey (id INT AUTO_INCREMENT,
                                      name VARCHAR(50),
                                           birthdate DATE, commands VARCHAR(300),
                                                                    PRIMARY KEY(id));


INSERT INTO horse_and_dunkey (name, birthdate, commands)
  (SELECT name,
          birthdate,
          commands
   FROM horse
   UNION SELECT name,
                birthdate,
                commands
   FROM dunkey);


SELECT *
FROM horse_and_dunkey;


DROP TABLE IF EXISTS age_1_3;


CREATE TABLE age_1_3 (id INT AUTO_INCREMENT,
                             name VARCHAR(50),
                                  birthdate DATE, commands VARCHAR(300),
                                                           age FLOAT, PRIMARY KEY(id));


INSERT INTO age_1_3 (name, birthdate, commands, age)
  (SELECT tempquery.name,
          tempquery.birthdate,
          tempquery.commands,
          FLOOR(timestampdiff(MONTH, tempquery.birthdate, curdate())/12) AS age
   FROM
     (SELECT name,
             birthdate,
             commands
      FROM horse
      UNION ALL SELECT name,
                       birthdate,
                       commands
      FROM dunkey
      UNION ALL SELECT name,
                       birthdate,
                       commands
      FROM camel
      UNION ALL SELECT name,
                       birthdate,
                       commands
      FROM dog
      UNION ALL SELECT name,
                       birthdate,
                       commands
      FROM cat
      UNION ALL SELECT name,
                       birthdate,
                       commands
      FROM hamster) AS tempquery
   WHERE timestampdiff(MONTH, tempquery.birthdate, curdate())<=36);


SELECT *
FROM age_1_3;


DROP TABLE IF EXISTS all_union;


CREATE TABLE all_union(id int AUTO_INCREMENT,
                              name VARCHAR(50),
                                   birthdate date, commands VARCHAR(300),
                                                            type_animal VARCHAR(10),
                                                                        PRIMARY KEY(id));


INSERT INTO all_union (name, birthdate, commands, type_animal)
  (SELECT name,
          birthdate,
          commands,
          'cat'
   FROM cat
   UNION ALL SELECT name,
                    birthdate,
                    commands,
                    'dog'
   FROM dog
   UNION ALL SELECT name,
                    birthdate,
                    commands,
                    'hamster'
   FROM hamster
   UNION ALL SELECT name,
                    birthdate,
                    commands,
                    'camel'
   FROM camel
   UNION ALL SELECT name,
                    birthdate,
                    commands,
                    'horse'
   FROM horse
   UNION ALL SELECT name,
                    birthdate,
                    commands,
                    'dunkey'
   FROM dunkey);


SELECT *
FROM all_union;