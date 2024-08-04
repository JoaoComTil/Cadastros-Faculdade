package Cadastros;

import java.util.ArrayList;

import app.Aluno;

public class CadastroAlunos {

    private int numAlunos;
    private ArrayList<Aluno> alunos;

    public CadastroAlunos() {
        this.alunos = new ArrayList<>();
    }

    public int cadastrarAluno(Aluno a) {
        alunos.add(a);
        numAlunos++;
        System.out.println("Aluno adicionado no sistema.\n");
        return numAlunos;
    }

    public Aluno pesquisarAluno(String matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(matricula)) {
                System.out.println("Aluno de matricula: " + a.getMatricula() + " Encontrado!\n");
                return a;
            }
        }
        System.out.println("Aluno não encontrado no sistema.\n");
        return null;
    }

    public boolean removerAluno(Aluno a, String matricula) {// verificar se pode usar o parametro matricula aqui
        if (a.getMatricula().equals(matricula)) {
            alunos.remove(a);
            numAlunos--;
            System.out.println("Aluno " + a + " removido do sistema.\n");
            return true;
        }
        return false;
    }

    public boolean atualizarAluno(String matricula, Aluno alunoAtualizado) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getMatricula().equals(matricula)) {
                alunos.set(i, alunoAtualizado);
                System.out.println(
                        "Informações do aluno trocadas.\n");
                return true;
            }
        }
        return false;
    }
}

// olhar se precisa fazer exceções para os if's que aparecem nas funções