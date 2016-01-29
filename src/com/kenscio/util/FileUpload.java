package com.kenscio.util;


import java.io.IOException;
import java.io.InputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class FileUpload {

	public static void upload(InputStream filecontent, String fileName) throws IOException{
		Session session = null;
		Channel channel = null;
		ChannelSftp channelSftp = null;

		try

		{
			JSch jsch = new JSch();
			session = jsch.getSession("sftp_demo","5.9.80.147");
			session.setPassword("sftpdemo123");
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			System.out.println("session configured");
			session.connect();
			System.out.println("connected");
			channel = session.openChannel("sftp");
			channel.connect();
			System.out.println("channel connected");
			channelSftp = (ChannelSftp) channel;
			channelSftp.cd("/home/sftp_demo");
			System.out.println(channelSftp.pwd());
			// File f = new File("test.txt");
			channelSftp.put(filecontent, fileName);
			System.out.println("File successfully transfered");
		} catch (Exception ex)

		{
			ex.printStackTrace();
		}

	}

	 
}
