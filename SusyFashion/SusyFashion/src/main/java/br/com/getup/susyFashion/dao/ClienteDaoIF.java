package br.com.getup.susyFashion.dao;

import br.com.getup.susyFashion.modelo.Cliente;
import java.util.List;

/**
 *
 * @author E.Wellington
 */
public interface ClienteDaoIF extends DaoIF{
    
    public List<Cliente> findByNameLike(String query);

    
}
