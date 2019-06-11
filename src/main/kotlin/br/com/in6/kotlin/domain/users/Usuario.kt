package br.com.in6.kotlin.domain.users

import javax.persistence.*

@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
data class Usuario constructor(
        @Id
        @GeneratedValue
        val id: Long = 0,

        @Column(nullable = false)
        val login: String,

        @Column(nullable = false)
        val email: String,

        var foto : String = ""
) {
        @Transient
        var password: String? = ""
}

data class UsuarioDto(val id: Long, val login: String)

fun Usuario.toDTO() = UsuarioDto(
        id = id,
        login = login
)
