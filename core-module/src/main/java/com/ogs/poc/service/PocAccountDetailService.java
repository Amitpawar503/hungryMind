package com.ogs.poc.service;

import javax.servlet.http.HttpSession;

import com.ogs.poc.beans.AccountDetails;
import com.ogs.poc.exception.CoreException;


public interface PocAccountDetailService {

	AccountDetails getAccountDetails(HttpSession httpSession) throws CoreException;

}