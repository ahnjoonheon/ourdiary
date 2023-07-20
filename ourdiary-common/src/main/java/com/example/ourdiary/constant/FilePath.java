package com.example.ourdiary.constant;

import java.nio.file.Path;
import java.time.LocalDate;

public enum FilePath {
    PROFILE_IMAGE(Path.of("file/profile-image/" + LocalDate.now())),
    POST_IMAGE(Path.of("file/post-image/" + LocalDate.now()));

    private final Path defaultPath;

    FilePath(Path defaultPath) {
        this.defaultPath = defaultPath;
    }

    public Path getPath() {
        return defaultPath;
    }


}
