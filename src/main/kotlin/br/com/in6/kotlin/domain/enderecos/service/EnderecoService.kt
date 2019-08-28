package br.com.in6.kotlin.domain.enderecos.service

import br.com.in6.kotlin.domain.enderecos.Endereco
import br.com.in6.kotlin.domain.enderecos.repository.CidadeRepository
import br.com.in6.kotlin.domain.enderecos.repository.EnderecoRepository
import br.com.in6.kotlin.domain.enderecos.repository.EstadoRepository
import br.com.in6.kotlin.domain.enderecos.repository.PaisRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class EnderecoService @Autowired constructor(
        val enderecoRepository: EnderecoRepository,
        val cidadeRepository: CidadeRepository,
        val estadoRepository: EstadoRepository,
        val paisRepository: PaisRepository
) {

    fun obter(id: Long) : Endereco? {
        return enderecoRepository.findByIdOrNull(id)
    }

    fun inserir(endereco: Endereco) : Endereco {
        this.normalizarEndereco(endereco, endereco)
        return checkNotNull( enderecoRepository.save(endereco) )
    }

    fun deletar(id: Long) {
        enderecoRepository.deleteById(id)
    }

    fun listar() : Iterable<Endereco> {
        return enderecoRepository.findAll().toMutableList()
    }

    fun atualizar(obj: Endereco) : Endereco {
        val endereco = this.obter(obj.id!!) ?: throw IllegalArgumentException("Endereco nao encontrado para atualização")
        this.normalizarEndereco(obj, endereco)

        endereco.logradouro = obj.logradouro
        endereco.numero = obj.numero
        endereco.bairro = obj.bairro
        endereco.cep = obj.cep
        endereco.complemento = obj.complemento
        endereco.descricao = obj.descricao
        endereco.tipo = obj.tipo

        return enderecoRepository.save(endereco)
    }

    fun listarEnderecoPorCep(cep: Long) : Iterable<Endereco> {
        return enderecoRepository.findByCep(cep)
    }

    fun normalizarEndereco(obj: Endereco, endPreencher: Endereco) {
        if ( obj.cidade!!.id > 0 ) {
            endPreencher.cidade = cidadeRepository.findByIdOrNull(obj.cidade!!.id)
        } else if ( obj.cidade!!.estado!!.id > 0) {
            endPreencher.cidade!!.estado = estadoRepository.findByIdOrNull(obj.cidade!!.estado!!.id)
        } else if ( obj.cidade!!.estado!!.pais!!.id > 0) {
            endPreencher.cidade!!.estado!!.pais = paisRepository.findByIdOrNull(obj.cidade!!.estado!!.pais!!.id)
        } else {

            throw IllegalArgumentException("Endereco nao informado de forma completa")
        }
    }
}