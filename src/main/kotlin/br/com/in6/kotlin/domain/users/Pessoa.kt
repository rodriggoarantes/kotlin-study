package br.com.in6.kotlin.domain.users

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name = "pessoa")
data class Pessoa (
        @Id @GeneratedValue
        val id: Long = 0,
        val nome: String,
        val email: String
) {
        @OneToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = true)
        @JsonManagedReference
        var usuario: Usuario? = null

        @OneToMany(mappedBy = "pessoa", cascade = [CascadeType.ALL], orphanRemoval = true)
        @JsonManagedReference
        var emails: MutableList<Email>? = mutableListOf()

        @OneToMany(mappedBy = "pessoa", cascade = [CascadeType.ALL], orphanRemoval = true)
        @JsonManagedReference
        var telefones: MutableList<Telefone>? = mutableListOf()

        @OneToMany(mappedBy = "pessoa", cascade = [CascadeType.ALL], orphanRemoval = true)
        @JsonManagedReference
        var redeSociais: MutableList<RedeSocial>? = mutableListOf()
}
