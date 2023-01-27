package com.carara.associate.service;

import com.carara.associate.domain.entity.Associate;
import com.carara.associate.infrastructure.repository.AssociateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AssociateService {

    AssociateRepository associateRepository;

    public Associate createAssociate(Associate associate) {
        cpfToNumbers(associate);

        return associateRepository.save(associate);
    }

    private static void cpfToNumbers(Associate associate) {
        associate.setCpf(associate.getCpf().replaceAll("\\D", ""));
    }


}
