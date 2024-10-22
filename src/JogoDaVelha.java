import entities.Jogador;
import entities.Tabuleiro;

import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro();
        Jogador jogador1 = new Jogador('X', 1);
        Jogador jogador2 = new Jogador('O', 2);
        Jogador jogadorAtual = jogador1;

        Scanner sc = new Scanner(System.in);
        boolean jogando = true;

        tabuleiro.inicializar();
        tabuleiro.exibir();

        while (jogando) {
            // RF03 e RT02 - Coleta a entrada do jogador (linha e coluna)
            System.out.println("\nJogador " + jogadorAtual.getNum() + ", Informe a linha que deseja fazer sua próxima jogada");
            int linha = sc.nextInt();
            System.out.println("Jogador " + jogadorAtual.getNum() + ", Informe a coluna que deseja fazer sua próxima jogada");
            int coluna = sc.nextInt();

            // RF02 e RT03 - Verifica se a jogada é válida e faz a realiza
            if(tabuleiro.fazerJogada(linha, coluna, jogadorAtual.getSimbolo())) {
                tabuleiro.exibir();

                // RF02 - Verifica se o jogador atual venceu o jogo
                if (tabuleiro.verificarVitoria(jogadorAtual.getSimbolo())) {
                    // RT04 - Exibe a mensagem de vitória
                    System.out.println("Jogador " + jogadorAtual.getNum() + " venceu!");
                    jogando = false;
                } else if (tabuleiro.completo()) {
                    // RT04 - Exibe a mensagem de empate
                    System.out.println("Empate!");
                    jogando = false;
                } else {
                    // RF01 - Alterna entre os jogadores 1 e 2
                    jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
                }
            } else {
                // RT03 - Mensagem de jogada inválida
                System.out.println("Jogada inválida. Tente novamente.");
            }
        }

        // RT04 - Ao final do jogo, oferece a opção de reiniciar
        System.out.println("Fim do jogo. Deseja jogar novamente? (S/N)");
        char resposta = sc.next().charAt(0);
        if (resposta == 'S' || resposta == 's') {
            main(new String[0]);  // Reinicia o jogo
        } else {
            System.out.println("Obrigado por jogar!");
        }
    }
}