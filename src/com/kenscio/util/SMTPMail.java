package com.kenscio.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SMTPMail 
{
	public static void sendMail(String content) 
	{
		FileReader reader;
		String currentdir = new File("").getAbsolutePath();
		final String from = "vikky.kv@gmail.com";
		final String host = "smtp.gmail.com";
		File configFile = new File(currentdir+"/Java/properties/passwords.properties");
		Properties props = new Properties();
		
		try {
			reader = new FileReader(configFile);
			props.load(reader);
			final String psw = props.getProperty("gmailpass");
			
			Properties properties = System.getProperties();
			properties.put("mail.smtp.starttls.enable", "true");
			properties.setProperty("mail.smtp.host", host);
			properties.setProperty("mail.smtp.port", "587");
			properties.put("mail.smtp.auth", "true");
			
			Session session = Session.getDefaultInstance(properties,
					new Authenticator() {
				protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
					return new javax.mail.PasswordAuthentication(from, psw);
				}
			});
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(from));
			message.setSubject("Ping");
			message.setText(content);

			Transport.send(message);
			System.out.println("message sent successfully....");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}


}
