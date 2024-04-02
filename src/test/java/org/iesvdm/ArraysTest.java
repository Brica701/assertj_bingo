package org.iesvdm;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ArraysTest {

    @Test
    public void limpiar_deberia_devolver_array_vacio() {
        // Arrange
        int[] expected = {};

        // Act
        int[] result = UtilesArrays.limpiar();

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void rellenar_deberia_devolver_array_de_ceros() {
        // Arrange
        int[] expected = {0, 0, 0, 0, 0};
        int[] array = new int[5];

        // Act
        int[] result = UtilesArrays.rellenar(array, 5);

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void rellenar_deberia_devolver_array_con_valor_indicado() {
        // Arrange
        int[] expected = {5, 5, 5, 5, 5};
        int[] array = new int[5];
        int valor = 5;

        // Act
        int[] result = UtilesArrays.rellenar(array, 5, valor);
        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void insertarAlFinal_deberia_insertar_elemento_al_final_del_array() {
        // Arrange
        int[] array = {1, 2, 3};
        int elemento = 4;
        int[] expected = {1, 2, 3, 4};

        // Act
        int[] result = UtilesArrays.insertarAlFinal(array, elemento);

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void insertarEnPosicion_deberia_insertar_elemento_en_posicion_indicada() {
        // Arrange
        int[] array = {1, 2, 3};
        int elemento = 4;
        int posicion = 1;
        int[] expected = {1, 4, 2, 3};
        // Act
        int[] result = UtilesArrays.insertarEnPosicion(array, elemento, posicion);

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void insertarOrdenado_deberia_insertar_elemento_ordenado_en_array() {
        // Arrange
        int[] array = {1, 3, 5};
        int elemento = 4;
        int[] expected = {1, 3, 4, 5};

        // Act
        int[] result = UtilesArrays.insertarOrdenado(array, elemento);

        // Assert
        assertArrayEquals(expected, result);
    }
    @Test
    public void eliminarUltimo_deberia_eliminar_ultima_posicion_del_array() {
        // Arrange
        int[] array = {1, 2, 3};
        int[] expected = {1, 2};

        // Act
        int[] result = UtilesArrays.eliminarUltimo(array);

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void eliminarUltimo_deberia_retornar_mismo_array_si_esta_vacio() {
        // Arrange
        int[] array = {};

        // Act
        int[] result = UtilesArrays.eliminarUltimo(array);

        // Assert
        assertArrayEquals(array, result);
    }

    @Test
    public void eliminarPrimero_deberia_eliminar_primera_posicion_del_array() {
        // Arrange
        int[] array = {1, 2, 3};
        int[] expected = {2, 3};

        // Act
        int[] result = UtilesArrays.eliminarPrimero(array);

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void eliminarPrimero_deberia_retornar_mismo_array_si_esta_vacio() {
        // Arrange
        int[] array = {};

        // Act
        int[] result = UtilesArrays.eliminarPrimero(array);

        // Assert
        assertArrayEquals(array, result);
    }

    @Test
    public void testEliminar() {
        int[] array = {1, 2, 3, 4, 5};
        int elemento = 3;
        int[] resultadoEsperado = {1, 2, 4, 5};

        int[] resultadoObtenido = UtilesArrays.eliminar(array, elemento);

        assertArrayEquals(resultadoEsperado, resultadoObtenido);
    }

    @Test
    public void testEliminarElementoNoPresente() {
        int[] array = {1, 2, 3, 4, 5};
        int elemento = 6;
        int[] resultadoEsperado = {1, 2, 3, 4, 5};

        int[] resultadoObtenido = UtilesArrays.eliminar(array, elemento);

        assertArrayEquals(resultadoEsperado, resultadoObtenido);
    }

}
