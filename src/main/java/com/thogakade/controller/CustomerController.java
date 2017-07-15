/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thogakade.controller;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.thogakade.db.DBConnection;
import com.thogakade.model.Customer;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miyuru Madusanka
 */
public class CustomerController {

    private static DB db;
    private static DBCollection collection;
    private static DBObject doc;
    private static DBObject query;

    public static boolean addCustomer(Customer customer) {
        WriteResult insert = null;
        try {
            db = DBConnection.getInstance().getDB();
            collection = db.getCollection("customer");
            doc = createDBObject(customer);
            insert = collection.insert(doc);

        } catch (UnknownHostException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (insert != null) ? true : false;
    }

    public static Customer searchCustomer(String id) {
        Customer customer = null;
        try {
            db = DBConnection.getInstance().getDB();
            collection = db.getCollection("customer");
            query = BasicDBObjectBuilder.start().add("_id", id).get();
            DBCursor cursor = collection.find(query);

            if (cursor.hasNext()) {

                DBObject o = cursor.next();
                customer = new Customer((String) o.get("name"), (String) o.get("address"), (String) o.get("city"), (String) o.get("mobile"), (String) o.get("landline"), (String) o.get("shopname"));
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer;
    }

    public static boolean updateCustomer(Customer customer) {
        WriteResult update = null;
        try {
            db = DBConnection.getInstance().getDB();
            collection = db.getCollection("customer");
            doc = createDBObject(customer);
            query = BasicDBObjectBuilder.start().add("_id", customer.getCid()).get();
            update = collection.update(query, doc);
        } catch (UnknownHostException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (update != null) ? true : false;
    }

    public static boolean deleteCustomer(String id) {
        WriteResult result = null;
        try {
            db = DBConnection.getInstance().getDB();
            collection = db.getCollection("customer");
            query = BasicDBObjectBuilder.start().add("_id", id).get();
            result = collection.remove(query);
        } catch (UnknownHostException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (result != null) ? true : false;
    }

    public static ArrayList<Customer> viewAllEmployees() {
        ArrayList<Customer> allCustomers = new ArrayList<>();
        Customer customer;
        try {
            db = DBConnection.getInstance().getDB();
            collection = db.getCollection("customer");
            DBCursor cursor = collection.find();
            DBObject o;
            while (cursor.hasNext()) {
                o = cursor.next();
                customer = new Customer((String) o.get("_id"),(String) o.get("name"), (String) o.get("address"), (String) o.get("city"), (String) o.get("mobile"), (String) o.get("landline"), (String) o.get("shopname"));
                allCustomers.add(customer);
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allCustomers;
    }

    private static DBObject createDBObject(Customer customer) {
        BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
        docBuilder.append("_id", customer.getCid());
        docBuilder.append("name", customer.getCustname());
        docBuilder.append("address", customer.getAddress());
        docBuilder.append("city", customer.getCity());
        docBuilder.append("mobile", customer.getMobile());
        docBuilder.append("landline", customer.getLandline());
        docBuilder.append("shopname", customer.getShopName());
        return docBuilder.get();
    }
}
