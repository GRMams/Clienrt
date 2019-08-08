/**
 * 
 */
package fr.houseofcode.dap.commandLine.dma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author dimam
 *
 */
public class ServerUtils {
    private final static String USER_AGENT = "Mozilla/5.0";

    /**
     * @param args
     */
    public String NextEvent(String UserKey) throws IOException {
        // TODO Auto-generated method stub
        String Event = CallServer("/Calendar/Events", UserKey);
        return Event;
    }

    public String getLabels(String UserKey) throws IOException {
        // TODO Auto-generated method stub
        String Labels = CallServer("/email/Labels", UserKey);
        return Labels;
    }

    public String getUnreadedMail(String UserKey) throws IOException {
        // TODO Auto-generated method stub
        String UnreadedMail = CallServer("/email/nbUnread", UserKey);
        return UnreadedMail;
    }

    public String CallServer(String url, String UserKey) throws IOException {
        // HTTP GET request 

        URL obj = new URL("http://localhost:8080" + url + "?UserKey=" + UserKey);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + "http://localhost:8080" + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

        return response.toString();

    }

}
