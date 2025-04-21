import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// Esta clase se encarga de leer el archivo CSV y de convertirlo en una lista de objetos
public class LectorDatosGPS {
    // Recibir la ruta al archivo CSV y devuelve una lista de objetos
    public static ArrayList<GPSData> leerDatosGPS(String rutaArchivo) {
        ArrayList<GPSData> listaGPS = new ArrayList<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            lector.readLine(); // Saltar el encabezado del archivo CSV

            // Leer cada linea del archivo
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");

                // Si tiene los 5 campos necesarios, convertimos los valores y creamos el objeto
                if (partes.length == 5) {
                    GPSData dato = new GPSData(
                            partes[0],                      // busId
                            partes[1],                      // timestamp
                            Double.parseDouble(partes[2]),  // latitude
                            Double.parseDouble(partes[3]),  // longitude
                            Double.parseDouble(partes[4])   // speed
                    );
                    //Añadir el objeto a la lista
                    listaGPS.add(dato);
                }
            }
            // Mensaje de confirmación con el numero total de registros leidos
            System.out.println("Se leyeron " + listaGPS.size() + " registros.");
        } catch (IOException e) {
            e.printStackTrace(); // En caso de error
        }

        return listaGPS;
    }
}