package com.yukode.apirestcrud.controller;

// La clase UserController maneja las solicitudes HTTP entrantes y los asigna a los metodos de servicio
import com.yukode.apirestcrud.dto.UserDTO;
import com.yukode.apirestcrud.model.User;
import com.yukode.apirestcrud.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Maneja las solicitudes HTTP delegando la logica de negocio a la capa de servicio.
@RestController // Combina @Controller y @ResponseBody indica que este controlador retorna respuestas JSON.
@RequestMapping("/api/users") // Especifica las URL base para todos los endpoints relacionados con user. 
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping // Asigna metodos HTTP a metodos de servicio
    @Operation(summary = "Get all users", description = "Retrieve a list of all users")
     @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful retrieval of user list",
                content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = User.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by ID", description = "Retrieve a user by their unique ID")
    public Optional<UserDTO> getUserById(@Parameter(description = "ID of the user to retrieve", required = true) @PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new user", description = "Create a new users in the system")
    public UserDTO createUser(@Parameter(description = "User object to be created", required = true) @RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing user", description = "Update a user's information by their unique ID\"")
    public UserDTO updateUser(@Parameter(description = "ID of the user to update", required = true) @PathVariable Long id, @Parameter(description = "Updated user object", required = true) @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a user", description = "Delete a user by ID")
    public void deleteUser(@Parameter(description = "ID of the user to retrieve", required = true) @PathVariable Long id) {
        userService.deleteUser(id);
    }
}
