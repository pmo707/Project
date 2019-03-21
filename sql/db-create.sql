DROP DATABASE IF EXISTS task4db;
CREATE DATABASE task4db;
ALTER DATABASE task4db CHARACTER SET = utf8mb4  COLLATE = utf8mb4_unicode_ci;
USE task4db;


CREATE TABLE roles
(
  id   INT         NOT NULL PRIMARY KEY,
  name VARCHAR(15) NOT NULL UNIQUE
);
CREATE TABLE statuses
(
  id   INT         NOT NULL PRIMARY KEY,
  name VARCHAR(10) NOT NULL UNIQUE
);

CREATE TABLE category
(
  id            INT PRIMARY KEY auto_increment,
  name_category VARCHAR(45) UNIQUE NOT NULL
);
CREATE TABLE user
(
  id       INT PRIMARY KEY auto_increment,
  login    VARCHAR(15) UNIQUE NOT NULL,
  password VARCHAR(45)        NOT NULL,
  role_id  INT                NOT NULL,
  FOREIGN KEY (role_id) REFERENCES roles (id)
    ON DELETE CASCADE
);

CREATE TABLE goods
(
  id          INT PRIMARY KEY auto_increment,
  name        VARCHAR(15) UNIQUE NOT NULL,
  price       DOUBLE             NOT NULL,
  createdAt   DATETIME           NOT NULL,
  color       VARCHAR(15)        NOT NULL,
  size        INT                NOT NULL,
  available   INT                NOT NULL,
  category_id INT                NOT NULL,
  FOREIGN KEY (category_id) REFERENCES category (id)
    ON DELETE CASCADE
);


CREATE TABLE orders
(
  id         INT      NOT NULL PRIMARY KEY auto_increment,
  user_id    INT      NOT NULL,
  status_id  INT      NOT NULL,
  created_at DATETIME NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE,
  FOREIGN KEY (status_id) REFERENCES statuses (id) ON DELETE CASCADE
);

CREATE TABLE orders_goods
(
  order_id INT NOT NULL,
  goods_id INT NOT NULL,
  FOREIGN KEY (goods_id) REFERENCES goods (id)ON DELETE CASCADE,
  FOREIGN KEY (order_id) REFERENCES orders (id)ON DELETE CASCADE
);


-- ------INSERT---------
-- INTO table roles
INSERT INTO roles
VALUES (1, "admin");
INSERT INTO roles
VALUES (2, "user");
INSERT INTO roles
VALUES (3, "blocked user");

-- ---------------------
-- INTO table statuses
INSERT INTO statuses
VALUES (1, "canceled");
INSERT INTO statuses
VALUES (2, "book");
INSERT INTO statuses
VALUES (3, "paid");

-- ---------------------
-- INTO table category
INSERT INTO category
VALUES (1, "car");
INSERT INTO category
VALUES (2, "motorbike");
INSERT INTO category
VALUES (3, "airplane");

-- ---------------------
-- INTO table users
INSERT INTO user
VALUES (default, "admin", "admin", 1);
INSERT INTO user
VALUES (default, "user", "user", 2);
INSERT INTO user
VALUES (default, "buser", "buser", 3);
INSERT INTO user
VALUES (default, "obama", "obamapass", 2);

-- ---------------------
-- INTO table goods
INSERT INTO goods
VALUES (default, "Audi", 100.0, "2000-02-03", "black", 11, 12, 1);
INSERT INTO goods
VALUES (default, "BMW", 400.0, CURRENT_TIME, "black", 11, 12, 2);
INSERT INTO goods
VALUES (default, "Jeep", 300.0, CURRENT_TIME, "black", 11, 12, 3);
INSERT INTO goods
VALUES (default, "Nissan", 1300.0, CURRENT_TIME, "black", 11, 12, 1);
INSERT INTO goods
VALUES (default, "Тест", 1300.0, CURRENT_TIME, "черный", 11, 12, 1);

-- ---------------------
-- INTO table orders
# INSERT INTO orders
# VALUES (default, 1, 2, CURRENT_TIME);
# INSERT INTO orders
# VALUES (default, 2, 2, CURRENT_TIME);
# INSERT INTO orders
# VALUES (default, 3, 1, CURRENT_TIME);
# INSERT INTO orders
# VALUES (default, 4, 1, CURRENT_TIME);

-- ---------------------
-- INTO table orders_goods
# INSERT INTO orders_goods
# VALUES (1, 1);
# INSERT INTO orders_goods
# VALUES (1, 2);
# INSERT INTO orders_goods
# VALUES (1, 3);
# INSERT INTO orders_goods
# VALUES (1, 4);




