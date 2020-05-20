/**
 * 
 */
package fr.houseofcode.dap.commandLine.dma;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//TODO DMA by Djer |JavaDoc| Il manque la description de la classe
//TODO DMA by Djer |POO| Attention ton projet ne respect pas la structure "standard", le sous-dossier "commandLine.dma" ne devrait pas etre présent
/**
 * @author dimam
 *
 */
public class CmdLineLauncher {

    //TODO DMA by Djer |JavaDoc| Mauvais commentaire javadoc.
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
            //TODO DMA by Djer |IDE| Encodage : attention tes fichiers étaient encodés en ISO-8859-2 lorsque tu as ajouter ce messages !
            LOG.debug("Connexion de l'utlisateur Ã  son calendrier : ");
            System.out.println("Tiens toi pret pour ton prochain events  ^^\n" + allEvents);
            break;

        case 2:
            //TODO DMA by Djer |IDE| Encodage : attention tes fichiers étaient encodés en ISO-8859-2 lorsque tu as ajouter ce messages !
            LOG.debug("Connexion de l'utilisateur Ã  son comtpe email : ");
            System.out.println("Vous avez : " + nbemails + " email(s) non lu(s) \n");
            break;

        case 3:
            //TODO DMA by Djer |IDE| Encodage : attention tes fichiers étaient encodés en ISO-8859-2 lorsque tu as ajouter ce messages !
            LOG.debug("Connexion de l'utilisateur Ã  sa classe de label :");
            System.out.println(displayLabel);
            break;

        case 4:
            //TODO DMA by Djer |IDE| Encodage : attention tes fichiers étaient encodés en ISO-8859-2 lorsque tu as ajouter ce messages !
            LOG.debug("Affichage de toutes les donnÃ©es de l'utilisateur");
            System.out.println("Tiens toi pret pour ton prochain events  ^^\n" + allEvents);
            System.out.println("Vous avez : " + nbemails + " email(s) non lu(s) \n");
            System.out.println("Voici la liste de vos labels" + displayLabel + " message \n");
            break;

        default:
            //TODO DMA by Djer |IDE| Encodage : attention tes fichiers étaient encodés en ISO-8859-2 lorsque tu as ajouter ce messages !
            System.out.println("Vous n'avez rien Ã  afficher !");
        }
    }

}
