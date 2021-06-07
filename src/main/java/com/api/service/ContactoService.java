package com.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dto.ResponseContacto;
import com.api.dto.ResponseContactos;
import com.api.model.Contacto;
import com.api.repo.IContactoRepo;

@Service
public class ContactoService {

	@Autowired
	private IContactoRepo repo;

	public ResponseContacto save(Contacto contacto) {
		ResponseContacto response = new ResponseContacto();
		try {
			response.setContacto(this.repo.save(contacto));
			response.setCodigo(0);
			response.setMensaje("Exito");
		} catch (Exception e) {
			response.setCodigo(-1);
			response.setMensaje(e.toString());
		}
		return response;
	}

	public ResponseContactos getContactos() {
		ResponseContactos responseProductos = new ResponseContactos();
		try {
			List<Contacto> list = this.repo.findAll();
			responseProductos.setContactos(list);
			responseProductos.setCodigo(0);
			responseProductos.setMensaje("Exito");
		} catch (Exception e) {
			responseProductos.setCodigo(-1);
			responseProductos.setMensaje(e.toString());
		}
		return responseProductos;
	}

}
