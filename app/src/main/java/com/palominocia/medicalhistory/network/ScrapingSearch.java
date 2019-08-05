package com.palominocia.medicalhistory.network;


import java.io.IOException;
import java.net.Proxy;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author jpalomin
 */
public class ScrapingSearch {
    /**
     * Con esta método compruebo el Status code de la respuesta que recibo al hacer la petición
     * EJM:
     * 		200 OK					300 Multiple Choices
     * 		301 Moved Permanently	305 Use Proxy
     * 		400 Bad Request			403 Forbidden
     * 		404 Not Found			500 Internal Server Error
     * 		502 Bad Gateway			503 Service Unavailable
     * @param url
     * @param c_proxy
     * @return Status Code
     */
    public int getStatusConnectionCode(String url,Proxy c_proxy) {
        Connection.Response response = null;

        try {
            if(c_proxy instanceof Proxy){
                response = Jsoup.connect(url).
                        userAgent("Mozilla/5.0").
                        proxy(c_proxy).
                        //timeout(1000000).
                                ignoreHttpErrors(true).
                                execute();
                return response.statusCode();
            }
            else{
                response = Jsoup.connect(url).
                        userAgent("Mozilla/5.0").
                        //proxy(proxy).
                        //timeout(1000000).
                                ignoreHttpErrors(true).
                                execute();
                return response.statusCode();
            }
        } catch (IOException ex) {
            System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
        }
        return 0;
    }


    /**
     * Con este método devuelvo un objeto de la clase Document con el contenido del
     * HTML de la web que me permitirá parsearlo con los métodos de la librelia JSoup
     * @param url
     * @param c_proxy
     * @return Documento con el HTML
     */
    public Document getHtmlDocument(String url,Proxy c_proxy) {
        Document doc = null;
        try {
            if(c_proxy instanceof Proxy){
                doc = Jsoup.
                        connect(url).
                        proxy(c_proxy).
                        userAgent("Mozilla/5.0").
                        timeout(3600000).
                        get();
            }
            else{
                doc = Jsoup.connect(url).userAgent("Mozilla/5.0").
                        timeout(3600000).
                        get();
            }
        } catch (IOException ex) {
            System.out.println("Excepción al obtener el HTML de la página" + ex.getMessage());
        }

        return doc;

    }
}