package it.eman.utils.helper;

import java.util.List;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.mashape.unirest.http.exceptions.UnirestException;

import it.eman.dto.client.ClientsDto;
import it.eman.dto.gnome.BrastlewarkListDto;
import it.eman.dto.policy.PoliciesDto;
import it.eman.utils.Initializer;
import it.eman.utils.InitializerImpl;
import it.eman.utils.constants.Constants;

public class Helper {

	private static Initializer init = new InitializerImpl();

	public static boolean nullSafeList(List<?> lista) {
		if (lista != null && !lista.isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean nullSafeSet(Set<?> set) {
		if (set != null && !set.isEmpty()) {
			return true;
		}
		return false;
	}

	public static <T> T castObject(Object o, Class<T> clazz) {
		try {
			return clazz.cast(o);
		} catch (ClassCastException e) {
			return null;
		}
	}

	public static Object poulateObject(String type) {
		try {
			if (Constants.CLIENTS.equals(type)) {
				return castObject(init.populateClientsList(), ClientsDto.class);
			}
			if (Constants.POLICIES.equals(type)) {
				return castObject(init.populatePoliciesList(), PoliciesDto.class);
			}
			if (Constants.BRASTLEWARK.equals(type)) {
				return castObject(init.populateBrastlewarkList(), BrastlewarkListDto.class);
			}
			return null;
		} catch (ClassCastException | UnirestException e) {
			return null;
		}
	}

	public static boolean authentication() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String role = auth.getAuthorities().toString();

		if (auth == null || Constants.ADMIN.equals(role) || Constants.USER.equals(role)) {
			return false;
		}

		return true;
	}
	
	public static boolean authenticationAdmin() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String role = auth.getAuthorities().toString();

		if (auth == null || !Constants.ADMIN.equals(role)) {
			return false;
		}

		return true;
	}
}
