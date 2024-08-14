package com.yukode.apirestcrud.dto;

import lombok.Data;

// La clase UserDTO (Data Transfer Object) es usada para tranferir informacion entre capas. Es una version simplificado de la clase User Model pero enfocada en la informacion que necesita el cliente enfocandose en que solo se expongan los datos necesarios.
// Es una simple POJO (Plain Old Java Object) representa la informacion que es transferida, No contiene ninguna logica de negocio.

@Data // Simplifica la creacion de getters, setter y otras propiedades del modelo.
public class UserDTO {

    private Long id_usuario;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
}
