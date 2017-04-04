CREATE SEQUENCE SEQ_Clients START WITH 1 INCREMENT BY 1 NOCYCLE;
CREATE SEQUENCE SEQ_Orders START WITH 1 INCREMENT BY 1 NOCYCLE;

CREATE TABLE Clients
(
  client_id    NUMBER NOT NULL,
  client_name  VARCHAR2(41) NOT NULL,
  CONSTRAINT client_id_PK PRIMARY KEY (client_id)
);

CREATE TABLE Orders
(
  order_id    NUMBER NOT NULL,
  client_id   NUMBER NOT NULL,
  order_sum   NUMBER NOT NULL,
  order_date  DATE DEFAULT SYSDATE NOT NULL,
  CONSTRAINT order_id_PK PRIMARY KEY (order_id)
);

INSERT INTO Clients(client_id, client_name) VALUES (SEQ_Clients.nextval, '1');
INSERT INTO Clients(client_id, client_name) VALUES (SEQ_Clients.nextval, '2');
INSERT INTO Clients(client_id, client_name) VALUES (SEQ_Clients.nextval, '3');

INSERT INTO Orders(order_id, client_id, order_sum, order_date)
VALUES(SEQ_Orders.nextval, '1', 20, SYSDATE);

INSERT INTO Orders(order_id, client_id, order_sum, order_date)
VALUES(SEQ_Orders.nextval, '2', 30, SYSDATE);

INSERT INTO Orders(order_id, client_id, order_sum, order_date)
VALUES(SEQ_Orders.nextval, '3', 60, SYSDATE);

INSERT INTO Orders(order_id, client_id, order_sum, order_date)
VALUES(SEQ_Orders.nextval, '3', 70, SYSDATE);
