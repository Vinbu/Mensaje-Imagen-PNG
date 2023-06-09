import java.io.IOException;

/**
 * El objetivo de la clase es que el usuario pueda ingresar si desea Codificar [Encode]
 * o Decodificar [Decode] la imagen, y poner los debidos argumentos
 */
public class Main {
    /**
     * @param args [Encode] Es necesario respetar el orden de los argumentos: 1. "Encode" 2."Mensaje a ocultar"
     *             3. "Nombre o ruta de la imagen a codificar" 4. "Nombre o ruta deseada de la nueva imagen generada"
     *             [Decode] Es necesario respetar el orden de los argumentos: 1. "Decode" 2. "Nombre o ruta de la imagen
     *             de la que se quiere extraer el mensaje"
     *             nota 1: el programa posee varios try-catch que preveen posibles errores al momento de ingresar los argumentos
     * @throws IOException arroja error al usuario si es que no ingresa decode o encode
     */
    public static void main(String[] args) throws IOException {
        try {

            String mensajeEntrada = "";
            String nombre_imagen = "";
            String nombre_imagen_final;

            if (args[0].equalsIgnoreCase("encode")) {
                try {
                    // Crear instancia de Encode y ejecutar el código
                    mensajeEntrada = args[1];
                    nombre_imagen = args[2];
                    nombre_imagen_final = args[3];
                    Encode encode = new Encode();
                    encode.mainEncode(mensajeEntrada, nombre_imagen, nombre_imagen_final);
                } catch (Exception e) {
                    System.out.println("Por favor ingrese el/los valor/es faltante/s");
                }
            } else if (args[0].equalsIgnoreCase("decode")) {
                try {
                    // Crear instancia de Decode y ejecutar el código
                    nombre_imagen_final = args[1];
                    Decode decode = new Decode();
                    decode.mainDecode(nombre_imagen_final);
                } catch (Exception e) {
                    System.out.println("Ingrese el nombre de la imagen");
                }
            } else {
                System.out.println("Ingrese si es 'encode' o 'decode'");
            }

        } catch (Exception e) {
            System.out.println("Ingrese si es 'encode' o 'decode'");
        }
    }
}