import java.io.IOException;

/**
 * El objetivo de la clase es que el usuario pueda ingresar si desea Codificar [Encode]
 * o Decodificar [Decode] la imagen
 * Si el usuario desea Codificar, debe ingresar: java Main encode "Mensaje_para_ocultar" "Nombre_o_ruta _de_imagen" "Nombre_o_ruta _de_imagen_modificada"
 * [Encode] IMPORTANTE respetar el orden: 1. "Mensaje_para_ocultar" 2."Nombre_o_ruta _de_imagen" 3. "Nombre_o_ruta _de_imagen_modificada"
 * Y si desea Decodificar debe ingresar: java Main decode "Nombre_de_imagen_o_ruta" "Mensaje_para_ocultar"
 * Por lo tanto es posible buscar y guardar la imagen escribiendo el nombre de la imagen o
 * escribiendo la ruta de la misma.
 */
public class Main {
    /**
     *
     * @param args El usuario deberia ingresar "decode" y la ruta en donde se encuentra la imagen
     *             o "encode",la ruta de la imagen, además del mensaje a ocultar y la ruta de la imagen nueva
     */
    public static void main(String[] args) throws IOException {
        try {

        String mensajeEntrada= "";
        String nombre_imagen= "";
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
                }
                catch(Exception e){
                    System.out.println("Ingrese el nombre de la imagen");
                }
            }else{
                System.out.println("Ingrese si es 'encode' o 'decode'");
            }

            }catch(Exception e){
            System.out.println("Ingrese si es 'encode' o 'decode'");
        }
    }
}