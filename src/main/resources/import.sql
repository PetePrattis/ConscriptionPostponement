INSERT INTO CITIZEN (email, firstname, lastname, password) VALUES ('stav@mail.com', 'Stavroula', 'Pratti', '$2a$12$EQMflPZ9.VN3cwgOerl0fuvFbKrhG9IjJn84bql0xCn2gTldRUS2q');

INSERT INTO OFFICE_WORKER (email, firstname, lastname, password) VALUES ('admin@mail.com', 'Mike', 'Blue', '$2a$12$kcghTzNzJ2jEu9TJIOH.7..l.ptIA1ZhtohOjZjr0tlp9RcjejGwG');

INSERT INTO ARMY_OFFICER (email, firstname, lastname, password) VALUES ('general@mail.com', 'Adam', 'Black', '$2a$12$jve0NdXdA36ZQT30ZkhamO96o/1xeILzdJrrw8U19bMeqKHXxW.LG');

INSERT INTO APPLICATION (document, birthday, citizen_id, office_worker_id, army_officer_id, validated, approved) VALUES ('document 1', '1/1/2000', 1, 1, 1, 0, 0);
INSERT INTO APPLICATION (document, birthday, citizen_id, office_worker_id, army_officer_id, validated, approved) VALUES ('document 2', '1/1/2001', 1, 1, 1, 1, -1);
