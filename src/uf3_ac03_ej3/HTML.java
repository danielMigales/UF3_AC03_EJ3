package uf3_ac03_ej3;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Daniel Migales
 */
//CLASE QUE CREA UN DOCUMENTO HTML CON LOS DATOS QUE RECIBE DEL OBJETO Y UNA PLANTILLA HTML
public class HTML {

    public static void crearFicheroHTML(Bookmarks bookmark){

        File fichero = new File("bookmarks.html");
        FileOutputStream salidaFile;
        try {
            salidaFile = new FileOutputStream(fichero, true);
            try (DataOutputStream salidaData = new DataOutputStream(salidaFile)) {

                salidaData.writeUTF("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n"
                        + "<html>\n"
                        + "<head>\n"
                        + "<title>Bookmarks</title>\n"
                        + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\n"
                        + "</head>\n"
                        + "<body>\n"
                        + "<h1>Bookmarks</h1>\n"
                        + "<dl>\n"
                        + "<dt><a href=" + bookmark.getUrl() + ">" + bookmark.getNombre() + "</a></dt>\n"
                        + "<dd>" + bookmark.getDescripcion() + "</dd>\n"
                        + "</dl>\n"
                        + "</body>\n"
                        + "</html>");;

                salidaData.close();
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {

        }
    }
}

