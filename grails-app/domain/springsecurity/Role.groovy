package springsecurity

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

//@GrailsCompileStatic
@EqualsAndHashCode(includes='authority')
@ToString(includes='authority', includeNames=true, includePackage=false)
class Role implements Serializable {
	public final static String ADMIN = "ROLE_ADMIN" //muss final sein
	public final static String USER = "ROLE_USER" //muss final sein

	private static final long serialVersionUID = 1

	String authority

	static constraints = {
		authority nullable: false, blank: false, unique: true
	}

	static mapping = {
		cache true
	}
}
