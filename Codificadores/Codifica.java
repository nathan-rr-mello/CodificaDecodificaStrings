package Codificadores;

public interface Codifica {
    // Retorna o autor do codificador
    String getNomeAutor();

    // Retorna a matrícula do autor do codificador
    String getMatriculaAutor();

    // Recebe um string e retorna o correspondente codificado
    String codifica(String str);

    // Recebe um string codificado e retorna o correspondente decodificado
    String decodifica(String str);
}