/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Modelo_Sucursal;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sergio Burga
 */
public class SucursalDAOTest {
    
    public SucursalDAOTest() {
    }

    // Datos de prueba con assertTrue
    @Test
    public void testInsertSucursal() {
        System.out.println("insertSucursal");
        String cod_sucursal = "001";
        String RUC = "12345678901";
        String departamento = "Lima";
        String Direccion = "Av. Siempre Viva 123";
        String telefono = "987654321";
        SucursalDAO instance = new SucursalDAO();
        String result = instance.insertSucursal(cod_sucursal, RUC, departamento, Direccion, telefono);
        assertTrue(result.equals("Registro Exitoso"));
    }

    @Test
    public void testListSucursal() {
        System.out.println("listSucursal");
        SucursalDAO instance = new SucursalDAO();
        ArrayList<Sucursal> expResult = null;
        ArrayList<Sucursal> result = instance.listSucursal();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEditarSucursal() {
        System.out.println("EditarSucursal");
        String cod_sucursal = "";
        String RUC = "";
        String departamento = "";
        String Direccion = "";
        String telefono = "";
        SucursalDAO instance = new SucursalDAO();
        int expResult = 0;
        int result = instance.EditarSucursal(cod_sucursal, RUC, departamento, Direccion, telefono);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEliminarSucursal() {
        System.out.println("EliminarSucursal");
        String cod_sucursal = "001";
        SucursalDAO instance = new SucursalDAO();
        int expResult = 0;
        int result = instance.EliminarSucursal(cod_sucursal);
        assertFalse(result > 0);
    }

    @Test
    public void testBuscarSucursalxDepartamento() {
        System.out.println("BuscarSucursalxDepartamento");
        String departamento = "";
        SucursalDAO instance = new SucursalDAO();
        ArrayList<Sucursal> expResult = null;
        ArrayList<Sucursal> result = instance.BuscarSucursalxDepartamento(departamento);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
