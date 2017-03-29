import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.entities.Client;
import fr.adaming.service.IClientService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class Test {
	@Autowired
	IClientService clientService;

	/**
	 * @param clientService the clientService to set
	 */
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}
	
	@org.junit.Test
	public void testAjout(){
		Client client = new Client();
		client.setNom("toto");
		clientService.addClient(client);
	}

}
