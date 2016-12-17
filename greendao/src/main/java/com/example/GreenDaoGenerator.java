package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class GreenDaoGenerator {
    private static final String PROJECT_DIR = System.getProperty("user.dir");

    public static void main(String[] args) {
        Schema schema = new Schema(1, "com.greendaoexample.database");
        schema.enableKeepSectionsByDefault();

        addTables(schema);

        try {
            new DaoGenerator().generateAll(schema, PROJECT_DIR + "\\app\\src\\main\\java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addTables(Schema schema) {
        //Entity i.e. Class to be stored in the database // ie table LOG
        Entity word_entity= schema.addEntity("MyObject");
        word_entity.addIdProperty().notNull(); //It is the primary key for uniquely identifying a row
        word_entity.addStringProperty("name").notNull();  //Not null is SQL constrain

        //  ./app/src/main/java/   ----   com/codekrypt/greendao/db is the full path

    }
}
