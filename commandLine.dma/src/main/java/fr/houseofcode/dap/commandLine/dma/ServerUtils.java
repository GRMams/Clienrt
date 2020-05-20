/**
 * 
 */
package fr.houseofcode.dap.commandLine.dma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//TODO DMA by Djer |JavaDoc| Il manque la description (de la classe)
/**
 * @author dimam
 *
 */
public class ServerUtils {
    private final static String USER_AGENT = "Mozilla/5.0";

    //TODO DMA by Djer |JavaDoc| Mauvais commentaire javadoc.
    /**
     * @param args
     */
    public String NextEvent(String UserKey) throws IOException {
        //TODO DMA by Djer |IDE| Supprime les TO-DO (même généré par ton IDE) une fois traités
        // TODO Auto-generated method stub
        String Event = CallServer("/Calendar/Events", UserKey);
        return Event;
    }

    //TODO DMA by Djer |JavaDoc| Il manque la javaDoc.
    public String getLabels(String UserKey) throws IOException {
      //TODO DMA by Djer |IDE| Supprime les TO-DO (même généré par ton IDE) une fois traités
        // TODO Auto-generated method stub
        String Labels = CallServer("/email/Labels", UserKey);
        return Labels;
    }

    //TODO DMA by Djer |JavaDoc| Il manque la javaDoc.
    public String getUnreadedMail(String UserKey) throws IOException {
      //TODO DMA by Djer |IDE| Supprime les TO-DO (même généré par ton IDE) une fois traités
        // TODO Auto-generated method stub
        String UnreadedMail = CallServer("/email/nbUnread", UserKey);
        return UnreadedMail;
    }

    //TODO DMA by Djer |JavaDoc| Il manque la javaDoc.
    //TODO DMA by Djer |POO| Le nom des méthodes doivent commencer par une minuscule puis être en CamelCase.
    public String CallServer(String url, String UserKey) throws IOException {
        // HTTP GET request 

        URL obj = new URL("http://localhost:8080" + url + "?UserKey=" + UserKey);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        //TODO DMA by Djer |Log4J| Une log (en Debug) serait plus approprié.
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
        //TODO DMA by Djer |Log4J| Une log (en Debug) serait plus approprié.
        System.out.println(response.toString());

        return response.toString();

    }

}
