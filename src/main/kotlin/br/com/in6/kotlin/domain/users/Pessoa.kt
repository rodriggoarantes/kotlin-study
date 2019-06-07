package br.com.in6.kotlin.domain.users

import javax.persistence.*

@Entity
@Table(name = "pessoa")
data class Pessoa (
        @Id
        @GeneratedValue
        val id: Long = 0,
        val nome: String,
        val email: String
) {

}

data class PessoaDto(
        val id: Long,
        val name: String,
        val email: String
)

fun Pessoa.toDTO() = PessoaDto(
        id = id,
        name = nome,
        email = email
)