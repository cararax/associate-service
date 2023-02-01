package com.carara.associate.infrastructure.loader;

import com.carara.associate.domain.entity.Associate;
import com.carara.associate.infrastructure.repository.AssociateRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Log4j2(topic = "DataLoader")
public class DataLoader implements CommandLineRunner {

    AssociateRepository associateRepository;

    @Override
    public void run(String... args) {
        if(associateRepository.count() == 0) {
            loadAssociateData();
        }
    }

    public void loadAssociateData(){
        List<Associate> associateEntities = List.of(
                new Associate("38744925166", "manuel@rocha.com"),
                new Associate("08069406623", "juan@rodrigues.com"),
                new Associate("34413507746", "igor@lopes.com"),
                new Associate("69406545420", "clara@barros.com"),
                new Associate("40062708791", "elisa@peixoto.com"),
                new Associate("82987313527", "ana@brito.com"),
                new Associate("53392453226", "leandro@corte.com"),
                new Associate("95683312396", "arthur@vicente.com"),
                new Associate("99696748973", "carlos@mota.com"),
                new Associate("63609139331", "pedro@nascimento.com"));
        associateRepository.saveAll(associateEntities);
        log.info("Associates loaded to database");
    }
}
