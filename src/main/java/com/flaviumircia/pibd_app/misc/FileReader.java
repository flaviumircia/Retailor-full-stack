package com.flaviumircia.pibd_app.misc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class FileReader {
    private static String formatString(String s){
        String[] arrayString=s.split("=");
        return arrayString[1];
    }
    public HashMap<String, String> readFromFile() throws FileNotFoundException {
        HashMap<String,String> map=new HashMap<>();
        File file =new File("src");
        File current_file=new File(file.getAbsolutePath()+"/main/java/com/flaviumircia/pibd_app/misc/credentials.txt");
        Scanner scanner =new Scanner(current_file);
        String username;
        String password;
        if(scanner.hasNextLine()){
            username=scanner.nextLine();
            map.put("user",formatString(username));
        }
        if(scanner.hasNextLine()){
            password=scanner.nextLine();
            map.put("password",formatString(password));
        }
        return map;
    }
}
