package com.yukode.apirestcrud.util;

// La clase UserMapper maneja la conversion entre entidades User y objetos UserDTO.
import com.yukode.apirestcrud.dto.UserDTO;
import com.yukode.apirestcrud.model.User;
import org.springframework.stereotype.Component;

// Mantiene la capa de servicio limpia mediante el manejo de la conversion entre DTO's y entidades.
@Component
public class UserMapper {
    
    public UserDTO toDto(User user) {
        UserDTO dto = new UserDTO();
        
        dto.setId_usuario(user.getId_usuario());
        dto.setNombre(user.getNombre());
        dto.setApellido(user.getApellido());
        dto.setEmail(user.getEmail());
        dto.setTelefono(user.getTelefono());
        return dto;
    }
    
    public User toEntity(UserDTO userDTO){
        User user = new User();
        
        user.setId_usuario(userDTO.getId_usuario());
        user.setNombre(userDTO.getNombre());
        user.setApellido(userDTO.getApellido());
        user.setEmail(userDTO.getEmail());
        user.setTelefono(userDTO.getTelefono());
        return user;
    }
    
}
