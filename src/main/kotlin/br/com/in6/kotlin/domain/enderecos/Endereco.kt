package br.com.in6.kotlin.domain.enderecos

import br.com.in6.kotlin.domain.pessoas.Pessoa
import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name = "endereco")
data class Endereco (
        @Id
        @GeneratedValue
        val id: Long = 0,
        val logradouro: String
) {
    @ManyToOne(optional = false)
    @JoinColumn(name = "pessoa_id", nullable = false)
    @JsonBackReference
    var pessoa: Pessoa? = null
}
