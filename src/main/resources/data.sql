-- Dodawanie adresów
INSERT INTO ADDRESS (id, address_line1, address_line2, city, postal_code)
VALUES 
    (1, 'ul. Kwiatowa 1', 'apt. 5', 'Warszawa', '62-030'),
    (2, 'ul. Słoneczna 10', NULL, 'Kraków', '30-002'),
    (3, 'ul. Leśna 7', NULL, 'Gdańsk', '80-003'),
    (4, 'ul. Morska 15', NULL, 'Gdynia', '81-123'),
    (5, 'ul. Parkowa 20', NULL, 'Poznań', '61-456'),
    (6, 'ul. Polna 25', 'apt. 3', 'Wrocław', '50-678'),
    (7, 'ul. Ogrodowa 30', NULL, 'Katowice', '40-901'),
    (8, 'ul. Jesienna 35', NULL, 'Łódź', '90-234'),
    (9, 'ul. Kwiatowa 40', NULL, 'Szczecin', '70-555'),
    (10, 'ul. Słonecznikowa 45', NULL, 'Gdynia', '81-789'),
    (11, 'ul. Brzozowa 50', 'apt. 2', 'Poznań', '61-012'),
    (12, 'ul. Wiosenna 55', NULL, 'Warszawa', '01-345'),
    (13, 'ul. Leśniczówka 60', NULL, 'Kraków', '30-678'),
    (14, 'ul. Górnicza 65', NULL, 'Gdańsk', '80-901'),
    (15, 'ul. Plażowa 70', NULL, 'Szczecin', '70-234'),
    (16, 'ul. Wodna 75', 'apt. 1', 'Katowice', '40-567'),
    (17, 'ul. Stokrotkowa 80', NULL, 'Łódź', '90-890'),
    (18, 'ul. Miodowa 85', NULL, 'Wrocław', '50-123'),
    (19, 'ul. Topolowa 90', NULL, 'Poznań', '61-456'),
    (20, 'ul. Brzegowa 95', NULL, 'Gdynia', '81-789');

-- Dodawanie lekarzy
INSERT INTO DOCTOR (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
VALUES
    (1, 'Jan', 'Kowalski', '123456789', 'jan.kowalski@example.com', 'D123', 'GP'),
    (2, 'Anna', 'Nowak', '987654321', 'anna.nowak@example.com', 'A456', 'DERMATOLOGIST'),
    (3, 'Mateusz', 'Nowakowski', '111111111', 'mateusz.nowakowski@example.com', 'M789', 'SURGEON'),
    (4, 'Katarzyna', 'Wójcik', '222222222', 'katarzyna.wojcik@example.com', 'K012', 'GP'),
    (5, 'Michał', 'Kowalczyk', '333333333', 'michal.kowalczyk@example.com', 'M345', 'DERMATOLOGIST'),
    (6, 'Karolina', 'Lis', '444444444', 'karolina.lis@example.com', 'K678', 'OCULIST'),
    (7, 'Piotr', 'Zając', '555555555', 'piotr.zajac@example.com', 'P901', 'SURGEON'),
    (8, 'Anna', 'Kowal', '666666666', 'anna.kowal@example.com', 'A234', 'GP'),
    (9, 'Tomasz', 'Krawczyk', '777777777', 'tomasz.krawczyk@example.com', 'T567', 'DERMATOLOGIST'),
    (10, 'Aleksandra', 'Mazurek', '888888888', 'aleksandra.mazurek@example.com', 'A890', 'OCULIST'),
    (11, 'Marek', 'Piotrowski', '999999999', 'marek.piotrowski@example.com', 'M111', 'SURGEON'),
    (12, 'Kamila', 'Witkowska', '123456789', 'kamila.witkowska@example.com', 'K222', 'GP'),
    (13, 'Rafał', 'Kaczmarek', '987654321', 'rafal.kaczmarek@example.com', 'R333', 'DERMATOLOGIST'),
    (14, 'Martyna', 'Wójcik', '555444333', 'martyna.wojcik@example.com', 'M444', 'OCULIST'),
    (15, 'Jakub', 'Nowicki', '111222333', 'jakub.nowicki@example.com', 'J555', 'SURGEON'),
    (16, 'Natalia', 'Duda', '444333222', 'natalia.duda@example.com', 'N666', 'GP'),
    (17, 'Paweł', 'Lewandowski', '777888999', 'pawel.lewandowski@example.com', 'P777', 'DERMATOLOGIST'),
    (18, 'Monika', 'Kowal', '123123123', 'monika.kowal@example.com', 'M888', 'OCULIST'),
    (19, 'Adam', 'Wojciechowski', '456456456', 'adam.wojciechowski@example.com', 'A999', 'SURGEON'),
    (20, 'Julia', 'Zając', '789789789', 'julia.zajac@example.com', 'J000', 'GP');

-- Dodawanie pacjentów
INSERT INTO PATIENT (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, has_insurance)
VALUES
    (1, 'Piotr', 'Wisniewski', '111222333', 'piotr.wisniewski@example.com', 'P123', '1985-05-10', true),
    (2, 'Alicja', 'Dabrowska', '444555666', 'alicja.dabrowska@example.com', 'A456', '1990-12-15', false),
    (3, 'Katarzyna', 'Kowalczyk', '777888999', 'katarzyna.kowalczyk@example.com', 'K789', '1976-03-25', true),
    (4, 'Robert', 'Lis', '333222111', 'robert.lis@example.com', 'R012', '1980-09-30', false),
    (5, 'Magdalena', 'Wójcik', '999888777', 'magdalena.wojcik@example.com', 'M345', '1995-07-12', true),
    (6, 'Paweł', 'Krawczyk', '555444333', 'pawel.krawczyk@example.com', 'P678', '1982-11-05', false),
    (7, 'Monika', 'Zając', '333555777', 'monika.zajac@example.com', 'M901', '1987-04-15', true),
    (8, 'Jakub', 'Nowak', '222333444', 'jakub.nowak@example.com', 'J234', '1992-01-20', false),
    (9, 'Anna', 'Witkowska', '444555666', 'anna.witkowska@example.com', 'A567', '1988-06-22', true),
    (10, 'Piotr', 'Mazurek', '777888999', 'piotr.mazurek@example.com', 'P890', '1997-08-18', false),
    (11, 'Karolina', 'Piotrowska', '111222333', 'karolina.piotrowska@example.com', 'K111', '1984-10-30', true),
    (12, 'Michał', 'Wójcik', '999888777', 'michal.wojcik@example.com', 'M222', '1979-02-12', false),
    (13, 'Natalia', 'Kaczmarek', '555666777', 'natalia.kaczmarek@example.com', 'N333', '1986-07-05', true),
    (14, 'Kamil', 'Zając', '777666555', 'kamil.zajac@example.com', 'K444', '1990-09-28', false),
    (15, 'Monika', 'Witkowska', '222333444', 'monika.witkowska@example.com', 'M555', '1983-12-15', true),
    (16, 'Tomasz', 'Lewandowski', '444555666', 'tomasz.lewandowski@example.com', 'T666', '1981-05-20', false),
    (17, 'Magdalena', 'Kowal', '777666555', 'magdalena.kowal@example.com', 'M777', '1994-11-10', true),
    (18, 'Kamil', 'Wójcik', '111222333', 'kamil.wojcik@example.com', 'K888', '1977-09-18', false),
    (19, 'Aleksandra', 'Duda', '444555666', 'aleksandra.duda@example.com', 'A999', '1980-04-25', true),
    (20, 'Mariusz', 'Zając', '777888999', 'mariusz.zajac@example.com', 'M000', '1993-03-08', false);

-- Dodawanie wizyt
-- Wizyty dla pacjenta 1
INSERT INTO VISIT (id, description, time, PATIENT_ID, DOCTOR_ID)
VALUES
    (1, 'Badanie kontrolne', '2024-03-14 10:00:00', 1, 1),
    (3, 'Badanie USG jamy brzusznej', '2024-03-16 09:00:00', 1, 2),
    (5, 'Badanie USG serca', '2024-03-18 11:00:00', 1, 1),
    (7, 'RTG klatki piersiowej', '2024-03-20 13:30:00', 1, 2),
    (9, 'Badanie EKG', '2024-03-22 15:45:00', 1, 3);

-- Wizyty dla pacjenta 2
INSERT INTO VISIT (id, description, time, PATIENT_ID, DOCTOR_ID)
VALUES
    (2, 'Szczepienie', '2024-03-15 14:30:00', 2, 2),
    (4, 'Badanie EKG z wysiłkiem', '2024-03-17 08:30:00', 2, 3),
    (6, 'Badanie USG tarczycy', '2024-03-19 10:45:00', 2, 2),
    (8, 'RTG zęba', '2024-03-21 12:15:00', 2, 3),
    (10, 'Badanie EKG 24-godzinne', '2024-03-23 16:00:00', 2, 1);

-- Wizyty dla pacjenta 1 (kontynuacja)
INSERT INTO VISIT (id, description, time, PATIENT_ID, DOCTOR_ID)
VALUES
    (11, 'Wizyta kontrolna', '2024-03-25 09:30:00', 1, 1),
    (13, 'Badanie USG nerek', '2024-03-27 11:15:00', 1, 2),
    (15, 'Badanie EKG z wysiłkiem', '2024-03-29 14:00:00', 1, 3),
    (17, 'Badanie krwi', '2024-03-31 16:45:00', 1, 1),
    (19, 'Badanie USG stawów', '2024-04-02 10:30:00', 1, 2);

-- Wizyty dla pacjenta 2 (kontynuacja)
INSERT INTO VISIT (id, description, time, PATIENT_ID, DOCTOR_ID)
VALUES
    (12, 'Badanie EKG', '2024-03-26 08:00:00', 2, 3),
    (14, 'Badanie USG tarczycy', '2024-03-28 10:00:00', 2, 2),
    (16, 'RTG klatki piersiowej', '2024-03-30 12:30:00', 2, 3),
    (18, 'Badanie kontrolne', '2024-04-01 15:00:00', 2, 1),
    (20, 'Szczepienie przeciw grypie', '2024-04-03 17:15:00', 2, 2);


-- Dodawanie leczenia medycznego
INSERT INTO MEDICAL_TREATMENT (id, description, type, VISIT_ID)
VALUES
    (1, 'Badanie krwi', 'DIAGNOSTIC', 1),
    (2, 'Szczepienie przeciw grypie', 'PREVENTIVE', 2),
    (3, 'Badanie USG jamy brzusznej', 'USG', 3),
    (4, 'Badanie EKG', 'EKG', 4),
    (5, 'RTG klatki piersiowej', 'RTG', 5),
    (6, 'Badanie USG tarczycy', 'USG', 6),
    (7, 'Badanie EKG z wysiłkiem', 'EKG', 7),
    (8, 'RTG zęba', 'RTG', 8),
    (9, 'Badanie USG serca', 'USG', 9),
    (10, 'Badanie EKG 24-godzinne', 'EKG', 10),
    (11, 'RTG kręgosłupa', 'RTG', 11),
    (12, 'Badanie USG nerek', 'USG', 12),
    (13, 'Badanie EKG dla dziecka', 'EKG', 13),
    (14, 'RTG stawu kolanowego', 'RTG', 14),
    (15, 'Badanie USG miednicy', 'USG', 15),
    (16, 'Badanie EKG z teletransmisją', 'EKG', 16),
    (17, 'RTG kości ręki', 'RTG', 17),
    (18, 'Badanie USG stawu barkowego', 'USG', 18),
    (19, 'Badanie EKG z defibrylacją', 'EKG', 19),
    (20, 'RTG kręgosłupa szyjnego', 'RTG', 20);