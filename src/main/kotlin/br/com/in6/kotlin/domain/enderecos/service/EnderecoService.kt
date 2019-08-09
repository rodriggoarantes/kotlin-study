package br.com.in6.kotlin.domain.enderecos.service

import br.com.in6.kotlin.domain.enderecos.Endereco
import br.com.in6.kotlin.domain.enderecos.Estado
import br.com.in6.kotlin.domain.enderecos.Pais
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
        return checkNotNull( enderecoRepository.save(endereco) )
    }

    fun deletar(id: Long) {
        enderecoRepository.deleteById(id)
    }

    fun listar() : Iterable<Endereco> {
        return enderecoRepository.findAll().toMutableList()
    }

    fun atualizar(obj: Endereco) : Endereco? {
        this.obter(obj.id!!) ?: throw IllegalArgumentException("Endereco nao encontrado para atualização")
        return enderecoRepository.save(obj)
    }

    fun listarPaises() : Iterable<Pais> {
        return paisRepository.findAll()
    }

    fun listarEstados() : Iterable<Estado> {
        return estadoRepository.findAll()
    }

    fun listarEstadosPorPais(param: Pais) : Iterable<Estado> {
        return estadoRepository.findByPais(param)
    }
}