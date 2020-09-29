import java.util.*

class DigitalHouseManager(
        var alunos: MutableList<Aluno>,
        var professores: MutableList<Professor>,
        var cursos: MutableList<Curso>,
        var matriculas: MutableList<Matricula>
){
    fun registrarCurso(nome: String, codigoCurso: Int, quantidadeMaxAlunos: Int) {
        var novoCurso = Curso(nome = nome, codigo = codigoCurso, quantidadeMaxAlunos = quantidadeMaxAlunos)
        if(cursos.add(novoCurso)){
            print("Curso registrado!")
        }else{
            println("Não foi possível registrar o curso. Verifique os dados inseridos.")
        }
    }

    fun excluirCurso(codigoCurso: Int) {
        cursos.forEach {
            if (it.codigo == codigoCurso) {
                if(cursos.remove(it)){
                    println("Curso removido!")
                }
            }else{
                println("Não foi possível remover o curso.")
            }
        }
    }

    fun registrarProfessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, horasMonitoria: Int){
        var tempoCasa: Int = 0
        var novoProfessorAdjunto = ProfessorAdjunto(nome, sobrenome, codigoProfessor, tempoCasa, horasMonitoria)
        if(professores.add(novoProfessorAdjunto)){
            println("Professor Adjunto registrado!")
        }else{
            println("Não foi possível registrar o professor. Verifique os dados inseridos.")
        }
    }

    fun registrarProfessorTitular(nome: String , sobrenome: String, codigoProfessor: Int, especialidade: String) {
        var tempoCasa: Int = 0
        var novoProfessorTitular = ProfessorTitular(nome, sobrenome, codigoProfessor, tempoCasa, especialidade)
        if(professores.add(novoProfessorTitular)){
            println("Professor Titular registrado!")
        }else{
            println("Não foi possível registrar o professor. Verifique os dados inseridos.")
        }
    }

    fun excluirProfessor(codigoProfessor: Int){
        professores.forEach {
            if (it.codigo == codigoProfessor) {
                if(professores.remove(it)){
                    println("Professor removido.")
                }else{
                    println("Não foi possível remover o professor")
                }
            }else{
                println("Professor não localizado. Verifique o código inserido.")
            }
        }
    }

    fun registrarAluno(nome: String, sobrenome: String, codigoAluno: Int){
        var novoAluno = Aluno(nome, sobrenome, codigoAluno)
        if(alunos.add(novoAluno)){
            println("Aluno registrado!")
        }else{
            println("Não foi possível fazer o registro do aluno.")
        }
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

    fun alocarProfessores(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int) {
        var curso = cursos.find { it.equals(codigoCurso) }
        var professorTitular = professores.find { it.equals(codigoProfessorTitular) }
        var professorAdjunto = professores.find { it.equals(codigoProfessorAdjunto) }

        if (curso != null) {
            if (professorTitular != null && professorAdjunto != null) {
                curso.profAdjunto = professorAdjunto as ProfessorAdjunto
                curso.profTitular = professorTitular as ProfessorTitular
                println("Professores alocados no curso.")
            } else {
                println("Professores não encontrados. Verifique os dados inseridos.")
            }
        } else {
            println("Curso não encontrado. Verifique o código digitado.")
        }
    }

}