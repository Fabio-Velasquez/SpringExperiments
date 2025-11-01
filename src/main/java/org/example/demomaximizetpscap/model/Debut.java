package org.example.demomaximizetpscap.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Debut {
    private String manga;
    private String anime;
    private String novel;
    private String movie;
    private String game;
    private String ova;
    private String appearsIn;
}
