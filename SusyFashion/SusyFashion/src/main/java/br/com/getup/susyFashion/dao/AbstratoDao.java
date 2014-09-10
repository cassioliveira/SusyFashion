package br.com.getup.susyFashion.dao;

import br.com.getup.susyFashion.modelo.Identificavel;

import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 *
 * @author E.Wellington
 * @param <T>
 */
public abstract class AbstratoDao<T extends Identificavel> implements DaoIF {

    private Class<T> entityClass;

    public AbstratoDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public abstract EntityManager getEntityManager();

    /**
     *
     * @param entidade
     */
    @Override
    public void salvar(Identificavel entidade) {
        getEntityManager().persist(entidade);
    }

    @Override
    public void atualizar(Identificavel entidade) {
        getEntityManager().refresh(entidade);
    }

    @Override
//    @Transactional
    public void remover(Identificavel entidade) {
        Identificavel find = getEntityManager().find(entidade.getClass(), entidade.getId());
        getEntityManager().remove(find);

    }

    @Override
    public Identificavel buscarPorId(Long id) {
        return (Identificavel) getEntityManager().find(entityClass, id);
    }

//    @Override
//    public List<Identificavel> buscarTodos() {
//        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
//        cq.select(cq.from(entityClass));
//        return getEntityManager().createQuery(cq).getResultList();
//               
//    }
}
