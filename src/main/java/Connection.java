package main.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

public class Connection {

    private static Connection instance;
    private BufferedReader buffer;

    private Connection(){}

    public static Connection getInstance(){
        if(instance == null)
            instance = new Connection();
        return instance;
    }

    public BufferedReader getBuffer(){
        return buffer;
    }

    public Connection setBufferFromUrl(String inputUrl) throws Exception{
        URL url = new URL(inputUrl);
        URLConnection con = url.openConnection();
        Reader reader = new InputStreamReader(con.getInputStream(),"UTF-8");
        buffer = new BufferedReader(reader);
        return this;
    }
}
