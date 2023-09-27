package dasniko.keycloak.authenticator.gateway;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Niko Köbler, https://www.n-k.de, @dasniko
 */
public class CustomSmsService implements SmsService {

	private final String senderId;

	CustomSmsService(Map<String, String> config) {
		senderId = config.get("senderId");
	}

	@Override
	public void send(String phoneNumber, String message) {
		//call sms service
	}

}
