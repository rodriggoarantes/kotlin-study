package br.com.in6.kotlin.domain.users

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Usuario constructor(@Id @GeneratedValue var id: Long? = null, var name: String) {

    class Builder {
        private var id : Long = 0
        private var name : String = ""

        fun id(id: Long) = apply { this.id = id }
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

