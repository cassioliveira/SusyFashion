package br.com.getup.susyFashion.modelo;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author E.Wellington
 */
@Entity
@Table(name = "tbl_cliente")
public class Cliente extends Pessoa{

    
    
 @OneToMany (mappedBy = "cliente", targetEntity = Folha.class, fetch = FetchType.LAZY)  
 private  List<Folha> listaFolhas;
 
 
    public List<Folha> getListaFolhas() {
        return listaFolhas;
    }

    public void setListaFolhas(List<Folha> listaFolhas) {
        this.listaFolhas = listaFolhas;
    }

    public Cliente() {
        endereco = new Endereco();
    
    }

    @Override
    public String toString() {
        return getNome();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        return true;
    }
    
    
 
    
 
 
}
