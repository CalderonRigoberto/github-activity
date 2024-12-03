package  com.rcalderon.github_activity.api.model;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Login {
    CALDERON_RIGOBERTO, WITHASTRO;

    @JsonValue
    public String toValue() {
        switch (this) {
            case CALDERON_RIGOBERTO: return "CalderonRigoberto";
            case WITHASTRO: return "withastro";
        }
        return null;
    }

    @JsonCreator
    public static Login forValue(String value) throws IOException {
        if (value.equals("CalderonRigoberto")) return CALDERON_RIGOBERTO;
        if (value.equals("withastro")) return WITHASTRO;
        throw new IOException("Cannot deserialize Login");
    }
}
