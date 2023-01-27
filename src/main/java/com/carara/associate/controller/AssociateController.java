package com.carara.associate.controller;

import com.carara.associate.domain.entity.Associate;
import com.carara.associate.service.AssociateService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/associates")
@AllArgsConstructor
public class AssociateController {

    AssociateService associateService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id) {
        return associateService.findById(id).<ResponseEntity<Object>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(String.format("Associate not found for id {%s}.", id)));
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
