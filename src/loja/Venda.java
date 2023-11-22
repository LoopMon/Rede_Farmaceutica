package loja;

import java.util.List;

public class Venda {
    private int codigo;
    private Cliente cliente;
    private boolean foiPaga;
    private ItensVenda itensVenda;
    private double precoTotal;

    // Método Construtor
    public Venda(int codigo, Cliente cliente, boolean foiPaga, ItensVenda itensVenda) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.foiPaga = foiPaga;
        this.itensVenda = itensVenda;
        this.precoTotal = this.itensVenda.calcularPrecoTotal();
    }

    // Listar as informações da Venda e de seus itens
    public void mostrarInfoVenda() {
        System.out.printf("Codigo: \t%s\n", this.codigo);
        System.out.printf("Cliente: \t%s\n", this.cliente.getNome());
        System.out.printf("Foi paga: \t%s\n", this.foiPaga);
        System.out.printf("Total:  \tR$%.2f\n", this.precoTotal);
        System.out.println("Itens da Venda: ");
        this.itensVenda.mostrarItens();
    }

    // Mostrar os clientes que estão:
    // - Inadimplentes
    // - Adimplentes
    public static void mostrarSituacaoVendas(List<Venda> vendas) {
        System.out.println("Vendas pendentes:");
        for (int i = 0; i < vendas.size(); i++) {
            if (vendas.get(i).foiPaga == false) {
                System.out.printf("   - %s,\t", vendas.get(i).cliente.getNome());
                System.out.println("Cod. compra: " + vendas.get(i).codigo);
            }
        }
        System.out.println("Vendas concluidas:");
        for (int i = 0; i < vendas.size(); i++) {
            if (vendas.get(i).foiPaga == true) {
                System.out.printf("   - %s,\t", vendas.get(i).cliente.getNome());
                System.out.println("Cod. compra: " + vendas.get(i).codigo);
            }
        }
    }

    // Mostra o total vendido da Farmácia (soma de todas as vendas)
    public static void mostrarTotalVendido(List<Venda> vendas) {
        double totalVendido = 0;
        for (int i = 0; i < vendas.size(); i++) {
            totalVendido = totalVendido + vendas.get(i).precoTotal;
        }
        System.out.printf("Total Vendido: R$%.2f\n", totalVendido);
    }
    
    // Calcula o total vendido por sexo
    public static void listarTotalVendidoPorSexo(List<Venda> vendas) {
        double totalFem = 0;
        double totalMasc = 0;
        for (Venda venda : vendas) {
            if (venda.cliente.getSexo() == 'm') {
                totalMasc += venda.precoTotal;
            } else {
                totalFem += venda.precoTotal;
            }
        }
        System.out.println("Total vendido por sexo:");
        System.out.println("Maculino: R$" + totalMasc);
        System.out.println("Feminino: R$" + totalFem);
    }
    
    public ItensVenda getItemVenda() {
        return this.itensVenda;
    }
}
