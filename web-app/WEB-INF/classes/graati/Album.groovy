package graati

class Album {

    static constraints = {
		releaseYear(nullable: true)
    }
	
	static mapping = {
		songs(sort: "indexNumber")
	}
	
	static belongsTo = Artist
	static hasMany = [ 'songs' : Song ]
	String name
	Integer releaseYear
	Artist artist
	
	public String toString() {
		"${name} by ${artist}"
	}
		
}
