package loja;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int cpf;
    private String nome;
    private int idade;
    private char sexo;
    private List<Receita> receitas;

    // Método Construtor
    public Cliente(int cpf, String nome, int idade, char sexo) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.receitas = new ArrayList<>();
    }

    // Lista as informações do Cliente e de suas Receitas
    public void mostrarInfo() {
        System.out.println("Nome: \t" + this.nome);
        System.out.println("CPF: \t" + this.cpf);
        System.out.println("Idade: \t" + this.idade);
        System.out.println("Sexo: \t" + this.sexo);
        System.out.println("N° de Receitas: " + this.receitas.size());
    }
    
    // Mostra a média de idades dos clientes
    public static void mediaDeIdades(List<Cliente> clientes) {
        int tamanhoLista = clientes.size();
        double soma = 0;
        for (int i = 0; i < tamanhoLista; i++) {
            soma = soma + clientes.get(i).idade;
        }
        double media = soma / tamanhoLista;
       
        System.out.printf("Media: %.2f\n", media);
    }
    
    // Preenche um lista vazia de clientes com os dados de um arquivo.txt
    public static void preencherListaClientes(List<Cliente> clientes, String path) throws IOException {
        String[] registros = LeitorArquivo.lerArquivo(path);
        for (String registro : registros) {
            String[] tupla = registro.split("[|]");
            Cliente cliente = new Cliente(
                    Integer.parseInt(tupla[0]),
                    tupla[1],
                    Integer.parseInt(tupla[2]),
                    tupla[3].charAt(0)
            );
            clientes.add(cliente);
        }
    }

    public void addReceita(Receita receita) {
        this.receitas.add(receita);
    }

    public int numReceitas() {
        return this.receitas.size();
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

}
