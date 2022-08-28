package Codificadores;

import java.util.HashMap;
import java.util.Map;

public class Codifica21101366 implements Codifica{

    private String tabela = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz .:úç";

    private Map<Integer, Long> tabelaFib = new HashMap<>();

    /**
     * Gera o n-esimo numero da sequencia de Fibonacci
     * usando recursão e HashMap.
     * @param n indice do numero desejado
     * @return o numero da sequencia correspondente
     */
    private long fib(int n){
        if(tabelaFib.containsKey(n)){
            return tabelaFib.get(n);
        }

        tabelaFib.put(n, fib(n-1) + fib(n-2));

        return tabelaFib.get(n);
    }

    /**
     * Gera uma String codificada deslocando os digitos pelo
     * numero de casas correspondente ao seu indice na sequencia de Fibonacci na tabela e a invertendo.
     * Caso esse indice seja maior que o tamanho da tabela, a tabela será tratada como uma lista circular.
     * @param str String a ser codificada.
     * @return Uma String codificada. 
     */
    @Override
    public String codifica(String str) {
        tabelaFib.put(0,(long) 1);
        tabelaFib.put(1, (long) 1);

        StringBuilder strCodificada = new StringBuilder();

        for(int i = 0; i < str.length(); i++){

            char letra = str.charAt(i);
            long indexToSwitch = fib(i) + tabela.indexOf(letra);

            if(indexToSwitch > tabela.length()-1){
                indexToSwitch %= tabela.length();
                strCodificada.append(tabela.charAt((int)indexToSwitch));
            }else{
                strCodificada.append(tabela.charAt((int)indexToSwitch));
            }
        }

        return strCodificada.reverse().toString();
    }

    /**
     * Descodifica uma String a desenvertendo e deslocando os digitos pelo numero de casas correspondente
     * ao seu indice na sequencia de Fibonacci na tabela, retornando-os a posição original
     * @param str String a ser descodificada.
     * @return Uma String descodificada. 
     */
    @Override
    public String decodifica(String str) {
       
        StringBuilder strDescodifica = new StringBuilder(str);
        strDescodifica.reverse();

        for(int i = 0; i < strDescodifica.length(); i++){

            char letra = strDescodifica.charAt(i);
                long indexToSwitch = tabela.indexOf(letra)-fib(i);

                if(indexToSwitch < 0){
                    
                    indexToSwitch %= tabela.length();
                    strDescodifica.setCharAt(i, tabela.charAt(tabela.length() + (int) indexToSwitch));
                }else{
                    strDescodifica.setCharAt(i, tabela.charAt((int)indexToSwitch));
                }
        }

        return strDescodifica.toString();
    }

    @Override
    public String getMatriculaAutor() {
        return "21101366";
    }

    @Override
    public String getNomeAutor() {
        return "Nathan Mello";
    }
    
}