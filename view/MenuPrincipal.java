package view;

import java.util.Scanner;

import Cadastros.CadastroAlunos;
import Cadastros.CadastroProfessores;

/*
 * Classe para controlar que menus serão usados no programa
 */

public class MenuPrincipal {

    private CadastroAlunos cadastroAlunos;
    private CadastroProfessores cadastroProfessores;

    public MenuPrincipal() {
        this.cadastroAlunos = new CadastroAlunos();
        this.cadastroProfessores = new CadastroProfessores();
    }

    public int menuOpcoes() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Menu Principal");
        System.out.println("1. Gerenciar Alunos");
        System.out.println("2. Gerenciar Professores");
        System.out.println("0. Sair");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        return opcao;
    }

    public void executarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                MenuAluno menuAluno = new MenuAluno();
                menuAluno.menuAluno(cadastroAlunos);
                break;
            case 2:
                MenuProfessor menuProfessor = new MenuProfessor();
                menuProfessor.menuProfessor(cadastroProfessores);

                break;
            case 0:
                System.out.println("Saindo do sistema...");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

}
