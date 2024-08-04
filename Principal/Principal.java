package Principal;

import Cadastros.CadastroAlunos;
import Cadastros.CadastroProfessores;
import view.MenuPrincipal;

public class Principal {

    // perguntar se precisa usar cadAluno e cadProfessor mesmo na classe Principal

    static CadastroAlunos cadAluno;
    static CadastroProfessores cadProfessor;

    public static void main(String[] args) {

        MenuPrincipal menuPrincipal = new MenuPrincipal();
        int opcao;

        // executando a função menuOpções (que é da classe MenuPrincipal) até a opção
        // for 0, que encerra o programa
        do {
            opcao = menuPrincipal.menuOpcoes();
            menuPrincipal.executarOpcao(opcao);
        } while (opcao != 0);

        System.out.println("Sistema encerrado.");
    }

}
