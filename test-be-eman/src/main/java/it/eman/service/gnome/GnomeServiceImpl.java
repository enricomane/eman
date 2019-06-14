package it.eman.service.gnome;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.eman.dto.gnome.BrastlewarkListDto;
import it.eman.utils.constants.Constants;
import it.eman.utils.helper.Helper;

@Service
@SuppressWarnings("unused")
public class GnomeServiceImpl implements GnomeService {

	private static Logger logger = LoggerFactory.getLogger(GnomeServiceImpl.class);

	@Autowired
	private BrastlewarkListDto initBrastlewark;

	@Override
	public BrastlewarkListDto getInitBrastlewark() {
		populateBrastlewark();
		return initBrastlewark;
	}

	private void populateBrastlewark() {
		if (initBrastlewark == null || !Helper.nullSafeList(initBrastlewark.getBrastlewark())) {
			initBrastlewark = Helper.castObject(Helper.poulateObject(Constants.BRASTLEWARK), BrastlewarkListDto.class);
		}
	}
}
