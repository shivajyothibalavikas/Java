package com.kenscio.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class FileUpload {

	public static boolean upload(File f, FileInputStream file) throws IOException{
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
			channelSftp = (ChannelSftp) channel;
			//channelSftp.cd("/home/sftp_demo");
			// File f = new File("test.txt");
			channelSftp.put(file, f.getName());
			System.out.println("File successfully transfered");
			return true;
		} catch (Exception ex)

		{
			ex.printStackTrace();
			return false;
		}

	}
}
