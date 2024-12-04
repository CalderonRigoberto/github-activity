package com.rcalderon.github_activity.api;

import com.rcalderon.github_activity.exceptions.InvalidUserNameException;

// Builder pattern for learning purposes
public class GithubUrlBuilder {
    final static String baseUrlFormat = "https://api.github.com/users/%s/events";
    private final String username;
    private final String baseUrlFormmated;

    public static class Builder {
        private String username;
        private String baseUrlFormmated;

        public Builder(String username) {
            this.username = username;
        }

        public GithubUrlBuilder build() {
            this.baseUrlFormmated = getBaseUrlFormat();
            return new GithubUrlBuilder(this);
        }

        private String getBaseUrlFormat() throws InvalidUserNameException {
            if(this.username == null || this.username.isBlank()) throw new InvalidUserNameException("The username is not present or has an invalid format!");
            return String.format(baseUrlFormat, this.username);
        }
    }

    private GithubUrlBuilder(Builder builder) {
        this.username = builder.username;
        this.baseUrlFormmated = builder.baseUrlFormmated;
    }

    public String getBaseUrlFormat() {
        return this.baseUrlFormmated;
    }
}
