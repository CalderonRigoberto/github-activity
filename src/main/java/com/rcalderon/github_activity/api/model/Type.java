package  com.rcalderon.github_activity.api.model;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Type {
    CREATE_EVENT, PUSH_EVENT, WATCH_EVENT;

    @JsonValue
    public String toValue() {
        switch (this) {
            case CREATE_EVENT: return "CreateEvent";
            case PUSH_EVENT: return "PushEvent";
            case WATCH_EVENT: return "WatchEvent";
        }
        return null;
    }

    @JsonCreator
    public static Type forValue(String value) throws IOException {
        if (value.equals("CreateEvent")) return CREATE_EVENT;
        if (value.equals("PushEvent")) return PUSH_EVENT;
        if (value.equals("WatchEvent")) return WATCH_EVENT;
        throw new IOException("Cannot deserialize Type");
    }
}
