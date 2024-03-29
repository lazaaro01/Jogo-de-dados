// simula um jogo de dados
import java.util.Random;

public class Gamer {
    private static final Random randomNumbers = new Random(); // cria um gerador de números aleatórios para uso no método

    private enum Status{CONTINUE, WON, LOST}; // enumeração com constantes que representam o status do jogo

    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;

    public void play() { // joga uma partida do jogo
        int myPoint = 0; // pontos se não ganhar ou perder na primeira rolagem
        Status gameStatus;

        int sumOfDice = rollDice(); // primeira rolagem dos dados 

        switch ( sumOfDice ) { // detrmina o status do jogo e a pontuação com base no primeiro lançamento
            case SEVEN: // ganha com 7 no primeiro lançamento
            case YO_LEVEN: // ganha com 11 no primeiro lançamento
             gameStatus = Status.WON;
            break;
            case SNAKE_EYES: // perde com 2 no primeiro lançamento
            case TREY: // perde com 3 no primeiro lançamento
            case BOX_CARS: // perde com 12 no primeiro lançamento
             gameStatus = Status.LOST;
            break;
         default: // se não ganhar ou se não perdeu, então registra a pontuação
            gameStatus = Status.CONTINUE; // jogo não terminou
            myPoint = sumOfDice; // informa a pontuação
            System.out.printf("A pontuação é: %d\n", myPoint);
            break;
        } 
        while ( gameStatus == Status.CONTINUE ) { // enquanto o jogo não estiver completo não vai ser nem WON nem LOST
            sumOfDice = rollDice(); // lança os dados novamente 
            if ( sumOfDice == myPoint ) // vitória por pontuação
             gameStatus = Status.WON;
            else
            if ( sumOfDice == SEVEN ) // perde obtendo 7 antes de atingir a pontuação
             gameStatus = Status.LOST;
        }
        if (gameStatus == Status.WON )
         System.out.println("O jogador ganhou!!"); // exibe uma mensagem caso o jogador ganhe
        else
        System.out.println("O jogador perdeu!"); // exibe uma mensagem caso o jogador perca
    }
    public int rollDice() { // lança os dados, e calcula a soma e exibe os resultados
        int diel1 = 1 + randomNumbers.nextInt(6); // primeiro lançamento do dado
        int diel2 = 1 + randomNumbers.nextInt(6); // segundo lançamento do dado

        int sum = diel1 + diel2; // soma os valores dos dados

        System.out.printf("O jogador lançou os dados %d + %d = %d\n", diel1, diel2, sum); // exibe os resultados

        return sum; // retona a soma dos dados
    }
}
