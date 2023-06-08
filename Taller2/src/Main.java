import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, IOException {
        Scanner scanner = new Scanner(System.in);

        String respuesta = args[0];
        String mensajeEntrada= "";
        String nombre_imagen= "";
        String nombre_imagen_final;

        if (args[0]==("encode")) {
            // Crear instancia de Encode y ejecutar el código
            mensajeEntrada=args[1];
            nombre_imagen=args[2];
            nombre_imagen_final=args[3];
            Encode encode = new Encode();
            encode.mainEncode(mensajeEntrada,nombre_imagen,nombre_imagen_final);
        } else if (args[0]==("decode")) {
            // Crear instancia de Decode y ejecutar el código
            nombre_imagen_final=args[1];
            Decode decode = new Decode();
            decode.mainDecode(nombre_imagen_final);
        } else {
            System.out.println("Respuesta inválida. Ingresa 'encode' o 'decode'.");
        }
    }
}