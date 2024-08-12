import javax.swing.JOptionPane;
import cadastros.CadastroAluno;
import cadastros.CadastroProfessores;
import cadastros.CadastroDisciplinas;
import cadastros.CadastroTurmas;
import view.MenuAluno;
import view.MenuProfessor;
import view.MenuDisciplinas;
import view.MenuTurmas;

public class Principal {

    static CadastroAluno cadAluno;
    static CadastroProfessores cadProfessores;
    static CadastroDisciplinas cadDisciplinas;
    static CadastroTurmas cadTurmas;

    public static void main(String[] args) {
        // Inicializando os cadastros
        cadAluno = new CadastroAluno();
        cadProfessores = new CadastroProfessores();
        cadDisciplinas = new CadastroDisciplinas();
        cadTurmas = new CadastroTurmas();

        int opcao;

        do {
            opcao = MenuPrincipal.menuOpcoes(); // Exibe o menu principal e retorna a opção escolhida
            switch (opcao) {
                case 1: // Menu de Alunos
                    MenuAluno.menuAluno(cadAluno);
                    break;
                case 2: // Menu de Professores
                    MenuProfessor.menuProfessor(cadProfessores);
                    break;
                case 3: // Menu de Disciplinas
                    MenuDisciplinas.menuDisciplinas(cadDisciplinas);
                    break;
                case 4: // Menu de Turmas
                    MenuTurmas.menuTurmas(cadTurmas, cadDisciplinas);
                    break;
                case 0: // Sair
                    JOptionPane.showMessageDialog(null, "Encerrando o sistema...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 0); // O loop continua até que o usuário escolha sair (opção 0)
    }
}

// Classe auxiliar para exibir o menu principal
class MenuPrincipal {
    public static int menuOpcoes() {
        String menu = "Menu Principal:\n"
                + "1 - Gerenciar Alunos\n"
                + "2 - Gerenciar Professores\n"
                + "3 - Gerenciar Disciplinas\n"
                + "4 - Gerenciar Turmas\n"
                + "0 - Sair";
        String strOpcao = JOptionPane.showInputDialog(menu);

        if (strOpcao == null) {
            return 0; // Retorna 0 para encerrar o sistema se o usuário cancelar
        }

        try {
            return Integer.parseInt(strOpcao); // Converte a string para int
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida! Por favor, insira um número.");
            return -1; // Retorna -1 para indicar opção inválida
        }
    }
}
