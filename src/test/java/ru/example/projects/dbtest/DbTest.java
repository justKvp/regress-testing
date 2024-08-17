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
        databaseSession.persist(testUser);
        databaseSession.getTransaction().commit();

        Long id = testUser.getEmpCodeId();

        //docker run --name selectel-pgdocker -e POSTGRES_PASSWORD=selectel -e POSTGRES_USER=selectel -e POSTGRES_DB=selectel -d -p 5432:5432 -v $HOME/docker/volumes/postgres:/var/lib/postgresql/data postgres
        //docker run --restart=always --name some-postgres -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 -v $HOME/docker/volumes/postgres:/var/lib/postgresql/data postgres
        Assertions.assertTrue(id > 0);
    }
}
