package main;

import main.entities.Jogador;
import main.entities.Tabuleiro;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JogoDaVelha {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            jogar();
            if (!desejaJogarNovamente()) {
                System.out.println("Obrigado por jogar!");
                break;
            }
        }
    }

    private static void jogar() {
        Tabuleiro tabuleiro = new Tabuleiro();
        Jogador jogador1 = new Jogador('X', 1);
        Jogador jogador2 = new Jogador('O', 2);
        Jogador jogadorAtual = jogador1;

        tabuleiro.inicializar();
        tabuleiro.exibir();

        boolean partida = true;

        while (partida) {
            int linha = obterEntrada("linha", jogadorAtual);
            int coluna = obterEntrada("coluna", jogadorAtual);

            // RF02 e RT03 - Verifica se a jogada é válida e faz a realiza
            if (tabuleiro.fazerJogada(linha, coluna, jogadorAtual.getSimbolo())) {
                tabuleiro.exibir();

                // RF02 - Verifica se o jogador atual venceu o jogo
                if (tabuleiro.verificarVitoria(jogadorAtual.getSimbolo())) {
                    // RT04 - Exibe a mensagem de vitória
                    System.out.println("Jogador " + jogadorAtual.getNum() + " venceu!");
                    partida = false;
                } else if (tabuleiro.completo()) {
                    // RT04 - Exibe a mensagem de empate
                    System.out.println("Empate!");
                    partida = false;
                } else {
                    // RF01 - Alterna entre os jogadores 1 e 2
                    jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
                }
            } else {
                // RT03 - Mensagem de jogada inválida
                System.out.println("Jogada inválida. Tente novamente.");
            }
        }
    }

    private static int obterEntrada(String tipo, Jogador jogadorAtual) {
        int valor;
        while (true) {
            try {
                System.out.println("\nJogador " + jogadorAtual.getNum() + ", Informe a " + tipo + " que deseja fazer sua próxima jogada");
                valor = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                sc.next();
            }
        }
        return valor;
    }

    private static boolean desejaJogarNovamente() {
        System.out.println("Fim do jogo. Deseja jogar novamente? (S/N)");
        char resposta = sc.next().charAt(0);
        return resposta == 'S' || resposta == 's';
    }
}