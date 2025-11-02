package org.example.demomaximizetpscap;

import org.example.demomaximizetpscap.ApiProcessor.ApiProcessor;
import org.example.demomaximizetpscap.Monitor.ThreadMonitor;
import org.example.demomaximizetpscap.Service.Naruto;
import org.example.demomaximizetpscap.model.CharacterEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiManager {
    private final ApiProcessor<CharacterEntity> processor;
    private final Naruto naruto;

    public ApiManager(ApiProcessor<CharacterEntity> processor, Naruto naruto, ThreadMonitor monitor) {
        this.processor = processor;
        this.naruto = naruto;
        monitor = new ThreadMonitor(processor.getExecutorService());
        monitor.start();
    }

    public List<CharacterEntity> getNarutoCharacters() {
        List<String> ids = List.of("1","2","3","4","5","6");
        return processor.process(ids, naruto);
    }
}
