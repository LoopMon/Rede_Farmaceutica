package loja;

import java.io.IOException;
import java.util.List;

public class MIP extends Remedio {
    private String solucaoParaSintomaSimples;

    // Método Construtor
    public MIP(int codigo, String nome, double preco, String classe, String manuseio, String solucaoParaSintomaSimples) {
        super(codigo, nome, preco, classe, manuseio);
        this.solucaoParaSintomaSimples = solucaoParaSintomaSimples;
    }

    // Reescrita do método mostrarInfo() da classe Pai
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.printf("Solução Simples: %s\n", this.solucaoParaSintomaSimples);
    }
    
    // Preenche um lista vazia de medicamentos sem prescrição médica com os dados de um arquivo.txt
    public static void preencherListaMIPs(List<MIP> mips, String path) throws IOException {
        String[] registros = LeitorArquivo.lerArquivo(path);
        for (String registro : registros) {
            String[] tupla = registro.split("[|]");
            MIP mip = new MIP(
                    Integer.parseInt(tupla[0]),
                    tupla[1],
                    Double.parseDouble(tupla[2]),
                    tupla[3],
                    tupla[4],
                    tupla[5]
            );
            mips.add(mip);
        }
    }
}
