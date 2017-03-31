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

	
	public Map<String, BigDecimal> getValues(){
		
		Map<String, BigDecimal> valeurAction=new HashMap<>();
		
		valeurAction.put("Apple",monService.getQuickQuote(tab[0], "0"));
		valeurAction.put("Ecopetrol",monService.getQuickQuote(tab[1], "0"));
		valeurAction.put("Kellogg",monService.getQuickQuote(tab[2], "0"));
		valeurAction.put("Ford",monService.getQuickQuote(tab[3], "0"));
		valeurAction.put("ManpowerGroup",monService.getQuickQuote(tab[4], "0"));
		valeurAction.put("Royal",monService.getQuickQuote(tab[5], "0"));
		valeurAction.put("Boston",monService.getQuickQuote(tab[6], "0"));
		valeurAction.put("Uranium",monService.getQuickQuote(tab[7], "0"));
		valeurAction.put("Yum!",monService.getQuickQuote(tab[8], "0"));
		valeurAction.put("Pacific",monService.getQuickQuote(tab[9], "0"));
		
		
		return valeurAction;
	}
}
