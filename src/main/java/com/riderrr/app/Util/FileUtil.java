package com.riderrr.app.Util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileUtil {

    public List<String> saveFile(MultipartFile[] files) throws IOException {

        List<String> paths = new ArrayList<>();

        if (files == null || files.length == 0) {
            return paths;
        }

        String uploadDir = "uploads/";

        if (!Files.exists(Path.of(uploadDir))) {
            Files.createDirectory(Path.of(uploadDir));
        }

        for (MultipartFile file : files) {

            if (file.isEmpty()) continue;

            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(uploadDir, fileName);

            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            paths.add(filePath.toString());
        }

        return paths;
    }

    public void deleteFile(String file) throws IOException {

        if (file == null || file.isBlank()) {
            return;
        }

        if (file != null) {
            Path path = Paths.get(file);
            if (Files.exists(path)) {
                Files.delete(path);
            }
        }
    }
}
