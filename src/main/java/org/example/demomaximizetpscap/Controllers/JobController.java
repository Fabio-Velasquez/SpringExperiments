package org.example.demomaximizetpscap.Controllers;

import org.example.demomaximizetpscap.Service.Naruto;
import org.example.demomaximizetpscap.model.CharacterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RestController()
public class JobController {
    @Autowired
    Naruto naruto;

    @GetMapping("/characters/")
    public List<CharacterEntity> getCharacters(){
        List<CharacterEntity> characters = Collections.synchronizedList(new ArrayList<>());
        ExecutorService executor = Executors.newFixedThreadPool(8);

        for(int i = 0; i < 20; i++) {
            int finalI = i;
            System.out.println(finalI);
            executor.submit(() -> {
                String threadName = Thread.currentThread().getName();
                long start = System.currentTimeMillis();
                System.out.println("[" + threadName + "] Starting request for ID " + finalI);

                characters.add(naruto.getCharacterById(String.valueOf(finalI)));
                System.out.println("[" + threadName + "] Finished request for ID " + finalI +
                        " in " + (System.currentTimeMillis() - start) + " ms");
            });

        }
        executor.shutdown();
        try {
            executor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return characters;
    }

    @GetMapping("test")
    public CharacterEntity testCharacter() {
        CharacterEntity c = new CharacterEntity();
        c.setId(1);
        c.setName("Naruto");
        return c;
    }
}
