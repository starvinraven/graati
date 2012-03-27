package graati

public enum RaatiPrivacy {
	PUBLIC("Public"), PARTICIPANT_VOTING("Only participants can vote"), PARTICIPANT_VIEWING("Only participants can view and vote");
	
	String description
	
	RaatiPrivacy(String description) {
		this.description = description
	}
}
