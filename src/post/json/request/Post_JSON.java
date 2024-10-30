/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post.json.request;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author razak
 */
public class Post_JSON {
    
    public static void main(String[]args) {
        Post_JSON.Post_JSON();
    }

    /**
     * @param args the command line arguments
     */
    public static void Post_JSON() {
        // TODO code application logic here

        String query_url = "https://gurujsonrpc.appspot.com/guru";
        String json = "{\"method\": \"guru.test\", \"params\" : [\"razak ariffin\"], \"id\" : 123}";

        try {

            URL url = new URL(query_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");

            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close();

            //read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            String result = IOUtils.toString(in, "UTF-8");

            System.out.println(result);

            in.close();
            conn.disconnect();
// I am testing something to publish to gitHub
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
