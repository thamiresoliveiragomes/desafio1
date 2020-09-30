class Curso(
        val nome: String,
        val codigo: Int,
        var profTitular: ProfessorTitular?,
        var profAdjunto: ProfessorAdjunto?,
        val quantidadeMaxAlunos: Int,
        var matriculados: MutableSet<Aluno> = mutableSetOf()
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Curso

        if (codigo != other.codigo) return false

        return true
    }

    override fun hashCode(): Int {
        return codigo
    }

    fun adicionarAluno(aluno: Aluno): Boolean{
        return if(matriculados.size == quantidadeMaxAlunos){
            false
        }else{
            matriculados.add(aluno)
            true
        }
    }

    fun excluirAluno(aluno: Aluno){
        matriculados.remove(aluno)
    }
}