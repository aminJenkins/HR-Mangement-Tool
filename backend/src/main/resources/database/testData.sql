INSERT INTO ZUGANG(EMAIL, PASSWORD) VALUES('admin@hr','password');
insert into ABTEILUNG(abteilung_id,name) values(1,'modern web');
insert into ABTEILUNG(abteilung_id,name) values(2,'operations');
insert into ABTEILUNG(abteilung_id,name) values(3,'vertrieb');
INSERT INTO mitarbeiter(mitarbeiter_id, anschrift, email, nachname, name, rolle, telnr, VORGESETZER_MITARBEITER_ID, abteilung_id)
VALUES (1,'Muster Str', 'vlad.musterman@gmail.com', 'Vlad', 'Musterman', 'mitarbeiter', '020982471', NULL,1);
INSERT INTO mitarbeiter(mitarbeiter_id, anschrift, email, nachname, name, rolle, telnr, VORGESETZER_MITARBEITER_ID, abteilung_id)
VALUES (2,'Andere Str.', 'amin.musterman@gmail.com', 'Amin', 'Musterman', 'mitarbeiter', '020982472', 1,1);
INSERT INTO mitarbeiter(mitarbeiter_id, anschrift, email, nachname, name, rolle, telnr, VORGESETZER_MITARBEITER_ID, abteilung_id)
VALUES (3,'Muster Str.', 'max.musterman@gmail.com', 'Max', 'Musterman', 'mitarbeiter', '020982473', NULL,2);
INSERT INTO mitarbeiter(mitarbeiter_id, anschrift, email, nachname, name, rolle, telnr, VORGESETZER_MITARBEITER_ID, abteilung_id)
VALUES (4,'Dritte Muster Str.', 'kai.musterman@gmail.com', 'Kai', 'Musterman', 'mitarbeiter', '020982474', 3,2);
INSERT INTO mitarbeiter(mitarbeiter_id, anschrift, email, nachname, name, rolle, telnr, VORGESETZER_MITARBEITER_ID, abteilung_id)
VALUES (5,'Vierte Muster Str.', 'rudolf.musterman@gmail.com', 'Rudolf', 'Musterman', 'mitarbeiter', '020982475', NULL,3);
INSERT INTO PROJEKT(PROJEKT_ID, AUFTRAGSGEBER, BEZEICHNUNG, BUDGET, STUNDENSATZ) VALUES(1,'HS Augsburg','WinterSemester Projekt',4000,20);
INSERT INTO PROJEKT(PROJEKT_ID, AUFTRAGSGEBER, BEZEICHNUNG, BUDGET, STUNDENSATZ) VALUES(2,'Uni Augsburg','SommerSemester Projekt',4000,20);
INSERT INTO PROJEKT(PROJEKT_ID, AUFTRAGSGEBER, BEZEICHNUNG, BUDGET, STUNDENSATZ) VALUES(3,'HS Augsburg','WinterSemester Projekt',4000,20);
INSERT INTO MITARBEITER_PROJEKT(MITARBEITER_ID,PROJEKT_ID) VALUES(1,1);
INSERT INTO MITARBEITER_PROJEKT(MITARBEITER_ID,PROJEKT_ID) VALUES(2,1);
INSERT INTO MITARBEITER_PROJEKT(MITARBEITER_ID,PROJEKT_ID) VALUES(3,2);
INSERT INTO MITARBEITER_PROJEKT(MITARBEITER_ID,PROJEKT_ID) VALUES(4,2);
INSERT INTO MITARBEITER_PROJEKT(MITARBEITER_ID,PROJEKT_ID) VALUES(5,3);
INSERT INTO TERMIN(TERMIN_ID, DATE, MITARBEITER) VALUES(1,'2020-02-03',1);