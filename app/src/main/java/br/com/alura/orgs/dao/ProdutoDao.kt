package br.com.alura.orgs.dao

import br.com.alura.orgs.model.Produto

class ProdutoDao {

    fun create(produto: Produto){
        produtos.add(produto)
    }

    fun findAll() : List<Produto>{
        return Companion.produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }
}