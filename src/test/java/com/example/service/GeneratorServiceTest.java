package com.example.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = GeneratorService.class)
public class GeneratorServiceTest {

    @Autowired
    GeneratorService generatorService;

    @Value("${user.account}")
    public String userAccount;

    @Test
    public void givenDefaultTPS_whenVariableRetrieved_thenDefaultFileReturned() {
        String secretKey = generatorService.getSecretKey();
        assertThat(secretKey).isEqualTo("HNRAVAH432QUBFOD3AW2NM2T3MGWRNOP");
    }

    @Test
    public void shouldGenerateSecretKey() {
        // When
        final String key = generatorService.generateSecretKey();
        // Then
        System.out.println(key);
    }

    @Test
    public void shouldGenerateTimeBasedCode() {
        String secretKey = "HNRAVAH432QUBFOD3AW2NM2T3MGWRNOP";
        String lastCode = null;
        while (true) {
            String code = generatorService.getTOTPCode(secretKey);
            if (!code.equals(lastCode)) {
                System.out.println(code);
            }
            lastCode = code;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    @Test
    public void shouldGenerateBarCode() {
        // Given

        // When
        final String code = generatorService.getGoogleAuthenticatorBarCode(generatorService.getSecretKey(), userAccount, "blah");
        // Then
        System.out.println(">>>>" + code + "<<<<");
    }
}