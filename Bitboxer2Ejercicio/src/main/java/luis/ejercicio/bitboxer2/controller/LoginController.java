package luis.ejercicio.bitboxer2.controller;

import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/erp/api/login")
@CrossOrigin
public class LoginController {

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
