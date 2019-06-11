package br.com.in6.kotlin.domain.users

import javax.persistence.*

@Entity
@Table(name = "email")
data class Email (
        @Id
        @GeneratedValue
        val id: Long = 0,
        val valor: String
) {
    @ManyToOne(optional = false)
    @JoinColumn(name = "pessoa_id", nullable = false)
    var pessoa: Pessoa? = null
}
