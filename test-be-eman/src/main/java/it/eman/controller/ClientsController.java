package it.eman.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.eman.dto.client.ClientDetailOutput;
import it.eman.dto.client.ClientsOutput;
import it.eman.service.client.ClientService;
import it.eman.utils.constants.Constants;
import it.eman.utils.helper.Helper;
import it.eman.utils.mapper.JsonObjMapper;

@RestController
@RequestMapping(value = "/clients", produces = "application/json")
public class ClientsController {

	private static Logger logger = LoggerFactory.getLogger(ClientsController.class);

	@Autowired
	private ClientService clientService;

	@Autowired
	private JsonObjMapper JsonObjMapper;

	@GetMapping
	public String getClientsList(@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "name", required = false) String name) {
		try {
			
			if (Boolean.FALSE.equals(Helper.authentication())) {
				return "/logout";
			}
			
			ClientsOutput list = new ClientsOutput();
			String typeFilter = "";
			String filter = "";

			if (name != null && id != null) {
				return "Attenzione: scegliere un solo filtro alla volta";
			}
			if (id != null) {
				typeFilter = Constants.ID;
				filter = id.trim();
			}

			if (name != null) {
				typeFilter = Constants.NAME;
				filter = name.trim();
			}

			list = clientService.getClientsListOutput(typeFilter, filter);

			return JsonObjMapper.writeValue(list);

		} catch (Exception e) {
			logger.error(e.getMessage());
			return JsonObjMapper.writeValue(e.getMessage());
		}
	}

	@GetMapping("/{name}")
	public String getClientPolicies(@PathVariable(value = "name", required = true) String name) {
		try {

			if (Boolean.FALSE.equals(Helper.authenticationAdmin())) {
				return "/logout";
			}

			if (StringUtils.isBlank(name)) {
				return "Attenzione: nome non inserito";
			}

			ClientDetailOutput output = clientService.getClientPolicies(name.trim());
			return JsonObjMapper.writeValue(output);

		} catch (Exception e) {
			logger.error(e.getMessage());
			return JsonObjMapper.writeValue(e.getMessage());
		}
	}
}
