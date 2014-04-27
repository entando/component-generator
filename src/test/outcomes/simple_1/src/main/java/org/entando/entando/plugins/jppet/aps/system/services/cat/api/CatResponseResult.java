/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jppet.aps.system.services.cat.api;

import javax.xml.bind.annotation.XmlElement;

import org.entando.entando.aps.system.services.api.model.AbstractApiResponseResult;


public class CatResponseResult extends AbstractApiResponseResult {
    
    @Override
    @XmlElement(name = "cat", required = false)
    public JAXBCat getResult() {
        return (JAXBCat) this.getMainResult();
    }
    
}