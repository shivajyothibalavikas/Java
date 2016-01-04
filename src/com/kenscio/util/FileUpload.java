package com.kenscio.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class FileUpload {
	
	public static void upload(File file)
	{
	String SFTPHOST = "10.0.0.223";
	int SFTPPORT = 22;
	String SFTPUSER = "madan";
	String SFTPPASS = "sriguru123";
	String SFTPWORKINGDIR = "/home/madan/Madan";

	Session session = null;
	Channel channel = null;
	ChannelSftp channelSftp = null;

	try

	{
		System.out.println("2");
		JSch jsch = new JSch();
		session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
		session.setPassword(SFTPPASS);
		java.util.Properties config = new java.util.Properties();
		config.put("StrictHostKeyChecking", "no");
		System.out.println("3");
		session.setConfig(config);
		System.out.println("4");
		session.connect();
		System.out.println("5");
		channel = session.openChannel("sftp");
		channel.connect();
		channelSftp = (ChannelSftp) channel;
		channelSftp.cd(SFTPWORKINGDIR);
		//File f = new File("test.txt");
		channelSftp.put(new FileInputStream(file), file.getName());
		System.out.println("File successfully transfered");
	} catch(

	Exception ex)

	{
		ex.printStackTrace();
	}

}}
