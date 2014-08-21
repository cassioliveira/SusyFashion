package br.com.getup.susyFashion.bean;

import br.com.getup.susyFashion.modelo.Identificavel;
import br.com.getup.susyFashion.service.ClienteServiceIF;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Elisângela
 */
public class ClienteBean implements BeanIF {

    @Inject
    private ClienteServiceIF clienteServiceIF;

    public ClienteBean() {
    }
    
    @Override
    public void salvar(Identificavel entidade) {
        clienteServiceIF.salvar(entidade);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO, "Gravação Efetuada com Sucesso", ""));
    }
     
    @Override
    public void atualizar(Identificavel entidade) {
        clienteServiceIF.atualizar(entidade);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO, "Atualizaçao Efetuada com Sucesso", ""));
    }

    @Override
    public void remover(Identificavel entidade) {
        clienteServiceIF.remover(entidade);
    }

    @Override
    public Identificavel buscarPorId(Long id) {
        return clienteServiceIF.buscarPorId(id);
    }

    @Override
    public List<Identificavel> buscarTodos() {
        return clienteServiceIF.buscarTodos();
    }

    public ClienteServiceIF getClienteServiceIF() {
        return clienteServiceIF;
    }

    public void setClienteServiceIF(ClienteServiceIF clienteServiceIF) {
        this.clienteServiceIF = clienteServiceIF;
    }
    
}
