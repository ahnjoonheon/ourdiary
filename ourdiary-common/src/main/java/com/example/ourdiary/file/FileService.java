package com.example.ourdiary.file;

import com.example.ourdiary.exception.FileNameNotFoundException;
import com.example.ourdiary.message.MessageService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;

@Service
public class FileService {
    private final MessageService messageService;

    public FileService(MessageService messageService) {
        this.messageService = messageService;
    }

    public Path upload(MultipartFile multipartFile, Path path) throws IOException {
        if (multipartFile.isEmpty()) {
            return null;
        }
        String originalFilename = multipartFile.getOriginalFilename();
        if (!StringUtils.hasText(originalFilename)) {
            throw new FileNameNotFoundException(messageService.get("exception.file-name-not-found"));
        }
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String filename = UUID.randomUUID() + extension;
        // make directories if not exist
        if (!path.toFile().exists()) {
            path.toFile().mkdirs();
        }

        multipartFile.transferTo(path.resolve(filename));
        return path.resolve(filename);
    }
}
