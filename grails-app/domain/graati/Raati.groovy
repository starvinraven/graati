package graati

class Raati {
	
	static constraints = {
		ends(nullable: true)
	}
	
	static mapping = {
		//albums(sort: "releaseYear")
	}
	
	String name
	static hasMany = [ 'albums' : Album, 'participants' : User ]
	User owner
	Date ends
	Boolean resultsReleased = false
	RaatiPrivacy privacy = RaatiPrivacy.PUBLIC
	
	public String toString() {
		name
	}
}
