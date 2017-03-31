package fr.adaming.WSSoapClient;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import fr.adaming.WSSoap.DelayedStockQuote;
import fr.adaming.WSSoap.DelayedStockQuoteSoap;
import fr.adaming.WSSoap.GetQuote;
import fr.adaming.WSSoap.GetQuoteDataSetResponse.GetQuoteDataSetResult;
import fr.adaming.WSSoap.QuoteData;

public class WebServiceSoapClient {
	public static void main(String[] args) {
		// wsimport -keep -d . -p fr.adaming.WSSoap
		// http://www.webservicex.net/stockquote.asmx?WSDL
		// instancier un proxy ou le stub : le nom de la classe du stub est la
		// valeur de l'attribut name de la balise service
		DelayedStockQuote stub = new DelayedStockQuote();
		DelayedStockQuoteSoap monService = stub.getDelayedStockQuoteSoap();

		String[] tab = new String[10];
		tab[0] = "AAPL";
		tab[1] = "EC";
		tab[2] = "F";
		tab[3] = "K";
		tab[4] = "MAN";
		tab[5] = "PACD";
		tab[6] = "RBS";
		tab[7] = "SAM";
		tab[8] = "UEC";
		tab[9] = "YUM";
		String nomAction = monService.getQuote("AAPL", "0").getCompanyName();

		Map<String, BigDecimal> action = new HashMap<>();
		for (int i = 0; i < tab.length; i++) {
			BigDecimal coursAction = monService.getQuickQuote(tab[i], "0");
			action.put(monService.getQuote(tab[i], "0").getCompanyName(), coursAction);
		}

		for (int i = 0; i < tab.length; i++) {
			System.out.println(action.keySet().toArray()[i].toString() + " : "
					+ action.get(action.keySet().toArray()[i].toString()));
		}
		
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
		
		System.out.println(valeurAction.get("Apple"));
	}

}
