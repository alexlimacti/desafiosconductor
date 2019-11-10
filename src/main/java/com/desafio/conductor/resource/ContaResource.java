package com.desafio.conductor.resource;

import com.desafio.conductor.dto.ContaSaldoDTO;
import com.desafio.conductor.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contas")
public class ContaResource {

    @Autowired
    private ContaService contaService;

    @GetMapping("/saldo/{conta}")
    public ResponseEntity<ContaSaldoDTO> getSaldo(@PathVariable("conta") Long conta){
        return ResponseEntity.ok(contaService.getSaldo(conta));
    }
}
