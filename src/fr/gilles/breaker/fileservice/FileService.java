package fr.gilles.breaker.fileservice;

import fr.gilles.breaker.game.Settings;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileService {

    private static  String fileDir = System.getProperty("user.home")+File.separator+"pong";
    private static String fileName  = fileDir+File.separator+"pong.conf";

    public static void saveSettings() throws IOException {
        if (Files.exists(Path.of(fileDir)) && Files.isDirectory(Path.of(fileDir))){
            if (Files.exists(Path.of(fileName)) ){
                FileWriter fileWriter = new FileWriter(fileName);
                fileWriter.write(Settings.getSettings().toString());
                fileWriter.close();
            }else{
                Files.createFile(Path.of(fileName));
                saveSettings();
            }
        }else
        {
            Files.createDirectory(Path.of(fileDir));
            saveSettings();
        }
    }

    private static  void  importSettings(){

    }

    public static  void loadSettings(){

    }
}
