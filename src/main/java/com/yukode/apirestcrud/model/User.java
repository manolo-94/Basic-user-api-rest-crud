package com.yukode.apirestcrud.model;

import jakarta.persistence.*;
import lombok.Data;

@Data // Simplifica la creacion de getters, setter y otras propiedades del modelo.
@Entity // Marca esta clase como una entidad JPA mapeando la tabla en la base de datos.
@Table(name = "usuario") // Especifica el nombre de la tabla en la base de datos.

public class User {
    
    @Id // Definicimos la llave primaria de la entidad.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica que la llave primaria es autoincrementable.
    @Column(name = "id_usuario")
    private Long id_usuario;
    
    @Column(name = "nombre", nullable = false) // Especificamos el nombre de sus columnas y sus propiedades
    private String nombre;
    
    @Column(name = "apellido", nullable = false) // Especificamos el nombre de sus columnas y sus propiedades
    private String apellido;
    
    @Column(name = "email", unique = true ,nullable = false) // Especificamos el nombre de sus columnas y sus propiedades
    private String email;
    
    @Column(name = "telefono", nullable = true) // Especificamos el nombre de sus columnas y sus propiedades
    private String telefono;
    
}
