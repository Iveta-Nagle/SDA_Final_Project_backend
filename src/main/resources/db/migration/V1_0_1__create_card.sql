DROP TABLE IF EXISTS card;

CREATE TABLE card(
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  card_holder VARCHAR(210) NOT NULL,
  card_number VARCHAR(21) NOT NULL,
  exp_date TIMESTAMP NOT NULL,
  account_id BIGINT,
  status INT DEFAULT NULL
);

INSERT INTO card(card_holder, card_number, exp_date, account_id, status)
VALUES
  ('KARLIS L', '123456789123456789021',current_date + 365, 1,1),
  ('JANIS S', '133456789123456789022',current_date + 320, 2,1),
  ('AIJA S', '133456789123456789023',current_date + 170, 2,1),
  ('LIGA B', '133456789123456789024',current_date + 130, null ,1);