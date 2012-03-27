package graati

class Artist {

    static constraints = {
    }
	
	static mapping = {
		albums(sort: "releaseYear")
	}
	
	static hasMany = [ 'albums' : Album ]
	
	String name
	
	public String toString() {
		name
	}
}
