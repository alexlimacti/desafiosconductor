package com.desafio.conductor.resource;

import com.desafio.conductor.dto.ContaPessoaDTO;
import com.desafio.conductor.dto.ContaSaldoDTO;
import com.desafio.conductor.model.Contas;
import com.desafio.conductor.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas")
public class ContaResource {

    @Autowired
    private ContaService contaService;

    @GetMapping("/saldo/{conta}")
    public ResponseEntity<ContaSaldoDTO> getSaldo(@PathVariable("conta") Long conta){
        return ResponseEntity.ok(contaService.getSaldo(conta));
    }

    @GetMapping("/bloqueioconta")
    public ResponseEntity bloqueioConta(@RequestParam Long idconta){
        contaService.bloqueio(idconta);
        return ResponseEntity.ok("Conta bloqueada com sucesso!");
    }

    @GetMapping("/desbloqueioconta")
    public ResponseEntity desbloqueioConta(@RequestParam Long idconta){
        contaService.desbloqueio(idconta);
        return ResponseEntity.ok("Conta desbloqueada com sucesso!");
    }

    @PostMapping("/")
    public ResponseEntity<Contas> criarConta(@RequestBody ContaPessoaDTO contaPessoaDTO){
        Contas conta = contaService.criarConta(contaPessoaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(conta);
    }
}
