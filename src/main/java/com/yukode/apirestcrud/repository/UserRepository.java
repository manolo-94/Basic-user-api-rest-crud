package com.yukode.apirestcrud.repository;

import com.yukode.apirestcrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // Marca esta interface como un repositorio de Spring Data.
// JpaReposity<User, Long> Provee operaciones CRUD para la entidad User. El parametro Long indica el tipo de llave primaria.
public interface UserRepository extends JpaRepository<User, Long> {
    
}
