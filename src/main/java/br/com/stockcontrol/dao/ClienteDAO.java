package br.com.stockcontrol.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.stockcontrol.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class ClienteDAO implements CRUD<Cliente, Long>{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public Cliente pesquisaPeloId(Long id) {
		return entityManager.find(Cliente.class, id);
	}

	@Override
	public List<Cliente> lista() {
		TypedQuery<Cliente> query = entityManager.createQuery("Select c from Cliente c", Cliente.class);
	    return query.getResultList();
	}

	@Override
	public void insere(Cliente cliente) {
		entityManager.persist(cliente);
	}

	@Override
	public void atualiza(Cliente cliente) {
		entityManager.merge(cliente);
	}

	@Override
	public void remove(Cliente cliente) {
		entityManager.remove(cliente);
	}

}
