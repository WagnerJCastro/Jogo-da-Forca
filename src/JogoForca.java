import java.util.ArrayList;
import java.util.Scanner;

public class JogoForca {

    //Todo:
    //Adicionar tratamento para letras já utilizadas ou valores que não são letras
    //Criar um menu para iniciar o jogo
    //Adicionar a opção de jogar novamente
    //Criar 3 bibliotecas de palavras separadas por dificuldade
    //Criar bibliotecas com divisão de tema e categoria das palavras
    //Adicionar dicas para as palavras
    //Adicionar pontuação
    //Adicionar banco de dados para salvar a pontuação
    //Adicionar diferentes modos de jogo como com mais de uma palavra ao mesmo tempo ou timer
    //Crie um jogo da forca onde a palavra secreta é uma parte de uma palavra cruzada maior. O jogador precisa preencher a palavra corretamente para continuar.
    //Divida o jogo em níveis, onde cada nível tem uma palavra secreta mais difícil. Os jogadores precisam completar um nível para desbloquear o próximo.
    //Introduza power-ups ou ajudas que os jogadores podem usar durante o jogo, como revelar uma letra ou pular para outra palavra.
    //Adicione uma versão educativa do jogo da forca, onde os jogadores aprendem novas palavras ou conceitos relacionados à educação.
    //Adicionar modo PVP
    //Criar uma interface para rodar o jogo
    //Pesquisar maneiras de inovar o jogo


    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int contemLetraEmBranco = 0;
        int validadordepontos = 0;
        String palavraSecreta = "Cachorro".toUpperCase();
        char[] palavraDescoberta;
        int tentativasRestantes = 6;
        ArrayList<Character> letrasChutadas = new ArrayList<>();

        palavraDescoberta = new char[palavraSecreta.length()];
        for (int i = 0; i < palavraDescoberta.length; i++) {
            palavraDescoberta[i] = '_';
        }


        while (tentativasRestantes > 0) {
            System.out.println("Tentativas restantes = " + tentativasRestantes);
            if(letrasChutadas.size() != 0){
            System.out.println("Você já chutou essas letras: " + letrasChutadas);
            }
            System.out.println(palavraDescoberta);
            System.out.println("Digite uma letra");
            char chute = teclado.nextLine().toUpperCase().charAt(0);

            for (int i = 0; i < palavraDescoberta.length; i++) {
                if (chute == palavraSecreta.charAt(i)) {
                    palavraDescoberta[i] = palavraSecreta.charAt(i);
                    validadordepontos++;
                }
            }
            letrasChutadas.add(chute);
            if (validadordepontos > 0) {
                System.out.println("Parabens! A letra " + chute + " é usada " + validadordepontos + " vezes nessa palavra");
                validadordepontos = 0;
            } else {
                System.out.println("Sinto muito, a letra " + chute + " não é usada nessa palavra");
                tentativasRestantes--;
                validadordepontos = 0;
            }
            for (int i = 0; i < palavraSecreta.length(); i++) {
                if (palavraDescoberta[i] == '_') {
                    contemLetraEmBranco++;
                }
            }
            if (contemLetraEmBranco == 0){
                System.out.println("Parabens você ganhou o jogo.");
                break;
            } else {
                contemLetraEmBranco = 0;
            }

        }
    }
}

