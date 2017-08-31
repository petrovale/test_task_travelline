package ru.rambler.authorization;

import javax.mail.*;
import javax.mail.search.FlagTerm;
import java.util.Properties;

public class NewUnreadMails {

    public static void main( String[] args ) throws Exception {

        Session session = Session.getDefaultInstance(new Properties( ));
        Store store = session.getStore("imaps");
        store.connect("imap.rambler.ru", 993, "alexey2017alexey", "alexey");
        Folder inbox = store.getFolder( "INBOX" );
        inbox.open( Folder.READ_ONLY );

        // Fetch unseen messages from inbox folder
        Message[] messages = inbox.search(
                new FlagTerm(new Flags(Flags.Flag.SEEN), false));

        if (messages.length == 0) System.out.println("No messages found.");

        for (int i = 0; i < messages.length; i++) {
            System.out.println("Message " + (i + 1));
            System.out.println("From : " + messages[i].getFrom()[0]);
            System.out.println("Subject : " + messages[i].getSubject());
            System.out.println("Sent Date : " + messages[i].getSentDate());
            System.out.println();
        }

        inbox.close(true);
        store.close();
    }
}
