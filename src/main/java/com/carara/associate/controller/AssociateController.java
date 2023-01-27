package com.carara.associate.controller;

import com.carara.associate.domain.entity.Associate;
import com.carara.associate.service.AssociateService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/associates")
@AllArgsConstructor
public class AssociateController {

    AssociateService associateService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Associate>> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(associateService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Associate> createAssociate(@Valid @RequestBody Associate associate) {
        Associate associateEntity = associateService.createAssociate(associate);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(associateEntity.getId())
                .toUri();
        return ResponseEntity.created(location)
                .body(associateEntity);
    }
}
