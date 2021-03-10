package com.amrut.prabhu;

import com.amrut.prabhu.api.AccountApiDelegate;
import com.amrut.prabhu.model.InlineObject;
import com.amrut.prabhu.model.InlineResponse200;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@Slf4j
public class AccountServiceImpl implements AccountApiDelegate {

    @Override
    public ResponseEntity<InlineResponse200> createAccount(InlineObject request) {
        log.info("Incoming request :{}", request);
        InlineResponse200 response = new InlineResponse200();
        response.accountId(UUID.randomUUID().toString())
                .accountType(request.getAccountType())
                .name(request.getName());
        log.info("Returning response :{}", response);
        return ResponseEntity.ok(response);
    }
}
