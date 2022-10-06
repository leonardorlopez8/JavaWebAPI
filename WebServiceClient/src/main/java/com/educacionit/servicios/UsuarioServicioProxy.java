package com.educacionit.servicios;

public class UsuarioServicioProxy implements com.educacionit.servicios.UsuarioServicio {
  private String _endpoint = null;
  private com.educacionit.servicios.UsuarioServicio usuarioServicio = null;
  
  public UsuarioServicioProxy() {
    _initUsuarioServicioProxy();
  }
  
  public UsuarioServicioProxy(String endpoint) {
    _endpoint = endpoint;
    _initUsuarioServicioProxy();
  }
  
  private void _initUsuarioServicioProxy() {
    try {
      usuarioServicio = (new com.educacionit.servicios.UsuarioServicioServiceLocator()).getUsuarioServicio();
      if (usuarioServicio != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)usuarioServicio)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)usuarioServicio)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (usuarioServicio != null)
      ((javax.xml.rpc.Stub)usuarioServicio)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.educacionit.servicios.UsuarioServicio getUsuarioServicio() {
    if (usuarioServicio == null)
      _initUsuarioServicioProxy();
    return usuarioServicio;
  }
  
  public boolean agregar(com.educacionit.entidades.Usuario usuario) throws java.rmi.RemoteException{
    if (usuarioServicio == null)
      _initUsuarioServicioProxy();
    return usuarioServicio.agregar(usuario);
  }
  
  public com.educacionit.entidades.Usuario[] listar() throws java.rmi.RemoteException{
    if (usuarioServicio == null)
      _initUsuarioServicioProxy();
    return usuarioServicio.listar();
  }
  
  public boolean eliminar(com.educacionit.entidades.Usuario usuario) throws java.rmi.RemoteException{
    if (usuarioServicio == null)
      _initUsuarioServicioProxy();
    return usuarioServicio.eliminar(usuario);
  }
  
  public com.educacionit.entidades.Usuario buscar(java.lang.String correo) throws java.rmi.RemoteException{
    if (usuarioServicio == null)
      _initUsuarioServicioProxy();
    return usuarioServicio.buscar(correo);
  }
  
  
}