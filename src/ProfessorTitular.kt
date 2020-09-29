data class ProfessorTitular(
        override val nome: String,
        override val sobrenome: String,
        override val codigo: Int,
        override val tempoCasa: Int,
        val especialidade: String
): Professor