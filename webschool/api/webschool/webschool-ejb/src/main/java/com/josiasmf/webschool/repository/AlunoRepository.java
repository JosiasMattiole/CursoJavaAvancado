package com.josiasmf.webschool.repository;

import com.josiasmf.webschool.model.Aluno;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Josias
 */
@RequestScoped
public class AlunoRepository extends GenericRepository<Aluno>{
    
    @Inject
    private EntityManager em;

    public AlunoRepository(EntityManager em) {
        super(em, Aluno.class);
    }
    
    public Aluno findById(Long id){
        return super.find(id);
    }

    public List<Aluno> findAllByNome(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Aluno> criteria = cb.createQuery(Aluno.class);
        Root<Aluno> aluno = criteria.from(Aluno.class);
        criteria.select(aluno).orderBy(cb.asc(aluno.get("nome")));
        return em.createQuery(criteria).getResultList();
    }
}
