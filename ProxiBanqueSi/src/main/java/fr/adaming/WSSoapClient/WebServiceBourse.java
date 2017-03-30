package fr.adaming.WSSoapClient;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import fr.adaming.WSSoap.DelayedStockQuote;
import fr.adaming.WSSoap.DelayedStockQuoteSoap;

public class WebServiceBourse {
	private DelayedStockQuote stub = new DelayedStockQuote();
	private DelayedStockQuoteSoap monService = stub.getDelayedStockQuoteSoap();

	private final static String[] tab = new String[]{"AAPL","EC","K","F","MAN","RBS","SAM","UEC", "YUM","PACD"};
	

	
	
	public Map<String, BigDecimal> getStocks(){
		Map<String, BigDecimal> action = new HashMap<>();
		
		for (int i = 0; i < tab.length; i++) {
			BigDecimal coursAction = monService.getQuickQuote(tab[i], "0");
			action.put(monService.getQuote(tab[i], "0").getCompanyName(), coursAction);
		}
		return action;
	}

}
