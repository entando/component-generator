/*
 *
 * <Your licensing text here>
 *
 */
package org.entando.entando.plugins.jppet.aps.system.services.cat.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.entando.entando.aps.system.services.api.model.AbstractApiResponse;
import org.entando.entando.aps.system.services.api.model.AbstractApiResponseResult;


@XmlRootElement(name = "response")
public class CatResponse extends AbstractApiResponse {
    
    @Override
    @XmlElement(name = "result", required = true)
    public CatResponseResult getResult() {
        return (CatResponseResult) super.getResult();
    }
    
    @Override
    protected AbstractApiResponseResult createResponseResultInstance() {
        return new CatResponseResult();
    }
    
}