import java.util.*

data class Matricula(
        val aluno: Aluno,
        val curso: Curso,
        var dataMatricula: Date = Date()
)