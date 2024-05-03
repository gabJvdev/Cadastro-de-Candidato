// Define o pacote ao qual esta classe pertence.
package com.gabjdev.crud.service;

// Importa as classes necessárias de outros pacotes.

import com.gabjdev.crud.model.CandidateModel;
import com.gabjdev.crud.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Anotação que indica que esta classe é um serviço no contexto do Spring Framework.
@Service
public class CandidateService {
    // Injeta automaticamente uma instância de CandidateRepository.
    @Autowired
    private CandidateRepository candidateRepository;

    // Método para obter todos os candidatos.
    public List<CandidateModel> getAll() {
        // Chama o repositório para encontrar todos os candidatos e retorna a lista.
        return candidateRepository.findAll();
    }

    // Método para obter um candidato pelo ID.
    public Optional<CandidateModel> getId(Integer id) {
        // Chama o repositório para encontrar o candidato pelo ID fornecido.
        return candidateRepository.findById(id);
    }

    // Método para adicionar um novo candidato.
    public CandidateModel add(CandidateModel candidateModel) {
        // Salva o candidato no repositório e retorna o objeto salvo.
        return candidateRepository.save(candidateModel);
    }

    // Método para deletar um candidato pelo ID.
    public void delete(Integer id) {
        // Chama o repositório para deletar o candidato pelo ID fornecido.
        candidateRepository.deleteById(id);
    }

    // Método para atualizar um candidato existente.
    public CandidateModel update(Integer id, CandidateModel candidateModel) {
        // Define o ID do modelo de candidato com o ID fornecido.
        candidateModel.setId(id);
        // Salva as alterações no repositório e retorna o objeto atualizado.
        return candidateRepository.save(candidateModel);
    }

}
