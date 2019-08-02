package br.com.in6.kotlin.domain.users

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name = "redesocial")
data class RedeSocial (
        @Id
        @GeneratedValue
        val id: Long = 0,
        val tipo: RedeSocialTipo,
        val valor: String
) {
    @ManyToOne(optional = false)
    @JoinColumn(name = "pessoa_id", nullable = false)
    @JsonBackReference
    var pessoa: Pessoa? = null
}
