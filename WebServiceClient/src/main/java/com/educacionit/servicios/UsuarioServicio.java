/**
 * UsuarioServicio.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.educacionit.servicios;

public interface UsuarioServicio extends java.rmi.Remote {
    public boolean agregar(com.educacionit.entidades.Usuario usuario) throws java.rmi.RemoteException;
    public com.educacionit.entidades.Usuario[] listar() throws java.rmi.RemoteException;
    public boolean eliminar(com.educacionit.entidades.Usuario usuario) throws java.rmi.RemoteException;
    public com.educacionit.entidades.Usuario buscar(java.lang.String correo) throws java.rmi.RemoteException;
}
