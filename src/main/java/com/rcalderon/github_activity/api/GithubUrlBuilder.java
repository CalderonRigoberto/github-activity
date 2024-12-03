package com.rcalderon.github_activity.api;

import com.rcalderon.github_activity.exceptions.InvalidUserNameException;

// Builder pattern for learning purposes
public class GithubUrlBuilder {
    final static String baseUrlFormat = "https://api.github.com/users/%s/events";
    String username;

    GithubUrlBuilder(Builder builder) {
        this.username = builder.username;
    }

    public String getBaseUrlFormat() throws InvalidUserNameException {
        if(this.username == null || this.username.isBlank()) throw new InvalidUserNameException("The username is not present or has an invalid format!");
        return String.format(baseUrlFormat, this.username);
    }

    public static class Builder {
        private String username;

        public Builder username(String username) {
            this.username = username;
            return this;
        }
        public GithubUrlBuilder build() {
            return new GithubUrlBuilder(this);
        }
    }
}
