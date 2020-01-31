package uf3_ac03_ej3;

import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import org.xml.sax.*;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * @Daniel Migales
 */
public class XML {

    public static void CrearXML() throws IOException, ParserConfigurationException, TransformerException {

        Scanner teclado = new Scanner(System.in);
        String elemento1 = "nombre";
        String elemento2 = "url";
        String elemento3 = "descripcion";
        String elemento4 = "claves";

        //Creamos la instancia para crear el documento xml
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //Creamos un documento vacio con la version del xml
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, "Mis_Bookmarks", null); //Nombre raiz
        document.setXmlVersion("1.0");
        
        boolean continuar = true;

        do {
            //Creamos un elemento
            Element raiz = document.createElement("bookmark");
            document.getDocumentElement().appendChild(raiz);

            //Elemento nombre        
            System.out.println("Inserte el nombre del Bookmark:");
            String nombre = teclado.nextLine();
            CrearElemento(elemento1, nombre, raiz, document);

            //elemento URL
            System.out.println("Inserte la URL:");
            String url = teclado.nextLine();
            CrearElemento(elemento2, url, raiz, document);

            //elemento descripcion
            System.out.println("Inserte la descripcion:");
            String descripcion = teclado.nextLine();
            CrearElemento(elemento3, descripcion, raiz, document);

            //elemento URL
            System.out.println("Inserte las palabras clave:");
            String claves = teclado.nextLine();
            CrearElemento(elemento4, claves, raiz, document);

            //Creamos la fuente del documento xml
            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File("bookmarks.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            
            System.out.println("¿Desea agregar otro bookmark?   SI/NO");
            String respuesta = teclado.nextLine();
            
            if (respuesta.equalsIgnoreCase("NO")) {
                continuar=false;
            }
        } while (continuar);

    }

    public static void CrearElemento(String nombreElemento, String valor, Element raiz, Document document) throws TransformerConfigurationException, TransformerException {

        Element elem = document.createElement(nombreElemento);
        Text text = document.createTextNode(valor);//damos valor
        raiz.appendChild(elem);//pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor

    }

    public static void SAX() throws SAXException, IOException {

        XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
        Gestor gestor = new Gestor();
        procesadorXML.setContentHandler(gestor);
        InputSource fileXML = new InputSource("bookmarks.xml");
        procesadorXML.parse(fileXML);
    }

}
