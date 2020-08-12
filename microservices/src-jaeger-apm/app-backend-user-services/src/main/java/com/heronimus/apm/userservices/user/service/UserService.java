package com.heronimus.apm.userservices.user.service;

import com.heronimus.apm.userservices.user.model.User;
import com.heronimus.apm.userservices.user.repository.UserRepository;
import com.heronimus.apm.userservices.user.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@AllArgsConstructor
@Component
public class UserService {
    private final UserRepository userRepository;

    public Mono<User> get(String id) {
        return userRepository.findById(id)
                .switchIfEmpty(Mono.error(new UserNotFoundException()));
    }

    public Flux<User> getAll() {
        return userRepository.findAll()
                .switchIfEmpty(Mono.error(new UserNotFoundException()));
    }

    public Mono<User> create(User user) {
        return userRepository.save(user);
    }
}
