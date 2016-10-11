package com.panarquia.api.domain.utils;

import java.util.ArrayList;
import java.util.Iterator;


public class HistoricalArrayList<T extends IHistorical> extends ArrayList<T>{

	private static final long serialVersionUID = 1L;

	@Override
	public boolean add(T e) {
		if (!this.isEmpty()) {
			IHistorical lastElement = this.getCurrentElement();
			lastElement.setTo(e.getFrom());
		}
		
		return super.add(e);
	}

	private IHistorical getCurrentElement() {
		if (!this.isEmpty()) {
			for (Iterator<T> iterator = this.iterator(); iterator.hasNext();) {
				T element = iterator.next();
				if (element.getTo() == null) {
					return element;
				}
			}
		}
		
		return null;
	}
	
	
}
