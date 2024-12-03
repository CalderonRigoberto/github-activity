package  com.rcalderon.github_activity.api.model;

import com.fasterxml.jackson.annotation.*;

public class Author {
    private Email email;
    private Name name;

    @JsonProperty("email")
    public Email getEmail() { return email; }
    @JsonProperty("email")
    public void setEmail(Email value) { this.email = value; }

    @JsonProperty("name")
    public Name getName() { return name; }
    @JsonProperty("name")
    public void setName(Name value) { this.name = value; }
}
