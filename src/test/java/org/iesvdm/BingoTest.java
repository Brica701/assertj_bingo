package org.iesvdm;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class BingoTest {

    @Test
    public void testEnamellerNumerousCarton() {
        int[][] carton = new int[8][3]; // Crear un cartón de 8 columnas y 3 filas

        // Ejecutar el método a probar
        Bingo.rellenarNumerosCarton(carton);

        // Verificar si el cartón está lleno (sin espacios en blanco)
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[0].length; j++) {
                assertNotEquals(String.valueOf(0), carton[i][j], "El cartón no debería tener espacios en blanco");
            }
        }

        // Verificar si los números están en el rango correcto
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[0].length; j++) {
                assertTrue("Número fuera del rango en la columna " + i, carton[i][j] >= (i * 10) + 1 && carton[i][j] <= (i * 10) + 9);
            }
        }

        // Verificar si los números están ordenados en cada columna
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[0].length - 1; j++) {
                assertTrue("Los números no están ordenados en la columna " + i, carton[i][j] <= carton[i][j + 1]);
            }
        }
    }



}
