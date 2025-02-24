package com.example.springbootcourse.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.springbootcourse.dtos.ProductRecordDto;
import com.example.springbootcourse.models.ProductModel;
import com.example.springbootcourse.repositories.ProductRepository;

import jakarta.validation.Valid;

@RestController
public class ProductController {

    @Autowired // Utilizado para fazer uma dependency injection de maneira "automática"
    // Estamos informando ao spring que o objeto productRepository será usado nesse Controller.
    ProductRepository productRepository;

    @PostMapping("/products") //Iremos mapear os dados, validar e salvar o recurso recebido por JSON, usando um DTO (Data Object Transfer)
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto){
        var productModel = new ProductModel(); // Uma boa prática, instanciar var dentro de módulos quando possível (reduz a quantidade de código e facilita a lógica)
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }
    
    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }

    @GetMapping("products/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value = "id") UUID id){
        Optional<ProductModel> product = productRepository.findById(id);
        if(product.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(product.get());
    }

    @PutMapping(("products/{id}"))
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") UUID id, @RequestBody @Valid ProductRecordDto productRecordDto){
        Optional<ProductModel> product = productRepository.findById(id);
        if(product.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }

        var productModel = product.get();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") UUID id, @RequestBody @Valid ProductRecordDto productRecordDto){
        Optional<ProductModel> product = productRepository.findById(id);

        if(product.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        productRepository.delete(product.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfuly.");
    }
}
