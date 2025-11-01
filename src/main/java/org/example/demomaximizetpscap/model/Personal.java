package org.example.demomaximizetpscap.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Personal {
    private String status;
    private String kekkeiGenkai;
    private String classification;
    private List<String> jinchūriki;
    private List<String> titles;
}
