package graati

import java.util.Date;

class MyRegistrationCode {

	String username
	String token = UUID.randomUUID().toString().replaceAll('-', '')
	Date dateCreated

	static mapping = {
		version false
	}
}
