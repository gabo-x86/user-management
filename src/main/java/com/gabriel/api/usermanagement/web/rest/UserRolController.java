package com.gabriel.api.usermanagement.web.rest;

import com.gabriel.api.usermanagement.domain.entities.UserRol;
import com.gabriel.api.usermanagement.services.UserRolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/users/{userId}/roles")
public class UserRolController {

    private final UserRolService userRolService;

    public UserRolController(UserRolService userRolService) {
        this.userRolService = userRolService;
    }

    @GetMapping
    public ResponseEntity<List<UserRol>> listUserRol(@PathVariable final Integer userId,
                                                     @RequestParam(required = false, defaultValue = "true") boolean activated){
        return ResponseEntity.ok().body(this.userRolService.getEnrollmentByUserId(userId, activated));
    }

    @PostMapping
    public ResponseEntity<UserRol> createUserRol(@RequestBody final UserRol userRol) throws URISyntaxException {
        if(userRol.getId() != null){
            throw new IllegalArgumentException("A new user rol shouldn't has an id");
        }
        userRol.setCreatedAt(LocalDateTime.now());
        userRol.setActive(true);
        UserRol userRolDB = this.userRolService.saveUserRol(userRol);

        return ResponseEntity
                .created(new URI("/v1/users" + userRolDB.getUser().getId() + "/roles/" + userRolDB.getId()))
                .body(userRolDB);
    }

    @PatchMapping("/{rolId}")
    public ResponseEntity<UserRol> inactivateUserRol(@PathVariable final Integer userId,
                                                     @PathVariable final Integer rolId){
        UserRol userRolDB = this.userRolService.disableUserRol(userId, rolId);
        return ResponseEntity
                .ok()
                .body(userRolDB);
    }
}
