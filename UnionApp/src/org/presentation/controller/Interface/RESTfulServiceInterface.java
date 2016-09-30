package org.presentation.controller.Interface;

import org.presentation.dto.RequestObj;
import org.presentation.dto.ResponseObj;

public interface RESTfulServiceInterface {

	ResponseObj login(RequestObj reqparam);
	
	ResponseObj logout(RequestObj reqparam);
	
	ResponseObj register(RequestObj reqparam);
	
	ResponseObj fetch(RequestObj reqparam);
	
	ResponseObj update(RequestObj reqparam);
	
	ResponseObj updateuserprofile(RequestObj reqparam);
	
	ResponseObj updatepwd(RequestObj reqparam);
	
	ResponseObj resetpwd(RequestObj reqparam);
	
	ResponseObj createmeeting(RequestObj reqparam);
	
	ResponseObj updatemeeting(RequestObj reqparam);
	
	ResponseObj fetchmeeting(RequestObj reqparam);
	
	ResponseObj acceptdenymeeting(RequestObj reqparam);

}
