package com.mycompany.crud_jdbc;

import DAO.ConnectionDB;

public class Crud_JDBC {

    public static void main(String[] args) {
        ConnectionDB connetion = new ConnectionDB();
        connetion.ConnetionDataBase();

    }
}
