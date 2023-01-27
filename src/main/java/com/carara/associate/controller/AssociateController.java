package com.carara.associate.controller;

import com.carara.associate.domain.entity.Associate;
import com.carara.associate.service.AssociateService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/associates")
@AllArgsConstructor
public class AssociateController {

    AssociateService associateService;

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
