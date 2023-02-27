package luis.ejercicio.bitboxer2.controller;

import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/erp/api/login")
@CrossOrigin
public class LoginController {

    /*@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request) {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            String token = jwtTokenProvider.createToken(request.getUsername());
            return ResponseEntity.ok(new AuthenticationResponse(token));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }*/

    @GetMapping
    ResponseEntity<?> getLog(){
        //var auth = SecurityContextHolder.getContext().getAuthentication();
        boolean goAhead = false;


        //return  ResponseEntity.ok(auth.isAuthenticated());
        return  null;
    }

    @PostMapping
    ResponseEntity<?> createLog(){


        return  ResponseEntity.ok("Muy bien");
    }
}
