package org.example.demomaximizetpscap;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class DemoMaximizeTpsCapApplicationTests {

    @Test
    void contextLoads() {
    }

}
