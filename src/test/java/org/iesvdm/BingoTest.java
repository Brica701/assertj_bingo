package org.iesvdm;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
public class BingoTest {

    @Test
    public void testPonerBlancos() {
        int[][] carton = new int[9][3];

        Bingo.ponerBlancos(carton);


        int blancosCount = 0;
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[0].length; j++) {
                if (carton[i][j] == -1) {
                    blancosCount++;
                }
            }
        }


    }

    @Test
    public void testRellenarNumerosCarton() {
        int[][] carton = new int[8][3];


        Bingo.rellenarNumerosCarton(carton);


        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[0].length; j++) {
                assertNotEquals(0, carton[i][j], "El cartón no debería tener espacios en blanco");
            }
        }


        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[0].length; j++) {
                assertTrue(carton[i][j] >= (i * 10)  && carton[i][j] <= (i * 10) + 9, "Número fuera del rango en la columna " + i);
            }
        }


        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[0].length - 1; j++) {
                assertTrue(carton[i][j] <= carton[i][j + 1], "Los números no están ordenados en la columna " + i);
            }
        }
    }

    @Test
    public void testBuscarFila() {
        int[][] carton = {
                {1, 2, 3},
                {4, -1, 6},
                {7, 8, 9}
        };


        assertTrue(Bingo.buscarFila(carton, 1, 1), "La posición (1, 1) debería contener -1");


        assertFalse(Bingo.buscarFila(carton, 0, 0), "La posición (0, 0) no debería contener -1");

        assertFalse(Bingo.buscarFila(carton, 2, 0), "La posición (2, 0) no debería contener -1");
    }

    @Test
    public void testBuscarColumna() {
        int[][] carton = {
                {1, -1, 3},
                {4, -1, 6},
                {7, 8, 9}
        };

        assertFalse(Bingo.buscarColumna(carton, 1), "La columna 1 debería tener dos blancos (-1)");

        assertFalse(Bingo.buscarColumna(carton, 0), "La columna 0 no debería tener dos blancos (-1)");

        assertFalse(Bingo.buscarColumna(carton, 2), "La columna 2 no debería tener dos blancos (-1)");
    }

    @Test
    public void testBuscarValorRepetido() {
        int[] array = {1, 2, 3, 4, 5};

        assertTrue(Bingo.buscarValorRepetido(array, 3), "El valor 3 debería estar presente en el array");

        assertFalse(Bingo.buscarValorRepetido(array, 6), "El valor 6 no debería estar presente en el array");
    }

    @Test
    public void testInsertarAlFinal() {
        int[] array = {1, 2, 3, 4};

        int elemento = 5;
        int[] nuevoArray = Bingo.insertarAlFinal(array, elemento);

        assertEquals(array.length + 1, nuevoArray.length, "La longitud del nuevo array no es la esperada");

        assertEquals(elemento, nuevoArray[nuevoArray.length - 1], "El elemento no fue insertado al final del nuevo array");
    }
    @Test
    public void testOrdenar() {
        int[] array = {5, 2, 8, 1, 4};

        int[] arrayOrdenado = Bingo.ordenar(array);

        int[] arrayEsperado = {1, 2, 4, 5, 8};
        assertArrayEquals(arrayEsperado, arrayOrdenado, "El array no está ordenado correctamente");
    }
}
