/*
We do have 2 tables in a relational database:
∙ Clients (client_id(PK), client_name)
∙ Orders (order_id(PK), client_id, order_sum, order_date)
Please write the following SQL queries:
a- list of clients, which have an order with order_sum > 50
b- clients, whose total sum of orders exceeds 100
* */
package com.luxoft.third;

public class SQLQueries {

    // tested on Oracle DB, there is create script in resources folder
    public static final String QUERY1 =
            "SELECT C.client_name FROM Clients C JOIN Orders O ON C.client_id = O.client_id WHERE O.order_sum > 50;";

    public static final String QUERY2 =
            "SELECT C.client_name FROM Clients C JOIN Orders O ON C.client_id = O.client_id GROUP BY C.client_name HAVING SUM(O.order_sum) > 100;";
}
