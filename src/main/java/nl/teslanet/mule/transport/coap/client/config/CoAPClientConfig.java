/*******************************************************************************
 * Copyright (c) 2017, 2018 (teslanet.nl) Rogier Cobben.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Public License - v 2.0 which accompany this distribution.
 * 
 * The Eclipse Public License is available at
 *    http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *    (teslanet.nl) Rogier Cobben - initial creation
 ******************************************************************************/

package nl.teslanet.mule.transport.coap.client.config;

import java.net.InetSocketAddress;

import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.components.Configuration;
import org.mule.api.annotations.display.Placement;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;

@Configuration(friendlyName = "Configuration")
public class CoAPClientConfig extends EndpointConfig
{
    @Configurable
    @Placement(tab= "General", group="Connect to")
    private String host= null;

    @Configurable
    @Optional
    @Placement(tab= "General", group="Connect to")
    private Integer port= null;

    //TODO add base path 
    
    @Configurable
    @Default( value= "false")
    @Placement(tab= "General", group="Connect to")
    //@FriendlyName(value = false)
    private boolean secure= false;

    public InetSocketAddress getLocalAddress()
    {
        int port = 0;

        if ( secure )
        {
            if ( getBindToPort() != null ) port=  Integer.parseInt( getBindToPort());
        }
        else if ( getBindToSecurePort() != null )
        {
            port= Integer.parseInt( getBindToSecurePort());
        };
        if ( getBindToHost() != null )
        {
            return new InetSocketAddress( getBindToHost(), port );            
        }
        else
        {
            return new InetSocketAddress( port );            
        }
	}


/**
     * @return the host
     */
    public String getHost()
    {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost( String host )
    {
        this.host= host;
    }

    /**
     * @return the port
     */
    public Integer getPort()
    {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort( Integer port )
    {
        this.port= port;
    }


    /**
     * @return the secure
     */
    public boolean isSecure()
    {
        return secure;
	}

    /**
     * @param secure the secure to set
     */
    public void setSecure( boolean secure )
    {
        this.secure= secure;
    }
}