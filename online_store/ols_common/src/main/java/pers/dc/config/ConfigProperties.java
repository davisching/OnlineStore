package pers.dc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "config")
public class ConfigProperties {
    public static String FACE_FOLDER;

    public String getFACE_FOLDER() {
        return FACE_FOLDER;
    }

    public void setFACE_FOLDER(String FACE_FOLDER) {
        this.FACE_FOLDER = FACE_FOLDER;
    }
}
