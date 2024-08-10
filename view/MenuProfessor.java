package view;

import javax.swing.JOptionPane;
import app.Professor;
import cadastros.CadastroProfessores;

public class MenuProfessor {

    // Método para coletar os dados de um novo professor
    public static Professor dadosNovoProfessor() {
        String nome = lerNome();
        String cpf = lerCPF();
        String email = lerEmail();
        String areaFormacao = lerAreaFormacao();
        String matriculaFUB = lerMatriculaFUB();
        return new Professor(nome, cpf, email, areaFormacao, matriculaFUB);
    }

    // Métodos para leitura de dados
    private static String lerNome() {
        return JOptionPane.showInputDialog("Informe o nome do professor:");
    }

    private static String lerCPF() {
        return JOptionPane.showInputDialog("Informe o CPF do professor:");
    }

    private static String lerEmail() {
        return JOptionPane.showInputDialog("Informe o email do professor:");
    }

    private static String lerAreaFormacao() {
        return JOptionPane.showInputDialog("Informe a área de formação do professor:");
    }

    private static String lerMatriculaFUB() {
        return JOptionPane.showInputDialog("Informe a matrícula FUB do professor:");
    }

    // Método principal para o menu de professores
    public static void menuProfessor(CadastroProfessores cadProfessores) {
        String txt = "Informe a opção desejada:\n"
                + "1 - Cadastrar professor\n"
                + "2 - Pesquisar professor\n"
                + "3 - Atualizar professor\n"
                + "4 - Remover professor\n"
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

            switch (opcao) {
                case 1:
                    Professor novoProfessor = dadosNovoProfessor();
                    cadProfessores.cadastrarProfessor(novoProfessor);
                    break;

                case 2:
                    String matriculaFUB = lerMatriculaFUB();
                    cadProfessores.pesquisarProfessor(matriculaFUB);
                    break;

                case 3:
                    matriculaFUB = lerMatriculaFUB();
                    Professor professorAtualizado = dadosNovoProfessor();
                    boolean atualizado = cadProfessores.atualizarProfessor(matriculaFUB, professorAtualizado);
                    if (atualizado) {
                        JOptionPane.showMessageDialog(null, "Professor atualizado com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Professor não encontrado para atualização.");
                    }
                    break;

                case 4:
                    matriculaFUB = lerMatriculaFUB();
                    boolean removido = cadProfessores.removerProfessor(matriculaFUB);
                    if (removido) {
                        JOptionPane.showMessageDialog(null, "Professor removido com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Professor não encontrado para remoção.");
                    }
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
}
