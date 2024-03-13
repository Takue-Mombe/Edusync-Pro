package com.Hit200.Lecturer.s.Companion.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Setter;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;

@Setter
@Getter
@Entity
@Table(name = "users")
public class user implements UserDetails {


    @Getter
    @Id
    private String username;
    @Getter
    private String password;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String emailAddress;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return the user's authorities (roles)
        // Example: return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
        return null;
    }


    public boolean isAccountNonExpired() {
        return true; // Modify as needed
    }


    public boolean isAccountNonLocked() {
        return true; // Modify as needed
    }


    public boolean isCredentialsNonExpired() {
        return true; // Modify as needed
    }


    public boolean isEnabled() {
        return true; // Modify as needed
    }


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

}
