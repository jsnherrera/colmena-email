package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.dto.Mail;
import com.api.dto.Response;
import com.api.dto.ResponseContacto;
import com.api.dto.ResponseContactos;
import com.api.model.Contacto;
import com.api.service.ContactoService;
import com.api.service.MailServiceImpl;

@RestController
@RequestMapping(value = "/v1/api")
@CrossOrigin("*")
public class EmailController {

	@Autowired
	private MailServiceImpl mailService;
	@Autowired
	private ContactoService contactoServ;

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

	@GetMapping(value = "/getAllContactos")
	public ResponseContactos getAllContactos() {
		ResponseContactos responseProductos = new ResponseContactos();
		try {
			responseProductos = this.contactoServ.getContactos();
		} catch (Exception e) {
			responseProductos.setCodigo(-1);
			responseProductos.setMensaje(e.toString());
		}
		return responseProductos;
	}

	@PostMapping(value = "/saveContacto")
	public ResponseContacto saveContacto(@RequestBody Contacto contacto) {
		ResponseContacto response = new ResponseContacto();
		try {
			response = this.contactoServ.save(contacto);
		} catch (Exception e) {
			response.setCodigo(-1);
			response.setMensaje(e.toString());
		}
		return response;
	}

}
