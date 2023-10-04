package dasniko.keycloak.authenticator.gateway;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import dasniko.keycloak.authenticator.Domain.User;

/**
 * @author Niko Köbler, https://www.n-k.de, @dasniko
 */
public class CustomSmsService implements SmsService {

	private final String senderId;

	CustomSmsService(Map<String, String> config) {
		senderId = config.get("senderId");
	}

	@Override
	public void send(User otpReceiver, String message, String subject) throws IOException, InterruptedException {
		// call sms service
		ExternalSMSService client = new ExternalSMSService();
		JSONObject requestBody = new JSONObject();
		requestBody.put("message", message);
		requestBody.put("user", otpReceiver);
		requestBody.put("subject", subject);
		
		client.post("https://smsprovider/send", requestBody);

	}

}
