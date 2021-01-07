INSERT INTO CARS (NAME, MODEL, PRICE, DATE, BOOKED, DETAILS,TYPE)
VALUES ('Volvo', 'V90', 2435,TIMESTAMP '1999-01-31' ,false, 'Motor: 300hk | Växel: Automat | Färg: Röd | Drivmedel: Diesel','Stor' ),
       ('Audi', 'A4', 2343,TIMESTAMP '1999-01-31' ,false,'Motor: 350hk | Växel: Manuell | Färg: Gul | Drivmedel: Bensin','Stor'),
       ('BMW', 'IQ', 4000,TIMESTAMP '1999-01-31' ,false,'Motor: 220hk | Växel: Automat | Färg: Blå | Drivmedel: El','Liten'),
       ('Citroen', 'Capture', 1300,TIMESTAMP '1999-01-31' ,false,'Motor: 290hk | Växel: Automat | Färg: grön | Drivmedel: Diesel','Mellan'),
       ('Ford', 'Kuga', 1444,TIMESTAMP '1999-01-31',false,'Motor: 200hk | Växel: Automat | Färg: Svart | Drivmedel: Bensin','Liten'),
       ('Mazda','Mx-5',3000,TIMESTAMP '1999-01-31' ,false,'Motor: 450hk | Växel: Manuell | Färg: Grå | Drivmedel: Diesel','Mellan'),
       ('KIA','Rio',500,TIMESTAMP '1999-01-31',false,'Motor: 300hk | Växel: Manuell | Färg: Vit | Drivmedel: Bensin','Liten'),
       ('Fiat','Panda',800,TIMESTAMP '1999-01-31' ,false,'Motor: 250hk | Växel: Automat | Färg: Orange | Drivmedel: Diesel','Liten');


INSERT INTO CUSTOMER (FIRSTNAME, LASTNAME, ADRESS, PHONE, USERNAME,RENT_TIMES)
VALUES ('Winston','McGee', 'Dingdong road 45', 2389323, 'Winston',1),
       ('Standford','Pines', 'Gravity Falls 42', 2343342, 'Standford',3),
       ('Wallace','Gromit', 'Englishmud road 23', 40002223,'Wallace',2),
       ('Bob','Spongepants', 'Pinapple searoad', 1300432,'Bob',5),
       ('Bruce','Kent', 'Steelbat road', 1444234,'Bruce',3),
       ('Happy','Stark','Malibou drive 32',3000223,'Happy',7),
       ('Bruce','Chan','Martial arts road',5002225, 'BruceChan',10),
       ('Bruce','Hulksson','Steorid road',9009000,'BruceHulk',60),
       ('Alfred','Abutler','Batman manor road',5550000,'Batalf',2);


