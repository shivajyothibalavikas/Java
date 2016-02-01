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
		final String to = "shivajyothi@kenscio.com";
		final String from = "kmadan77@gmail.com";
		final String host = "smtp.gmail.com";
		final String psw = "transformer";
		
		try {
			
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
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Ping");
			message.setText(content);

			Transport.send(message);
			System.out.println("message sent successfully....");
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}


}
