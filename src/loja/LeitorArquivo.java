package loja;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorArquivo {
    // Le um arquivo.txt e retorna um vetor de Strings
    // onde cada indice é uma linha do arquivo
    public static String[] lerArquivo(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String[] registros;
        String arquivo = "";
        String registro = buffRead.readLine();
        
        while (true) {
            if (registro != null) {
                arquivo += registro + ";";
            } else {
                break;
            }
            registro = buffRead.readLine();
        }
        buffRead.close();
        
        registros = arquivo.split("[;]");
        
        return registros;
    }
}
