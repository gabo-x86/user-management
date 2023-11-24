package com.gabriel.api.usermanagement.web.rest;

import com.gabriel.api.usermanagement.dto.RolDTO;
import com.gabriel.api.usermanagement.dto.UserDetailDTO;
import com.gabriel.api.usermanagement.services.RolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/roles")
public class RolController {
    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @PostMapping
    public ResponseEntity<RolDTO> createRol(@RequestBody final RolDTO dto) throws URISyntaxException {
        if(dto.getId() != null){
            throw new IllegalArgumentException("A new course should not have an id");
        }

        RolDTO rolDTO = this.rolService.saveRol(dto);

        return ResponseEntity
                .created(new URI("/v1/roles"+rolDTO.getId()))
                .body(rolDTO);
    }

    @GetMapping
    public ResponseEntity<List<RolDTO>> listRoles(){
        return ResponseEntity
                .ok()
                .body(this.rolService.listRoles());
    };

    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> getRolById(@PathVariable final Integer id){
        return ResponseEntity
                .ok()
                .body(this.rolService.getRolById(id).orElseThrow(
                        () -> new IllegalArgumentException("Resource not found exception for id: "+id)
                ));
    };

    @PutMapping("/{id}")
    public ResponseEntity<RolDTO> editRol(@RequestBody final RolDTO dto,
                                          @PathVariable final Integer id){
        if(dto == null){
            throw new IllegalArgumentException("There isn't data");
        }

        if(!Objects.equals(dto.getId(), id)){
            throw new IllegalArgumentException("Invalid role id");
        }

        return ResponseEntity
                .ok()
                .body(this.rolService.saveRol(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDetailDTO> deleteRol(@PathVariable final Integer id) {
        this.rolService.deleteRol(id);
        return ResponseEntity.noContent().build();
    }

}
