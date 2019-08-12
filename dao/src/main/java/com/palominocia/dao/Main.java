package com.palominocia.dao;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class Main {
    public static void main(String args[]) throws Exception {
        Schema schema = new Schema(1, "com.palominocia.dao");

        Entity clinicas= schema.addEntity("Clinicas");
        Entity sedes= schema.addEntity("Sedes");
        Entity medico= schema.addEntity("Medicos");
        Entity especialidad= schema.addEntity("Especialidad");
        Entity citas= schema.addEntity("Citas");
        Entity diagnostico= schema.addEntity("Diagnostico");
        Entity receta= schema.addEntity("Receta");
        Entity medicinas= schema.addEntity("Medicinas");

        clinicas.addIntProperty("codigoClinica").primaryKey().autoincrement();
        clinicas.addStringProperty("NombreClinica");

        sedes.addIntProperty("codigoSede").primaryKey().autoincrement();
        sedes.addStringProperty("NombreSede");

        clinicas.addToMany(sedes,sedes.getPkProperty());

        new DaoGenerator().generateAll(schema, "./dao/src/main/java");
    }
}
