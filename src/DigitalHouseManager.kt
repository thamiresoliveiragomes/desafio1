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
    
}