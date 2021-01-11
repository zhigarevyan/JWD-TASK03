package by.zhigarev.dao;

import java.io.*;

public class XmlFileReader {

    private final String file;

    public XmlFileReader(String file){
        this.file = file;
    }


    public String readAllFile() throws IOException {
        byte[] bytesFromFile;
        try(BufferedInputStream bufferedReader = new BufferedInputStream(new FileInputStream(file))) {
            bytesFromFile = bufferedReader.readAllBytes();
        }
        return new String(bytesFromFile);
    }

}
