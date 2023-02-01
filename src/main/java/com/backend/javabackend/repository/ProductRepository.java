package com.backend.javabackend.repository;

import com.backend.javabackend.model.Product;
import com.backend.javabackend.model.exception.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private List<Product> products = new ArrayList<>();
    private Long lastId = 0L;

    /**
     * Metodo para retornar uma lista de produto
     * @return Lista de produtos.
     */
    public List<Product> getAll(){
        return products;
    }

    /**
     * Metodo que retorna produto filtrando por Id.
     * @param id do produto que será localizado
     * @return Retorna um produto.
     */
    public Optional<Product> getPerId(Long id){
        return products
                .stream()
                .filter(product ->  product.getId() == id)
                .findFirst();
    }

    /**
     * Metodo para adicionar um novo produto
     * @param product produto qye sera adicionaod
     * @return Retorna o produto que foi adicionado a lista
     * */
    public Product addProduct(Product product){
        lastId++;

        product.setId(lastId);
        products.add(product);

        return product;
    }

    /**
     * Metodo para deletar produto por id
     * @param id do produto a ser deletado
     * */
    public void deleteProduct(Long id){
        products.removeIf(product -> product.getId() == id );
    }

    /**
     * Metodo para atualizar o produto
     * @param product produto a ser atualizado
     * @return Retorna o produto apos atualizacao
     * */
    public Product updateProduct(Product product){
        Optional<Product> productFound = getPerId(product.getId());

        if(productFound.isEmpty()){
            throw new ResourceNotFoundException("Produto não encontrado");
        }
        deleteProduct(product.getId());
        products.add(product);
        return product;
    }

}

