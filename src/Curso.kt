class Curso (
        val nome: String,
        val codigo: Int,
        var profTitular: ProfessorTitular,
        var profAdjunto: ProfessorAdjunto,
        val quantidadeMaxAlunos: Int,
        var matriculados: MutableList<Aluno>
){
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