package com.ogs.poc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ogs.poc.beans.AccountDetails;
import com.ogs.poc.exception.CoreException;
import com.ogs.poc.service.PocAccountDetailService;

import static org.apache.commons.lang3.StringUtils.isNotBlank;
import org.springframework.http.HttpStatus;
import static com.ogs.poc.constant.CoreModuleConstant.REQUESTTYPE;

@Controller
@RequestMapping("/operatorwalletplatform/path/to/wallet")
public class PocAccountDetailController {

	Logger logger = LoggerFactory.getLogger(PocAccountDetailController.class);

	@Autowired
	private PocAccountDetailService pocService;

	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public  ResponseEntity<AccountDetails> getAccount(HttpServletRequest request, HttpSession httpSession) throws CoreException{

		request.setAttribute("requestType", REQUESTTYPE);
		httpSession.setAttribute("sessionId", "123456789");

		String requestType = request.getAttribute("requestType").toString();
		AccountDetails details = new AccountDetails();

		if (isNotBlank(requestType) && REQUESTTYPE.equals(requestType)) {
			details = pocService.getAccountDetails(httpSession);
		}
		return new ResponseEntity<AccountDetails>(details,HttpStatus.OK);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAccessDeniedException(Exception ex) {
		return new ResponseEntity<Object>("", HttpStatus.OK);

	}
}
