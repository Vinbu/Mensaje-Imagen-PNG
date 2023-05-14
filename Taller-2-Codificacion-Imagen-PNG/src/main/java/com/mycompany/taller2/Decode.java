package com.mycompany.taller2;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Decode {
    public static void main(String[]args) throws IOException {
        // Cargar la imagen desde un archivo
        BufferedImage imagen = ImageIO.read(new File("Ruta archivo"));

// Extraer los tres primeros píxeles
        int color1 = imagen.getRGB(0, 0);
        int color2 = imagen.getRGB(1, 0);
        int color3 = imagen.getRGB(2, 0);

        // Obtener los bits de la letra "A"
        String bits = Integer.toBinaryString((int) 'A');
        bits = String.format("%-8s", bits).replace(' ', '0');

// Aplicar la técnica de sustitución del bit menos significativo
        int mascara = 0xFE;
        int nuevoColor1 = (color1 & mascara) | Integer.parseInt(bits.substring(0, 1));
        int nuevoColor2 = (color2 & mascara) | Integer.parseInt(bits.substring(1, 2));
        int nuevoColor3 = (color3 & mascara) | Integer.parseInt(bits.substring(2, 3));

// Guardar los nuevos valores en los píxeles
        imagen.setRGB(0, 0, nuevoColor1);
        imagen.setRGB(1, 0, nuevoColor2);
        imagen.setRGB(2, 0, nuevoColor3);

// Guardar la imagen con la letra "A" oculta
        ImageIO.write(imagen, "png", new File("Ruta archivo"));



    }






}
