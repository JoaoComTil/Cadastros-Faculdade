package view;

import javax.swing.JOptionPane;
import app.Disciplinas;
import cadastros.CadastroDisciplinas;
import exceptions.JaCadastradoException;
import exceptions.NaoCadastradoException;

public class MenuDisciplinas {

    // Método para coletar os dados de uma nova disciplina (sem número de turmas)
    public static Disciplinas dadosNovaDisciplina() {
        String nome = lerNome();
        String codigo = lerCodigo();
        int cargaHoraria = lerCargaHoraria();
        return new Disciplinas(nome, codigo, cargaHoraria, 0);
    }

    // Métodos para leitura de dados
    private static String lerNome() {
        return JOptionPane.showInputDialog("Informe o nome da disciplina:");
    }

    private static String lerCodigo() {
        return JOptionPane.showInputDialog("Informe o código da disciplina:");
    }

    private static int lerCargaHoraria() {
        int cargaHoraria = -1;
        while (cargaHoraria < 0) {
            try {
                cargaHoraria = Integer.parseInt(JOptionPane.showInputDialog("Informe a carga horária da disciplina:"));
                if (cargaHoraria < 0) {
                    JOptionPane.showMessageDialog(null, "A carga horária deve ser um número positivo.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, insira um número válido para a carga horária.");
            }
        }
        return cargaHoraria;
    }

    // Método para exibir informações da disciplina
    private static void exibirDisciplina(Disciplinas disciplina) {
        if (disciplina != null) {
            JOptionPane.showMessageDialog(null, disciplina.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Disciplina não encontrada.");
        }
    }

    // Método principal para o menu de disciplinas
    public static void menuDisciplinas(CadastroDisciplinas cadDisciplinas) {
        String txt = "Informe a opção desejada:\n"
                + "1 - Cadastrar disciplina\n"
                + "2 - Pesquisar disciplina\n"
                + "3 - Atualizar disciplina\n"
                + "4 - Remover disciplina\n"
                + "0 - Voltar para o menu anterior";

        int opcao;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            if (strOpcao == null) {
                opcao = 0; // Tratar fechamento da caixa de diálogo como "Voltar"
            } else {
                try {
                    opcao = Integer.parseInt(strOpcao);
                } catch (NumberFormatException e) {
                    opcao = -1; // Opcao inválida se a entrada não for um número
                }
            }

            try {
                switch (opcao) {
                    case 1:
                        Disciplinas novaDisciplina = dadosNovaDisciplina();
                        cadDisciplinas.adicionarDisciplina(novaDisciplina);
                        break;

                    case 2:
                        Disciplinas disciplinaPesquisada = cadDisciplinas.pesquisarDisciplina(lerCodigo());
                        exibirDisciplina(disciplinaPesquisada);
                        break;

                    case 3:
                        String codigoParaAtualizar = lerCodigo();
                        Disciplinas disciplinaAtualizada = dadosNovaDisciplina();
                        cadDisciplinas.alterarDisciplina(
                                codigoParaAtualizar,
                                disciplinaAtualizada.getNome(),
                                disciplinaAtualizada.getCodigo(),
                                disciplinaAtualizada.getCargaHoraria(),
                                disciplinaAtualizada.getNumTurmas());
                        JOptionPane.showMessageDialog(null, "Disciplina atualizada com sucesso.");
                        break;

                    case 4:
                        String codigoParaRemover = lerCodigo();
                        cadDisciplinas.removerDisciplina(codigoParaRemover);
                        JOptionPane.showMessageDialog(null, "Disciplina removida com sucesso.");
                        break;

                    case 0:
                        // Voltar para o menu anterior
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!");
                        break;
                }
            } catch (NaoCadastradoException | JaCadastradoException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (opcao != 0);
    }
}
