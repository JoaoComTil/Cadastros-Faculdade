package cadastros;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import app.Turma;
import exceptions.DisciplinaNaoAtribuidaException;
import exceptions.JaCadastradoException;
import exceptions.NaoCadastradoException;
import exceptions.ProfessorNaoAtribuidoException;

public class CadastroTurmas {

    private final ArrayList<Turma> turmas;

    public CadastroTurmas() {
        this.turmas = new ArrayList<>();
    }

    // IMPORTANTE: Aqui é feito o tratamento da exceção de professor não atribuido
    public void adicionarTurma(Turma turma)
            throws JaCadastradoException, DisciplinaNaoAtribuidaException, ProfessorNaoAtribuidoException {

        if (turma.getProfessorResponsavel() == null || turma.getProfessorResponsavel().isEmpty()) {
            throw new ProfessorNaoAtribuidoException("A turma não pode ser cadastrada sem um professor.");
        }

        if (pesquisarTurma(turma.getNumero()) != null) {
            throw new JaCadastradoException("Turma já cadastrada.");
        }

        turmas.add(turma);
        turma.getDisciplinaAssociada().incrementarNumTurmas();
        JOptionPane.showMessageDialog(null, "Turma adicionada ao sistema.");
    }

    public void adicionarAlunoNaTurma(int numeroTurma, String nomeAluno) throws NaoCadastradoException {
        Turma turma = pesquisarTurma(numeroTurma);
        if (turma != null) {
            turma.adicionarAluno(nomeAluno);
            JOptionPane.showMessageDialog(null,
                    "Aluno adicionado à turma " + numeroTurma + ". Total de alunos: " + turma.getNumAlunos());
        } else {
            throw new NaoCadastradoException("Turma não encontrada.");
        }
    }

    public Turma pesquisarTurma(int numero) {
        for (Turma turma : turmas) {
            if (turma.getNumero() == numero) {
                return turma;
            }
        }
        return null; // Retorna null se a turma não for encontrada
    }

    public boolean removerTurma(int numero) throws NaoCadastradoException {
        Turma turmaParaRemover = pesquisarTurma(numero);
        if (turmaParaRemover != null) {
            turmas.remove(turmaParaRemover);
            JOptionPane.showMessageDialog(null, "Turma removida do sistema.");
            return true;
        } else {
            throw new NaoCadastradoException("Turma não encontrada.");
        }
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
