package com.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.api.dto.Response;

@Service
public class MailServiceImpl {

	@Autowired
	private JavaMailSender mailSender;

	public Response sendEmail(String to, String subject, String content) {
		Response response = new Response();
		try {
			SimpleMailMessage email = new SimpleMailMessage();
			email.setTo(to);
			email.setSubject(subject);
			email.setText(content);
			this.mailSender.send(email);
			response.setCodigo(0);
			response.setMensaje("Exito");
		} catch (Exception e) {
			response.setCodigo(-1);
			response.setMensaje(e.toString());
		}
		return response;

	}
}
