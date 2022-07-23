package com.amrut.prabhu;

import com.amrut.prabhu.api.AccountApiDelegate;
import com.amrut.prabhu.model.CreateAccount200Response;
import com.amrut.prabhu.model.CreateAccountRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@Slf4j
public class AccountServiceImpl implements AccountApiDelegate {

    @Override
    public ResponseEntity<CreateAccount200Response> createAccount(CreateAccountRequest request) {
        log.info("Incoming request :{}", request);
        CreateAccount200Response response = new CreateAccount200Response();
        response.accountId(UUID.randomUUID().toString())
                .accountType(request.getAccountType())
                .name(request.getName());
        log.info("Returning response :{}", response);
        return ResponseEntity.ok(response);
    }
}
