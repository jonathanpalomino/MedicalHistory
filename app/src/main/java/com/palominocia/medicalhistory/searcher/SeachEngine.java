package com.palominocia.medicalhistory.searcher;

import com.palominocia.medicalhistory.beans.MedicoBean;
import com.palominocia.medicalhistory.network.ScrapingSearch;

import java.util.ArrayList;
import java.util.Collections;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author jpalomin
 * @param <T>
 */
public class SeachEngine<T> extends ScrapingSearch {
    // A Generic method example
    public <T> ArrayList<T> seachElements(Class<T> element, String clinic,boolean delSeparator) {
        ArrayList lista = null;
        if (element.isInstance(new MedicoBean())) {
            if (clinic.equals("LIMATAMBO")) {
                String url = "https://www.clinicalimatambo.com/staff-medico/especialidades-medicas/buscar/null/null/";
                int statusCode = getStatusConnectionCode(url, null);
                if (statusCode == 200) {
                    // Obtengo el HTML de la web en un objeto Document
                    Document document = getHtmlDocument(url, null);
                    // Busco todas las historias de meneame que estan dentro de:
                    Elements entradas = document.select("ul.UlRes").select("li");
                    System.out.println("Número de entradas en la página inicial : " + entradas.size() + "\n");
                    lista = new ArrayList();
                    for (Element elem : entradas) {
                        MedicoBean tmp = new MedicoBean();
                        String nombreMedico = elem.select("a").text();
                        String imagenMedico = "https://www.clinicalimatambo.com/" + elem.select("img[src]").attr("src");
                        String especialidadMedico = elem.select("div.ResSub").text();

                        String sedeMedico = elem.select("div.ResNum").get(1).text();
                        String colegiaturaMedico = elem.select("div.ResNum").get(0).text();
                        String horarioMedico = "";
                        Elements eles = elem.select("tbody > tr > td");
                        for (Element ele : eles) {
                            horarioMedico = horarioMedico + ele.html() + "\n";
                        }

                        tmp.setNombre(nombreMedico);
                        tmp.setUrlImage(imagenMedico);

                        tmp.setHospital("Clinica Limatambo");

                        if(delSeparator){
                            tmp.setSedeHospital(sedeMedico.replace("Sede:", "").trim());
                            tmp.setEspecialidad(especialidadMedico.replace("Especialidad:", "").trim());
                        }
                        else{
                            tmp.setEspecialidad(especialidadMedico);
                            tmp.setSedeHospital(sedeMedico);
                        }

                        tmp.setHorarios(horarioMedico);

                        ArrayList<String> arrayList = new ArrayList<>();
                        Collections.addAll(arrayList, colegiaturaMedico.split("/"));
                        tmp.setColegiatura(arrayList) ;

                        lista.add(tmp);
                    }
                }
            }
        }
        return lista;
    }
}

