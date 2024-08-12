package cadastros;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import app.Professor;
import exceptions.JaCadastradoException;
import exceptions.NaoCadastradoException;

public class CadastroProfessores {

    private ArrayList<Professor> professores;

    public CadastroProfessores() {
        this.professores = new ArrayList<>();
    }

    // Método para cadastrar um professor
    public int cadastrarProfessor(Professor p) throws JaCadastradoException {
        for (Professor professor : professores) {
            if (professor.getMatriculaFUB().equalsIgnoreCase(p.getMatriculaFUB())) {
                throw new JaCadastradoException(
                        "Professor com matrícula " + p.getMatriculaFUB() + " já está cadastrado.");
            }
        }
        professores.add(p);
        JOptionPane.showMessageDialog(null, "Professor adicionado no sistema.");
        return professores.size();
    }

    // Método para pesquisar um professor pela matrícula
    public Professor pesquisarProfessor(String matriculaFUB) throws NaoCadastradoException {
        for (Professor p : professores) {
            if (p.getMatriculaFUB().equals(matriculaFUB)) {
                JOptionPane.showMessageDialog(null,
                        "Professor de matrícula: " + p.getMatriculaFUB() + " encontrado!\n" + p.toString());
                return p;
            }
        }
        throw new NaoCadastradoException("Professor não encontrado no sistema.");
    }

    // Método para remover um professor pela matrícula
    public boolean removerProfessor(String matriculaFUB) throws NaoCadastradoException {
        Professor p = pesquisarProfessor(matriculaFUB);
        if (p != null) {
            professores.remove(p);
            JOptionPane.showMessageDialog(null, "Professor " + p.getNome() + " removido com sucesso.");
            return true;
        }
        throw new NaoCadastradoException("Professor não encontrado para remoção.");
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
