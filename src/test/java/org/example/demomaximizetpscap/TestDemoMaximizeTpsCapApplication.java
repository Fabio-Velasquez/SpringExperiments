package org.example.demomaximizetpscap;

import org.springframework.boot.SpringApplication;

public class TestDemoMaximizeTpsCapApplication {

    public static void main(String[] args) {
        SpringApplication.from(DemoMaximizeTpsCapApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
