package loja;

import java.io.IOException;
import java.util.List;

public class Controlado extends Remedio {
    private String classificacao;

    // Método Construtor
    public Controlado(int codigo, String nome, double preco, String classe, String manuseio, String classificacao) {
        super(codigo, nome, preco, classe, manuseio);
        this.classificacao = classificacao;
    }
    
    // Sobreescrevendo o método mostrarInfo() da classe Pai
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.printf("Receituario: %s\n", this.classificacao);
    }
    
    // Preenche um lista vazia de medicamentos controlados com os dados de um arquivo.txt
    public static void preencherListaControlados(List<Controlado> controlados, String path) throws IOException {
        String[] registros = LeitorArquivo.lerArquivo(path);
        for (String registro : registros) {
            String[] tupla = registro.split("[|]");
            Controlado controlado = new Controlado(
                    Integer.parseInt(tupla[0]),
                    tupla[1],
                    Double.parseDouble(tupla[2]),
                    tupla[3],
                    tupla[4],
                    tupla[5]
            );
            controlados.add(controlado);
        }
    }
}
