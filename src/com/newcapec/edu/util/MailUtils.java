package com.newcapec.edu.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtils {
	/**
	 * 发送邮件的方法
	 * to:给谁发邮件
	 * code邮件的激活码
	 * @param to
	 * @param code
	 * @throws Exception 
	 * @throws AddressException 
	 */
	public static void sendMail(String to,String code) throws AddressException, Exception{
	//创建链接对象链接到邮件服务器
		//Pro设置主机名，发送的服务器地址因为本地所以可以省略掉
		//props.setProperty("host",value);
		Properties props = new Properties();
		
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("service@news.com", "123");
			}
		
		});
		//创建邮件对象
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("service@news.com"));
		//发送一封邮件
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		message.setSubject("激活邮件");
		message.setContent("<h3>来自新闻管理的激活邮件，激活请点击以下链接:<a href='http://localhost:8080/news_xkx/ActiveServlet?code="+code+"'>http://localhost:8080/news_xkx/ActiveServlet?code="+code+"</a></h3>", "text/html;charset=utf-8");
		Transport.send(message);
	}
	

}
