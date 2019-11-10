package com.desafio.conductor.resource;

import com.desafio.conductor.dto.DepositoDTO;
import com.desafio.conductor.dto.SaqueDTO;
import com.desafio.conductor.dto.TransacoesCartaoDTO;
import com.desafio.conductor.dto.TransacoesDTO;
import com.desafio.conductor.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping ("/transacoes")
public class TransacaoResource {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping("/deposito")
    public ResponseEntity deposito(@RequestBody DepositoDTO depositoDTO){
        transacaoService.deposito(depositoDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/saque")
    public ResponseEntity saque(@RequestBody SaqueDTO saqueDTO){
        return ResponseEntity.ok(transacaoService.saque(saqueDTO));
    }

    @PostMapping("/novatransacaocartao")
    public ResponseEntity novaTransacaoCartao(@RequestBody TransacoesCartaoDTO transacoesCartaoDTO){
        transacaoService.transacaoCartao(transacoesCartaoDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/bloqueioconta")
    public ResponseEntity bloqueioConta(@RequestBody Long idconta){
        return ResponseEntity.ok("Conta bloqueada com sucesso!");
    }

    @GetMapping("/desbloqueioconta")
    public ResponseEntity desbloqueioConta(@RequestBody Long idconta){
        return ResponseEntity.ok("Conta desbloqueada com sucesso!");
    }

    @GetMapping("/layout")
    public ResponseEntity<Resource> download(@RequestParam("datalayout") Date datalayout) throws IOException {
        Path path = Paths.get(transacaoService.getLayout(datalayout).toURI());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=cartaolayout.txt");
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");

        return ResponseEntity.ok()
                .headers(header)
                .contentLength(resource.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }

    @GetMapping("/extrato/{conta}/{dataini}/{datafim}")
    public ResponseEntity<List<TransacoesDTO>> getExtrato(@PathVariable("conta") Long conta, @PathVariable("dataini") Date dataini, @PathVariable("datafim") Date datafim){
        List<TransacoesDTO> lst = new ArrayList<TransacoesDTO>(transacaoService.getExtrato(conta, dataini, datafim));
        return ResponseEntity.ok(lst);
    }

}

