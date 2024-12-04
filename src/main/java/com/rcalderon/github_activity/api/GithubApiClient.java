package com.rcalderon.github_activity.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rcalderon.github_activity.api.model.GithubUserEvents;
import com.rcalderon.github_activity.exceptions.GithubActivityException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


public class GithubApiClient {
    private final HttpRequest httpRequest;

    public GithubApiClient(String username) {
        GithubUrlBuilder githubUrlBuilder = new GithubUrlBuilder.Builder(username)
                .build();

        this.httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(githubUrlBuilder.getBaseUrlFormat()))
                .timeout(Duration.ofSeconds(10L))
                .GET()
                .build();
    }

    public void getEventsByUser() {
        try {
            // Creating completable future with http request state initialized at
            // constructor class
            // For learning purposes I use builder pattern at GithubUrlBuilder
            CompletableFuture<HttpResponse<String>> response = HttpClient.newBuilder()
                    .build()
                    .sendAsync(
                            this.httpRequest, HttpResponse.BodyHandlers.ofString()
                    );

            // Obtaining response and formatting message to print in console
            String body = response.thenApply(HttpResponse::body).get();
            parseUserEventsResponse(body).forEach(GithubApiClient::printFormattedMessage);

        } catch (Exception e) {
            // General exception handling not the best yet, just to print
            // message according to exception type thrown by the different
            // proccesses
            throw translateException(e);
        }
    }

    /**
     * Using jackson to convert from string/json to a list of GithubUserEvents
     * Note. All models under package  com.rcalderon.github_activity.api.model; was generated using quicktype.io
     */
    private static List<GithubUserEvents> parseUserEventsResponse(String body) throws JsonProcessingException {
        return new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .readValue(body, new TypeReference<List<GithubUserEvents>>() {
                });
    }

    // TODO Add the missing events documented at https://docs.github.com/en/rest/using-the-rest-api/github-event-types?apiVersion=2022-11-28
    private static void printFormattedMessage(GithubUserEvents userEvent) {
        switch (userEvent.getType()) {
            case PUSH_EVENT:
                System.out.printf(
                        "Pushed %s commits to %s\n",
                        userEvent.getPayload().getCommits().length,
                        userEvent.getRepo().getName()
                );
                break;

            case CREATE_EVENT:
                System.out.printf(
                        "Created a new %s on %s\n",
                        userEvent.getPayload().getRefType(),
                        userEvent.getRepo().getName()
                );
                break;

            case WATCH_EVENT:
                System.out.printf(
                        "Starred %s\n",
                        userEvent.getRepo().getName()
                );
                break;
        }
    }

    // Generic method to return errors using a custom exception
    // TODO Improve error handling
    private static GithubActivityException translateException(Exception e) {
        if (e instanceof InterruptedException) {
            return new GithubActivityException("Request was interrupted", e);
        } else if (e instanceof ExecutionException) {
            return new GithubActivityException("Execution failed", e);
        } else if (e instanceof JsonProcessingException) {
            return new GithubActivityException("Failed to parse JSON response", e);
        }

        return new GithubActivityException("Unexpected error occurred", e);
    }
}
