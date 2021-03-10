package com.amrut.prabhu;

import com.amrut.prabhu.api.AccountApi;
import com.amrut.prabhu.model.InlineObject;
import com.amrut.prabhu.model.InlineResponse200;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Controller {

    private final AccountApi accountAPI;

    public Controller(AccountApi accountApi) {
        this.accountAPI = accountApi;
        this.accountAPI.getApiClient()
                .setBasePath("http://localhost:8080");
    }

    @GetMapping("/call")
    public void callClient() {
        InlineObject request = new InlineObject();
        request.accountType("Savings")
                .residencyStatus("Resident")
                .name("Amrut Prabhu");

        log.info("Sending generated request: {}", request);
        InlineResponse200 account = this.accountAPI.createAccount(request);
        log.info("Received response: {}", account);
    }
}
