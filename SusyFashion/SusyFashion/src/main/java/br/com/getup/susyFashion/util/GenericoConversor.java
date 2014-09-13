/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getup.susyFashion.util;

import br.com.getup.susyFashion.modelo.Identificavel;
import java.io.Serializable;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author E.Wellington
 */
@FacesConverter("generico")
public class GenericoConversor implements Converter, Serializable {

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
        if (value != null) {
            return this.getAttributesFrom(component).get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext ctx, UIComponent component, Object value) {

        if (value != null
                && !"".equals(value)) {

            Identificavel entity = (Identificavel) value;

            // adiciona item como atributo do componente
            if (entity.getId() != null) {
                this.addAttribute(component, entity);
                Long codigo = entity.getId();
                if (codigo != null) {
                    return String.valueOf(codigo);
                }

            }
            return (String) value.toString();
        }
        return "";
    }

    protected void addAttribute(UIComponent component, Identificavel o) {
        String key = o.getId().toString(); // codigo da empresa como chave neste caso
        this.getAttributesFrom(component).put(key, o);
    }

    protected Map<String, Object> getAttributesFrom(UIComponent component) {
        return component.getAttributes();
    }

}