package com.carara.associate.controller;

import com.carara.associate.domain.entity.Associate;
import com.carara.associate.service.AssociateService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/associates")
@AllArgsConstructor
@Log4j2(topic = "AssociateController")
public class AssociateController {

    AssociateService associateService;

    @GetMapping("/{id}")
    public ResponseEntity<Associate> findById(@PathVariable("id") Long id) {
        log.info("Find associate by id: " + id);
        return associateService.findById(id).map(ResponseEntity::ok)
                .orElseThrow(() -> new EntityNotFoundException("Associate not found for id: " + id));
    }

    @PostMapping
    public ResponseEntity<Associate> createAssociate(@Valid @RequestBody Associate associate) {
        Associate associateEntity = associateService.createAssociate(associate);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(associateEntity.getId())
                .toUri();
        log.info("Associate created: " + associateEntity.toString());
        return ResponseEntity.created(location)
                .body(associateEntity);
    }
}
