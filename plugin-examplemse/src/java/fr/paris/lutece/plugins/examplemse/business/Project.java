/*
 * Copyright (c) 2002-2025, City of Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.examplemse.business;

import javax.validation.constraints.Size;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;
import java.io.Serializable;
/**
 * This is the business class for the object Project
 */ 
public class Project implements Serializable
{
    private static final long serialVersionUID = 1L;

    // Variables declarations 
    private int _nId;
    
    @NotEmpty( message = "#i18n{examplemse.validation.project.Name.notEmpty}" )
    @Size( max = 50 , message = "#i18n{examplemse.validation.project.Name.size}" ) 
    private String _strName;
    
    @NotEmpty( message = "#i18n{examplemse.validation.project.Description.notEmpty}" )
    @Size( max = 255 , message = "#i18n{examplemse.validation.project.Description.size}" ) 
    private String _strDescription;
    @URL( message = "#i18n{portal.validation.message.url}" )
    @NotEmpty( message = "#i18n{examplemse.validation.project.Imageurl.notEmpty}" )
    @Size( max = 255 , message = "#i18n{examplemse.validation.project.Imageurl.size}" ) 
    private String _strImageurl;

    @Min( value = 5 , message ="#i18n{example.validation.project.cost.range}")
    @Max( value =- 25 , message ="#i18n{example.validation.project.cost.range}")
    private int _nCost;

    /**
     * Returns the Id
     * @return The Id
     */
    public int getId( )
    {
        return _nId;
    }

    /**
     * Sets the Id
     * @param nId The Id
     */ 
    public void setId( int nId )
    {
        _nId = nId;
    }
    
    /**
     * Returns the Name
     * @return The Name
     */
    public String getName( )
    {
        return _strName;
    }

    /**
     * Sets the Name
     * @param strName The Name
     */ 
    public void setName( String strName )
    {
        _strName = strName;
    }
    
    
    /**
     * Returns the Description
     * @return The Description
     */
    public String getDescription( )
    {
        return _strDescription;
    }

    /**
     * Sets the Description
     * @param strDescription The Description
     */ 
    public void setDescription( String strDescription )
    {
        _strDescription = strDescription;
    }
    
    
    /**
     * Returns the Imageurl
     * @return The Imageurl
     */
    public String getImageurl( )
    {
        return _strImageurl;
    }

    /**
     * Sets the Imageurl
     * @param strImageurl The Imageurl
     */ 
    public void setImageurl( String strImageurl )
    {
        _strImageurl = strImageurl;
    }


    // Get value of Cost
    // @return the cost

    public int getCost( )
    {
        return _nCost;
    }


    /**
     * Sets the value of the cost
     * @param _nCost The cost to set
     */ 

    public void setCost( int _nCost)
    {
        this._nCost = _nCost;
    }



    /**
    *Cost control
    *@return true if cost is.a multiple of 5, false otherwise
    */

    public boolean isCostValid( ){
        return( _nCost % 5 == 0);
    }

    
}
