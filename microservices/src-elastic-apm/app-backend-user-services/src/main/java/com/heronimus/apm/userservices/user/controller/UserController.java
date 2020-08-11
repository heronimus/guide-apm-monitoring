package com.heronimus.apm.userservices.user.controller;

import com.heronimus.apm.userservices.user.rest.UserResource;
import com.heronimus.apm.userservices.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users/{id}")
    public Mono<UserResource> get(@PathVariable("id") String id) {
        return userService.get(id).map(UserResource::from);
    }

    @GetMapping("/users")
    public Flux<UserResource> getAll() {
        return userService.getAll().map(UserResource::from);
    }

    @PostMapping("/users")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mono<UserResource> create(@RequestBody @Valid UserResource user) {
        return userService.create(user.toModel()).map(UserResource::from);
    }
}
