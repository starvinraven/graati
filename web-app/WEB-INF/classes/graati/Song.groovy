package graati

class Song {

    static constraints = {
		artist(nullable: true)
		audioUrl(nullable: true)
    }

	Artist artist	
	Album album
	String name
	Integer indexNumber
	//URL audioUrl
	String audioUrl
	
	public Artist getArtist() {
		if(artist == null) {
			return album.artist
		}
	}
	
	public String toString() {
		"$name ($album)"
	}
	
}
