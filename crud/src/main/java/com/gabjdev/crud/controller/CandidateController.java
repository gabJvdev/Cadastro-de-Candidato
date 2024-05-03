package com.gabjdev.crud.controller;

import com.gabjdev.crud.model.CandidateModel;
import com.gabjdev.crud.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    // Método GET para obter todos os candidatos.
    @GetMapping
    public ResponseEntity<List<CandidateModel>> getAll() {
        List<CandidateModel> candidates = candidateService.getAll();
        if (candidates.isEmpty()) {
            // Retorna noContent se a lista de candidatos estiver vazia.
            return ResponseEntity.noContent().header("X-Message", "Nenhum candidato encontrado").build();
        }
        // Retorna ok com a lista de candidatos se não estiver vazia.
        return ResponseEntity.ok().header("X-Message", "Candidatos listados com sucesso").body(candidates);
    }

    // Método GET para obter um candidato pelo ID.
    @GetMapping("/{id}")
    public ResponseEntity<CandidateModel> getId(@PathVariable Integer id) {
        Optional<CandidateModel> candidate = candidateService.getId(id);
        if (!candidate.isPresent()) {
            // Retorna notFound se o candidato com o ID fornecido não for encontrado.
            return ResponseEntity.notFound().header("X-Message", "Candidato não encontrado").build();
        }
        // Retorna ok com o candidato se for encontrado.
        return ResponseEntity.ok().header("X-Message", "Candidato encontrado com sucesso").body(candidate.get());
    }

    // Método POST para adicionar um novo candidato.
    @PostMapping
    public ResponseEntity<CandidateModel> add(@RequestBody CandidateModel candidateModel) {
        CandidateModel savedCandidate = candidateService.add(candidateModel);
        // Retorna created com o candidato adicionado.
        return ResponseEntity.created(URI.create("/api/candidate/" + savedCandidate.getId())).header("X-Message", "Candidato adicionado com sucesso").body(savedCandidate);
    }

    // Método DELETE para deletar um candidato pelo ID.
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (!candidateService.getId(id).isPresent()) {
            // Retorna notFound se o candidato com o ID fornecido não for encontrado.
            return ResponseEntity.notFound().header("X-Message", "Candidato não encontrado para deletar").build();
        }
        candidateService.delete(id);
        // Retorna noContent após deletar o candidato.
        return ResponseEntity.noContent().header("X-Message", "Candidato deletado com sucesso").build();
    }

    // Método PUT para atualizar um candidato existente pelo ID.
    @PutMapping("/{id}")
    public ResponseEntity<CandidateModel> update(@PathVariable Integer id, @RequestBody CandidateModel candidateModel) {
        if (!candidateService.getId(id).isPresent()) {
            // Retorna notFound se o candidato com o ID fornecido não for encontrado.
            return ResponseEntity.notFound().header("X-Message", "Candidato não encontrado para atualizar").build();
        }
        CandidateModel updatedCandidate = candidateService.update(id, candidateModel);
        // Retorna ok com o candidato atualizado.
        return ResponseEntity.ok().header("X-Message", "Candidato atualizado com sucesso").body(updatedCandidate);
    }
}
