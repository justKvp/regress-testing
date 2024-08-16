package ru.example.projects.tmp;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.example.framework.basetests.BaseTest;

public class TmpTest extends BaseTest {

    @Tag("run")
    @Test
    public void simpleTest() {
        aftStep("первый шаг", (action)-> {

        });

        aftStep("второй шаг", (action)-> {

        });

        aftStep("третий шаг", (action)-> {

        });
    }
}
