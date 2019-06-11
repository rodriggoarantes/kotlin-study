package br.com.in6.kotlin.domain.users

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import javax.persistence.*

@Entity
@Table(name = "usuario")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator::class, property="id")
data class Usuario constructor(
        @Id
        @GeneratedValue
        val id: Long = 0,

        @Column(nullable = false)
        val login: String = "",

        @Column(nullable = false)
        val email: String = "",

        var foto : String = ""
) {
        @OneToOne(mappedBy = "usuario")
        @JsonBackReference
        var pessoa : Pessoa? = null

        @Transient
        var password: String? = ""
}

data class UsuarioDto(val id: Long, val login: String)

fun Usuario.toDTO() = UsuarioDto(
        id = id,
        login = login
)
