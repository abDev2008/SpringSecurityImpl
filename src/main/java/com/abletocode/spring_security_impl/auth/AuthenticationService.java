package com.abletocode.spring_security_impl.auth;

import com.abletocode.spring_security_impl.config.JwtService;
import com.abletocode.spring_security_impl.user.User;
import com.abletocode.spring_security_impl.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service

public class AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


//    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
//    Authentication authentication = authenticationManager.authenticate(
//            new UsernamePasswordAuthenticationToken(
//                    authenticationRequest.username(),
//                    authenticationRequest.password()
//            )
//    );
//    var user = (User) authentication.getPrincipal();
//    String tocken = "";
//    return new AuthenticationResponse(tocken);
////        return null;
//    }

//edit
public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
    Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    authenticationRequest.username(),
                    authenticationRequest.password()
            )
    );
    var user = (User) authentication.getPrincipal();

    // ✅ Generate actual token
    String token = jwtService.generateToken(user);

    return new AuthenticationResponse(token);
}

//edit

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        //create a User object
        User user = new User(

                registerRequest.firstName(),
                registerRequest.lastName(),
                registerRequest.username(),
               passwordEncoder.encode(registerRequest.password()),
                registerRequest.role()
        );

        //save it in DB
        User registeredUser = userRepository.save(user);

        //generate token
        String token = jwtService.generateToken(registeredUser);
        return new AuthenticationResponse(token);
    }
}
