package org.example;

import com.mongodb.client.*;
import org.bson.Document;
import org.bson.conversions.Bson;

public class Database{
    //initialize the class variables
    public String DBTOKEN;
    public String collectionName;
    public String databaseName;
    public MongoClient client;
    public MongoDatabase db;
    public MongoCollection <Document> collections;

    //constructor
    public Database(String TOKEN, String dbName, String colName) {
        DBTOKEN = TOKEN;
        collectionName = colName;
        databaseName = dbName;

        //connect to the database and get the collection
        client = MongoClients.create(DBTOKEN);
        db = client.getDatabase(databaseName);
        collections = db.getCollection(collectionName);
    }

    //obtains the user credits given their userID
    public String obtainUserCredits(String userID){
        Document userInfo = (Document) collections.find(new Document("discordid",userID)).first();

        //use the get function to obtain a value given a key
        System.out.println(userInfo.get("credits"));
        return (String) userInfo.get("credits");
    }

    //Create a new user
    public void insertDocument(String userID){
        //insert a persons id and the amount of credits they start out with
        Document document = new Document();
        document.append("discordid", userID);
        document.append("credits", "3380");
        db.getCollection(collectionName).insertOne(document);
        System.out.println("document added sucessfully");
    }

    //update a users credit when they win or lose credits
    public void updateDocument(String userID, String credits){
        Document userInfo = (Document) collections.find(new Document("discordid",userID)).first();

        //if the document is found apply update the document and send it to MongoDB
        if(userInfo != null){
            Bson updatedValue = new Document("credits",credits);
            Bson updatedOperation = new Document("$set", updatedValue);
            collections.updateOne(userInfo,updatedOperation);
            System.out.println("Updated the document requested");
        }
    }

    //retuns a boolean value if user is in the database else returns false
    public boolean findUser(String userID){
        Document user = (Document) collections.find(new Document("discordid",userID)).first();
        if(user != null){
            return true;
        }
        return false;
    }
}
