package com.example.springdatarelational32.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.spel.spi.EvaluationContextExtension;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TablePropertiesProvider implements EvaluationContextExtension {
    @Value("chins")
    String tabName;
    @Value("name")
    String column1Name;
    @Value("color")
    String column2Name;
    @Value("birthday")
    String column3Name;
    @Value("weight")
    String column4Name;
    @Value("sex")
    String column5Name;
    @Value("for_sale")
    String column6Name;

    public String getTabName() {
        return tabName;
    }

    public String getColumn1Name() {
        return column1Name;
    }

    public String getColumn2Name() {
        return column2Name;
    }

    public String getColumn3Name() {
        return column3Name;
    }

    public String getColumn4Name() {
        return column4Name;
    }

    public String getColumn5Name() {
        return column5Name;
    }

    public String getColumn6Name() {
        return column6Name;
    }

    @Override
    public String getExtensionId() {
        return "myFirstExtension";
    }
    @Override
    public Map<String, Object> getProperties() {
        return Map.of("tablePropertiesProvider", this);
    }

}
