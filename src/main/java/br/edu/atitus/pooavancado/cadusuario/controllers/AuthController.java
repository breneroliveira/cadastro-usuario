package br.edu.atitus.pooavancado.cadusuario.controllers;

import br.edu.atitus.pooavancado.cadusuario.components.JwtUtils;
import br.edu.atitus.pooavancado.cadusuario.controllers.payloads.SigninPayload;
import br.edu.atitus.pooavancado.cadusuario.controllers.payloads.SignupPayload;
import br.edu.atitus.pooavancado.cadusuario.entities.Usuario;
import br.edu.atitus.pooavancado.cadusuario.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;
    private final JwtUtils jwtUtils;

    public AuthController(UsuarioService usuarioService, PasswordEncoder passwordEncoder, AuthenticationManager authManager, JwtUtils jwtUtils) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
        this.authManager = authManager;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/signin")
    public ResponseEntity<Object> login(@RequestBody SigninPayload signin) {
        try {
            Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(signin.getEmail(), signin.getSenha()));
            String jwt = jwtUtils.generateTokenFromEmail(signin.getEmail());
            return ResponseEntity.status(HttpStatus.OK).body(jwt);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> autoCadastro(@RequestBody SignupPayload signup) {
        try {
            Usuario usuarioNovo = new Usuario();
            usuarioNovo.setNome(signup.getNome());
            usuarioNovo.setEmail(signup.getEmail());
            usuarioNovo.setDepartamento(signup.getDepartamento());
            usuarioNovo.setStatus(true);
            String senha = "sla";
            usuarioNovo.setSenha(passwordEncoder.encode(senha));
            usuarioService.save(usuarioNovo);
            return ResponseEntity.status(HttpStatus.OK).body(senha);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}