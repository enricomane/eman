package it.eman.utils;

import com.mashape.unirest.http.exceptions.UnirestException;

import it.eman.dto.client.ClientsDto;
import it.eman.dto.gnome.BrastlewarkListDto;
import it.eman.dto.policy.PoliciesDto;

public interface Initializer {

	ClientsDto populateClientsList() throws UnirestException;

	PoliciesDto populatePoliciesList() throws UnirestException;

	BrastlewarkListDto populateBrastlewarkList() throws UnirestException;
}