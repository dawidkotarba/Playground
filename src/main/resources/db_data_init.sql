-- USER TABLE
INSERT INTO PUBLIC.USER(USERNAME, PASSWORD, ENABLED, ROLE) VALUES('admin', 'admin', true, 'ROLE_ADMIN');
INSERT INTO PUBLIC.USER(USERNAME, PASSWORD, ENABLED, ROLE) VALUES('user', 'user', true, 'ROLE_USER');

-- COUNTRY TABLE
INSERT INTO PUBLIC.COUNTRY(NAME, CAPITAL, AREA, POPULATION, CURRENCY) VALUES('Poland', 'Warsaw', 312685, 38000000, 'PLN');
INSERT INTO PUBLIC.COUNTRY(NAME, CAPITAL, AREA, POPULATION, CURRENCY) VALUES('Germany', 'Berlin', 357340, 81000000, 'EUR');
INSERT INTO PUBLIC.COUNTRY(NAME, CAPITAL, AREA, POPULATION, CURRENCY) VALUES('UK', 'London', 244820, 63000000, 'GBP');