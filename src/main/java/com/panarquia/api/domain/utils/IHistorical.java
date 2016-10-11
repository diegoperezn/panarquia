package com.panarquia.api.domain.utils;

import java.util.Date;

public interface IHistorical {

	Date getFrom();

	void setTo(Date to);
	
	Date getTo();
	
}
