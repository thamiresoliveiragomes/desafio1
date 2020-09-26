data class Curso (
        val nome: String,
        val codigo: Int,
        var profTitular: ProfessorTitular,
        var profAdjunto: ProfessorAdjunto,
        val quantidadeMaxAlunos: Int,
        var matriculados: MutableList<Aluno>
)