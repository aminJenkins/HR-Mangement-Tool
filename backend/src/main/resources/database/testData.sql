
insert into ABTEILUNG(id,name,leiter) values(1,'modern web',null);
insert into ABTEILUNG(id,name,leiter) values(2,'operations',null);
insert into ABTEILUNG(id,name,leiter) values(3,'vertrieb',null);
INSERT INTO mitarbeiter(id, anschrift, mail, nachname, name, telnr,  abteilung)
VALUES (1,'Muster Str', 'user@ma', 'Vlad', 'Musterman', '020982471',1);
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
INSERT INTO KONTINGENT(ID,BEZEICHNUNG) VALUES (1,'INTERNES PROJEKT');
INSERT INTO KONTINGENT(ID,BEZEICHNUNG) VALUES (2,'WEITERBILDUNG');
INSERT INTO KONTINGENT(ID,BEZEICHNUNG) VALUES (3,'URLAUB');
INSERT INTO KONTINGENT(ID,BEZEICHNUNG) VALUES (4,'KRANKHEIT');
INSERT INTO PROJEKTVERTEILUNG(MITARBEITER_ID,PROJEKT_ID) VALUES(1,1);
INSERT INTO PROJEKTVERTEILUNG(MITARBEITER_ID,PROJEKT_ID) VALUES(2,1);
INSERT INTO PROJEKTVERTEILUNG(MITARBEITER_ID,PROJEKT_ID) VALUES(2,2);
INSERT INTO PROJEKTVERTEILUNG(MITARBEITER_ID,PROJEKT_ID) VALUES(4,2);
INSERT INTO PROJEKTVERTEILUNG(MITARBEITER_ID,PROJEKT_ID) VALUES(1,3);
INSERT INTO TERMIN (ID,TITEL,BESCHREIBUNG,BEGINN,ENDE, PRIORITY,DATUM, PROJEKT_ID) values(1,'titel','beschreibung','08:00','10:00','high','2022-08-01',1);
INSERT INTO ZEITERFASSUNG (ID, MITARBEITER_ID,KOMMENTAR,DAUER,DATUM,KONTINGENT_ID) values(1,1,'NO COMMENTS',3,parseDateTime('20220101','yyyyMMdd'),1);
INSERT INTO ZEITERFASSUNG (ID, MITARBEITER_ID,KOMMENTAR,DAUER,DATUM,KONTINGENT_ID) values(2,1,'NO COMMENTS',3,parseDateTime('20220102','yyyyMMdd'),1);
INSERT INTO ZEITERFASSUNG (ID, MITARBEITER_ID,KOMMENTAR,DAUER,DATUM,KONTINGENT_ID) values(3,1,'NO COMMENTS',3,parseDateTime('20220103','yyyyMMdd'),1);
INSERT INTO ZEITERFASSUNG (ID, MITARBEITER_ID,KOMMENTAR,DAUER,DATUM,KONTINGENT_ID) values(4,1,'NO COMMENTS',3,parseDateTime('20220104','yyyyMMdd'),1);
INSERT INTO ZEITERFASSUNG (ID, MITARBEITER_ID,KOMMENTAR,DAUER,DATUM,KONTINGENT_ID) values(5,1,'NO COMMENTS',3,parseDateTime('20220103','yyyyMMdd'),1);
INSERT INTO ZEITERFASSUNG (ID, MITARBEITER_ID,KOMMENTAR,DAUER,DATUM,KONTINGENT_ID) values(6,1,'NO COMMENTS',3,parseDateTime('20220104','yyyyMMdd'),1);
