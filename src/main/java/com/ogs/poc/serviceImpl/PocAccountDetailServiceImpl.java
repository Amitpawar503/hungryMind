package com.ogs.poc.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ogs.poc.beans.AccountDetails;
import com.ogs.poc.exception.CoreException;
import com.ogs.poc.repository.AccountDetailsRepository;
import com.ogs.poc.repository.RealSetRepository;
import com.ogs.poc.service.PocAccountDetailService;
import com.ogs.poc.utils.RandomNumberGenerationUtil;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Service
public class PocAccountDetailServiceImpl implements PocAccountDetailService {

	@Autowired
	private AccountDetailsRepository accountDetailsRepository;

	@Autowired
	private RealSetRepository realSetRepository;

	private RandomNumberGenerationUtil randomNumberGenarationUtil;

	public PocAccountDetailServiceImpl(RandomNumberGenerationUtil randomNumberGenarationUtil) {
		this.randomNumberGenarationUtil = randomNumberGenarationUtil;
	}

	Logger logger = LoggerFactory.getLogger(PocAccountDetailServiceImpl.class);

	public AccountDetails getAccountDetails(String sessionId) throws CoreException {

		AccountDetails details = new AccountDetails();
		if (isNotBlank(sessionId)) {

			RestTemplate restTemplate = new RestTemplate();
			String url = String.format("http://localhost:8082/wiapi/mockapi?request=getaccount&sessionid=%s",
					sessionId);
			try {
				details = restTemplate.getForObject(url, AccountDetails.class);
			} catch (Exception ex) {
				logger.error("Account details are not present");
				throw new CoreException("invalid data" + ex);
			}

			// details.setAccountId(object.getClass().getResource("accountId").toString());

			logger.info("Get the account details");

			// http://localhost:8082/wiapi/mockapi?request=getaccount&sessionid=ccbcecef-1c04-42db-b90e-6e880d64e68c

			/*
			 * try { details.setAccountId("3"); details.setCountry("India");
			 * details.setCurrency("INR"); details.setGameSessionId(sessionId);
			 * details.setNationId("91"); details.setNickName("Lazzy_Learner");
			 * } catch (Exception ex) {
			 * logger.error("Account details are not present"); throw new
			 * CoreException("invalid data"); }
			 */
		}

		AccountDetails details1 = accountDetailsRepository.save(details);
		logger.info("Created ToDo " + details1.getAccountId());

		AccountDetails details2 = accountDetailsRepository.findAll().get(0);
		logger.info("Created ToDo " + details2.getGameSessionId());

		logger.warn("Created ToDo " + details2.getCountry());

		logger.warn("random number" + randomNumberGenarationUtil.getRandomNumberInRange(1, 30));
		logger.warn("----------------------" + realSetRepository.findAll().get(0).real1);

		return details;
	}
}