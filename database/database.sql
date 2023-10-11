
CREATE TABLE LOG (
    ID SERIAL NOT NULL ,
    LOG_DATE timestamp DEFAULT CURRENT_TIMESTAMP,
    LOG_MESSAGE VARCHAR(255),
    LOG_KEY VARCHAR(255),
    LOG_LEVEL VARCHAR(10),
    PRIMARY KEY (ID)
);

INSERT INTO LOG (LOG_DATE, LOG_MESSAGE, LOG_KEY, LOG_LEVEL)
VALUES
    ('2023-10-07 10:15:00', 'User logged in', 'user123', 'INFO'),
    ('2023-10-07 11:30:45', 'Error in database connection', 'app456', 'ERROR'),
    ('2023-10-07 12:45:30', 'Data imported successfully', 'import789', 'INFO'),
    ('2023-10-07 14:20:15', 'Invalid input received', 'app123', 'WARN'),
    ('2023-10-08 08:00:00', 'System started', 'system', 'INFO'),
    ('2023-10-08 09:30:20', 'File not found', 'app789', 'ERROR'),
    ('2023-10-08 10:45:10', 'User registered', 'user456', 'INFO'),
    ('2023-10-08 14:15:45', 'Configuration updated', 'app123', 'INFO'),
    ('2023-10-09 12:30:00', 'Database backup completed', 'backup', 'INFO'),
    ('2023-10-09 13:45:30', 'Security breach detected', 'app789', 'ERROR'),
    ('2023-10-10 09:15:00', 'Payment received', 'payment123', 'INFO'),
    ('2023-10-10 10:30:20', 'Out of memory', 'app456', 'ERROR'),
    ('2023-10-10 12:00:15', 'User session expired', 'user123', 'WARN'),
    ('2023-10-11 08:30:00', 'Server restart initiated', 'server', 'INFO'),
    ('2023-10-11 09:45:45', 'File uploaded successfully', 'upload789', 'INFO'),
    ('2023-10-11 11:15:30', 'Invalid API request', 'api456', 'ERROR'),
    ('2023-10-12 10:00:00', 'Password changed', 'user123', 'INFO'),
    ('2023-10-12 11:30:20', 'Database connection restored', 'app456', 'INFO'),
    ('2023-10-12 13:00:45', 'Failed login attempt', 'user789', 'ERROR'),
    ('2023-10-12 14:45:15', 'Application shutdown', 'app123', 'INFO');
-- Inserting sample data into the LOG table


--WORK TIME TABLES


CREATE TABLE CLIENT (
    ID SERIAL NOT NULL ,
    CODE  VARCHAR(255),
    NOM VARCHAR(255),
    PRENOM VARCHAR(255),
    ADRESSE VARCHAR(255),
    EMAIL VARCHAR(255),
    TELEPHONE VARCHAR(255),
    PROFILE_IMAGE VARCHAR(255),
    PASSWORD VARCHAR(255),
    PRIMARY KEY (ID)
);


DROP TABLE IF EXISTS RESERVATION;
CREATE TABLE RESERVATION (
    ID SERIAL NOT NULL ,
    CODE VARCHAR(255) UNIQUE NOT NULL,
    PRICE_TOTAL VARCHAR(255),
    DATE_RESERVATION VARCHAR(255),
    CLIENT_ID INT NOT NULL,
    DATE_DEPART VARCHAR(255),
    NUMBER_DE_ADULETS INT,
    NUMBER_DE_ENFANTS INT,
    NUMBER_DE_BEBES INT,
    LHEURE_DEPART VARCHAR(255),
    LHEURE_ARRIVEE VARCHAR(255),
    DATE_ARRIVEE VARCHAR(255),
    VILLE_DEPART VARCHAR(255),
    VILLE_ARRIVEE VARCHAR(255),
    STATUS varchar(255),
    cancelled BOOLEAN,
    CONSTRAINT FK_CLIENT FOREIGN KEY (CLIENT_ID) REFERENCES CLIENT(ID)

);


-- Insert 100 rows into the RESERVATION table
INSERT INTO RESERVATION (CODE, PRICE_TOTAL, DATE_RESERVATION, CLIENT_ID, DATE_DEPART, NUMBER_DE_ADULETS, NUMBER_DE_ENFANTS, NUMBER_DE_BEBES, LHEURE_DEPART, LHEURE_ARRIVEE, DATE_ARRIVEE, VILLE_DEPART, VILLE_ARRIVEE, STATUS, cancelled)
VALUES
    ('ABC123', '500.00', '2023-10-15', 1, '2023-11-01', 2, 1, 0, '08:00 AM', '12:00 PM', '2023-11-01', 'New York', 'Los Angeles', 'Confirmed', FALSE),
    ('DEF456', '350.00', '2023-09-20', 1, '2023-10-10', 1, 2, 1, '09:30 AM', '01:30 PM', '2023-10-10', 'Chicago', 'Miami', 'Confirmed', FALSE),
    ('GHI789', '800.00', '2023-08-05', 1, '2023-09-15', 3, 0, 2, '10:15 AM', '02:30 PM', '2023-09-15', 'San Francisco', 'Seattle', 'Cancelled', TRUE),
    ('JKL101', '400.00', '2023-11-02', 1, '2023-11-20', 2, 0, 0, '10:00 AM', '02:00 PM', '2023-11-20', 'Boston', 'Washington D.C.', 'Confirmed', FALSE),
    ('MNO202', '550.00', '2023-09-12', 1, '2023-09-28', 1, 1, 0, '11:30 AM', '03:30 PM', '2023-09-28', 'Dallas', 'Phoenix', 'Confirmed', FALSE),
    ('PQR303', '700.00', '2023-08-25', 1, '2023-09-10', 2, 2, 1, '09:15 AM', '01:30 PM', '2023-09-10', 'Denver', 'Las Vegas', 'Cancelled', TRUE),
    ('STU404', '300.00', '2023-07-15', 1, '2023-08-01', 3, 0, 0, '08:30 AM', '12:45 PM', '2023-08-01', 'Seattle', 'San Francisco', 'Confirmed', FALSE),
    ('VWX505', '450.00', '2023-10-05', 1, '2023-10-25', 1, 0, 1, '12:45 PM', '05:00 PM', '2023-10-25', 'Los Angeles', 'New York', 'Pending', FALSE),
    ('YZA606', '600.00', '2023-12-05', 1, '2023-12-20', 2, 0, 0, '10:30 AM', '03:00 PM', '2023-12-20', 'Miami', 'Chicago', 'Confirmed', FALSE),
    ('ABB707', '750.00', '2023-11-18', 1, '2023-12-05', 2, 1, 0, '09:00 AM', '01:15 PM', '2023-12-05', 'Washington D.C.', 'Boston', 'Pending', FALSE),
    ('CCD808', '500.00', '2023-10-28', 1, '2023-11-15', 3, 0, 2, '08:15 AM', '12:30 PM', '2023-11-15', 'Phoenix', 'Dallas', 'Confirmed', FALSE),
    ('DDE909', '350.00', '2023-09-08', 1, '2023-09-25', 1, 0, 0, '11:00 AM', '03:00 PM', '2023-09-25', 'Las Vegas', 'Denver', 'Confirmed', FALSE),
    ('EEF113', '400.00', '2023-12-01', 1, '2023-12-20', 2, 0, 0, '10:15 AM', '02:30 PM', '2023-12-20', 'San Francisco', 'Seattle', 'Pending', FALSE),
    ('FFG114', '650.00', '2023-11-10', 1, '2023-11-25', 3, 1, 0, '09:45 AM', '02:00 PM', '2023-11-25', 'Boston', 'Washington D.C.', 'Confirmed', FALSE),
    ('GGH115', '550.00', '2023-10-12', 1, '2023-10-30', 2, 0, 1, '11:30 AM', '04:15 PM', '2023-10-30', 'Dallas', 'Phoenix', 'Confirmed', FALSE),
    ('HHI116', '750.00', '2023-08-18', 1, '2023-09-05', 3, 2, 0, '08:00 AM', '01:00 PM', '2023-09-05', 'Denver', 'Las Vegas', 'Cancelled', TRUE),
    ('IIJ117', '350.00', '2023-09-05', 1, '2023-09-20', 1, 0, 0, '10:30 AM', '02:45 PM', '2023-09-20', 'Seattle', 'San Francisco', 'Confirmed', FALSE),
    ('JJK118', '400.00', '2023-11-15', 1, '2023-11-30', 2, 1, 0, '09:15 AM', '01:30 PM', '2023-11-30', 'Miami', 'Chicago', 'Confirmed', FALSE),
    ('KKL119', '700.00', '2023-10-22', 1, '2023-11-10', 3, 0, 1, '11:45 AM', '04:00 PM', '2023-11-10', 'Washington D.C.', 'Boston', 'Pending', FALSE),
    ('LLM120', '500.00', '2023-08-30', 1, '2023-09-15', 2, 1, 0, '09:30 AM', '01:45 PM', '2023-09-15', 'Phoenix', 'Dallas', 'Confirmed', FALSE),
    ('MMN121', '300.00', '2023-12-10', 1, '2023-12-25', 1, 0, 0, '10:00 AM', '02:15 PM', '2023-12-25', 'Las Vegas', 'Denver', 'Confirmed', FALSE),
    ('NNO122', '450.00', '2023-11-25', 1, '2023-12-10', 2, 0, 0, '09:30 AM', '01:30 PM', '2023-12-10', 'New York', 'Los Angeles', 'Pending', FALSE),
    ('OOP123', '600.00', '2023-09-28', 1, '2023-10-15', 2, 0, 1, '08:15 AM', '12:45 PM', '2023-10-15', 'Chicago', 'Miami', 'Confirmed', FALSE),
    ('PPQ124', '750.00', '2023-08-15', 1, '2023-08-30', 3, 2, 0, '12:00 PM', '04:30 PM', '2023-08-30', 'San Francisco', 'Seattle', 'Confirmed', FALSE),
    ('QQQ125', '400.00', '2023-11-05', 1, '2023-11-22', 1, 0, 0, '10:45 AM', '03:00 PM', '2023-11-22', 'Los Angeles', 'New York', 'Pending', FALSE),
    ('RRR126', '500.00', '2023-10-08', 1, '2023-10-25', 2, 1, 0, '09:00 AM', '01:15 PM', '2023-10-25', 'Boston', 'Washington D.C.', 'Confirmed', FALSE),
    ('SSS127', '350.00', '2023-09-12', 1, '2023-09-30', 1, 0, 0, '11:15 AM', '03:45 PM', '2023-09-30', 'Dallas', 'Phoenix', 'Confirmed', FALSE),
    ('TTT128', '650.00', '2023-12-22', 1, '2023-12-28', 3, 1, 0, '09:30 AM', '02:15 PM', '2023-12-28', 'Denver', 'Las Vegas', 'Pending', FALSE),
    ('UUU129', '600.00', '2023-08-05', 1, '2023-08-22', 2, 1, 1, '10:00 AM', '03:30 PM', '2023-08-22', 'Seattle', 'San Francisco', 'Confirmed', FALSE),
    ('VVV130', '700.00', '2023-11-30', 1, '2023-12-15', 2, 0, 0, '11:30 AM', '04:00 PM', '2023-12-15', 'Miami', 'Chicago', 'Confirmed', FALSE),
    ('WWW131', '300.00', '2023-10-18', 1, '2023-11-05', 1, 0, 0, '08:45 AM', '01:00 PM', '2023-11-05', 'Washington D.C.', 'Boston', 'Cancelled', TRUE),
    ('XXX132', '450.00', '2023-09-15', 1, '2023-09-30', 3, 2, 1, '09:15 AM', '02:45 PM', '2023-09-30', 'Phoenix', 'Dallas', 'Confirmed', FALSE),
    ('YYY133', '750.00', '2023-12-10', 1, '2023-12-25', 2, 1, 0, '10:30 AM', '03:30 PM', '2023-12-25', 'Las Vegas', 'Denver', 'Confirmed', FALSE),
    ('ZZZ134', '550.00', '2023-08-28', 1, '2023-09-15', 2, 0, 0, '11:00 AM', '03:15 PM', '2023-09-15', 'New York', 'Los Angeles', 'Pending', FALSE),
    ('AAA135', '400.00', '2023-11-20', 1, '2023-12-10', 1, 0, 0, '09:30 AM', '01:45 PM', '2023-12-10', 'Chicago', 'Miami', 'Confirmed', FALSE),
    ('BBB136', '600.00', '2023-10-02', 1, '2023-10-20', 2, 0, 1, '08:30 AM', '12:30 PM', '2023-10-20', 'Boston', 'Washington D.C.', 'Confirmed', FALSE),
    ('CCC137', '500.00', '2023-09-18', 1, '2023-10-05', 3, 1, 0, '11:15 AM', '03:00 PM', '2023-10-05', 'Dallas', 'Phoenix', 'Pending', FALSE),
    ('DDD138', '350.00', '2023-11-01', 1, '2023-11-18', 1, 0, 0, '10:45 AM', '02:00 PM', '2023-11-18', 'Denver', 'Las Vegas', 'Confirmed', FALSE),
    ('EEE139', '750.00', '2023-10-10', 1, '2023-10-25', 2, 1, 1, '09:00 AM', '01:15 PM', '2023-10-25', 'Seattle', 'San Francisco', 'Confirmed', FALSE),
    ('FFF140', '400.00', '2023-08-15', 1, '2023-08-30', 1, 0, 0, '08:30 AM', '12:45 PM', '2023-08-30', 'Los Angeles', 'New York', 'Pending', FALSE),
    ('GGG141', '450.00', '2023-12-05', 1, '2023-12-20', 2, 0, 0, '10:15 AM', '02:45 PM', '2023-12-20', 'Miami', 'Chicago', 'Confirmed', FALSE),
    ('HHH142', '550.00', '2023-11-18', 1, '2023-12-05', 3, 0, 1, '12:00 PM', '04:00 PM', '2023-12-05', 'Washington D.C.', 'Boston', 'Confirmed', FALSE),
    ('III143', '600.00', '2023-09-25', 1, '2023-10-12', 1, 0, 0, '09:30 AM', '01:45 PM', '2023-10-12', 'Phoenix', 'Dallas', 'Pending', FALSE),
    ('JJJ144', '350.00', '2023-08-28', 1, '2023-09-15', 2, 1, 0, '10:45 AM', '02:30 PM', '2023-09-15', 'Denver', 'Las Vegas', 'Confirmed', FALSE),
    ('KKK145', '700.00', '2023-12-02', 1, '2023-12-15', 3, 0, 0, '08:15 AM', '12:45 PM', '2023-12-15', 'New York', 'Los Angeles', 'Confirmed', FALSE),
    ('LLL146', '750.00', '2023-11-10', 1, '2023-11-25', 2, 0, 0, '09:30 AM', '01:30 PM', '2023-11-25', 'Chicago', 'Miami', 'Pending', FALSE),
    ('MMM147', '400.00', '2023-10-08', 1, '2023-10-25', 1, 1, 0, '12:00 PM', '04:15 PM', '2023-10-25', 'Boston', 'Washington D.C.', 'Confirmed', FALSE),
    ('NNN148', '300.00', '2023-09-18', 1, '2023-09-30', 1, 0, 0, '08:45 AM', '01:15 PM', '2023-09-30', 'Dallas', 'Phoenix', 'Confirmed', FALSE),
    ('OOO149', '600.00', '2023-11-20', 1, '2023-12-05', 2, 0, 0, '11:15 AM', '03:30 PM', '2023-12-05', 'Denver', 'Las Vegas', 'Pending', FALSE),
    ('PPP150', '500.00', '2023-10-28', 1, '2023-11-15', 3, 1, 1, '10:30 AM', '03:00 PM', '2023-11-15', 'Seattle', 'San Francisco', 'Confirmed', FALSE),
    ('QQQ151', '450.00', '2023-08-18', 1, '2023-08-30', 2, 0, 0, '09:00 AM', '01:00 PM', '2023-08-30', 'Miami', 'Chicago', 'Confirmed', FALSE),
    ('RRR152', '700.00', '2023-12-15', 1, '2023-12-28', 3, 1, 0, '08:30 AM', '01:30 PM', '2023-12-28', 'Washington D.C.', 'Boston', 'Pending', FALSE),
    ('SSS153', '550.00', '2023-11-25', 1, '2023-12-10', 2, 0, 0, '11:30 AM', '04:00 PM', '2023-12-10', 'Phoenix', 'Dallas', 'Confirmed', FALSE),
    ('TTT154', '350.00', '2023-10-10', 1, '2023-10-25', 1, 0, 0, '10:00 AM', '02:15 PM', '2023-10-25', 'Las Vegas', 'Denver', 'Confirmed', FALSE),
    ('UUU155', '750.00', '2023-09-12', 1, '2023-09-28', 3, 1, 0, '09:15 AM', '01:45 PM', '2023-09-28', 'New York', 'Los Angeles', 'Confirmed', FALSE),
    ('YYY157', '550.00', '2022-12-01', 1, '2022-12-20', 2, 0, 0, '10:15 AM', '02:30 PM', '2022-12-20', 'San Francisco', 'Seattle', 'Confirmed', FALSE),
    ('ZZZ158', '650.00', '2022-11-02', 1, '2022-11-20', 3, 1, 0, '09:45 AM', '02:00 PM', '2022-11-20', 'Boston', 'Washington D.C.', 'Confirmed', FALSE),
    ('AAA159', '550.00', '2022-10-15', 1, '2022-10-30', 2, 0, 1, '11:30 AM', '04:15 PM', '2022-10-30', 'Dallas', 'Phoenix', 'Pending', FALSE),
    ('BBB160', '700.00', '2022-09-18', 1, '2022-10-05', 3, 2, 0, '08:00 AM', '01:00 PM', '2022-10-05', 'Denver', 'Las Vegas', 'Cancelled', TRUE),
    ('CCC161', '350.00', '2022-08-25', 1, '2022-09-10', 1, 0, 0, '10:30 AM', '02:45 PM', '2022-09-10', 'Seattle', 'San Francisco', 'Confirmed', FALSE),
    ('DDD162', '400.00', '2022-07-15', 1, '2022-08-01', 3, 1, 0, '08:45 AM', '01:30 PM', '2022-08-01', 'Los Angeles', 'New York', 'Pending', FALSE),
    ('EEE163', '700.00', '2022-06-20', 1, '2022-07-05', 2, 0, 0, '09:15 AM', '01:00 PM', '2022-07-05', 'Chicago', 'Miami', 'Confirmed', FALSE),
    ('FFF164', '400.00', '2022-05-18', 1, '2022-06-02', 1, 0, 0, '10:00 AM', '02:15 PM', '2022-06-02', 'Washington D.C.', 'Boston', 'Confirmed', FALSE),
    ('GGG165', '450.00', '2022-04-22', 1, '2022-05-10', 2, 1, 0, '09:30 AM', '01:45 PM', '2022-05-10', 'Phoenix', 'Dallas', 'Pending', FALSE),
    ('HHH166', '350.00', '2022-03-25', 1, '2022-04-10', 1, 0, 0, '11:15 AM', '03:45 PM', '2022-04-10', 'Denver', 'Las Vegas', 'Confirmed', FALSE),
    ('III167', '600.00', '2022-02-12', 1, '2022-02-28', 2, 0, 0, '09:30 AM', '01:30 PM', '2022-02-28', 'New York', 'Los Angeles', 'Confirmed', FALSE),
    ('JJJ168', '750.00', '2022-01-15', 1, '2022-01-30', 3, 0, 1, '10:45 AM', '04:00 PM', '2022-01-30', 'Chicago', 'Miami', 'Pending', FALSE),
    ('KKK169', '550.00', '2021-12-05', 1, '2021-12-20', 1, 0, 0, '12:00 PM', '04:15 PM', '2021-12-20', 'Washington D.C.', 'Boston', 'Confirmed', FALSE),
    ('LLL170', '600.00', '2021-11-18', 1, '2021-12-05', 2, 1, 0, '09:15 AM', '01:30 PM', '2021-12-05', 'Dallas', 'Phoenix', 'Confirmed', FALSE),
    ('MMM171', '700.00', '2021-10-28', 1, '2021-11-15', 3, 0, 0, '10:30 AM', '02:45 PM', '2021-11-15', 'Denver', 'Las Vegas', 'Pending', FALSE),
    ('NNN172', '450.00', '2021-09-10', 1, '2021-09-25', 2, 1, 0, '11:30 AM', '04:00 PM', '2021-09-25', 'Seattle', 'San Francisco', 'Confirmed', FALSE),
    ('OOO173', '350.00', '2021-08-25', 1, '2021-09-10', 1, 0, 0, '08:45 AM', '01:15 PM', '2021-09-10', 'Los Angeles', 'New York', 'Confirmed', FALSE),
    ('PPP174', '650.00', '2021-07-22', 1, '2021-08-10', 3, 2, 0, '08:15 AM', '12:30 PM', '2021-08-10', 'Miami', 'Chicago', 'Pending', FALSE),
    ('QQQ175', '500.00', '2021-06-15', 1, '2021-06-30', 2, 0, 0, '10:00 AM', '02:15 PM', '2021-06-30', 'Boston', 'Washington D.C.', 'Confirmed', FALSE),
    ('RRR176', '750.00', '2021-05-18', 1, '2021-06-02', 3, 1, 1, '11:45 AM', '04:00 PM', '2021-06-02', 'Phoenix', 'Dallas', 'Confirmed', FALSE),
    ('SSS177', '400.00', '2021-04-20', 1, '2021-05-05', 1, 0, 0, '09:30 AM', '01:45 PM', '2021-05-05', 'Denver', 'Las Vegas', 'Pending', FALSE),
    ('TTT178', '550.00', '2021-03-15', 1, '2021-03-30', 2, 0, 1, '12:15 PM', '04:30 PM', '2021-03-30', 'New York', 'Los Angeles', 'Confirmed', FALSE),
    ('UUU179', '600.00', '2021-02-10', 1, '2021-02-28', 2, 0, 0, '09:00 AM', '01:30 PM', '2021-02-28', 'Chicago', 'Miami', 'Confirmed', FALSE),
    ('VVV180', '700.00', '2021-01-05', 1, '2021-01-20', 3, 1, 0, '10:30 AM', '03:00 PM', '2021-01-20', 'Washington D.C.', 'Boston', 'Pending', FALSE),
    ('WWW181', '350.00', '2020-12-02', 1, '2020-12-15', 1, 0, 0, '08:15 AM', '12:45 PM', '2020-12-15', 'Dallas', 'Phoenix', 'Confirmed', FALSE),
    ('XXX182', '450.00', '2020-11-15', 1, '2020-11-30', 2, 0, 0, '09:00 AM', '01:15 PM', '2020-11-30', 'Denver', 'Las Vegas', 'Confirmed', FALSE),
    ('YYY183', '600.00', '2020-10-12', 1, '2020-10-25', 3, 1, 0, '11:45 AM', '04:00 PM', '2020-10-25', 'Seattle', 'San Francisco', 'Pending', FALSE),
    ('ZZZ184', '700.00', '2020-09-18', 1, '2020-10-05', 2, 0, 1, '09:15 AM', '01:45 PM', '2020-10-05', 'Los Angeles', 'New York', 'Confirmed', FALSE),
    ('AAA185', '400.00', '2020-08-25', 1, '2020-09-10', 1, 0, 0, '10:45 AM', '03:00 PM', '2020-09-10', 'Boston', 'Washington D.C.', 'Confirmed', FALSE),
    ('BBB186', '350.00', '2020-07-15', 1, '2020-08-01', 3, 1, 0, '08:30 AM', '01:30 PM', '2020-08-01', 'Miami', 'Chicago', 'Pending', FALSE),
    ('CCC187', '750.00', '2020-06-22', 1, '2020-07-05', 2, 0, 0, '11:00 AM', '03:30 PM', '2020-07-05', 'Washington D.C.', 'Boston', 'Confirmed', FALSE),
    ('DDD188', '550.00', '2020-05-12', 1, '2020-05-28', 1, 0, 0, '08:30 AM', '12:45 PM', '2020-05-28', 'Phoenix', 'Dallas', 'Confirmed', FALSE),
    ('EEE189', '600.00', '2020-04-15', 1, '2020-04-30', 3, 2, 0, '12:15 PM', '04:30 PM', '2020-04-30', 'Denver', 'Las Vegas', 'Pending', FALSE),
    ('FFF190', '500.00', '2020-03-18', 1, '2020-04-02', 2, 1, 0, '09:00 AM', '01:15 PM', '2020-04-02', 'New York', 'Los Angeles', 'Confirmed', FALSE),
    ('XXY110', '350.00', '2023-08-28', 1, '2023-09-15', 1, 0, 0, '11:45 AM', '03:15 PM', '2023-09-15', 'New York', 'Los Angeles', 'Confirmed', FALSE),
    ('YYZ111', '600.00', '2023-11-05', 1, '2023-11-20', 2, 0, 1, '09:00 AM', '01:30 PM', '2023-11-20', 'Los Angeles', 'New York', 'Confirmed', FALSE),
    ('ZZZ112', '500.00', '2023-10-18', 1, '2023-11-05', 1, 1, 0, '10:30 AM', '02:45 PM', '2023-11-05', 'Chicago', 'Miami', 'Pending', FALSE);


INSERT INTO RESERVATION (CODE, PRICE_TOTAL, DATE_RESERVATION, CLIENT_ID, DATE_DEPART, NUMBER_DE_ADULETS, NUMBER_DE_ENFANTS, NUMBER_DE_BEBES, LHEURE_DEPART, LHEURE_ARRIVEE, DATE_ARRIVEE, VILLE_DEPART, VILLE_ARRIVEE, status, cancelled)
VALUES ('RESERVATION-1', '1000', '2021-10-10', 1, '2021-10-10', 2, 1, 1, '10:00', '12:00', '2021-10-10', 'Tunis', 'Paris', 'CONFIRMED', false),
       ('RESERVATION-2', '1000', '2021-10-10', 1, '2021-10-10', 2, 1, 1, '10:00', '12:00', '2021-10-10', 'Tunis', 'Paris', 'CANCELED', false),
       ('RESERVATION-3', '1000', '2021-10-10', 1, '2021-10-10', 2, 1, 1, '10:00', '12:00', '2021-10-10', 'Tunis', 'Paris', 'PENDING', false),
       ('RESERVATION-4', '1000', '2021-10-10', 1, '2021-10-10', 2, 1, 1, '10:00', '12:00', '2021-10-10', 'Tunis', 'Paris', 'CONFIRMED', false),
       ('RESERVATION-5', '1000', '2021-10-10', 1, '2021-10-10', 2, 1, 1, '10:00', '12:00', '2021-10-10', 'Tunis', 'Paris', 'CANCELED', false),
       ('RESERVATION-6', '1000', '2021-10-10', 1, '2021-10-10', 2, 1, 1, '10:00', '12:00', '2021-10-10', 'Tunis', 'Paris', 'PENDING', false),
       ('RESERVATION-7', '1000', '2021-10-10', 1, '2021-10-10', 2, 1, 1, '10:00', '12:00', '2021-10-10', 'Tunis', 'Paris', 'CONFIRMED', false),
       ('RESERVATION-8', '1000', '2021-10-10', 1, '2021-10-10', 2, 1, 1, '10:00', '12:00', '2021-10-10', 'Tunis', 'Paris', 'CANCELED', false),
       ('RESERVATION-9', '1000', '2021-10-10', 1, '2021-10-10', 2, 1, 1, '10:00', '12:00', '2021-10-10', 'Tunis', 'Paris', 'PENDING', false);


-- ETQ Administrateur je veux Afficher les statistiques des vols confirmés (mensuelles et annuelles)
SELECT COUNT(*) FROM RESERVATION WHERE status = 'CONFIRMED' AND DATE_RESERVATION BETWEEN '2021-10-01' AND '2021-10-31';
SELECT COUNT(*) FROM RESERVATION WHERE status = 'CONFIRMED' AND DATE_RESERVATION BETWEEN '2021-01-01' AND '2021-12-31';
-- ETQ Administrateur je veux Afficher les statistiques des vols annulés (mensuelles et annuelles)
SELECT COUNT(*) FROM RESERVATION WHERE status = 'CANCELED' AND DATE_RESERVATION BETWEEN '2021-10-01' AND '2021-10-31';
SELECT COUNT(*) FROM RESERVATION WHERE status = 'CANCELED' AND DATE_RESERVATION BETWEEN '2021-01-01' AND '2021-12-31';

-- GET USER ALL RESERVATION
SELECT * FROM RESERVATION WHERE CLIENT_ID = 1;

CREATE TABLE AEROPORT (
    ID SERIAL NOT NULL ,
    CODE VARCHAR(255),
    NOM VARCHAR(255),
    ADRESSE VARCHAR(255),
   TELEPHONE VARCHAR(255),
   PRIMARY KEY (ID)
);


CREATE TABLE VILLE (
    ID SERIAL NOT NULL ,
    CODE VARCHAR(255),
    NOM VARCHAR(255),
    CODE_POSTAL VARCHAR(255),
    PRIMARY KEY (ID)
);


DROP TABLE VILLE_IMAGE ;
CREATE TABLE VILLE_IMAGE (
    ID SERIAL NOT NULL ,
    IMAGE VARCHAR(255),
    VILLE_ID INT NOT NULL,
    CONSTRAINT FK_CITY FOREIGN KEY (VILLE_ID) REFERENCES VILLE(ID) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (ID)
);


CREATE TABLE SOCIETE_AERIENNE (
                                  ID SERIAL NOT NULL ,
                                  CODE VARCHAR(255),
                                  NOM VARCHAR(255),
                                  ADRESSE VARCHAR(255),
                                  TELEPHONE VARCHAR(255),
                                  PRIMARY KEY (ID)
);

--ADD COLUMN TO TABLE SOCIETE_AERIENNE

ALTER TABLE SOCIETE_AERIENNE
    ADD COLUMN LOGO varchar(255) ;

CREATE TABLE VOL (
                     ID SERIAL NOT NULL ,
                     CODE VARCHAR(255),
                     HEURE_DEPART VARCHAR(255),
                     HEURE_ARRIVEE VARCHAR(255),
                     DATE_DEPART VARCHAR(255),
                     DATE_ARRIVEE VARCHAR(255),
                     VILLE_DEPART VARCHAR(255),
                     VILLE_ARRIVEE VARCHAR(255),
                     NOMBRE_DE_PLACES INT,
                     PRIX VARCHAR(255),
                     AEROPORT_ID INT NOT NULL,
                     SOCIETE_AERIENNE_ID INT NOT NULL,
                     VILLE_ID INT ,
                     CONSTRAINT FK_AEROPORT FOREIGN KEY (AEROPORT_ID) REFERENCES AEROPORT(ID),
                     CONSTRAINT FK_VILLE FOREIGN KEY (VILLE_ID) REFERENCES VILLE(ID),
                     CONSTRAINT FK_SOCIETE_AERIENNE FOREIGN KEY (SOCIETE_AERIENNE_ID) REFERENCES SOCIETE_AERIENNE(ID),
                     PRIMARY KEY (ID)
);


CREATE TABLE VOL_ESCALE(
    ID SERIAL NOT NULL ,
    VILLE_ESCALE VARCHAR(255),
    HEURE_ESCALE VARCHAR(255),
    VOL_ID INT NOT NULL,
    CONSTRAINT FK_VOL FOREIGN KEY (VOL_ID) REFERENCES VOL(ID),
    PRIMARY KEY (ID)

);


CREATE TABLE VOL_EXTRAS (
    ID SERIAL NOT NULL ,
    TYPE VARCHAR(255),
    PRIX VARCHAR(255),
    DESCRIPTION VARCHAR(255),
    VOL_ID INT NOT NULL,
    CONSTRAINT FK_VOL FOREIGN KEY (VOL_ID) REFERENCES VOL(ID),
    PRIMARY KEY (ID)
);
--TYPE VOL_EXTRACTS TYPES  FOOD - ASSURANCE - HOTEL - FIRST CLASS - BUSINESS CLASS - ECONOMY CLASS

CREATE TABLE RESERVATION_VOL (
    ID SERIAL NOT NULL ,
    RESERVATION_CODE VARCHAR(255) NOT NULL,
    VOL_ID INT NOT NULL,
    CONSTRAINT FK_RESERVATION FOREIGN KEY (RESERVATION_CODE) REFERENCES RESERVATION(CODE),
    CONSTRAINT FK_VOL FOREIGN KEY (VOL_ID) REFERENCES VOL(ID),
    PRIMARY KEY (ID)
);






CREATE TABLE ADMINISTRATEUR (
    ID SERIAL NOT NULL ,
    CODE VARCHAR(255),
    NOM VARCHAR(255),
    PRENOM VARCHAR(255),
    ADRESSE VARCHAR(255),
    EMAIL VARCHAR(255),
    TELEPHONE VARCHAR(255),
    PASSWORD VARCHAR(255),
    PRIMARY KEY (ID)
);

-- CREATE PAYMENT TABLE
CREATE TABLE PAYMENT (
PAYMENTID SERIAL NOT NULL ,
RESERVATION_CODE VARCHAR(255) NOT NULL,
PAYMENTAMOUNT DECIMAL(10, 2),
PAYMENTDATE timestamp DEFAULT CURRENT_TIMESTAMP,
PAYMENTSTATUS VARCHAR(255),
PAYMENTMETHOD VARCHAR(255),
FOREIGN KEY (RESERVATION_CODE) REFERENCES RESERVATION(CODE)
);
