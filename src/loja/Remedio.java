package loja;

public class Remedio {
    private int codigo;
    private String nome;
    private double preco;
    private String classe;
    private String manuseio;

    // Método Construtor
    public Remedio(int codigo, String nome, double preco, String classe, String manuseio) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.classe = classe;
        this.manuseio = manuseio;
    }
    
    // Listar as informações do Medicamento
    public void mostrarInfo() {
        System.out.printf("Codigo: \t%s\n", this.codigo);
        System.out.printf("Nome:   \t%s\n", this.nome);
        System.out.printf("Preco:   \tR$%.2f\n", this.preco);
        System.out.printf("Classe: \t%s\n", this.classe);
        System.out.printf("Manuseio: \t%s\n", this.manuseio);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getManuseio() {
        return manuseio;
    }

    public void setManuseio(String manuseio) {
        this.manuseio = manuseio;
    }
}
