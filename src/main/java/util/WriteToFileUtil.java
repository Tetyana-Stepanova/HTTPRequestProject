package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteToFileUtil {

    private final String FILE_PATH = "src/main/resources/";
    private String fileNameFormat = "user-%s-post-%s-comments.json";

    public boolean writeCommentsToFile(Integer userId, Integer postId, String commentsJson) {
        if (!Files.exists(Paths.get(FILE_PATH))) {
            new File(FILE_PATH).mkdirs();
        }
        FileWriter file = null;
        String fileName = String.format(fileNameFormat, userId, postId);
        try {

            // Constructs a FileWriter given a file name, using the platform's default charset
            file = new FileWriter(FILE_PATH + fileName);
            file.write(commentsJson);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {

                if (file != null) {
                    file.flush();
                    file.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
