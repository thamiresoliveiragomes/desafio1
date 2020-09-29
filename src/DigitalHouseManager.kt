import java.util.*

class DigitalHouseManager(
        var alunos: MutableList<Aluno>,
        var professores: MutableList<Professor>,
        var cursos: MutableList<Curso>,
        var matriculas: MutableList<Matricula>
){
    fun registrarCurso(nome: String, codigoCurso: Int, quantidadeMaxAlunos: Int) {
        var novoCurso = Curso(nome = nome, codigo = codigoCurso, quantidadeMaxAlunos = quantidadeMaxAlunos)
        cursos.add(novoCurso)
    }

    fun excluirCurso(codigoCurso: Int) {
        cursos.forEach {
            if (it.codigo == codigoCurso) {
                cursos.remove(it)
            }
        }
    }

    fun registrarProfessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, horasMonitoria: Int){
        var tempoCasa: Int = 0
        var novoProfessorAdjunto = ProfessorAdjunto(nome, sobrenome, codigoProfessor, tempoCasa, horasMonitoria)
        professores.add(novoProfessorAdjunto)
    }

    fun registrarProfessorTitular(nome: String , sobrenome: String, codigoProfessor: Int, especialidade: String) {
        var tempoCasa: Int = 0
        var novoProfessorTitular = ProfessorTitular(nome, sobrenome, codigoProfessor, tempoCasa, especialidade)
        professores.add(novoProfessorTitular)
    }

    fun excluirProfessor(codigoProfessor: Int){
        professores.forEach {
            if (it.codigo == codigoProfessor) {
                professores.remove(it)
            }
        }
    }

    fun registrarAluno(nome: String, sobrenome: String, codigoAluno: Int){
        var novoAluno = Aluno(nome, sobrenome, codigoAluno)
        alunos.add(novoAluno)
    }

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int){
        var aluno: Aluno? = alunos.find { it.equals(codigoAluno) }
        var curso: Curso? = cursos.find { it.equals(codigoCurso) }

        if (aluno != null && curso != null) {
            if(curso.adicionarAluno(aluno)) {
                var novaMatricula = Matricula(aluno, curso, Date())
                matriculas.add(novaMatricula)
                print("Matrícula realizada!")
            }else{
                print("Não foi possível realizar a matrícula. No momento não há vagas disponíveis.")
            }
        } else {
            print("Não foi possível localizar código do aluno e/ou código do curso. Tente novamente.")
        }
    }

    fun alocarProfessores(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int){
        var curso = cursos.find { it.equals(codigoCurso) }
        var professorTitular = professores.find { it.equals(codigoProfessorTitular) }
        var professorAdjunto = professores.find { it.equals(codigoProfessorAdjunto) }

        if(curso != null){
            if (professorTitular != null && professorAdjunto != null){
                curso.profAdjunto = professorAdjunto as ProfessorAdjunto
                curso.profTitular = professorTitular as ProfessorTitular
                println("Professores alocados no curso.")
            }else{
                println("Professores não encontrados. Verifique os códigos digitados.")
            }
        }else{
            println("Curso não encontrado. Verifique o código digitado.")
        }
    }




}