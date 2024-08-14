package com.yukode.apirestcrud.service;

// La clase UserService contiene la logica de negocio e interactua con la clase repositorio.
import com.yukode.apirestcrud.dto.UserDTO;
import com.yukode.apirestcrud.model.User;
import com.yukode.apirestcrud.repository.UserRepository;
import com.yukode.apirestcrud.util.UserMapper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// La capa de servicio encapsula la logica de negocio asegurandose que el controlador no se sobrecargue.
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public List<UserDTO> getAllUsers() {

        return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());

    }
    
    public Optional<UserDTO> getUserById(Long idUsuario){
        
        return userRepository.findById(idUsuario).map(userMapper::toDto);
        
    }
    
    public UserDTO createUser(UserDTO userDTO){
        
        User user = userMapper.toEntity(userDTO);
        
        user = userRepository.save(user);
        
        return userMapper.toDto(user);
    }
    
    public UserDTO updateUser(Long idUsuario, UserDTO userDTO){
    
        userDTO.setId_usuario(idUsuario);
        
        User user = userMapper.toEntity(userDTO);
        
        user = userRepository.save(user);
        
        return userMapper.toDto(user);
        
    }
    
    public void deleteUser(Long idUsuario){
        
        userRepository.deleteById(idUsuario);
        
    }

}
