package com.example.db;

import com.example.SpringInitializrApplication;
import com.example.model.User;
import com.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SpringInitializrApplication.class})
public class UserRepositoryTest {

    @Autowired
    UserService service;

    @Test
    public void shouldReadAndInsertUserEndToEnd() {
        // Given
        int id = 0;
        User user = new User();
        user.setName("Jon");
        user.setId(0);
        user.setEmail("jon@jon.com");
        user.setSecret("HNRAVAH432QUBFOD3AW2NM2T3MGWRNOP");

        // When
        User foundUser = service.getById(id);
        // Then
        assertThat(foundUser).isEqualTo(user);

        service.deleteUser(user);
        // When
        foundUser = service.getById(id);
        // Then
        assertThat(foundUser).isEqualTo(null);

        // When
        User saveUser = service.saveUser(user);

        // Then
        foundUser = service.getById(id);
        // Then
        assertThat(foundUser).isEqualTo(user);
    }

    @Test
    public void shouldLoadUser() {
        // Given
        int id = 0;
        User user = new User();
        user.setName("Jon");
        user.setId(0);
        user.setEmail("jon@jon.com");
        user.setSecret("HNRAVAH432QUBFOD3AW2NM2T3MGWRNOP");

        // When
        User byId = service.getById(id);

        // Then
        assertThat(byId).isEqualTo(user);
    }
}