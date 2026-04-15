package com.prova.template_cadastro_produtos;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductValidatorTest {

    private ProductValidator validator;

    @Before
    public void setup() {
        // Inicializa o validador antes de cada teste
        validator = new ProductValidator();
    }

    @Test
    public void testIsPriceValid() {
        // Preços válidos
        assertTrue("Deveria aceitar preço válido", validator.isPriceValid("150.50"));
        assertTrue("Deveria aceitar preço inteiro", validator.isPriceValid("200"));

        // Preços inválidos
        assertFalse("Não deveria aceitar zero", validator.isPriceValid("0"));
        assertFalse("Não deveria aceitar número negativo", validator.isPriceValid("-10.50"));
        assertFalse("Não deveria aceitar texto", validator.isPriceValid("abc"));
    }

    @Test
    public void testIsQuantityValid() {
        // Quantidades válidas
        assertTrue("Deveria aceitar quantidade inteira positiva", validator.isQuantityValid("10"));

        // Quantidades inválidas
        assertFalse("Não deveria aceitar zero", validator.isQuantityValid("0"));
        assertFalse("Não deveria aceitar número decimal", validator.isQuantityValid("10.5"));
        assertFalse("Não deveria aceitar texto", validator.isQuantityValid("abc"));
    }

    @Test
    public void testAreFieldsPopulated() {
        // Todos preenchidos
        assertTrue("Deveria retornar true quando tudo está preenchido",
                validator.areFieldsPopulated("Notebook", "NTB123", "3000.00", "5"));

        // Faltando dados
        assertFalse("Deveria retornar false se o nome for vazio",
                validator.areFieldsPopulated("", "NTB123", "3000.00", "5"));
        assertFalse("Deveria retornar false se o preço for nulo",
                validator.areFieldsPopulated("Notebook", "NTB123", null, "5"));
    }
}