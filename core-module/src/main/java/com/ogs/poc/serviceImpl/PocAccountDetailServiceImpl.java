package com.ogs.poc.serviceImpl;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ogs.poc.beans.AccountDetails;
import com.ogs.poc.exception.CoreException;
import com.ogs.poc.repository.AccountDetailsRepository;
import com.ogs.poc.service.PocAccountDetailService;

import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static com.ogs.poc.constant.CoreModuleConstant.ACCOUNTDETAIL_URL;

@Service
public class PocAccountDetailServiceImpl implements PocAccountDetailService {

	@Autowired
	private AccountDetailsRepository accountDetailsRepository;

	Logger logger = LoggerFactory.getLogger(PocAccountDetailServiceImpl.class);

	private static final String SESSIONID = "123456789";

	public AccountDetails getAccountDetails(HttpSession httpSession) throws CoreException {
		
		AccountDetails details = new AccountDetails();
		String sessionId = httpSession.getAttribute("sessionId").toString();

		if (isNotBlank(sessionId) && SESSIONID.equals(sessionId)) {

			// String url = String.format(ACCOUNTDETAIL_URL, sessionId);
			RestTemplate restTemplate = new RestTemplate();
			// ResponseEntity<AccountDetails> accountDetails =
			// restTemplate.getForEntity(url, AccountDetails.class);
			logger.info("Get the account details");
			// HttpEntity<> request = new HttpEntity<>();

			try {
				details.setAccountId("3");
				details.setCountry("India");
				details.setCurrency("INR");
				details.setGameSessionId(sessionId);
				details.setNationId("91");
				details.setNickName("Lazzy_Learner");
			} catch (Exception ex) {
				logger.error("Account details are not present");
				throw new CoreException("invalid data");
			}
		}
		
		
		AccountDetails details1 = accountDetailsRepository.save(details);
        logger.info("Created ToDo " + details1.getAccountId());

        AccountDetails details2 = accountDetailsRepository.findAll().get(0);
        logger.info("Created ToDo " + details2.getGameSessionId());
        
        logger.warn("Created ToDo " + details2.getCountry());
                
		return details;
	}
}