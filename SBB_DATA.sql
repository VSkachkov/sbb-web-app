﻿INSERT INTO cantons  VALUES (1, 'Zurich');
INSERT INTO cantons  VALUES (2, 'Bern');
INSERT INTO cantons  VALUES (3, 'Lucerne');
INSERT INTO cantons  VALUES (4, 'Uri');
INSERT INTO cantons  VALUES (5, 'Schwyz');
INSERT INTO cantons  VALUES (6, 'Obwalden');
INSERT INTO cantons  VALUES (7, 'Nidwalden');
INSERT INTO cantons  VALUES (8, 'Glarus');
INSERT INTO cantons  VALUES (9, 'Zug');
INSERT INTO cantons  VALUES (10, 'Fribourg');
INSERT INTO cantons  VALUES (11, 'Solothurn');
INSERT INTO cantons  VALUES (12, 'Basel-Stadt');
INSERT INTO cantons  VALUES (13, 'Basel-Landschaft');
INSERT INTO cantons  VALUES (14, 'Schaffhausen');
INSERT INTO cantons  VALUES (15, 'Appenzell Innerrhoden');
INSERT INTO cantons  VALUES (16, 'Appenzell Ausserrhoden');
INSERT INTO cantons  VALUES (17, 'St. Gallen');
INSERT INTO cantons  VALUES (18, 'Grisons');
INSERT INTO cantons  VALUES (19, 'Aargau');
INSERT INTO cantons  VALUES (20, 'Thurgau');
INSERT INTO cantons  VALUES (21, 'Ticino');
INSERT INTO cantons  VALUES (22, 'Vaud');
INSERT INTO cantons  VALUES (23, 'Valais');
INSERT INTO cantons  VALUES (24, 'Neuchâtel');
INSERT INTO cantons  VALUES (25, 'Geneva');
INSERT INTO cantons  VALUES (26, 'Jura');

INSERT INTO STATIONS VALUES (1, 'Zürich Hauptbahnhof', 1, 1);
INSERT INTO STATIONS VALUES (2, 'Bern', 1, 2);
INSERT INTO STATIONS VALUES (3, 'Basel SBB', 1, 12);
INSERT INTO STATIONS VALUES (4, 'Lausanne', 1, 22);
INSERT INTO STATIONS VALUES (5, 'Winterthur', 1, 1);
INSERT INTO STATIONS VALUES (6, 'Lucerne', 1, 3);
INSERT INTO STATIONS VALUES (7, 'Zürich Oerlikon', 1, 1);
INSERT INTO STATIONS VALUES (8, 'Zürich Stadelhofen', 1, 1);
INSERT INTO STATIONS VALUES (9, 'Geneva', 1, 25);
INSERT INTO STATIONS VALUES (10, 'Zürich Hardbrücke', 1, 1);
INSERT INTO STATIONS VALUES (11, 'St. Gallen', 1, 17);
INSERT INTO STATIONS VALUES (12, 'Zürich Airport', 1, 1);
INSERT INTO STATIONS VALUES (13, 'Biel/Bienne', 1, 2);
INSERT INTO STATIONS VALUES (14, 'Zug', 1, 9);
INSERT INTO STATIONS VALUES (15, 'Baden', 1, 19);
INSERT INTO STATIONS VALUES (16, 'Zürich Altstetten', 1, 1);
INSERT INTO STATIONS VALUES (17, 'Thun', 1, 2);
INSERT INTO STATIONS VALUES (18, 'Neuchâtel', 1, 24);
INSERT INTO STATIONS VALUES (19, 'Chur', 1, 18);
INSERT INTO STATIONS VALUES (20, 'Uster', 1, 1);
INSERT INTO STATIONS VALUES (21, 'Rapperswil', 1, 17);
INSERT INTO STATIONS VALUES (22, 'Fribourg', 1, 10);
INSERT INTO STATIONS VALUES (23, 'Brugg', 1, 19);
INSERT INTO STATIONS VALUES (24, 'Vevey', 1, 22);
INSERT INTO STATIONS VALUES (25, 'Stettbach', 1, 1);
INSERT INTO STATIONS VALUES (26, 'Dietikon', 1, 1);
INSERT INTO STATIONS VALUES (27, 'Visp', 1, 23);
INSERT INTO STATIONS VALUES (28, 'Renens CFF', 1, 22);
INSERT INTO STATIONS VALUES (29, 'Thalwil', 1, 1);
INSERT INTO STATIONS VALUES (30, 'Schaffhausen', 1, 14);
INSERT INTO STATIONS VALUES (31, 'Bülach', 1, 1);
INSERT INTO STATIONS VALUES (32, 'Nyon', 1, 22);
INSERT INTO STATIONS VALUES (33, 'Effretikon', 1, 1);
INSERT INTO STATIONS VALUES (34, 'Liestal', 1, 13);
INSERT INTO STATIONS VALUES (35, 'Brig', 1, 23);
INSERT INTO STATIONS VALUES (36, 'Montreux', 1, 22);
INSERT INTO STATIONS VALUES (37, 'Morges', 1, 22);
INSERT INTO STATIONS VALUES (38, 'Solothurn', 1, 11);
INSERT INTO STATIONS VALUES (39, 'Burgdorf', 1, 2);
INSERT INTO STATIONS VALUES (40, 'Lugano', 1, 21);
INSERT INTO STATIONS VALUES (41, 'Geneva Airport', 1, 25);
INSERT INTO STATIONS VALUES (42, 'Bellinzona', 1, 21);


INSERT INTO TRAINS VALUES (1, "Bern Express", TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, 10);
INSERT INTO TRAINS VALUES (2, 'Zurich Express', 1, 0, 1, 0, 1, 0, 1, 10);

INSERT INTO TIMETABLE VALUES (1, 1, 1, NULL, 060000);
INSERT INTO TIMETABLE VALUES (2, 2, 2, NULL, 070000);
INSERT INTO TIMETABLE VALUES (3, 1, 5, 080000, NULL);
INSERT INTO TIMETABLE VALUES (4, 1, 2, 073000, 073200);

INSERT INTO RAILROAD_HAULS VALUES (1, 1, 2, 35.5);
INSERT INTO RAILROAD_HAULS VALUES (2, 2, 5, 40.1);

INSERT INTO ROLE  VALUES (1, 'ROLE_ADMIN');
INSERT INTO ROLE  VALUES (2, 'ROLE_MANAGER');
INSERT INTO ROLE  VALUES (3, 'ROLE_CLIENT');
INSERT INTO ROLE  VALUES (4, 'ROLE_ANONYM');


INSERT INTO USERS VALUES (1, 'Vitali', 'Skachkov', '1986-10-20', 'vitali.skachkov@gmail.com', 'belrafter', '0000', NULL, 1);





