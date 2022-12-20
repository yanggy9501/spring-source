package com.readspring.service;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

/**
 * @author yanggy
 */
@Service
public class LookupService {

	@Lookup("publicService")
	public PublicService publicService() {
		return null;
	}

	public void test() {
		System.out.println(publicService());
	}
}
