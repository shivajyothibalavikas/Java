package com.kenscio.util;


import java.io.IOException;
import java.io.InputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class FileUpload {

	public static boolean upload(InputStream filecontent, String fileName) throws IOException{
		String user = "sftp_demo";
		String password = "sftpdemo123";
		String host = "5.9.80.147";
		int port = 22;
		String targetDir = "/user/sftp_demo/Test";
		String fileNameDest = targetDir + "/" + fileName;
		System.out.println(fileNameDest);

		try

		{
			JSch jsch = new JSch();
			Session session = jsch.getSession(user, host, port);
			session.setPassword(password);
			session.setConfig("StrictHostKeyChecking", "no");
			System.out.println("Establishing Connection...");
			session.connect();
			System.out.println("Connection established.");
			System.out.println("Crating SFTP Channel.");
			ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
			sftpChannel.connect();
			System.out.println("SFTP Channel created.");

			sftpChannel.put(filecontent, fileName);
			sftpChannel.disconnect();
			System.out.println("Disconnecting the sftp Chnannel");

			session.disconnect();
			System.out.println("Discontinuing the session");
			return true;
		} 
		catch (Exception ex)

		{
			ex.printStackTrace();
			return false;
		}

	}

	 
}
