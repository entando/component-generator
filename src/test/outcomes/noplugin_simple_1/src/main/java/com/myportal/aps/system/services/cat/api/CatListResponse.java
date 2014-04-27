/*
 *
 * <Your licensing text here>
 *
 */
package com.myportal.aps.system.services.cat.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.entando.entando.aps.system.services.api.model.AbstractApiResponse;
import org.entando.entando.aps.system.services.api.model.AbstractApiResponseResult;


@XmlRootElement(name = "response")
public class CatListResponse extends AbstractApiResponse {
    
    @Override
    @XmlElement(name = "result", required = true)
    public CatListResponseResult getResult() {
        return (CatListResponseResult) super.getResult();
    }
    
    @Override
    protected AbstractApiResponseResult createResponseResultInstance() {
        return new CatListResponseResult();
    }
    
}