package br.com.mozar7.marketplace.service;

import br.com.mozar7.marketplace.model.Produto;
import br.com.mozar7.marketplace.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public Produto criar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> listarPorId(UUID uuid) {
        return produtoRepository.findById(uuid);
    }

    public void deletar(UUID uuid) {
        produtoRepository.deleteById(uuid);
    }

    public Optional<Produto> atualizar(UUID uuid, Produto atualizarProduto) {
        Optional<Produto> optProduto = produtoRepository.findById(uuid);
        if (optProduto.isPresent()) {
            Produto produto = optProduto.get();
            produto.setNome(atualizarProduto.getNome());
            produto.setPreco(atualizarProduto.getPreco());
            produto.setDescricao(atualizarProduto.getDescricao());
            produto.setCategoria(atualizarProduto.getCategoria());
            produto.setStatus(atualizarProduto.getStatus());
            produto.setImagem(atualizarProduto.getImagem());

            produtoRepository.save(produto);
            return Optional.of(produto);
        }
        return Optional.empty();
    }
}
