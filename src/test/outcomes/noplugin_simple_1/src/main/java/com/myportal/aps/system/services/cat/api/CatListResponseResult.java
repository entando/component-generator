/*
 *
 * <Your licensing text here>
 *
 */
package com.myportal.aps.system.services.cat.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.entando.entando.aps.system.services.api.model.AbstractApiResponseResult;
import org.entando.entando.aps.system.services.api.model.ListResponse;

@XmlSeeAlso({JAXBCat.class})
public class CatListResponseResult extends AbstractApiResponseResult {
    
    @XmlElement(name = "items", required = false)
    public ListResponse<JAXBCat> getResult() {
        if (this.getMainResult() instanceof Collection) {
            List<JAXBCat> cats = new ArrayList<JAXBCat>();
            cats.addAll((Collection<JAXBCat>) this.getMainResult());
            ListResponse<JAXBCat> entity = new ListResponse<JAXBCat>(cats) {};
            return entity;
        }
        return null;
    }

}