package com.jnavarro.springservice.service;

import org.springframework.stereotype.Service;

/**
 * TimeService
 */

@Service
public interface TimeService {

    public String time();

	public String edad(Integer aday, Integer amonth, Integer ayear);
}