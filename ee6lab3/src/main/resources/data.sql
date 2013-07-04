DROP SCHEMA ee6lab3 cascade;
CREATE SCHEMA ee6lab3;

--drop table ee6lab3.users;
CREATE TABLE ee6lab3.users(id serial,firstname VARCHAR(32), lastname VARCHAR(32), email VARCHAR(32));
insert into ee6lab3.users values (DEFAULT,'Thomas','Mecker','thomas.mecker@gmail.com');
insert into ee6lab3.users values (DEFAULT,'Neal','Graham','neal.graham@yahoo.com');
insert into ee6lab3.users values (DEFAULT,'Myra','Sanchez','myra.sanchez@hotmail.com');
insert into ee6lab3.users values (DEFAULT,'Lisa','Smith','lisa.smith@ibm.com');
insert into ee6lab3.users values (DEFAULT,'Paul','Phelp','paul.phelp@apple.com');
insert into ee6lab3.users values (DEFAULT,'Sheila','Lewis','sheila.lewis@yahoo.de');
insert into ee6lab3.users values (DEFAULT,'Thomas','James','thomas.james@sony.tw');

--drop table ee6lab3.resources;
CREATE TABLE ee6lab3.resources(id serial,category VARCHAR(32),manufacturer VARCHAR(32), type VARCHAR(32), image VARCHAR(200));
insert into ee6lab3.resources values (DEFAULT,'Notebook','Dell','Inspiron 3521','http://www.edigital.hu/Notebook/www.edigital.hu/files/product_images/kepek/354/394953.jpg');
insert into ee6lab3.resources values (DEFAULT,'Notebook','Apple','MacBook Pro','http://www.edigital.hu/Notebook/www.edigital.hu/files/product_images/kepek/347/382919.jpg');
insert into ee6lab3.resources values (DEFAULT,'Notebook','Samsung','NP300E5C-S06HU','http://www.edigital.hu/Notebook/www.edigital.hu/files/product_images/kepek/340/370336.jpg');
insert into ee6lab3.resources values (DEFAULT,'Keyboard','Logitech','K400','http://www.edigital.hu/Vezetek_nelkuli_billentyuzet/www.edigital.hu/files/product_images/kepek/269/279364.jpg');
insert into ee6lab3.resources values (DEFAULT,'Keyboard','Genius','KB-M200','http://www.edigital.hu/Vezetekes_billentyuzet/www.edigital.hu/files/product_images/kepek/352/391705.jpg');
insert into ee6lab3.resources values (DEFAULT,'Keyboard','A4TECH','KD-126','http://www.edigital.hu/Vezetekes_billentyuzet/www.edigital.hu/files/product_images/kepek/354/395723.jpg');
insert into ee6lab3.resources values (DEFAULT,'Mouse','Logitec',' M185','http://www.edigital.hu/Vezetek_nelkuli_eger/www.edigital.hu/files/product_images/kepek/271/280947.jpg');
insert into ee6lab3.resources values (DEFAULT,'Mouse','Genius','Traveler 9000','http://www.edigital.hu/Vezetek_nelkuli_eger/www.edigital.hu/files/product_images/kepek/273/286003.jpg');
insert into ee6lab3.resources values (DEFAULT,'Mouse','Gigabyte','GM-M7580','http://www.edigital.hu/Vezetek_nelkuli_eger/www.edigital.hu/files/kepek/d_71459.jpg');
insert into ee6lab3.resources values (DEFAULT,'Monitor','Samsung','T22B300','http://www.edigital.hu/Monitor/www.edigital.hu/files/product_images/kepek/326/353677.jpg');
insert into ee6lab3.resources values (DEFAULT,'Monitor','LG','22EN33S-B','http://www.edigital.hu/Monitor/www.edigital.hu/files/product_images/kepek/350/387164.jpg');
insert into ee6lab3.resources values (DEFAULT,'Monitor','LG','29EA93-P','http://www.edigital.hu/Monitor/www.edigital.hu/files/product_images/kepek/345/379409.jpg');
insert into ee6lab3.resources values (DEFAULT,'PC','HP','Pro 3500MT','http://www.edigital.hu/Komplett_gep/www.edigital.hu/files/product_images/kepek/353/393589.jpg');
insert into ee6lab3.resources values (DEFAULT,'PC','Asus','Essentio CM6830-HU005S','http://www.edigital.hu/Komplett_gep/www.edigital.hu/files/product_images/kepek/356/399039.jpg');
insert into ee6lab3.resources values (DEFAULT,'PC','Apple','Mac mini','http://www.edigital.hu/Komplett_gep/Apple_Mac_mini_25GHz_(md387mg/www.edigital.hu/files/product_images/kepek/342/371951.jpg');
insert into ee6lab3.resources values (DEFAULT,'Pendrive','Kingston','DataTraveler SE9','http://www.edigital.hu/Pendrive/www.edigital.hu/files/product_images/kepek/323/353315.jpg');
insert into ee6lab3.resources values (DEFAULT,'Mobilephone','Samsung','I9505 Galaxy S 4','http://www.edigital.hu/Okostelefon/www.edigital.hu/files/product_images/kepek/353/393150.jpg');
insert into ee6lab3.resources values (DEFAULT,'Fax','Xerox','TF4075','http://www.edigital.hu/Fax_es_faxkiegeszito/www.edigital.hu/files/product_images/kepek/347/384556.jpg');
insert into ee6lab3.resources values (DEFAULT,'Projector','Benq','MS502','http://www.edigital.hu/Projektor/www.edigital.hu/files/product_images/kepek/335/364173.jpg');
select * from ee6lab3.resources;

--drop table ee6lab3.user_resource;
CREATE TABLE ee6lab3.user_resource(id serial,user_id integer,resource_id integer);
insert into ee6lab3.user_resource values (default,1,1);
insert into ee6lab3.user_resource values (default,2,2);
insert into ee6lab3.user_resource values (default,3,3);
insert into ee6lab3.user_resource values (default,4,4);
insert into ee6lab3.user_resource values (default,4,7);
insert into ee6lab3.user_resource values (default,4,10);
insert into ee6lab3.user_resource values (default,4,13);
insert into ee6lab3.user_resource values (default,5,5);
insert into ee6lab3.user_resource values (default,5,8);
insert into ee6lab3.user_resource values (default,5,11);
insert into ee6lab3.user_resource values (default,5,14);
insert into ee6lab3.user_resource values (default,6,6);
insert into ee6lab3.user_resource values (default,6,9);
insert into ee6lab3.user_resource values (default,6,12);
insert into ee6lab3.user_resource values (default,6,15);
insert into ee6lab3.user_resource values (default,7,16);
insert into ee6lab3.user_resource values (default,7,17);
insert into ee6lab3.user_resource values (default,7,18);
insert into ee6lab3.user_resource values (default,7,19);
--select * from ee6lab3.user_resource;
