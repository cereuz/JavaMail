package com.onezao.javamail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.junit.Test;

public class SendEmail {
	@Test
    public void sendEmail() throws AddressException, MessagingException{
    	/*
    	 * 1.得到session
    	 */
		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.163.com");
		props.setProperty("mail.smtp.auth", "true");
		
		Authenticator auth = new Authenticator(){
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("sunedo","2008134122");
			}
		};
		
		Session session = Session.getInstance(props,auth);
		/*
		 * 2.创建MimeMessage
		 */
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("sunedo@163.com"));//设置发件人
		msg.setRecipients(RecipientType.TO, "sunedo@qq.com");//设置收件人
		msg.setRecipients(RecipientType.CC, "sunedo@126.com");//设置抄送
		msg.setRecipients(RecipientType.BCC, "sunedo@yeah.net");//设置暗送
		
		msg.setSubject("这是来自sunedo的一封信");
		String ztext = "听风者无耳，千里眼无目，悲喜交加的时候是个真实的梦靥；\n"+ GetTime.getTime();
		msg.setContent(ztext,"text/html;charset=utf-8");
		/*
		 * 3.发送邮件
		 */
		Transport.send(msg);
		
		
    }
}
