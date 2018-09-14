package org.georgi.shop.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Component
public class UploadFilesService {

    private static final String UPLOAD_DIR = "/uploads/";

    private final HttpServletRequest httpServletRequest;

    private static String directoryToUpload;

    @Autowired
    public UploadFilesService(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
        directoryToUpload = this.httpServletRequest.getServletContext().getRealPath(UPLOAD_DIR);
    }

    public boolean saveFile(MultipartFile uploaded) throws IOException {
        if (!uploaded.isEmpty()) {

            createDirectory(directoryToUpload);

            File destinationFile = new File(directoryToUpload + uploaded.getOriginalFilename());

            uploaded.transferTo(destinationFile);
        }

        return false;
    }

    private boolean createDirectory(String directory) {
       return !new File(directory).exists() ? new File(directory).mkdir() : false;
    }
}
