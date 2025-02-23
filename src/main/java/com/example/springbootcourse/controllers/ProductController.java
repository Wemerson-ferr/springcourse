package com.example.springbootcourse.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }


}
