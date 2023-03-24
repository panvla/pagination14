package com.vladimirpandurov.paginationB.controller;

import com.vladimirpandurov.paginationB.domain.HttpResponse;
import com.vladimirpandurov.paginationB.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<HttpResponse> getUsers(@RequestParam Optional<String> name,
                                                 @RequestParam Optional<Integer> page,
                                                 @RequestParam Optional<Integer> size){
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                .timeStamp(LocalDateTime.now().toString())
                .statusCode(HttpStatus.OK.value())
                .status(HttpStatus.OK)
                .message("Users retrieved")
                .data(Map.of("page", this.userService.getUsers(name.orElse(""), page.orElse(0), size.orElse(10))))
                .build()
        );
    }

}
