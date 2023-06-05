package com.mycompany.taller2;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class Encode {
    public static void main(String[]args) throws IOException {
        // Cargar la imagen desde un archivo
        BufferedImage imagen = ImageIO.read(new File("image.jpg"));

        Scanner teclado = new Scanner(System.in);

        //Guardar mensaje en matriz
        System.out.println("¿Qué frase desea ocultar?");
        String mensaje = teclado.nextLine();

        int filas = (int) Math.ceil((double) mensaje.length() * 8 / 3); // Obtener el número de filas necesario
        int columnas = 3;
        char[][] matriz = new char[filas][columnas];

// Guardar los bits individuales en la matriz
        int fila = 0;
        int columna = 0;
        for (int i = 0; i < mensaje.length(); i++) {
            char letra = mensaje.charAt(i);
            String binario = String.format("%8s", Integer.toBinaryString(letra)).replace(' ', '0');
            for (int j = 0; j < binario.length(); j++) {
                matriz[fila][columna] = binario.charAt(j);
                columna++;
                if (columna >= columnas) {
                    columna = 0;
                    fila++;
                }
            }
        }

        int numero_filas= matriz.length;
        //Obtiene las dimensiones de la imagen
        int alto = imagen.getHeight();
        int ancho = imagen.getWidth();

        for(int y=0; y<alto;y++){
            for(int x=0; x<ancho;x++){

                //Obtiene los valores del Pixel
                int Pixel = imagen.getRGB(x,y);
                Color c = new Color(Pixel);

                //Crea la mascara para comparar los bits
                int mascara = 0xFE;


                //Reccorre la fila actual de la matriz para guardar los bits en cada valor RGB
                for(int i =0;i<matriz.length;i++){
                    for(int j=0;j<matriz[i].length;j++){

                        //Se crean 3 situaciones= Dependiendo del largo del mensaje existe la posibilidad de que la última fila de la matriz de bits
                        //este incompleta, es decir, tenga solo 2 o 1 bit guardado, entonces para evitar errores en el codigo,
                        //se prepara la situacion de que última fila solo tenga 1 elemento o 2, el resto de veces siempre pasará por la opción 3,
                        //en la que la fila 3 está llena
                        if(matriz[i].length==1){
                            int colorR = c.getRed();
                            char bitChar = matriz[i][j];
                            int bit = Character.getNumericValue(bitChar);
                            int nuevoColorR = (colorR & mascara) | bit;
                            int colorG = c.getGreen();
                            int colorB = c.getBlue();
                            int nuevoPixel = (nuevoColorR << 16) | (colorG << 8) | colorB;
                            imagen.setRGB(x, y, nuevoPixel);
                            break;
                        }
                        else if(matriz[i].length==2){
                            if(j==0){
                                int colorR = c.getRed();
                                char bitChar = matriz[i][j];
                                int bit = Character.getNumericValue(bitChar);
                                int nuevoColorR = (colorR & mascara) | bit;
                                int colorG = c.getGreen();
                                int colorB = c.getBlue();
                                int nuevoPixel = (nuevoColorR << 16) | (colorG << 8) | colorB;
                                imagen.setRGB(x, y, nuevoPixel);
                            }
                            if(j==1){
                                int colorG = c.getGreen();
                                char bitChar = matriz[i][j];
                                int bit = Character.getNumericValue(bitChar);
                                int nuevoColorG = (colorG & mascara) | bit;
                                int colorR = c.getRed();
                                int colorB = c.getBlue();
                                int nuevoPixel = (colorR << 16) | (nuevoColorG << 8) | colorB;
                                imagen.setRGB(x, y, nuevoPixel);
                                break;
                            }
                        }
                        else if(matriz[i].length==3){
                            if(j==0){
                                int colorR = c.getRed();
                                char bitChar = matriz[i][j];
                                int bit = Character.getNumericValue(bitChar);
                                int nuevoColorR = (colorR & mascara) | bit;
                                int colorG = c.getGreen();
                                int colorB = c.getBlue();
                                int nuevoPixel = (nuevoColorR << 16) | (colorG << 8) | colorB;
                                imagen.setRGB(x, y, nuevoPixel);
                            }
                            if(j==1){
                                int colorG = c.getGreen();
                                char bitChar = matriz[i][j];
                                int bit = Character.getNumericValue(bitChar);
                                int nuevoColorG = (colorG & mascara) | bit;
                                int colorR = c.getRed();
                                int colorB = c.getBlue();
                                int nuevoPixel = (colorR << 16) | (nuevoColorG << 8) | colorB;
                                imagen.setRGB(x, y, nuevoPixel);
                            }
                            if(j==2&&(i==(numero_filas-1))){
                                int colorB = c.getBlue();
                                char bitChar = matriz[i][j];
                                int bit = Character.getNumericValue(bitChar);
                                int nuevoColorB = (colorB & mascara) | bit;
                                int colorR = c.getRed();
                                int colorG = c.getGreen();
                                int nuevoPixel = (colorR << 16) | (colorG << 8) | nuevoColorB;
                                imagen.setRGB(x, y, nuevoPixel);
                                break;
                            }
                            if(j==2){
                                int colorB = c.getBlue();
                                char bitChar = matriz[i][j];
                                int bit = Character.getNumericValue(bitChar);
                                int nuevoColorB = (colorB & mascara) | bit;
                                int colorR = c.getRed();
                                int colorG = c.getGreen();
                                int nuevoPixel = (colorR << 16) | (colorG << 8) | nuevoColorB;
                                imagen.setRGB(x, y, nuevoPixel);
                            }
                        }
                    }
                }
            }
        }
        ImageIO.write(imagen, "png", new File("imagen.png"));
    }
}
