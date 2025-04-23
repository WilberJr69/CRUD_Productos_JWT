package wilber.gestion_productos.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import wilber.gestion_productos.jwt.service.JwtService;
import wilber.gestion_productos.user.model.AuthRequest;
import wilber.gestion_productos.user.model.UserDTO;
import wilber.gestion_productos.user.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;


    @PostMapping("/register_user")
    public String registerUser(@RequestBody UserDTO userDTO){

        userService.registerUser(userDTO);

        return "Usuario Registrado";
    }

    @PostMapping("/register_admin")
    public String registerAdmin(@RequestBody UserDTO userDTO){

        userService.registerAdmin(userDTO);

        return "Admin Registrado";
    }




    @PostMapping("/generateToken")
    public String generateToken(@RequestBody AuthRequest authRequest){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
        );

        if (authentication.isAuthenticated()){
            return jwtService.generateToken(authRequest.getEmail());
        }else {
            throw new UsernameNotFoundException("Usuario invalido");
        }

    }

    @GetMapping("/information_admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String informationAdmin(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return "Welcome admin whit email: "+username;
    }

    @GetMapping("/information_user")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String informationUser(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return "Welcome user whit email: "+username;
    }




}
