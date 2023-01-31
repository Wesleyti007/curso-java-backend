package com.backend.javabackend.services;

import com.backend.javabackend.model.Product;
import com.backend.javabackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Metodo para retornar uma lista de produto
     * @return Lista de produtos.
     */
    public List<Product> getAll(){
      return productRepository.getAll();
    }

    /**
     * Metodo que retorna produto filtrando por Id.
     * @param id do produto que será localizado
     * @return Retorna um produto.
     */
    public Optional<Product> getPerId(Long id){
        return productRepository.getPerId(id);

    }

    /**
     * Metodo para adicionar um novo produto
     * @param product produto qye sera adicionaod
     * @return Retorna o produto que foi adicionado a lista
     * */
    public Product addProduct(Product product){
       return productRepository.addProduct(product);
    }

    /**
     * Metodo para deletar produto por id
     * @param id do produto a ser deletado
     * */
    public void deleteProduct(Long id){
        productRepository.deleteProduct(id);
    }

    /**
     * Metodo para atualizar o produto
     * @param product produto a ser atualizado
     * @param id do produto
     * @return Retorna o produto apos atualizacao
     * */
    public Product updateProduct(Long id, Product product){
        product.setId(id);
        return productRepository.updateProduct(product);
    }
}
