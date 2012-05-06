grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.target.level = 1.6
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
		inherits true // Whether to inherit repository definitions from plugins
		grailsPlugins()
		grailsHome()
		grailsCentral()
		mavenCentral()

        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        mavenLocal()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
		mavenRepo "http://repository.jboss.com/maven2"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        runtime 'mysql:mysql-connector-java:5.1.5'
		compile "org.apache.commons:commons-math:2.0"
		// compile ":spring-security-ui:0.2"
    }
	
	plugins {
		compile ":hibernate:$grailsVersion"
		build ":tomcat:$grailsVersion"
		compile "org.grails.plugins:famfamfam:1.0.1"
		runtime ":jquery:1.7.1"
		compile ":jquery-ui:1.8.15"
		compile ":mail:1.0"
		compile ":spring-security-core:1.2.7.2"
		compile ":spring-security-ui:0.2"
	}
/*	
plugins.famfamfam=1.0.1
plugins.jquery=1.4.2.5
plugins.jquery-ui=1.8.4.2
plugins.mail=0.9
plugins.spring-security-core=1.1
plugins.spring-security-ui=0.1.1
*/
}



