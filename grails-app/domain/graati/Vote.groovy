package graati

class Vote {

    static constraints = {
		user()
		song()
		score(nullable: true)
		comment(nullable: true, size:0..512)
		normalizedScore(nullable: true)
    }

	User user
	Raati raati
	Song song
	Float score
	Float normalizedScore
	String comment

	public String toString() {
		"vote #$id"
		// "$user gave $score to $song"
	}
}

