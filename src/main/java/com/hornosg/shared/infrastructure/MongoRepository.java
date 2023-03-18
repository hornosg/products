package com.hornosg.shared.infrastructure;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MongoRepository {
    private static String database_url;

    @Value("${project-properties.database_url}")
    public void setDatabaseUrl(String databaseUrl) {
        database_url = databaseUrl;
    }

    protected MongoClient getClient()
    {
        return MongoClients.create(database_url);
    }


    protected MongoCollection<Document> getCollection(
            MongoClient mongoClient,
            String databaseName,
            String collectionName
    ) {
        MongoDatabase database = mongoClient.getDatabase(databaseName);

        return database.getCollection(collectionName);
    }
}
