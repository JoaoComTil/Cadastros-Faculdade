package cadastros;

import app.Disciplinas;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import exceptions.NaoCadastradoException;
import exceptions.JaCadastradoException;

public class CadastroDisciplinas {
    private final List<Disciplinas> disciplinas;

    // Construtor
    public CadastroDisciplinas() {
        this.disciplinas = new ArrayList<>();
    }

    // Método para adicionar uma disciplina
    // Método para adicionar uma disciplina
    public void adicionarDisciplina(Disciplinas disciplina) throws JaCadastradoException {
        for (Disciplinas d : disciplinas) {
            if (d.getCodigo().equalsIgnoreCase(disciplina.getCodigo())
                    || d.getNome().equalsIgnoreCase(disciplina.getNome())) {
                throw new JaCadastradoException("Disciplina com código ou nome já cadastrado.");
            }
        }
        disciplinas.add(disciplina);
        JOptionPane.showMessageDialog(null, "Disciplina adicionada com sucesso!");
    }

    // Método para exibir todas as disciplinas cadastradas
    public void exibirDisciplinas() {
        if (disciplinas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma disciplina cadastrada.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Disciplinas disciplina : disciplinas) {
                sb.append(disciplina.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    // Método para listar as disciplinas cadastradas
    public List<Disciplinas> getDisciplinas() {
        return disciplinas;
    }

    // Método para pesquisar disciplina por nome ou código
    public Disciplinas pesquisarDisciplina(String termo) {
        for (Disciplinas disciplina : disciplinas) {
            if (disciplina.getNome().equalsIgnoreCase(termo) || disciplina.getCodigo().equalsIgnoreCase(termo)) {
                return disciplina;
            }
        }
        return null;
    }

    public boolean removerDisciplina(Object termo) throws NaoCadastradoException {
        Disciplinas disciplinaParaRemover = null;

        // Se o termo for uma instância de Disciplinas, usá-lo diretamente
        if (termo instanceof Disciplinas) {
            disciplinaParaRemover = (Disciplinas) termo;
        }
        // Se o termo for uma String, procurar a disciplina pelo nome ou código
        else if (termo instanceof String) {
            disciplinaParaRemover = pesquisarDisciplina((String) termo);
        }

        // Se a disciplina foi encontrada, removê-la
        if (disciplinaParaRemover != null && disciplinas.remove(disciplinaParaRemover)) {
            JOptionPane.showMessageDialog(null, "Disciplina removida com sucesso.");
            return true;
        } else {
            throw new NaoCadastradoException("Disciplina não encontrada para remoção.");
        }
    }

    // Método para alterar os dados de uma disciplina
    public boolean alterarDisciplina(String termo, String novoNome, String novoCodigo, int novaCargaHoraria,
            int novoNumTurmas) throws NaoCadastradoException, JaCadastradoException {
        Disciplinas disciplinaParaAlterar = pesquisarDisciplina(termo);
        if (disciplinaParaAlterar != null) {
            removerDisciplina(disciplinaParaAlterar);
            Disciplinas disciplinaAlterada = new Disciplinas(novoNome, novoCodigo, novaCargaHoraria, novoNumTurmas);
            adicionarDisciplina(disciplinaAlterada);
            JOptionPane.showMessageDialog(null, "Disciplina alterada com sucesso.");
            return true;
        }
        throw new NaoCadastradoException("Disciplina não encontrada para alteração.");
    }
}