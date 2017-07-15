/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thogakade.db;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;

/**
 *
 * @author Miyuru Madusanka
 */
public class DBConnection {

    private static DBConnection dBConnection;
    private MongoClient mongo;
    private DB db;

    private DBConnection() throws UnknownHostException {
        mongo = new MongoClient("localhost", 27017);
        db = mongo.getDB("thogakade");
    }

    public static DBConnection getInstance() throws UnknownHostException {
        if (dBConnection == null) {
            dBConnection = new DBConnection();
        }
        return dBConnection;
    }

    public DB getDB() {
        return db;
    }
}
