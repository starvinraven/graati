package graati

class BlogEntry {

    static constraints = {
    }
	
	User author
	Date dateCreated
	Date lastUpdated
	String title
	String text
	Boolean published
	
}
