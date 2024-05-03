// Define o pacote ao qual esta interface pertence.
package com.gabjdev.crud.repository;

// Importa as classes necessárias de outros pacotes.

import com.gabjdev.crud.model.CandidateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Anotação que indica que esta interface é um repositório no contexto do Spring Framework.
@Repository
// Esta interface estende JpaRepository, fornecendo métodos CRUD para a entidade CandidateModel.
public interface CandidateRepository extends JpaRepository<CandidateModel, Integer> {

}
