package EX11_Repository;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import EX11_Model.Cidade;
import EX11_Model.Previsao;
import EX11_Model.Semana;

public class TesteInserePrevisaoComSemanaECidade {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Semana s = new Semana();
		s.setDiaDaSemana("Sabado");
		manager.persist(s);
		
		Cidade c = new Cidade();
		c.setNome("São Paulo");
		c.setLatitude( -23.5489);
		c.setLongitude(-46.6388);
		manager.persist(c);
		
		Previsao p = new Previsao();
		p.setTemperaturaMin(12.0);
		p.setTemperaturaMax(25.0);
		p.setUmidadeRelAr(5.0);
		p.setLocalDate(LocalDate.now());
		p.setSemana(s);
		p.setCidade(c);
		p.setDescricao("Sabado a temperatura máxima em " + p.getCidade().getNome() + " será de 25 graus celsius e a mínima será de 12 graus celsius, com umidade relativa do ar em  5%.");
		manager.persist(p);
		transaction.commit();
		JPAUtil.close();
	}
}
