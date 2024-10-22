package main.entities;

public class Tabuleiro {
    // RT01 - Representa uma célula vazia no tabuleiro, Matriz 3x3 representando o tabuleiro
    private static final char VAZIO = '-';
    private char[][] tabuleiro = new char[3][3];

    // RT01 - Inicializa o tabuleiro com células vazias e preenche o tabuleiro com o caractere vazio
    public void inicializar() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = VAZIO;
            }
        }
    }

    // RF03 - Exibe o tabuleiro no console com os números de linhas e colunas
    public void exibir() {
        System.out.println(" 0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    // RF03 - Faz uma jogada se for válida (linha e coluna dentro dos limites e célula vazia)
    public boolean fazerJogada(int linha, int coluna, char simbolo) {
        if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2 || tabuleiro[linha][coluna] != VAZIO) {
            return false;
        }
        tabuleiro[linha][coluna] = simbolo;  // RF01 - Coloca o símbolo do jogador no tabuleiro
        return true;
    }

    // RF02 - Verifica se o jogador venceu (linhas, colunas ou diagonais)
    public boolean verificarVitoria(char simbolo) {
        return (verificaLinhas(simbolo) || verificaColunas(simbolo) || verificaDiagonais(simbolo));
    }

    // Verifica se há três símbolos iguais em uma linha
    private boolean verificaLinhas(char simbolo) {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == simbolo && tabuleiro[i][1] == simbolo && tabuleiro[i][2] == simbolo) {
                return true;
            }
        }
        return false;
    }

    // Verifica se há três símbolos iguais em uma coluna
    private boolean verificaColunas(char simbolo) {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[0][i] == simbolo && tabuleiro[1][i] == simbolo && tabuleiro[2][i] == simbolo) {
                return true;
            }
        }
        return false;
    }

    // Verifica se há três símbolos iguais em uma diagonal
    private boolean verificaDiagonais(char simbolo) {
        return (tabuleiro[0][0] == simbolo && tabuleiro[1][1] == simbolo && tabuleiro[2][2] == simbolo) ||
                (tabuleiro[0][2] == simbolo && tabuleiro[1][1] == simbolo && tabuleiro[2][0] == simbolo);
    }

    // Verifica se o tabuleiro está completo (empate)
    public boolean completo() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == VAZIO) {
                    return false;
                }
            }
        }
        return true;
    }
}
