package Cadastros;

import java.util.ArrayList;

import app.Professor;

public class CadastroProfessores {

    private int numProfessores;

    private ArrayList<Professor> professores;

    public CadastroProfessores() {
        this.professores = new ArrayList<>();
    }

    public int CadastrarProfessor(Professor p) {
        professores.add(p);
        numProfessores++;
        System.out.println("Professor adicionado no sistema.\n");
        return numProfessores;
    }

    public Professor pesquisarProfessor(String matriculaFUB) {
        for (Professor p : professores) {
            if (p.getMatriculaFUB().equals(matriculaFUB)) {
                System.out.println("Professor de matricula: " + p.getMatriculaFUB() + " Encontrado!\n");
                return p;
            }
        }
        System.out.println("Professor não encontrado no sistema.\n");
        return null;
    }

    public boolean removerProfessor(Professor p, String matriculaFUB) {
        if (p.getMatriculaFUB().equals(matriculaFUB)) {
            professores.remove(p);
            numProfessores--;
            System.out.println("Professor" + p + " removido com sucesso.\n");
            return true;
        }
        return false;
    }

    public boolean atualizarProfessor(String matriculaFUB, Professor professorAtualizado) {
        for (int i = 0; i < professores.size(); i++) {
            if (professores.get(i).getMatriculaFUB().equals(matriculaFUB)) {
                professores.set(i, professorAtualizado);
                System.out.println("Informações do professor trocadas.\n");
                return true;
            }
        }
        return false;
    }
}

// olhar se precisa fazer exceções para os if's que aparecem nas funções