package es.ulpgc.montesdeoca110.cristina.zonget.app;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import dmax.dialog.SpotsDialog;
import es.ulpgc.montesdeoca110.cristina.zonget.R;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;

//Class is extending AsyncTask because this class is going to perform a networking operation
public class SendMail extends AsyncTask<Void, Void, Void> {

  //Declaring Variables
  private final Context context;

  //Information to send email
  private final String email;
  private final String subject;
  private final String message;

  //Alertdialog to show while sending email
  private AlertDialog dialog;

  //Class Constructor
  public SendMail(Context context, String email, String subject, String message) {
    //Initializing variables
    this.context = context;
    this.email = email;
    this.subject = subject;
    this.message = message;
  }

  @Override
  protected void onPreExecute() {
    super.onPreExecute();
    dialog = new SpotsDialog(context, R.style.SentEmailDialogProgressTheme);
    dialog.show();
  }

  @Override
  protected void onPostExecute(Void aVoid) {
    super.onPostExecute(aVoid);
    dialog.dismiss();
  }

  @Override
  protected Void doInBackground(Void... params) {
    //Creating properties
    Properties props = new Properties();

    //Configuring properties for gmail
    //If you are not using gmail you may need to change the values
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");

    //Creating a new session
    Session session = Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {
              //Authenticating the password
              protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EmailConfig.ADMIN_EMAIL,
                        EmailConfig.ADMIN_PASSWORD);
              }
            });

    try {
      //Creating MimeMessage object
      MimeMessage mm = new MimeMessage(session);

      //Setting sender address
      mm.setFrom(new InternetAddress(EmailConfig.ADMIN_EMAIL));
      //Adding receiver
      mm.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
      //Adding subject
      mm.setSubject(subject);
      //Adding message
      mm.setText(message);

      //Sending email
      Transport.send(mm);

    } catch (MessagingException e) {
      e.printStackTrace();
    }
    return null;
  }
}

