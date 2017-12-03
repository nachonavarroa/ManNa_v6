/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.nacho.manna.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 * REST Web Service
 *
 * @author Nacho
 */

@javax.ws.rs.ApplicationPath("resources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.example.nacho.manna.rest.OrdenResources.class);
        resources.add(com.example.nacho.manna.rest.UsuarioResource.class);
    }
    
}