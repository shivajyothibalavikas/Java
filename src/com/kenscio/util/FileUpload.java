package com.kenscio.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class FileUpload {

	public static boolean upload(File file) throws IOException{
		//System.out.println("Entered");
		String currentdir = new File("").getAbsolutePath();
		System.out.println(currentdir);
		File configFile = new File(currentdir + "/Java/properties/SFTPConnect.properties");
		Properties props = new Properties();
		FileReader reader = new FileReader(configFile);
		props.load(reader);
		String SFTPHOST = props.getProperty("SFTPHOST");
		int SFTPPORT = 22;
		String SFTPUSER = props.getProperty("SFTPUSER");
		String SFTPPASS = props.getProperty("SFTPPASS");
		String SFTPWORKINGDIR = props.getProperty("SFTPWORKINGDIR");
		Session session = null;
		Channel channel = null;
		ChannelSftp channelSftp = null;
		//System.out.println("checked");

		try

		{
			JSch jsch = new JSch();
			//System.out.println("try entered");
			session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
			//System.out.println("session 1");
			session.setPassword(SFTPPASS);
			//System.out.println("session 2");
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			System.out.println("session configured");
			session.connect();
			System.out.println("connected");
			channel = session.openChannel("sftp");
			channel.connect();
			channelSftp = (ChannelSftp) channel;
			channelSftp.cd(SFTPWORKINGDIR);
			// File f = new File("test.txt");
			channelSftp.put(new FileInputStream(file), file.getName());
			System.out.println("File successfully transfered");
			return true;
		} catch (Exception ex)

		{
			ex.printStackTrace();
			return false;
		}

	}
}
