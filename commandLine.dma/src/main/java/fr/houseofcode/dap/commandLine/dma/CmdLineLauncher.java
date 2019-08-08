/**
 * 
 */
package fr.houseofcode.dap.commandLine.dma;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author dimam
 *
 */
public class CmdLineLauncher {

    /**
    * @param args
    */
    private static final Logger LOG = LogManager.getLogger();

    /**
    * @param args is the external parameters.
    * @throws IOException if the sent or received message is broken.
    * @throws GeneralSecurityException if there's a security failure.
    */

    public static void main(final String[] args) throws IOException, GeneralSecurityException {
        ServerUtils su = new ServerUtils();
        LOG.debug("Debut du Main avec comme arguments :  " + args);

        String ChoixUserKey = args[1];
        String nbemails = su.getUnreadedMail(ChoixUserKey);
        String displayLabel = su.getLabels(ChoixUserKey);
        String allEvents = su.NextEvent(ChoixUserKey);

        int n = Integer.parseInt(args[0]);
        switch (n) {
        case 1:
            LOG.debug("Connexion de l'utlisateur à son calendrier : ");
            System.out.println("Tiens toi pret pour ton prochain events  ^^\n" + allEvents);
            break;

        case 2:
            LOG.debug("Connexion de l'utilisateur à son comtpe email : ");
            System.out.println("Vous avez : " + nbemails + " email(s) non lu(s) \n");
            break;

        case 3:
            LOG.debug("Connexion de l'utilisateur à sa classe de label :");
            System.out.println(displayLabel);
            break;

        case 4:
            LOG.debug("Affichage de toutes les données de l'utilisateur");
            System.out.println("Tiens toi pret pour ton prochain events  ^^\n" + allEvents);
            System.out.println("Vous avez : " + nbemails + " email(s) non lu(s) \n");
            System.out.println("Voici la liste de vos labels" + displayLabel + " message \n");
            break;

        default:
            System.out.println("Vous n'avez rien à afficher !");
        }
    }

}
