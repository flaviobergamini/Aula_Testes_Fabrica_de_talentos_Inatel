package br.inatel.banco.tests;

import br.inatel.banco.services.ContaCorrenteService;
import br.inatel.banco.services.ContaPoupancaService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ContaTest {
    ContaCorrenteService cc;
    ContaPoupancaService cp;

    @Before
    public void setup(){
        cc = new ContaCorrenteService("1234", "12345678-9");
        cp = new ContaPoupancaService("4321", "98765432-1");
    }

    @Test
    public void ContaCorrentePagarCredito_Ok(){
        boolean verifica = cc.pagarCredito(10);
        assertEquals(true, verifica);
    }

    @Test
    public void ContaCorrentePagarCredito_Error(){
        assertEquals(false, cc.pagarCredito(-10));
    }

    @Test
    public void contaPoupancaAdicionaRendimento_Ok(){
        cp.depositoConta(5600, "teste");
        cp.adicionaRendimento();
        assertEquals(56.0, cp.consultaRendimento(), 0);
    }
}
