dataSource {
	driverClassName = "org.h2.Driver"
	// In memory database
	url = "jdbc:h2:mem:devDb;MVCC=TRUE"
	
	// File-based database
	//url = "jdbc:h2:prodDb;MVCC=TRUE"
}

hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop','update'
        }
    }
	test {
		dataSource {
            driverClassName = "com.mysql.jdbc.Driver"
            dbCreate = "update" // one of 'create', 'create-drop','update'
            //url = "jdbc:mysql://db1.kapsi.fi/esmo?useUnicode=true&characterEncoding=UTF-8"
            url = "jdbc:mysql://localhost/graati?useUnicode=true&characterEncoding=UTF-8"
            dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
            username = "graati"
            password = "graati"
            properties {
                minEvictableIdleTimeMillis = 900000
                timeBetweenEvictionRunsMillis = 900000
                numTestsPerEvictionRun = 3
                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = true
                validationQuery = 'select 1'
                minIdle = 1
                maxActive = 16
                initialSize = 4
            }
		}
	}
    production {
        dataSource {
			driverClassName = "com.mysql.jdbc.Driver"
			dbCreate = "update" // one of 'create', 'create-drop','update'
			//url = "jdbc:mysql://db1.kapsi.fi/esmo?useUnicode=true&characterEncoding=UTF-8"
			url = "jdbc:mysql://localhost/graati?useUnicode=true&characterEncoding=UTF-8"
			dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
			username = "graati"
			password = "graati"
			properties {
				minEvictableIdleTimeMillis = 900000
				timeBetweenEvictionRunsMillis = 900000
				numTestsPerEvictionRun = 3
				testOnBorrow = true
				testWhileIdle = true
				testOnReturn = true
				validationQuery = 'select 1'
				minIdle = 1
				maxActive = 16
				initialSize = 4
			}
        }
    }
}
