-- USER TABLE
INSERT INTO public.user (username, password, enabled, role) VALUES
  ('admin', 'admin', TRUE, 'ROLE_ADMIN'),
  ('user', 'user', TRUE, 'ROLE_USER');

-- CAPITAL TABLE
INSERT INTO public.capital (name, population) VALUES
  ('Warsaw', 1735442),
  ('Berlin', 3440991),
  ('London', 8416535),
  ('Moscow', 12100000),
  ('Amsterdam', 801200);

-- COUNTRY TABLE
INSERT INTO public.country (name, capital, area, population, currency) VALUES
  ('Poland', 1, 312685, 38000000, 'PLN'),
  ('Germany', 2, 357340, 81000000, 'EUR'),
  ('UK', 3, 244820, 63000000, 'GBP'),
  ('Netherlands', 4, 41526, 16800000, 'EUR'),
  ('Russia', 5, 17098242, 143500000, 'RUB');

-- NEIGHBOUR TABLE
INSERT INTO public.neighbour (country, neighbour) VALUES
  (1, 2),
  (1, 5),
  (2, 1),
  (2, 4),
  (4, 2),
  (5, 1);
