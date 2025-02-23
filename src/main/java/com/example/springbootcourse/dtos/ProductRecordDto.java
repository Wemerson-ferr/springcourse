package com.example.springbootcourse.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// Record é uma classe que armazena dados, porém ela é imutável. Ou seja, uma vez declarada não pode ser modificado os dados.
// Possui construtor, atributos e metodos auxiliares além de equals, hashCode e toString().
// No caso, precisamos colocar os parametros que a classe irá armazenar, nesse caso name e value.
// Usamos as ano annotations @NotBlank e @NotNull para definir regras de validação dos valores
public record ProductRecordDto(@NotBlank String name, @NotNull BigDecimal value) {

}
