package br.inatel.banco.tests;

import br.inatel.banco.controller.ManipulaConta;
import br.inatel.banco.services.ContaCorrenteService;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ManipulaContaTest {
    ManipulaConta ManipulaContaFake;

    @Test
    public void depositarValorContaCorrenteTest_Ok(){
        ManipulaContaFake = new ManipulaConta();

        ContaCorrenteService cc = new ContaCorrenteService("1111", "11111111");

        String resultado = ManipulaContaFake.depositarValor(cc, 1500, "PIX");

        assertEquals("Depósito realizado com sucesso", resultado);
    }

    @Test
    public void depositarValorContaCorrenteTest_Error(){
        ManipulaContaFake = new ManipulaConta();

        ContaCorrenteService cc = new ContaCorrenteService("1111", "11111111");

        String resultado = ManipulaContaFake.depositarValor(cc, -1500, "PIX");

        assertEquals("Falha ao realizar depósito", resultado);
    }

    @Test
    public void PagamentoContaCorrenteTest_Ok(){
        ManipulaContaFake = new ManipulaConta();

        ContaCorrenteService cc = new ContaCorrenteService("1111", "11111111");

        ManipulaContaFake.depositarValor(cc, 300, "teste");

        String resultado = ManipulaContaFake.pagamentoConta(cc, 99.90, "Internet");
        assertEquals("Pagamento realizado com sucesso", resultado);
    }

    @Test
    public void PagamentoContaCorrenteTest_Error(){
        ManipulaContaFake = new ManipulaConta();

        ContaCorrenteService cc = new ContaCorrenteService("1111", "11111111");

        ManipulaContaFake.depositarValor(cc, 300, "teste");

        String resultado = ManipulaContaFake.pagamentoConta(cc, 999, "Internet");
        assertEquals("Falha ao realizar pagamento", resultado);
    }
}
