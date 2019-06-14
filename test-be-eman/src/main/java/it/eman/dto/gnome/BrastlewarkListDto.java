package it.eman.dto.gnome;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BrastlewarkListDto implements Serializable {

	@JsonProperty("Brastlewark")
	private List<BrastlewarkDto> brastlewark = new ArrayList();

	public List<BrastlewarkDto> getBrastlewark() {
		return brastlewark;
	}

	public void setBrastlewark(List<BrastlewarkDto> brastlewark) {
		this.brastlewark = brastlewark;
	}

}
