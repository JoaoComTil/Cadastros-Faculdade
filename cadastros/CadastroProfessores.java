package cadastros;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import app.Professor;

public class CadastroProfessores {

    private ArrayList<Professor> professores;

    public CadastroProfessores() {
        this.professores = new ArrayList<>();
    }

    // Método para cadastrar um professor
    public int cadastrarProfessor(Professor p) {
        professores.add(p);
        JOptionPane.showMessageDialog(null, "Professor adicionado no sistema.");
        return professores.size(); // Retorna o número atual de professores
    }

    // Método para pesquisar um professor pela matrícula
    public Professor pesquisarProfessor(String matriculaFUB) {
        for (Professor p : professores) {
            if (p.getMatriculaFUB().equals(matriculaFUB)) {
                JOptionPane.showMessageDialog(null, "Professor de matrícula: " + p.getMatriculaFUB() + " encontrado!\n" + p.toString());
                return p;
            }
        }
        JOptionPane.showMessageDialog(null, "Professor não encontrado no sistema.");
        return null;
    }

    // Método para remover um professor pela matrícula
    public boolean removerProfessor(String matriculaFUB) {
        Professor p = pesquisarProfessor(matriculaFUB);
        if (p != null) {
            professores.remove(p);
            JOptionPane.showMessageDialog(null, "Professor " + p.getNome() + " removido com sucesso.");
            return true;
        }
        JOptionPane.showMessageDialog(null, "Professor não encontrado para remoção.");
        return false;
    }

    // Método para atualizar um professor
    public boolean atualizarProfessor(String matriculaFUB, Professor professorAtualizado) {
        for (int i = 0; i < professores.size(); i++) {
            if (professores.get(i).getMatriculaFUB().equals(matriculaFUB)) {
                professores.set(i, professorAtualizado);
                JOptionPane.showMessageDialog(null, "Informações do professor atualizadas.");
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Professor não encontrado para atualização.");
        return false;
    }
}
