
package com.cultos.demo.Security;

//en esta clase realizo la anotacion de que esta clase es de seguridad

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration //indica que la clase es de configuarion de spring
@EnableWebSecurity //habilita la configuracion web de mi pagina
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    //metodo para darle roles a los usarios
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{ //luego lanzo exeption
        
        //estos usuario se almacenan en memoria y no en la base de datos
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}12345")
                .roles("ADMIN", "USER")
                .and()
                .withUser("user")
                .password("{noop}123")
                .roles("USER");
        /*
                auth.inMemoryAuthentication()
                .withUser("admin") //Super usuario
                .password("{noop}12345") // {noop}: sinifica que no aplica codificacion o encriptacion a la contraseña y password de super usuario
                .roles("AMIND", "USER")
                .and()
                .withUser("user") //rol de solo usuario
                .password("{noop}123") //password de usuario
                .roles("USER"); //rol de usuario
        */
    }
    
    //agrego los permisos de los roles, los alcances de los usuario, las rutas a las cuales puede acceder
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{ //luedo lanzo exeption
        
        //estos usuario se almacenan en memoria y no en la base de datos
        httpSecurity.authorizeHttpRequests()
                .antMatchers("/editar/**", "/agregar/**", "/eliminar")
                .hasRole("ADMIN")
                .antMatchers("/")
                .hasAnyRole("USER", "ADMIN")
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/errores/403"); //me mada a pagina de error, porque no tiene permisos
        
                // .antMatchers("/editar/**", "/agregar/**", "/eliminar")  >>> "/eliminar" nio lleva /**, porque es el ultimo

    }
}

/*

package com.cultos.demo.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        
        auth.inMemoryAuthentication()
               .withUser("admin")
                .password("{noop}12345")
                .roles("ADMIN", "USER")
                .and()
                .withUser("user")
                .password("{noop}123")
                .roles("USER");

        
    }
    
     @Override
    protected void configure(HttpSecurity http) throws Exception{
        
        http.authorizeHttpRequests()
             .antMatchers("/editar/**", "/agregar/**", "/eliminar")
              .hasRole("ADMIN")
              .antMatchers("/")
              .hasAnyRole("USER", "ADMIN")
              .and()
              .formLogin()
              .loginPage("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/errores/403");
                

        
    }
    
}
*/