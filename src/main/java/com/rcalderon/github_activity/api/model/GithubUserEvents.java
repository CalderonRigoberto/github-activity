package  com.rcalderon.github_activity.api.model;

import com.fasterxml.jackson.annotation.*;
import java.time.OffsetDateTime;

public class GithubUserEvents {
    private String id;
    private Type type;
    private Actor actor;
    private Repo repo;
    private Payload payload;
    private boolean githubUserEventPublic;
    private OffsetDateTime createdAt;
    private Actor org;

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("type")
    public Type getType() { return type; }
    @JsonProperty("type")
    public void setType(Type value) { this.type = value; }

    @JsonProperty("actor")
    public Actor getActor() { return actor; }
    @JsonProperty("actor")
    public void setActor(Actor value) { this.actor = value; }

    @JsonProperty("repo")
    public Repo getRepo() { return repo; }
    @JsonProperty("repo")
    public void setRepo(Repo value) { this.repo = value; }

    @JsonProperty("payload")
    public Payload getPayload() { return payload; }
    @JsonProperty("payload")
    public void setPayload(Payload value) { this.payload = value; }

    @JsonProperty("public")
    public boolean getGithubUserEventPublic() { return githubUserEventPublic; }
    @JsonProperty("public")
    public void setGithubUserEventPublic(boolean value) { this.githubUserEventPublic = value; }

    @JsonProperty("created_at")
    public OffsetDateTime getCreatedAt() { return createdAt; }
    @JsonProperty("created_at")
    public void setCreatedAt(OffsetDateTime value) { this.createdAt = value; }

    @JsonProperty("org")
    public Actor getOrg() { return org; }
    @JsonProperty("org")
    public void setOrg(Actor value) { this.org = value; }
}
