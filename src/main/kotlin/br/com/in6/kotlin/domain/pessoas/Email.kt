package br.com.in6.kotlin.domain.pessoas

import com.fasterxml.jackson.annotation.JsonBackReference
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
    @JsonBackReference
    var pessoa: Pessoa? = null
}
