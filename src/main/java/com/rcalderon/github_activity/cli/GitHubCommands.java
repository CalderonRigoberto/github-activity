package com.rcalderon.github_activity.cli;

import com.rcalderon.github_activity.api.GithubApiClient;
import picocli.CommandLine;

@CommandLine.Command(name = "github-activity")
public class GitHubCommands implements Runnable {

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @CommandLine.Parameters(index = "0", arity = "1..*", description = "need to provide an username") String username;

    @Override
    public void run() {
        /* Creating github client, internal creation of base url with username provided
         * making sure the error control and the correct execution if a username
         * parameters was provided
         */
        new GithubApiClient(username).getEventsByUser();
    }
}
