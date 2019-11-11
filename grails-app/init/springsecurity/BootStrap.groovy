package springsecurity

class BootStrap {

    def init = { servletContext ->
        Role adminRole = Role.findOrSaveWhere(authority: Role.ADMIN)
        Role userRole = save(Role.findOrCreateWhere(authority: Role.USER))

        User user = save(new User(username: 'user', password: 'user'))
        User admin = save(new User(username: 'admin', password: 'admin'))

        UserRole.create(user, userRole, true)
        UserRole.create(admin, adminRole, true)
    }

    static save(domainObject){
        domainObject.save(failOnError: true, flush: true)
    }

    def destroy = {
    }
}
