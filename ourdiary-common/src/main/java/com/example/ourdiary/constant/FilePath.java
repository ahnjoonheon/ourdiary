package com.example.ourdiary.constant;

import java.nio.file.Path;

public enum FilePath {
    PROFILE_IMAGE(Path.of("profile-image")),
    POST_IMAGE(Path.of("post-image"));

    private final Path path;

    FilePath(Path path) {
        this.path = path;
    }

    public Path getPath() {
        return path;
    }
}
