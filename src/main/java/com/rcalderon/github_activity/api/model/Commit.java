package  com.rcalderon.github_activity.api.model;

import com.fasterxml.jackson.annotation.*;

public class Commit {
    private String sha;
    private Author author;
    private String message;
    private boolean distinct;
    private String url;

    @JsonProperty("sha")
    public String getSHA() { return sha; }
    @JsonProperty("sha")
    public void setSHA(String value) { this.sha = value; }

    @JsonProperty("author")
    public Author getAuthor() { return author; }
    @JsonProperty("author")
    public void setAuthor(Author value) { this.author = value; }

    @JsonProperty("message")
    public String getMessage() { return message; }
    @JsonProperty("message")
    public void setMessage(String value) { this.message = value; }

    @JsonProperty("distinct")
    public boolean getDistinct() { return distinct; }
    @JsonProperty("distinct")
    public void setDistinct(boolean value) { this.distinct = value; }

    @JsonProperty("url")
    public String getURL() { return url; }
    @JsonProperty("url")
    public void setURL(String value) { this.url = value; }
}
