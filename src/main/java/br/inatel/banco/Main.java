package br.inatel.banco;

import br.inatel.banco.services.ContaBaseService;
import br.inatel.banco.services.ContaCorrenteService;
import br.inatel.banco.services.ContaPoupancaService;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------------Inatel Bank----------------");

        ContaCorrenteService ContaCorrente =
                new ContaCorrenteService("1111", "1234567-8");

        ContaPoupancaService ContaPoupanca =
                new ContaPoupancaService("2222", "9876543-1");

        ContaCorrente.pagarConta(70.56, "CEMIG");
        ContaCorrente.depositoConta(300, "PIX");
        ContaCorrente.adicionarCredito(3000);
        ContaCorrente.pagarConta(70.56, "CEMIG");
        ContaCorrente.pagarCredito(100);
        ContaCorrente.consultaEstrato();

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");

        ContaPoupanca.depositoConta(5600, "PIX");
        ContaPoupanca.adicionaRendimento();
        System.out.println("Rendimento: " + ContaPoupanca.consultaRendimento());
        ContaPoupanca.adicionaRendimento();
        System.out.println("Rendimento: " + ContaPoupanca.consultaRendimento());
        ContaPoupanca.pagarConta(99.90, "Internet");
        ContaPoupanca.adicionaRendimento();
        System.out.println("Rendimento: " + ContaPoupanca.consultaRendimento());
        ContaPoupanca.consultaEstrato();
    }
}
