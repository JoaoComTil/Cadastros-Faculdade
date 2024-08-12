

UnB - Universidade de Brasilia
FGA - Faculdade do Gama
OO - Orientação por Objetos
Prof. André Luiz Peron Martins Lanna

## Cadastros-Faculdade






Membros:
João Gabriel Milhomem de Brito - 221022005
----------------------------------------------------------

O seguinte programa foi criado como trabalho para exercitar os conceitos de programação orientada a objeto, exercitando tanto nos seus fundamentos, quanto no tratamento de exceções de java. Tem o intuito de realizar todas as operações tipicas que você veria em um programa de cadastro de faculdade como adicionar, pesquisar, remover e alterar entidades.

É composto de 5 pacotes.


**App:**  Classes base que do programa. Todos as outras funcionalidades girarão em torno desse pacote.




**cadastros:** Executam as operações associadas ao cadastro.



**view:** Programação dos menus.



**exceptions:** Todos os exceptions personalizados.



**Principal:** onde reside a classe usada para executar o programa.

![Cadastros-Faculdade drawio (1)](https://github.com/user-attachments/assets/af41f93e-c64a-40a9-96b8-9aad9267472b)

## Como Usar:


Execute a classe "Principal" para começar a rodar o programa. O usuário assim será apresentado ao menu principal, podendo escolher em ministrar operações a respeito de alunos, professores, turmas e disciplínas. Para escolher uma opção, basta escolher o numero associado à operações que quer realizar, sendo essa, a maneira de navegar pelo programa como todo.

![image](https://github.com/user-attachments/assets/cb950b29-34a3-4316-9af2-5151a6c06fb8)


Praticamente todas as operações associadas ao cadastro no programa usam um código para serem identificados. Então por exemplo, aluno é associado a sua matricula, então para alterar as informações de um aluno, o usuário deverá pôr a matricula antiga do aluno. Para pôr o aluno em uma turma, deverá pôr o número associado aquela turma e assim por diante.

## Exemplo:

![image](https://github.com/user-attachments/assets/26de5d5b-0a75-4bef-b1c7-9c6bf6b86d81)
![image](https://github.com/user-attachments/assets/22931b4b-6a7c-4170-b2fc-38cd8e57230f)




> [!WARNING]
> Todas as operações são relativamente simples de entender. Porém uma atenção extra é requerida no cadastro de turmas, pois sem código de disciplina associado, ou/e professor, aquela turma não poderá ser criada
