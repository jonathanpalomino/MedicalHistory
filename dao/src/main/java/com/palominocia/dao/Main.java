package com.palominocia.dao;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class Main {
    public static void main(String args[]) throws Exception {
        Schema schema = new Schema(1, "com.palominocia.dao");

        Entity note= schema.addEntity("Medicos");
        note.addIdProperty();
        note.addStringProperty("codMedico").notNull();
        note.addStringProperty("comment");
        note.addDateProperty("date");

        new DaoGenerator().generateAll(schema, "./dao/src/main/java");
    }
}
