package view;

import java.util.Scanner;

import Cadastros.CadastroProfessores;
import app.Professor;

/*
 * Classe usada para manipular as funções de CadastroProfessores
*/

public class MenuProfessor {

    public void menuProfessor(CadastroProfessores cadProfessor) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Menu Professor");
        System.out.println("1. Cadastrar Professor");
        System.out.println("2. Pesquisar Professor");
        System.out.println("3. Remover Professor");
        System.out.println("4. Atualizar Professor");
        System.out.println("0. Sair");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                Professor novoProfessor = dadosNovoProfessor();
                cadProfessor.CadastrarProfessor(novoProfessor);
                break;
            case 2:
                System.out.print("Digite a matriculaFUB do professor: ");
                String matriculaFUB = scanner.nextLine();
                Professor professorCadastrado = cadProfessor.pesquisarProfessor(matriculaFUB);
                System.out.println(professorCadastrado);
                break;
            case 3:
                System.out.print("Digite a matriculaFUB do professor a remover: ");
                matriculaFUB = scanner.nextLine();
                Professor professorRemover = cadProfessor.pesquisarProfessor(matriculaFUB);

                if (professorRemover == null) {
                    break;
                }
                cadProfessor.removerProfessor(professorRemover, matriculaFUB);
                break;

            case 4:
                System.out.print("Digite a matriculaFUB do professor a atualizar: ");
                matriculaFUB = scanner.nextLine();
                Professor professorAtualizado = dadosNovoProfessor();
                cadProfessor.atualizarProfessor(matriculaFUB, professorAtualizado);
                break;
            case 0:
                System.out.println("Saindo do menu...");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public Professor dadosNovoProfessor() { // usado para quando um usuário cadastrar um novo professor
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Matricula FUB: ");
        String matriculaFUB = scanner.nextLine();
        System.out.print("Area de formacao: ");
        String area = scanner.nextLine();

        Professor professor = new Professor();
        professor.setNome(nome);
        professor.setCpf(cpf);
        professor.setEmail(email);
        professor.setAreaFormacao(area);
        professor.setMatriculaFUB(matriculaFUB);

        return professor;
    }
}
