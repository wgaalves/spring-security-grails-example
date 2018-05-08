package spring__sec_example

import br.com.example.Role
import br.com.example.User
import br.com.example.UserRole

class BootStrap {

    def init = { servletContext ->
        Role adminRole = (!Role.findByAuthority("ROLE_ADMIN"))?new Role(authority: 'ROLE_ADMIN').save(flush: true):Role.findByAuthority("ROLE_ADMIN")
        Role roleUser = (!Role.findByAuthority("ROLE_USER"))?new Role(authority: 'ROLE_USER').save(flush: true):Role.findByAuthority("ROLE_USER")
        User admin = (!User.findByUsername("admin"))?new User(username: "admin",password: "admin").save(flush: true):null
        if(admin != null){
            new UserRole(user: admin,role: adminRole).save(flush: true)
        }

    }
    def destroy = {
    }
}
