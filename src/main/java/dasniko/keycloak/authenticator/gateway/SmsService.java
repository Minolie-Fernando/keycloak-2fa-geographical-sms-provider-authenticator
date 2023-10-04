package dasniko.keycloak.authenticator.gateway;

import java.io.IOException;
import java.util.Map;

import dasniko.keycloak.authenticator.Domain.User;

/**
 * @author Niko Köbler, https://www.n-k.de, @dasniko
 */
public interface SmsService {

	void send(User otpReceiver, String message, String subject) throws IOException, InterruptedException;

}
