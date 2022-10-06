/**
 * UsuarioServicioServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.educacionit.servicios;

public class UsuarioServicioServiceLocator extends org.apache.axis.client.Service implements com.educacionit.servicios.UsuarioServicioService {

    public UsuarioServicioServiceLocator() {
    }


    public UsuarioServicioServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public UsuarioServicioServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for UsuarioServicio
    private java.lang.String UsuarioServicio_address = "http://localhost:8081/WebService/services/UsuarioServicio";

    public java.lang.String getUsuarioServicioAddress() {
        return UsuarioServicio_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String UsuarioServicioWSDDServiceName = "UsuarioServicio";

    public java.lang.String getUsuarioServicioWSDDServiceName() {
        return UsuarioServicioWSDDServiceName;
    }

    public void setUsuarioServicioWSDDServiceName(java.lang.String name) {
        UsuarioServicioWSDDServiceName = name;
    }

    public com.educacionit.servicios.UsuarioServicio getUsuarioServicio() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(UsuarioServicio_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getUsuarioServicio(endpoint);
    }

    public com.educacionit.servicios.UsuarioServicio getUsuarioServicio(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.educacionit.servicios.UsuarioServicioSoapBindingStub _stub = new com.educacionit.servicios.UsuarioServicioSoapBindingStub(portAddress, this);
            _stub.setPortName(getUsuarioServicioWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setUsuarioServicioEndpointAddress(java.lang.String address) {
        UsuarioServicio_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.educacionit.servicios.UsuarioServicio.class.isAssignableFrom(serviceEndpointInterface)) {
                com.educacionit.servicios.UsuarioServicioSoapBindingStub _stub = new com.educacionit.servicios.UsuarioServicioSoapBindingStub(new java.net.URL(UsuarioServicio_address), this);
                _stub.setPortName(getUsuarioServicioWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("UsuarioServicio".equals(inputPortName)) {
            return getUsuarioServicio();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://servicios.educacionit.com", "UsuarioServicioService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://servicios.educacionit.com", "UsuarioServicio"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("UsuarioServicio".equals(portName)) {
            setUsuarioServicioEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
