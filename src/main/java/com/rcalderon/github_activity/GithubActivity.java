package com.rcalderon.github_activity;


import com.rcalderon.github_activity.cli.GitHubCommands;
import picocli.CommandLine;

public class GithubActivity {

    // Added class that contains commands using Picocli Framework
    public static void main(String[] args) {
        System.exit(new CommandLine(new GitHubCommands()).execute(args));
    }
}
