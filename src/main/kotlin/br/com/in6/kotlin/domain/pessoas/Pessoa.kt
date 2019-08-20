package br.com.in6.kotlin.domain.pessoas

import br.com.in6.kotlin.domain.enderecos.Endereco
import br.com.in6.kotlin.domain.usuarios.Usuario
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

        @ManyToMany(cascade = [CascadeType.ALL])
        @JoinTable(
                name = "pessoa_endereco",
                joinColumns = [JoinColumn(name = "pessoa_id", referencedColumnName = "id")],
                inverseJoinColumns = [JoinColumn(name = "endereco_id", referencedColumnName = "id")] )
        var enderecos: MutableList<Endereco>? = mutableListOf()
}
