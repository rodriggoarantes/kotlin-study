package br.com.in6.kotlin.domain.enderecos

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name = "estado")
data class Estado (
        @Id
        @GeneratedValue
        val id: Long = 0,
        val nome: String,
        val uf: String
) {
        @OneToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "pais_id", referencedColumnName = "id", nullable = false)
        @JsonManagedReference
        var pais: Pais? = null
}
