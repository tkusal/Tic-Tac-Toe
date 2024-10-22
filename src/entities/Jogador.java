package entities;

public class Jogador {
    // RF01 - Cada jogador tem um símbolo ('X' ou 'O')
    private int num;
    private char simbolo;

    public Jogador(char simbolo, int num) {
        this.simbolo = simbolo;
        this.num = num;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public int getNum() {
        return num;
    }
}
