package loja;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        
        // Coleção de objetos para agrupar os objetos
        List<Cliente> clientes = new ArrayList<>();
        List<Controlado> controlados = new ArrayList<>();
        List<MIP> mips = new ArrayList<>();
        List<Receita> receitas = new ArrayList<>();
        
        // Preenchimento das listas com dados de arquivos.txt
        // Inserção de Dados
        Cliente.preencherListaClientes(clientes, "dados/clientes.txt");
        Controlado.preencherListaControlados(controlados, "dados/medicamentosControlados.txt");
        MIP.preencherListaMIPs(mips, "dados/mips.txt");
        Receita.preencherListaReceitas(receitas, controlados, "dados/receitas.txt");
        
        // Criação do relacionamento entre um cliente e n receitas (1, n)
        clientes.get(0).addReceita(receitas.get(0));
        clientes.get(0).addReceita(receitas.get(1));
        clientes.get(1).addReceita(receitas.get(2));
        clientes.get(1).addReceita(receitas.get(3));
        clientes.get(2).addReceita(receitas.get(4));
        clientes.get(2).addReceita(receitas.get(5));
        clientes.get(3).addReceita(receitas.get(6));
        clientes.get(3).addReceita(receitas.get(7));
        clientes.get(4).addReceita(receitas.get(8));
        clientes.get(4).addReceita(receitas.get(9));
        clientes.get(5).addReceita(receitas.get(10));
        clientes.get(5).addReceita(receitas.get(11));
        
        // Criando os Itens de Venda e adicionando Itens na Venda
        // Itens da venda 1
        ItensVenda itensVenda1 = new ItensVenda();
        itensVenda1.addItem(mips.get(0));
        itensVenda1.addItem(mips.get(1));
        itensVenda1.addItem(receitas.get(0));
        itensVenda1.addItem(receitas.get(1));
        itensVenda1.addItem(receitas.get(8));
        // Itens da venda 2
        ItensVenda itensVenda2 = new ItensVenda();
        itensVenda2.addItem(mips.get(2));
        itensVenda2.addItem(mips.get(3));
        itensVenda2.addItem(receitas.get(2));
        itensVenda2.addItem(receitas.get(3));
        itensVenda2.addItem(receitas.get(9));
        // Itens da venda 3
        ItensVenda itensVenda3 = new ItensVenda();
        itensVenda3.addItem(mips.get(4));
        itensVenda3.addItem(mips.get(5));
        itensVenda3.addItem(receitas.get(4));
        itensVenda3.addItem(receitas.get(5));
        itensVenda3.addItem(receitas.get(10));
        // Itens da venda 4
        ItensVenda itensVenda4 = new ItensVenda();
        itensVenda4.addItem(mips.get(6));
        itensVenda4.addItem(receitas.get(6));
        itensVenda4.addItem(receitas.get(7));
        itensVenda4.addItem(receitas.get(11));
        
        // Criando as Vendas a apartir dos itens de venda
        Venda venda1 = new Venda(1, clientes.get(0), false, itensVenda1);
        Venda venda2 = new Venda(2, clientes.get(0), true, itensVenda2);
        Venda venda3 = new Venda(3, clientes.get(1), true, itensVenda3);
        Venda venda4 = new Venda(4, clientes.get(2), false, itensVenda4);
        
        // Agrupando as Vendas 
        List<Venda> vendas = new ArrayList<>();
        vendas.add(venda1);
        vendas.add(venda2);
        vendas.add(venda3);
        vendas.add(venda4);
        
        // =-=-=-=-= MENU DO SISTEMA =-=-=-=-=
        byte opcao = 0;
        do {
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("\t  \u001B[32mRede Farmaceutica\u001B[0m");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Listar dados de: ");
            System.out.println("  1- Clientes");
            System.out.println("  2- Vendas");
            System.out.println("  3- Receitas");
            System.out.println("  4- MIPs");
            System.out.println("  5- Mc");
            System.out.println("Relatorios:");
            System.out.println("  6- Clientes Adim. e Inadim.");
            System.out.println("  7- Mostrar n° de medicamentos vendidos em forma:");
            System.out.println("        + Liquido");
            System.out.println("        + Pilula");
            System.out.println("  8- Total vendido por sexo: ");
            System.out.println("        + masculino");
            System.out.println("        + feminino");
            System.out.println("0- Sair do programa");
            System.out.print(">> ");
            // ler a opcao do usuario
            opcao = input.nextByte();
            
            switch(opcao) {
                // Listar clientes
                case 1 -> {
                    int cont = 1;
                    for (Cliente cliente : clientes) {
                        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                        System.out.println("\t      \u001B[33mCliente " + cont);
                        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                        cliente.mostrarInfo();
                        cont++;
                    }
                }
                // Listar vendas
                case 2 -> {
                    int cont = 1;
                    for (Venda venda : vendas) {
                        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                        System.out.println("\t      \u001B[33mVenda " + cont);
                        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                        venda.mostrarInfoVenda();
                        cont++;
                    }
                }
                // Listar receitas medicas
                case 3 -> {
                    int cont = 1;
                    for (Receita receita : receitas) {
                        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                        System.out.println("\t      \u001B[33mReceita " + cont);
                        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                        receita.mostrarInfo();
                        cont++;
                    }
                }
                // Listar medicamentos isentos de prescricao medica
                case 4 -> {
                    int cont = 1;
                    for (MIP mip : mips) {
                        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                        System.out.println("\t\u001B[33mMed. s/ presc. Medica " + cont);
                        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                        mip.mostrarInfo();
                        cont++;
                    }
                }
                // Listar medicamentos que necessitam prescricao medica
                case 5 -> {
                    int cont = 1;
                    for (Controlado controlado : controlados) {
                        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                        System.out.println("\t\u001B[33mMed. c/ presc. Medica " + cont);
                        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                        controlado.mostrarInfo();
                        cont++;
                    }
                }
                // Listar clientes Adimplentes e Inadimplentes
                case 6 -> {
                    Venda.mostrarSituacaoVendas(vendas);
                }
                // Listar Medicamentos vendidos em forma de:
                // Pilula e Liquida
                case 7 -> {
                    int nLiquido = 0, nPilula = 0;
                    for (Venda venda : vendas) {
                        nLiquido += venda.getItemVenda().numRemPorManuseioLiquido();
                        nPilula += venda.getItemVenda().numRemPorManuseioPilula();
                    }
                    System.out.println("Medicamentos vendidos em forma:");
                    System.out.println("   Liquida: " + nLiquido);
                    System.out.println("   Pilula: " + nPilula);
                }
                // Listar total vendido por sexo
                case 8 -> {
                    Venda.listarTotalVendidoPorSexo(vendas);
                }
                // Finalizar o programa
                case 0 -> {
                    System.out.println("\u001B[35mFim do Programa!!!\u001B[0m");
                }
                // Opcao invalida
                default -> {
                    System.err.println("Opcao invalida!!!");
                }
            }
        } while(opcao != 0);
    }
}