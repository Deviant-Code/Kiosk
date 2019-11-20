package manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import com.google.gson.*;

public class AdminPortalListener {

    AdminPortalListener() {

    }

    private  String readUrl(String urlString) throws Exception {
        BufferedReader br = null;
        try {
            URL url = new URL(urlString);
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = br.read(chars)) != -1)
                buffer.append(chars, 0, read); 

            return buffer.toString();
        } finally {
            if (br != null)
                br.close();
        }
    }
    
    //Grabs json from portal via URL to json file
    public Object getObject(String url) throws Exception {
        Object obj;
        try {
            String json = readUrl(url);
            Gson gson = new Gson();        
            obj = gson.fromJson(json, Object.class);
        } catch(Exception err) {
            obj = null;
        }
        return obj;
    }

}