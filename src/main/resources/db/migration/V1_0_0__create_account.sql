DROP TABLE IF EXISTS account;

CREATE TABLE account (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  account_number VARCHAR(21),
  currency VARCHAR(3) NOT NULL,
  ballance DOUBLE NOT NULL,
  status INT DEFAULT NULL
);


INSERT INTO account (account_number, currency, ballance, status) VALUES
  ('LV007UNLA66666666666', 'USD',999, 1),
  ('LV007UNLA77777777777', 'EUR',15, 1);