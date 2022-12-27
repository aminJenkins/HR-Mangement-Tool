insert into ABTEILUNG(id,name,leiter) values(1,'modern web',null);
insert into ABTEILUNG(id,name,leiter) values(2,'operations',null);
insert into ABTEILUNG(id,name,leiter) values(3,'vertrieb',null);
INSERT INTO mitarbeiter(id, anschrift, mail, nachname, name, telnr,  abteilung)
VALUES (1,'Muster Str', 'vlad.musterman@gmail.com', 'Vlad', 'Musterman', '020982471',1);
INSERT INTO mitarbeiter(id, anschrift, mail, nachname, name, telnr,  abteilung)
VALUES (2,'Andere Str.', 'amin.musterman@gmail.com', 'Amin', 'Musterman', '020982472',1);
INSERT INTO mitarbeiter(id, anschrift, mail, nachname, name, telnr,  abteilung)
VALUES (3,'Muster Str.', 'max.musterman@gmail.com', 'Max', 'Musterman', '020982473',2);
INSERT INTO mitarbeiter(id, anschrift, mail, nachname, name, telnr,  abteilung)
VALUES (4,'Dritte Muster Str.', 'kai.musterman@gmail.com', 'Kai', 'Musterman', '020982474',2);
INSERT INTO mitarbeiter(id, anschrift, mail, nachname, name, telnr,  abteilung)
VALUES (5,'Vierte Muster Str.', 'rudolf.musterman@gmail.com', 'Rudolf', 'Musterman', '020982475',3);
INSERT INTO PROJECT(ID, AUFTRAGSGEBER, BEZEICHNUNG,BUDGET_IN_ARBEITSTAGEN, STUNDENSATZ,PROJEKT_LEITER) VALUES(1,'HS Augsburg','WinterSemester Projekt',4000,20,1);
INSERT INTO PROJECT(ID, AUFTRAGSGEBER, BEZEICHNUNG,BUDGET_IN_ARBEITSTAGEN, STUNDENSATZ,PROJEKT_LEITER) VALUES(2,'Uni Augsburg','SommerSemester Projekt',4000,20,2);
INSERT INTO PROJECT(ID, AUFTRAGSGEBER, BEZEICHNUNG,BUDGET_IN_ARBEITSTAGEN, STUNDENSATZ,PROJEKT_LEITER) VALUES(3,'HS Augsburg','WinterSemester Projekt',4000,20,1);
INSERT INTO PROJEKTVERTEILUNG(MITARBEITER_ID,PROJEKT_ID) VALUES(1,1);
INSERT INTO PROJEKTVERTEILUNG(MITARBEITER_ID,PROJEKT_ID) VALUES(2,1);
INSERT INTO PROJEKTVERTEILUNG(MITARBEITER_ID,PROJEKT_ID) VALUES(3,2);
INSERT INTO PROJEKTVERTEILUNG(MITARBEITER_ID,PROJEKT_ID) VALUES(4,2);
INSERT INTO PROJEKTVERTEILUNG(MITARBEITER_ID,PROJEKT_ID) VALUES(5,3);
--insert into TERMIN (ID,TITEL,BESCHREIBUNG,BIS,PRIORITY,VON,PROJEKT_ID) values(1,'titel','beschreibung',parseDateTime('20140101000000','yyyyMMddHHmmss'),'high',parseDateTime('20150101000000','yyyyMMddHHmmss'),1)
--INSERT INTO TERMIN(TERMIN_ID, DATE, MITARBEITER) VALUES(1,'2020-02-03',1);