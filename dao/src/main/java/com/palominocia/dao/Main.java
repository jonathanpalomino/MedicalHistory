package com.palominocia.dao;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Index;
import org.greenrobot.greendao.generator.Property;
import org.greenrobot.greendao.generator.Schema;
import org.greenrobot.greendao.generator.ToMany;
import org.greenrobot.greendao.generator.ToOne;

public class Main {
    public static void main(String args[]) throws Exception {
        Schema schema = new Schema(1, "com.palominocia.medicalhistory.dao");
        schema.enableKeepSectionsByDefault();

        Entity clinicas= schema.addEntity("Clinicas");
        Property codigoClinica = clinicas.addLongProperty("codigoClinica")
                                .primaryKey()
                                .autoincrement()
                                .getProperty();
        clinicas.addStringProperty("NombreClinica");

        Entity sedes= schema.addEntity("Sedes");
        sedes.addIdProperty().primaryKey().autoincrement();
        Property codigoSede = sedes.addLongProperty("codigoSede")
                                    //.primaryKey()
                                    //.autoincrement()
                                    .getProperty();
        Property codigoClinicaId = sedes.addLongProperty("codigoClinica")
                                    .getProperty();
        sedes.addStringProperty("NombreSede");
        sedes.addStringProperty("DireccionSede");
        sedes.addStringProperty("TelefonoSede");
        Index indice1 =new Index();
        indice1.addPropertyAsc(codigoSede);
        indice1.addPropertyAsc(codigoClinicaId);
        sedes.addIndex(indice1);

        ToOne sedesToClinicas = sedes.addToOne(clinicas,codigoClinicaId);
        ToMany clinicasToSedes = clinicas.addToMany(sedes, codigoClinicaId);

        Entity medico= schema.addEntity("Medicos");
        medico.addIdProperty().primaryKey().autoincrement();
        Property codigoMedico = medico.addLongProperty("codigoMedico")
                                        //.primaryKey()
                                        //.autoincrement()
                                        .getProperty();
        medico.addStringProperty("nombreMedico");
        medico.addStringProperty("urlMedico");

        Entity sedeClinica= schema.addEntity("SedeClinica");
        Property sedeClinica_codigoSedeId = sedeClinica.addLongProperty("codigoSede").getProperty();
        Property sedeClinica_codigoClinicaId = sedeClinica.addLongProperty("codigoClinica").getProperty();
        Property sedeClinica_codigoMedicoId = sedeClinica.addLongProperty("codigoMedico").getProperty();

        ToOne sedesClinicaToClinica02 = sedeClinica.addToOne(sedes,sedeClinica_codigoClinicaId);
        Property[] sourceProperties ={codigoSede,codigoClinicaId};
        Property[] targetProperties ={sedeClinica_codigoSedeId,sedeClinica_codigoClinicaId};
        ToMany clinicasToSedeClinicas = sedes.addToMany(sourceProperties,sedeClinica,targetProperties);

        medico.addToMany(sedeClinica,sedeClinica_codigoMedicoId);


        Entity especialidad= schema.addEntity("Especialidad");
        especialidad.addIdProperty().primaryKey().autoincrement();
        Property codigoEspecialidad = especialidad.addLongProperty("codigoEspecialidad")
                                //.primaryKey()
                                //.autoincrement()
                                .getProperty();
        especialidad.addStringProperty("nombreEspecialidad");

        Entity medicoEspecialidad= schema.addEntity("MedicoEspecialidad");
        medicoEspecialidad.addStringProperty("mcaEspecialidadActiva");
        Property medicoEspecialidad_codigoSedeId = medicoEspecialidad.addLongProperty("codigoMedico").getProperty();
        medico.addToMany(medicoEspecialidad,medicoEspecialidad_codigoSedeId);

        especialidad.addToMany(medicoEspecialidad,codigoEspecialidad);


        Entity citas= schema.addEntity("Citas");
        citas.addLongProperty("codigoCita");
        citas.addDateProperty("fechaCita");

        Entity diagnostico= schema.addEntity("Diagnostico");
        diagnostico.addLongProperty("codigoDiagnostico");
        diagnostico.addStringProperty("indicaciones");
        diagnostico.addDateProperty("fechaDiagnostico");

        Entity receta= schema.addEntity("Receta");
        Property codigoReceta = receta.addLongProperty("codigoReceta")
                                .primaryKey()
                                .autoincrement()
                                .getProperty();
        //receta.addLongProperty("codigoReceta");
        receta.addDateProperty("fechaReceta");

        Entity medicinas= schema.addEntity("Medicinas");
        Property codigoMedicina = medicinas.addLongProperty("codigoMedicina")
                                .primaryKey()
                                .autoincrement()
                                .getProperty();
        //medicinas.addLongProperty("codigoMedicina");
        medicinas.addStringProperty("nombreMedicina");
        medicinas.addStringProperty("presentacionMedicina");

        /*Entity recetaMedicina= schema.addEntity("RecetaMedicina");
        receta.addToMany(recetaMedicina,codigoMedicina);*/

        Entity paciente= schema.addEntity("Paciente");
        Property codigoPaciente = paciente.addLongProperty("codigoPaciente")
                                    .primaryKey()
                                    .autoincrement()
                                    .getProperty();
        paciente.addStringProperty("nombrePaciente");
        paciente.addDateProperty("fecNacimientoPaciente");

        new DaoGenerator().generateAll(schema, "./app/src/main/java");
    }
}
