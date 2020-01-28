package uf3_ac03_ej3;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @Daniel Migales
 */
//CLASE QUE ANALIZA CON SAX EL DOCUMENTO XML
public class Gestor extends DefaultHandler {

    Bookmarks bookmark = new Bookmarks(); //objeto donde se almacenan los elementos
    //banderas que se activan en el metodo de startElement
    boolean tagNombre = false;
    boolean tagUrl = false;
    boolean tagDescripcion = false;
    boolean tagClave = false;

    public Gestor() {
        super();
    }

    @Override
    public void startDocument() {
        System.out.println("Comienzo del Documento XML.");
    }

    @Override
    public void endDocument() {
        System.out.println("Final del Documento XML.");
        //AL FINALIZAR DE LEER TODO EL DOCUMENTO XML SE CREA EL ARCHIVO HTML
        HTML.crearFicheroHTML(bookmark);
    }

    @Override
    public void startElement(String uri, String nombre, String nombreC, Attributes atts) {

        System.out.println("\tElemento encontrado: " + nombre);

        //CUANDO ENCUENTRA UN ELEMENTO DE UN TIPO ACTIVA UNA BANDERA
        if (nombre.equals("nombre")) {
            tagNombre = true;
        }

        if (nombre.equals("url")) {
            tagUrl = true;
        }
        if (nombre.equals("descripcion")) {
            tagDescripcion = true;
        }
        if (nombre.equals("claves")) {
            tagClave = true;
        }

    }

    public void endElement(String uri, String nombre, String nombreC) {
        System.out.println("\tFin del elemento: " + nombre);
    }

    
    @Override
    public void characters(char[] ch, int inicio, int longitud) throws SAXException {

        String car = new String(ch, inicio, longitud);
        car = car.replaceAll("[\t\n]", "");
        System.out.println("\t" + car);
        
        //CUANDO LLEGA A ESTE METODO COMPRUEBA QUE BANDERA ESTA ACTIVA Y GRABA UN DATO EN EL OBJETO
        if (tagNombre) {
            tagNombre = false;
            bookmark.setNombre(car);
        }

        if (tagUrl) {
            tagUrl = false;
            bookmark.setUrl(car);
        }

        if (tagDescripcion) {
            tagDescripcion = false;
            bookmark.setDescripcion(car);
        }

        if (tagClave) {
            tagClave = false;
            bookmark.setClaves(car);
        }
    }

}
