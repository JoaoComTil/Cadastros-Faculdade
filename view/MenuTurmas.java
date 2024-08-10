package view;

import javax.swing.JOptionPane;
import app.Turma;
import cadastros.CadastroTurmas;
import cadastros.CadastroDisciplinas;
import app.Disciplinas;

public class MenuTurmas {

    public static void menuTurmas(CadastroTurmas cadTurmas, CadastroDisciplinas cadDisciplinas) {
        String txt = "Informe a opção desejada:\n"
                + "1 - Cadastrar turma\n"
                + "2 - Pesquisar turma\n"
                + "3 - Exibir todas as turmas\n"
                + "4 - Remover turma\n"
                + "5 - Adicionar aluno à turma\n"
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
                    JOptionPane.showMessageDialog(null, "Entrada inválida! Por favor, insira um número.");
                    opcao = -1; // Retorna -1 para indicar opção inválida
                }
            }

            switch (opcao) {
                case 1:
                    Turma novaTurma = dadosNovaTurma(cadDisciplinas);
                    if (novaTurma != null) {
                        cadTurmas.adicionarTurma(novaTurma);
                    }
                    break;

                case 2:
                    int numeroTurma = lerNumeroTurma();
                    cadTurmas.pesquisarTurma(numeroTurma);
                    break;

                case 3:
                    cadTurmas.exibirTurmas();
                    break;

                case 4:
                    numeroTurma = lerNumeroTurma();
                    cadTurmas.removerTurma(numeroTurma);
                    break;

                case 5:
                    numeroTurma = lerNumeroTurma();
                    String nomeAluno = JOptionPane.showInputDialog("Informe o nome do aluno a ser adicionado:");
                    cadTurmas.adicionarAlunoNaTurma(numeroTurma, nomeAluno);
                    break;

                case 0:
                    // Voltar para o menu anterior
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    private static int lerNumeroTurma() {
        String entrada = JOptionPane.showInputDialog("Informe o número da turma:");
        return Integer.parseInt(entrada); // Convertendo a entrada para int
    }

    private static Turma dadosNovaTurma(CadastroDisciplinas cadDisciplinas) {
        int numero = lerNumeroTurma();
        String professorResponsavel = lerProfessorResponsavel();
        String codigoDisciplina = lerCodigoDisciplina();

        Disciplinas disciplinaAssociada = cadDisciplinas.pesquisarDisciplina(codigoDisciplina);
        if (disciplinaAssociada == null) {
            JOptionPane.showMessageDialog(null, "Disciplina não encontrada. A turma não pode ser cadastrada.");
            return null;
        }

        return new Turma(numero, professorResponsavel, disciplinaAssociada);
    }

    private static String lerProfessorResponsavel() {
        return JOptionPane.showInputDialog("Informe o nome do professor responsável:");
    }

    private static String lerCodigoDisciplina() {
        return JOptionPane.showInputDialog("Informe o código da disciplina associada:");
    }
}
