package loja;

import java.io.IOException;
import java.util.List;

public class Receita {
    private int codigo;
    private char tipo;
    private Controlado remedio;
    
    // Método Construtor
    public Receita(int codigo, char tipo){
        this.codigo = codigo;
        this.tipo = tipo;
    }
    
    // Listar as informações da Receita e o Medimento da mesma
    public void mostrarInfo() {
        System.out.println("Codigo: \t" + this.codigo);
        System.out.println("Tipo: \t" + this.tipo);
        System.out.println("Medicamento: \t" + this.remedio.getNome());
    }
    
    public void adicionarRemedio(Controlado remedio){
        this.remedio = remedio;     
    }
    
    public Controlado getRemedio(){
        return this.remedio;
    }
    
    // Preenche um lista vazia de receitas com os dados de um arquivo.txt
    // E os medicamentos pertencentes a ela
    public static void preencherListaReceitas(List<Receita> receitas, List<Controlado> controlados, String path) throws IOException {
        String[] registros = LeitorArquivo.lerArquivo(path);
        int indice = 0;
        for (String registro : registros) {
            String[] tupla = registro.split("[|]");
            Receita receita = new Receita(
                    Integer.parseInt(tupla[0]),
                    tupla[1].charAt(0)
            );
            
            receita.adicionarRemedio(controlados.get(indice));
            indice++;
            
            receitas.add(receita);
        }
    }
}
