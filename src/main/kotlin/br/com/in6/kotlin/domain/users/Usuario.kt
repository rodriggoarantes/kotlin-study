package br.com.in6.kotlin.domain.users

data class Usuario constructor(val id: Int, val name: String) {
    class Builder {
        private var id : Int = 0
        private var name : String = ""

        fun id(id: Int) = apply { this.id = id }
        fun name(name: String) = apply { this.name = name }

        fun build() = Usuario(
                id,
                name
        )
    }

    companion object {
        fun generate() : List<Usuario> {
            return listOf(Usuario(1, "Generated"))
        }
    }
}

