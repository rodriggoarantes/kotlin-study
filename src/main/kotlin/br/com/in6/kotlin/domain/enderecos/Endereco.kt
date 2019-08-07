package br.com.in6.kotlin.domain.enderecos

import javax.persistence.*

@Entity
@Table(name = "endereco")
data class Endereco (
        @Id
        @GeneratedValue
        val id: Long = 0,
        val descricao: String,
        val cep: Long,
        val logradouro: String,
        val numero: Long,
        val complemento: String,
        val bairro: String,
        val tipo: EnderecoTipo
) {
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "cidade_id", referencedColumnName = "id", nullable = false)
    var cidade: Cidade? = null
}
