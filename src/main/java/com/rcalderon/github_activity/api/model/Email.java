package  com.rcalderon.github_activity.api.model;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Email {
    JESUSCALFLO15_GMAIL_COM;

    @JsonValue
    public String toValue() {
        switch (this) {
            case JESUSCALFLO15_GMAIL_COM: return "jesuscalflo15@gmail.com";
        }
        return null;
    }

    @JsonCreator
    public static Email forValue(String value) throws IOException {
        if (value.equals("jesuscalflo15@gmail.com")) return JESUSCALFLO15_GMAIL_COM;
        throw new IOException("Cannot deserialize Email");
    }
}
