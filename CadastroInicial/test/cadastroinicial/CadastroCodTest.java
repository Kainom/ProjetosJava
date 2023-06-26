/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package cadastroinicial;

import java.awt.event.ActionEvent;
import javax.swing.event.ChangeEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */
public class CadastroCodTest {
    
    public CadastroCodTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of configurarJanela method, of class CadastroCod.
     */
    @Test
    public void testConfigurarJanela() {
        System.out.println("configurarJanela");
        CadastroCod instance = new CadastroCod();
        instance.configurarJanela();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of configurarJPanelDados method, of class CadastroCod.
     */
    @Test
    public void testConfigurarJPanelDados() {
        System.out.println("configurarJPanelDados");
        CadastroCod instance = new CadastroCod();
        instance.configurarJPanelDados();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dados method, of class CadastroCod.
     */
    @Test
    public void testDados() {
        System.out.println("dados");
        CadastroCod instance = new CadastroCod();
        instance.dados();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actionPerformed method, of class CadastroCod.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent sexo = null;
        CadastroCod instance = new CadastroCod();
        instance.actionPerformed(sexo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stateChanged method, of class CadastroCod.
     */
    @Test
    public void testStateChanged() {
        System.out.println("stateChanged");
        ChangeEvent idade = null;
        CadastroCod instance = new CadastroCod();
        instance.stateChanged(idade);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ValidaCampos method, of class CadastroCod.
     */
    @Test
    public void testValidaCampos() {
        System.out.println("ValidaCampos");
        CadastroCod instance = new CadastroCod();
        int expResult = 0;
        int result = instance.ValidaCampos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
