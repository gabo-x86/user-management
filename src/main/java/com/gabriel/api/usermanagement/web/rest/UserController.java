package com.gabriel.api.usermanagement.web.rest;

import com.gabriel.api.usermanagement.dto.UserDetailDTO;
import com.gabriel.api.usermanagement.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDetailDTO>> listUsers(@RequestParam(required = false, defaultValue = "false") boolean detailed){
        if(detailed){
            return ResponseEntity
                    .ok()
                    .body(this.userService.listUsersDetailed());
        }else{
            return ResponseEntity
                    .ok()
                    .body(this.userService.listUsers());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailDTO> getUserById(@PathVariable final Integer id){
        return ResponseEntity
                .ok()
                .body(this.userService.getUserById(id).orElseThrow(
                        () -> new IllegalArgumentException("Resource not found exception for id: "+id)
                ));
    }

    @PostMapping
    public ResponseEntity<UserDetailDTO> createUser(@RequestBody final UserDetailDTO dto) throws URISyntaxException {
        if(dto.getId() != null){
            throw new IllegalArgumentException("A new user should not have an id");
        }
        dto.setCreatedAt(LocalDateTime.now());
        UserDetailDTO userDetailDTO = this.userService.save(dto);

        return ResponseEntity
                .created(new URI("/v1/users/"+userDetailDTO.getId()))
                .body(userDetailDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDetailDTO> deleteUser(@PathVariable final Integer id) {
        this.userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDetailDTO> editUser(@RequestBody final UserDetailDTO dto,
                                                  @PathVariable final Integer id){
        if(dto == null){
            throw new IllegalArgumentException("There isn't data");
        }

        if(!Objects.equals(dto.getId(), id)){
            throw new IllegalArgumentException("Invalid user id");
        }

        return ResponseEntity
                .ok()
                .body(this.userService.edit(dto));
    }

    @GetMapping("/by-role")
    public ResponseEntity<List<UserDetailDTO>> listUsersByRol(@RequestParam(required = false, defaultValue = "") String rolName){
        return ResponseEntity
                .ok()
                .body(this.userService.listUsersByRol(rolName));

    }
}
