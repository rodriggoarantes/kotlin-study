package br.com.in6.kotlin.domain.enderecos

import br.com.in6.kotlin.domain.pessoas.Pessoa
import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name = "endereco")
data class Endereco (
        @Id
        @GeneratedValue
        val id: Long = 0,
        val descricao: String,
        val cep: String,
        val logradouro: String,
        val numero: Long,
        val complemento: String,
        val bairro: String,
        val tipo: EnderecoTipo
) {
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "cidade_id", referencedColumnName = "id", nullable = false)
    @JsonManagedReference
    var cidade: Cidade? = null
}
