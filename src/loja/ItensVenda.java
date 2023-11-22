package loja;

import java.util.ArrayList;
import java.util.List;

public class ItensVenda {
    private List<Remedio> itens;

    // Método Construtor
    public ItensVenda() {
        this.itens = new ArrayList<>();
    }
    
    // Listar as informações de cada Item da venda
    public void mostrarItens() {
        for (Remedio item : this.itens) {
            System.out.printf("    Cod.: %s, ", item.getCodigo());
            System.out.printf("Nome: %s, Preco: R$%.2f\n", item.getNome(), item.getPreco());
        }
    }

    // Retorna o preço total da venda (soma de todos os itens)
    public double calcularPrecoTotal() {
        double soma = 0;
        for (Remedio item : this.itens) {
            soma += item.getPreco();
        }
        return soma;
    }
    
    // Retorna a quantidade de medicamentos na venda
    // por manuseio:
    // - medicamentos liquidos
    public int numRemPorManuseioLiquido() {
        int numeroRemediosLiquido = 0;
        for (Remedio item : itens) {
            if (item.getManuseio().equals("liquido")) {
                numeroRemediosLiquido++;

            } 
        }
        return numeroRemediosLiquido;
    }
    
    // Retorna a quantidade de medicamentos na venda
    // por manuseio:
    // - medicamentos em pilula
    public int numRemPorManuseioPilula() {
        int numeroRemediosPilula = 0;
        for (Remedio item : itens) {
            if (item.getManuseio().equals("pilula")) {
                numeroRemediosPilula++;
            } 
        }
        return numeroRemediosPilula;
    }
    
    // Adicionar medicamento isento de prescricao medica
    public void addItem(Remedio remedio) {
        this.itens.add(remedio);
    }
    // Adicionar medicamento que necessita de prescricao medica
    public void addItem(Receita receita) {
        this.itens.add(receita.getRemedio());
    }
}
