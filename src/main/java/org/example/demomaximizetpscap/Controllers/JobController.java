package org.example.demomaximizetpscap.Controllers;

import org.example.demomaximizetpscap.ApiManager;
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
    ApiManager apiManager;
    @GetMapping("/characters/")
    public List<CharacterEntity> getCharacters(){
        List<CharacterEntity> characters = apiManager.getNarutoCharacters();
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
