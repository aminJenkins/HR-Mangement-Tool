INSERT INTO ZUGANG(EMAIL, PASSWORD) VALUES('admin@hr','password')
insert into ABTEILUNG(abteilung_id,name) values(1,'modern web');
insert into ABTEILUNG(abteilung_id,name) values(2,'operations');
insert into ABTEILUNG(abteilung_id,name) values(3,'vertrieb');
INSERT INTO mitarbeiter(mitarbeiter_id, anschrift, email, nachname, name, rolle, telnr, VORGESETZER_MITARBEITER_ID, abteilung_id)
VALUES (1,'Salomon-Diler-Str', 'vlad.hyrov@gmail.com', 'vlad', 'hyrov', 'ma', '020982471', NULL,1);
INSERT INTO mitarbeiter(mitarbeiter_id, anschrift, email, nachname, name, rolle, telnr, VORGESETZER_MITARBEITER_ID, abteilung_id)
VALUES (2,'Salomon-Diler-Str', 'vlad.hyrov@gmail.com', 'vladi', 'urka', 'ma', '020982471', 1,1);
INSERT INTO PROJEKT(PROJEKT_ID, AUFTRAGSGEBER, BEZEICHNUNG, BUDGET, STUNDENSATZ) VALUES(1,'HS Augsburg','Semester Projekt',4000,20);
INSERT INTO MITARBEITER_PROJEKT(MITARBEITER_ID,PROJEKT_ID) VALUES(1,1);
INSERT INTO MITARBEITER_PROJEKT(MITARBEITER_ID,PROJEKT_ID) VALUES(2,1);
INSERT INTO TERMIN(TERMIN_ID, DATE, MITARBEITER) VALUES(1,'2020-02-03',1);