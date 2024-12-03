package  com.rcalderon.github_activity.api.model;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Name {
    CALDERON_RIGOBERTO, RIGOBERTO_CALDERON;

    @JsonValue
    public String toValue() {
        switch (this) {
            case CALDERON_RIGOBERTO: return "CalderonRigoberto";
            case RIGOBERTO_CALDERON: return "Rigoberto Calderon";
        }
        return null;
    }

    @JsonCreator
    public static Name forValue(String value) throws IOException {
        if (value.equals("CalderonRigoberto")) return CALDERON_RIGOBERTO;
        if (value.equals("Rigoberto Calderon")) return RIGOBERTO_CALDERON;
        throw new IOException("Cannot deserialize Name");
    }
}
