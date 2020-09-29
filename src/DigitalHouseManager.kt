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
    
}