package view;

import java.util.Scanner;

import Cadastros.CadastroAlunos;
import app.Aluno;

/*
 * Classe usada para manipular as funções de CadastroAlunos
*/
public class MenuAluno {

    public void menuAluno(CadastroAlunos cadAluno) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Menu Aluno");
        System.out.println("1. Cadastrar Aluno");
        System.out.println("2. Pesquisar Aluno");
        System.out.println("3. Remover Aluno");
        System.out.println("4. Atualizar Aluno");
        System.out.println("0. Sair");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                Aluno novoAluno = dadosNovoAluno();
                cadAluno.cadastrarAluno(novoAluno);
                break;

            case 2:
                System.out.print("Digite a matrícula do aluno: ");
                String matricula = scanner.nextLine();
                Aluno alunoCadastrado = cadAluno.pesquisarAluno(matricula);
                System.out.println(alunoCadastrado);
                break;

            case 3:
                System.out.print("Digite a matrícula do aluno a remover: ");
                matricula = scanner.nextLine();
                Aluno alunoRemover = cadAluno.pesquisarAluno(matricula);
                if (alunoRemover == null) {
                    break;
                }
                cadAluno.removerAluno(alunoRemover, matricula);
                break;
            case 4:

                System.out.print("Digite a matrícula do aluno a atualizar: ");
                matricula = scanner.nextLine();
                Aluno alunoAtualizado = dadosNovoAluno();
                cadAluno.atualizarAluno(matricula, alunoAtualizado);
                break;

            case 0:
                System.out.println("Saindo do menu...");
                break;
            default:
                System.out.println("Opção inválida.");
        }

    }

    public Aluno dadosNovoAluno() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Curso: ");
        String curso = scanner.nextLine();

        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setCpf(cpf);
        aluno.setEmail(email);
        aluno.setMatricula(matricula);
        aluno.setCurso(curso);

        return aluno;
    }

}
