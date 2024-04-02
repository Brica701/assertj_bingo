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

    @Test
    void testOrdenarArrayDesordenado() {
        int[] array = {3, 1, 5, 2, 4};
        int[] esperado = {1, 2, 3, 4, 5};
        int[] resultado = UtilesArrays.ordenar(array);
        assertArrayEquals(esperado, resultado);
    }

    @Test
    void testDesordenar() {
        int[] array = {1, 2, 3, 4, 5};
        int[] arrayOriginal = Arrays.copyOf(array, array.length);
        UtilesArrays.desordenar(array);

        assertNotEquals(Arrays.toString(arrayOriginal), Arrays.toString(array));
    }

    @Test
    void testInvertirArray() {
        int[] array = {1, 2, 3, 4, 5};
        int[] esperado = {5, 4, 3, 2, 1};
        int[] resultado = UtilesArrays.invertir(array);
        assertArrayEquals(esperado, resultado);
    }

    @Test
    void testImprimirArray() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        int[] array = {1, 2, 3, 4, 5};
        UtilesArrays.imprimir(array);

        assertEquals("\t[1, 2, 3, 4, 5]\n", outputStreamCaptor.toString());
    }

    @Test
    void testArrayOrdenadoAscendente() {
        int[] array = {1, 2, 3, 4, 5};
        assertTrue(UtilesArrays.estaOrdenado(array));
    }

    @Test
    void testArrayOrdenadoDescendente() {
        int[] array = {5, 4, 3, 2, 1};
        assertFalse(UtilesArrays.estaOrdenado(array));
    }

    @Test
    void testArrayDesordenado() {
        int[] array = {3, 1, 5, 2, 4};
        assertFalse(UtilesArrays.estaOrdenado(array));
    }

    @Test
    void testArrayConElementosRepetidos() {
        int[] array = {1, 2, 3, 3, 4, 5};
        assertTrue(UtilesArrays.estaOrdenado(array));
    }

    @Test
    void testArrayVacio() {
        int[] array = {};
        assertTrue(UtilesArrays.estaOrdenado(array));
    }

    @Test
    void testArrayUnicoElemento() {
        int[] array = {1};
        assertTrue(UtilesArrays.estaOrdenado(array));
    }

    @Test
    public void testConcatenarArrays() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};
        int[] expected = {1, 2, 3, 4, 5, 6};

        int[] result = UtilesArrays.concatenarArrays(array1, array2);

        assertArrayEquals(expected, result);
    }
    @Test
    public void testElementosIguales() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        int posicioAComparar = 1;

        boolean expected = true;

        boolean result = UtilesArrays.elementosIguales(array1, array2, posicioAComparar);

        assertEquals(expected, result);
    }

    @Test
    public void testSonIguales() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};

        boolean expected = true;

        boolean result = UtilesArrays.sonIguales(array1, array2);

        assertEquals(expected, result);
    }

    @Test
    public void testPartirPor() {
        int[] array = {1, 2, 3, 4, 5, 6};
        int posicionInicio = 2;
        int posicionCorte = 5;

        int[] expected = {3, 4, 5};

        int[] result = UtilesArrays.partirPor(array, posicionInicio, posicionCorte);

        assertTrue(Arrays.equals(expected, result));
    }
}
