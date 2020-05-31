package EX11_Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import EX11_Model.Previsao;


public interface PrevisoesRepository extends JpaRepository<Previsao, Long> {

}