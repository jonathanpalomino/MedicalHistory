package com.palominocia.dao;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Property;
import org.greenrobot.greendao.generator.Schema;
import org.greenrobot.greendao.generator.ToMany;

public class Main {
    public static void main(String args[]) throws Exception {
        Schema schema = new Schema(1, "com.palominocia.dao");

        Entity clinicas= schema.addEntity("Clinicas");
        Property codigoClinica = clinicas.addLongProperty("codigoClinica")
                                    .notNull()
                                    .primaryKey()
                                    .autoincrement()
                                    .getProperty();
        clinicas.addStringProperty("NombreClinica");

        Entity sedes= schema.addEntity("Sedes");
        Property codigoSede = sedes.addLongProperty("codigoSede")
                                    .notNull()
                                    .primaryKey()
                                    .autoincrement()
                                    .getProperty();
        sedes.addStringProperty("NombreSede");
        sedes.addStringProperty("DireccionSede");
        sedes.addStringProperty("TelefonoSede");

        //ToMany manySedes = clinicas.addToMany(sedes,codigoSede);
        //manySedes.setName("codigoSede");

        Entity medico= schema.addEntity("Medicos");
        Property codigoMedico = medico.addLongProperty("codigoMedico")
                .notNull()
                .primaryKey()
                .autoincrement()
                .getProperty();
        medico.addStringProperty("nombreMedico");
        medico.addStringProperty("urlMedico");

        Entity sedeClinica= schema.addEntity("sedeClinica");
        sedes.addToMany(sedeClinica,codigoSede);//.setName("codigoSedeRef");
        medico.addToMany(sedeClinica,codigoMedico);//.setName("codigoMedicoRef");

        Entity especialidad= schema.addEntity("Especialidad");
        Property codigoEspecialidad = especialidad.addLongProperty("codigoEspecialidad")
                                .notNull()
                                .primaryKey()
                                .autoincrement()
                                .getProperty();
        especialidad.addStringProperty("nombreEspecialidad");

        Entity medicoEspecialidad= schema.addEntity("MedicoEspecialidad");
        medicoEspecialidad.addStringProperty("mcaEspecialidadActiva");

        especialidad.addToMany(medicoEspecialidad,codigoEspecialidad);//.setName("codigoEspecialidadRef");
        medico.addToMany(medicoEspecialidad,codigoMedico);//.setName("codigoMedicoRef");

        Entity citas= schema.addEntity("Citas");
        citas.addLongProperty("codigoCita");
        citas.addDateProperty("fechaCita");

        Entity diagnostico= schema.addEntity("Diagnostico");
        diagnostico.addLongProperty("codigoDiagnostico");
        diagnostico.addStringProperty("indicaciones");
        diagnostico.addDateProperty("fechaDiagnostico");

        Entity receta= schema.addEntity("Receta");
        Property codigoReceta = receta.addLongProperty("codigoReceta")
                                .notNull()
                                .primaryKey()
                                .autoincrement()
                                .getProperty();
        //receta.addLongProperty("codigoReceta");
        receta.addDateProperty("fechaReceta");

        Entity medicinas= schema.addEntity("Medicinas");
        Property codigoMedicina = medicinas.addLongProperty("codigoMedicina")
                                .notNull()
                                .primaryKey()
                                .autoincrement()
                                .getProperty();
        //medicinas.addLongProperty("codigoMedicina");
        medicinas.addStringProperty("nombreMedicina");
        medicinas.addStringProperty("presentacionMedicina");

        Entity recetaMedicina= schema.addEntity("RecetaMedicina");
        receta.addToMany(recetaMedicina,codigoMedicina);

        Entity paciente= schema.addEntity("RecetaMedicina");
        Property codigoPaciente = paciente.addLongProperty("codigoPaciente")
                                    .notNull()
                                    .primaryKey()
                                    .autoincrement()
                                    .getProperty();
        paciente.addStringProperty("nombrePaciente");
        paciente.addDateProperty("fecNacimientoPaciente");

        new DaoGenerator().generateAll(schema, "./dao/src/main/java");
    }
}
