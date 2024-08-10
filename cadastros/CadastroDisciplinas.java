package cadastros;

import app.Disciplinas;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class CadastroDisciplinas {
    private final List<Disciplinas> disciplinas;

    // Construtor
    public CadastroDisciplinas() {
        this.disciplinas = new ArrayList<>();
    }

    // Método para adicionar uma disciplina
    public void adicionarDisciplina(Disciplinas disciplina) {
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
        JOptionPane.showMessageDialog(null, "Disciplina não encontrada.");
        return null; // Retorna null se a disciplina não for encontrada
    }

    public boolean removerDisciplina(Object termo) {
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
            JOptionPane.showMessageDialog(null, "Disciplina não encontrada para remoção.");
            return false;
        }
    }

    // Método para alterar os dados de uma disciplina
    public boolean alterarDisciplina(String termo, String novoNome, String novoCodigo, int novaCargaHoraria, int novoNumTurmas) {
        Disciplinas disciplinaParaAlterar = pesquisarDisciplina(termo);
        if (disciplinaParaAlterar != null) {
            // Criando uma nova instância de Disciplinas com os dados alterados
            Disciplinas disciplinaAlterada = new Disciplinas(novoNome, novoCodigo, novaCargaHoraria, novoNumTurmas);
            
            // Removendo a antiga e adicionando a nova
            removerDisciplina(disciplinaParaAlterar);
            adicionarDisciplina(disciplinaAlterada);
            
            JOptionPane.showMessageDialog(null, "Disciplina alterada com sucesso.");
            return true; // Alteração bem-sucedida
        }
        JOptionPane.showMessageDialog(null, "Disciplina não encontrada para alteração.");
        return false; // Não encontrou a disciplina para alterar
    }
}
