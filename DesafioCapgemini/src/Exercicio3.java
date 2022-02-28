import javax.swing.JOptionPane;

public class Exercicio3 {

    public static void main(String[] args) {

        String palavra = digiteAPalavra();
        char vetor[];

        /**
         * retira todos os espaços do inicio, meio e fim das palavras
         * digitadas
         */
        palavra = retiraEspaco(palavra);

        vetor = new char[palavra.length()];

        /**
         * armazena a palavra em vetor
         */
        quebraPalavra(palavra, vetor);

        /**
         * cria o anagrama
         */
        calculaAnagrama(vetor, 0);

        /**
         * finaliza programa
         */
        System.exit(0);
    }// fim main()

    /**
     * pede ao usuario para entrar com uma palavra
     *
     * @return palavra
     */
    private static String digiteAPalavra() {
        String palavra = "";
        while (palavra.length() <= 2) {
            palavra = JOptionPane.showInputDialog(null,
                    "Digite uma palavra de no minimo 3 caracteres",
                    "Calculando Anagrama", JOptionPane.INFORMATION_MESSAGE);
        }
        return palavra;
    }// fim metodo digiteAPalavra()

    /**
     * mostra a palavra. A palavra é armazenada em um vetor para
     * ficar mais facil o manuseio
     *
     * @param vetor
     */
    private static void Mostra(char[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }// for
        System.out.println("");
    }// fim metodo Mostra()

    /**
     * recebe uma palavra e remove todos os espaços entre, durante e
     * no final de qualquer palavra.
     *
     * @param palavra
     * @return palavra_sem_espaços
     */
    private static String retiraEspaco(String palavra) {
        String alterada = "", interna = (palavra).trim();
        char c;

        for (int i = 0; i < interna.length(); i++) {
            c = interna.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                alterada += c;
            }// if
        }// for

        return alterada;
    }// fim metodo retiraEspaco()

    /**
     * recebe o vetor contendo a palavra e mostra para o usuario
     * todas as possibilidades de anagrama com esta palavra.
     *
     * @param vetor
     */
    private static void calculaAnagrama(char vetor[], int k) {
        int i;
        if (k == vetor.length - 1)
            Mostra(vetor);
        else {
            calculaAnagrama(vetor, k + 1);
            i = k + 1;
            while (i < vetor.length) {
                trocaPosicao(vetor, k, i);
                calculaAnagrama(vetor, k + 1);
                trocaPosicao(vetor, k, i);
                i = i + 1;
            }
        }
    }// fim metodo calculaAnagrama()

    /**
     * efetua a troca das posições desejadas
     *
     * @param vetor
     * @param i
     * @param k
     */
    private static void trocaPosicao(char[] vetor, int k, int i) {
        char aux;
        aux = vetor[i];
        vetor[i] = vetor[k];
        vetor[k] = aux;
    }// fim metodo trocaPosicao()

    /**
     * recebe a palavra e um vetor vazio e retorna o vetor contendo
     * a palavra
     *
     * @param palavra
     * @param vetor
     */
    private static void quebraPalavra(String palavra, char vetor[]) {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = palavra.charAt(i);
        }// for
    }// fim metodo quebraPalavra()
}// fim class

