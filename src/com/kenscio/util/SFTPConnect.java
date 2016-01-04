package com.kenscio.util;

import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.kenscio.to.ConnectionTo;

public class SFTPConnect {
	
	public static Channel getConnection(ConnectionTo to)
	{
		
		String user=to.getUser_name();
		String ip=to.getIp();
		String psw = to.getPassword();
		Channel channel = null;
		
		JSch jSch = new JSch();
		Session session;
		try 
		{
			session = jSch.getSession(user,ip);
			session.setPassword(psw);
			Properties config = new Properties();
	        config.put("StrictHostKeyChecking", "no");
	        session.setConfig(config);
			session.connect();
			channel= session.openChannel("sftp");
			channel.connect();
		} 
		catch (JSchException e) 
		{
			System.out.println("Exception" + e);
		}
		
		return channel;
		
	}

}
