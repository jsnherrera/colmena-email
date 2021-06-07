package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.dto.Mail;
import com.api.dto.Response;
import com.api.service.MailServiceImpl;

@RestController
@RequestMapping(value = "/v1/api")
@CrossOrigin("*")
public class EmailController {

	@Autowired
	private MailServiceImpl mailService;

	@PostMapping(value = "/sendEmail")
	public Response sendEmail(@RequestBody Mail mail) {
		Response response = new Response();
		try {
			response = this.mailService.sendEmail(mail.getTo(), mail.getSubject(), mail.getText());
		} catch (Exception e) {
			response.setCodigo(-1);
			response.setMensaje(e.toString());
		}
		return response;
	}

}
