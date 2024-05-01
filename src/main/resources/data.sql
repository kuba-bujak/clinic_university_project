-- Dodawanie adresów
INSERT INTO ADDRESS (id, address_line1, address_line2, city, postal_code)
VALUES 
    (1, 'ul. Kwiatowa 1', 'apt. 5', 'Warszawa', '62-030'),
    (2, 'ul. Słoneczna 10', NULL, 'Kraków', '30-002'),
    (3, 'ul. Leśna 7', NULL, 'Gdańsk', '80-003');

-- Dodawanie lekarzy
INSERT INTO DOCTOR (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
VALUES
    (1, 'Jan', 'Kowalski', '123456789', 'jan.kowalski@example.com', 'D123', 'GP'),
    (2, 'Anna', 'Nowak', '987654321', 'anna.nowak@example.com', 'A456', 'DERMATOLOGIST');

-- Dodawanie pacjentów
INSERT INTO PATIENT (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, has_insurance)
VALUES
    (1, 'Piotr', 'Wiśniewski', '111222333', 'piotr.wisniewski@example.com', 'P123', '1985-05-10', true),
    (2, 'Alicja', 'Dąbrowska', '444555666', 'alicja.dabrowska@example.com', 'A456', '1990-12-15', false);

-- Dodawanie wizyt
INSERT INTO VISIT (id, description, time, PATIENT_ID, DOCTOR_ID)
VALUES
    (1, 'Badanie kontrolne', '2024-03-14 10:00:00', 1, 1),
    (2, 'Szczepienie', '2024-03-15 14:30:00', 2, 2);

-- Dodawanie leczenia medycznego
INSERT INTO MEDICAL_TREATMENT (id, description, type, VISIT_ID)
VALUES
    (1, 'Badanie krwi', 'DIAGNOSTIC', 1),
    (2, 'Szczepienie przeciw grypie', 'PREVENTIVE', 2);