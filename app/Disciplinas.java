package app;

public class Disciplinas {

    private String nome;
    private String codigo;
    private int cargaHoraria;
    private int numTurmas;

    // Construtor
    public Disciplinas(String nome, String codigo, int cargaHoraria, int numTurmas) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        this.numTurmas = numTurmas;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public int getNumTurmas() {
        return numTurmas;
    }

    // Método para incrementar o número de turmas
    public void incrementarNumTurmas() {
        this.numTurmas++;
    }

    public String toString() {
        return "Disciplina{" +
                "nome: '" + nome + '\'' +
                ", codigo: '" + codigo + '\'' +
                ", cargaHoraria:" + cargaHoraria +
                ", numTurmas:" + numTurmas +
                '}';
    }
}
