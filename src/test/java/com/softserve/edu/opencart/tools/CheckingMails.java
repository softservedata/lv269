package com.softserve.edu.opencart.tools;

import com.softserve.edu.opencart.tools.exceptions.ErrorUtils;

import javax.mail.*;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Properties;

public final class CheckingMails {
    public static String getMessageUrlFromMail(String host, String storeType, String user,
                             String password) {
        String url= null;
        try {
            //create properties field
            Properties properties = new Properties();
            properties.put("mail.pop3.host", host);
            properties.put("mail.pop3.port", "995");
            properties.put("mail.pop3.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);

            //create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore("pop3s");

            store.connect(host, user, password);

            //create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_WRITE);

            // retrieve the messages from the folder in an array
            Message[] messages = emailFolder.getMessages();

            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                BufferedInputStream bis = new BufferedInputStream(message.getInputStream());
                ByteArrayOutputStream buf = new ByteArrayOutputStream();
                int result = bis.read();
                while (result != -1) {
                    buf.write((byte) result);
                    result = bis.read();
                }
                 url = TextUtils.extractUrls(buf.toString("UTF-8"));
                message.setFlag(Flags.Flag.DELETED, true);
                break;
            }

            //close the store and folder objects
            emailFolder.close(true);
            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ErrorUtils.createInputDataIsEmptyException(url == null, "Not find url");
        return url;
    }

}
