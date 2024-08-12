package cadastros;

import java.util.ArrayList;
import java.util.List;

import app.Aluno;
import exceptions.JaCadastradoException;
import exceptions.NaoCadastradoException;

public class CadastroAluno {
	int numAlunos;
	private List<Aluno> alunos;

	public CadastroAluno() {
		numAlunos = 0;
		alunos = new ArrayList<Aluno>();
	}

	public int cadastrarAluno(Aluno a) throws JaCadastradoException {
		for (Aluno aluno : alunos) {
			if (aluno.getMatricula().equalsIgnoreCase(a.getMatricula())) {
				throw new JaCadastradoException("Aluno com matrícula " + a.getMatricula() + " já está cadastrado.");
			}
		}
		boolean cadastrou = alunos.add(a);
		if (cadastrou) {
			numAlunos = alunos.size();
		}
		return numAlunos;
	}

	public Aluno pesquisarAluno(String matriculaAluno) throws NaoCadastradoException {
		for (Aluno a : alunos) {
			if (a.getMatricula().equalsIgnoreCase(matriculaAluno)) {
				return a;
			}
		}
		throw new NaoCadastradoException("Aluno com matrícula " + matriculaAluno + " não está cadastrado.");
	}

	public boolean removerAluno(Aluno a) throws NaoCadastradoException {
		if (a == null || !alunos.contains(a)) {
			throw new NaoCadastradoException("Aluno não está cadastrado.");
		}
		return alunos.remove(a);
	}

	public boolean atualizarAluno(String matricula, Aluno a) throws NaoCadastradoException {
		Aluno remover = pesquisarAluno(matricula);
		if (remover != null) {
			alunos.remove(remover);
			return alunos.add(a);
		}
		throw new NaoCadastradoException("Aluno com matrícula " + matricula + " não está cadastrado.");
	}
}
