import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

// En esta clase generaremos los datos simulados por GPS para varios autobuses
public class GeneradorDatosGPS {
    // Asignacion de IDs de los autobuses
    private static final String[] AUTOBUSES = {"BUS01", "BUS02", "BUS03"};

    // Cantidad de minutos que se simulan por autobus
    private static final int MINUTOS = 60;

    // Nombre del archivo donde se guardaran los datos
    private static final String ARCHIVO_SALIDA = "src/datos_gps.csv";

    public static void main(String[] args) {
        try (FileWriter escritor = new FileWriter(ARCHIVO_SALIDA)) {
            // Encabezado del archivo
            escritor.write("idAutobus,marcaTiempo,latitud,longitud,velocidad\n");

            // Definir la hora de inicio de la simulacion
            LocalDateTime inicio = LocalDateTime.of(2025, 3, 25, 8, 0);
            DateTimeFormatter formato = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

            // Generador de numeros aeatorios
            Random aleatorio = new Random();

            for (String autobus : AUTOBUSES) {
                // Posicion inicial
                double latitud = 40.4172;
                double longitud = -3.7045;

                // Genaracion de los datos por minuto
                for (int i = 0; i < MINUTOS; i++) {
                    LocalDateTime momento = inicio.plusMinutes(i);

                    //Velocidad aleatoria entre 0 y 50 km/h
                    double velocidad = aleatorio.nextInt(51);

                    // La latitud y longitud cambian, simulando el movimiento
                    latitud += 0.0005 * (aleatorio.nextDouble() - 0.5);
                    longitud += 0.0005 * (aleatorio.nextDouble() - 0.5);

                    // Escribir los datos en el archivo CSV asegurandonos de que sea formato estadounidense para que no salgan comas
                    escritor.write(autobus + "," +
                            momento.format(formato) + "," +
                            String.format(Locale.US, "%.6f", latitud) + "," +
                            String.format(Locale.US, "%.6f", longitud) + "," +
                            velocidad + "\n");
                }
            }
            // Mensaje de confirmación
            System.out.println("Datos GPS simulados guardados en " + ARCHIVO_SALIDA);
        } catch (IOException e) {
            e.printStackTrace(); // En caso de que haya un error
        }
    }
}
