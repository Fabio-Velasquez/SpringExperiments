package org.example.demomaximizetpscap.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CharacterEntity {


    private int id;
    private String name;
    private List<String> images;
    private Debut debut;
    private List<String> jutsu;
    private List<String> natureType;
    private Personal personal;
    private List<String> uniqueTraits;
}
