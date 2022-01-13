package com.example.gitwork;

import org.kohsuke.github.GHAppInstallationToken;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import java.io.IOException;
import java.util.List;

public class GithubQuery {
    GitHub gb;

    public GithubQuery(String token) throws IOException {
        gb = new GitHubBuilder().withOAuthToken(token).build();
    }
    public GHRepository[] getRepo(){
        GHAppInstallationToken apptoken = new GHAppInstallationToken();
        return (GHRepository[]) apptoken.getRepositories().toArray();
    }
}
