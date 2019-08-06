package br.com.in6.kotlin.domain.enderecos

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name = "cidade")
data class Cidade (
        @Id
        @GeneratedValue
        val id: Long = 0,
        val nome: String
) {
        @OneToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "estado_id", referencedColumnName = "id", nullable = false)
        @JsonManagedReference
        var estado: Estado? = null
}
