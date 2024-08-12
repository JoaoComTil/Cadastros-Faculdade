package app;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private int numero;
    private String professorResponsavel;
    private int numAlunos;
    private Disciplinas disciplinaAssociada;
    private List<String> alunos;

    // Construtor
    public Turma(int numero, String professorResponsavel, Disciplinas disciplinaAssociada) {
        this.numero = numero;
        this.professorResponsavel = professorResponsavel;
        this.numAlunos = 0;
        this.disciplinaAssociada = disciplinaAssociada;
        this.alunos = new ArrayList<>();
    }

    // Getters
    public int getNumero() {
        return numero;
    }

    public String getProfessorResponsavel() {
        return professorResponsavel;
    }

    public int getNumAlunos() {
        return numAlunos;
    }

    public Disciplinas getDisciplinaAssociada() {
        return disciplinaAssociada;
    }

    public List<String> getAlunos() {
        return alunos;
    }

    // Método para adicionar aluno e incrementar o número de alunos
    public void adicionarAluno(String aluno) {
        alunos.add(aluno);
        numAlunos++;
    }

    public String toString() {
        String resposta = super.toString() + '\n';
        resposta += "NUMERO: " + numero + '\n';
        resposta += "PROFESSOR RESPONSÁVEL: " + professorResponsavel + '\n';
        resposta += "NUMERO DE ALUNOS: " + numAlunos + '\n';
        return resposta;
    }
}
