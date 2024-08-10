package cadastros;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import app.Turma;
import app.Disciplinas;

public class CadastroTurmas {

    private final ArrayList<Turma> turmas;

    public CadastroTurmas() {
        this.turmas = new ArrayList<>();
    }

    public void adicionarTurma(Turma turma) {
        turmas.add(turma);
        turma.getDisciplinaAssociada().incrementarNumTurmas();
        JOptionPane.showMessageDialog(null, "Turma adicionada ao sistema.");
    }

    public void adicionarAlunoNaTurma(int numeroTurma, String nomeAluno) {
        Turma turma = pesquisarTurma(numeroTurma);
        if (turma != null) {
            turma.adicionarAluno(nomeAluno);
            JOptionPane.showMessageDialog(null, "Aluno adicionado à turma " + numeroTurma + ". Total de alunos: " + turma.getNumAlunos());
        } else {
            JOptionPane.showMessageDialog(null, "Turma não encontrada.");
        }
    }

    public Turma pesquisarTurma(int numero) {
        for (Turma turma : turmas) {
            if (turma.getNumero() == numero) {
                JOptionPane.showMessageDialog(null, turma.toString());
                return turma;
            }
        }
        JOptionPane.showMessageDialog(null, "Turma não encontrada.");
        return null; // Retorna null se a turma não for encontrada
    }

    public boolean removerTurma(int numero) {
        Turma turmaParaRemover = pesquisarTurma(numero);
        if (turmaParaRemover != null) {
            turmas.remove(turmaParaRemover);
            JOptionPane.showMessageDialog(null, "Turma removida do sistema.");
            return true;
        }
        JOptionPane.showMessageDialog(null, "Turma não encontrada para remoção.");
        return false; // Retorna false se a turma não foi encontrada
    }

    public void exibirTurmas() {
        if (turmas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma turma cadastrada.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Turma turma : turmas) {
                sb.append(turma.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }
}
