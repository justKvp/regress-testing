package ru.example.projects.tmp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.example.framework.basetests.BaseTest;

@DisplayName("suite : TmpTest имя набора")
public class TmpTest extends BaseTest {

    @Tag("run")
    @Test
    @DisplayName("тест : simpleTest имя теста")
    public void simpleTest() {
        aftStep("первый шаг", (action)-> {

        });

        aftStep("второй шаг", (action)-> {

        });

        aftStep("третий шаг", (action)-> {

        });
    }

    @Tag("run")
    @Test
    @DisplayName("тест : simpleTest2 имя теста")
    public void simpleTest2() {
        aftStep("первый шаг", (action)-> {

        });

        aftStep("второй шаг", (action)-> {

        });

        aftStep("третий шаг", (action)-> {

        });
    }

    @Tag("run")
    @Test
    @DisplayName("тест : simpleTest3 имя теста")
    public void simpleTest3() {
        aftStep("первый шаг", (action)-> {

        });

        aftStep("второй шаг", (action)-> {

        });

        aftStep("третий шаг", (action)-> {

        });
    }
}
