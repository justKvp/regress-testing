package ru.example.projects.dbtest;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.example.framework.basetests.BaseTest;
import ru.example.framework.extensions.DatabaseExtension;
import ru.example.framework.managers.databasemgr.models.User;

@Tag("db")
@DisplayName("Проект: DbTest")
@ExtendWith(DatabaseExtension.class)
public class DbTest extends BaseTest {

    @Test
    @DisplayName("1 : Тест первый")
    @Description("Описание")

    void simpleTest() {
        User testUser = new User();
        testUser.setText("test text");

        databaseSession.beginTransaction();
        Long id = (Long) databaseSession.save(testUser);
        databaseSession.getTransaction().commit();

        Assertions.assertTrue(id > 0);
    }
}
