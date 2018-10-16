package com.ogs.poc.service;

import com.ogs.poc.beans.AccountDetails;
import com.ogs.poc.exception.CoreException;

public interface PocAccountDetailService {

	AccountDetails getAccountDetails(String sessionId) throws CoreException;

}