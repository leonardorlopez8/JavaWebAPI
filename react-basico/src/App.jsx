import React, { Component } from "react";
import Avatar from "./recursos/imagenes/avatar.png";
import Formulario from "./Componentes/Formulario";
import Usuario from "./Componentes/Usuario";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            usuarios: []
        }

    }

    componentDidMount() {
        this.buscarUsuarios();

    }

    buscarUsuarios = () => {
        //promesas
        const URL = "https://reqres.in/api/users";
        fetch(URL).then((response) => response.json()).
            then((json) => this.setState({ usuarios: json.data })).
            catch((error) => console.log(error));

    }

    agregarUsuarioArreglo = (correo, nombre, apellido) => {
        const usuario = {
            email: correo,
            first_name: nombre,
            last_name: apellido,
            avatar: Avatar
        }
        this.agregarUsuarioAPI(usuario);
        
    }

    //recibe un usuario
    agregarUsuarioAPI = (usuario) => {
        const URL = "https://reqres.in/api/users";
        const HEADER = {
            method: "POST",
            body: JSON.stringify(usuario),
            //y si quiero le paso el header
            headers: {
                "Content-Type" : "application/json"
            }
        }
        //y ahora hago mi peticion fetch
        fetch(URL, HEADER).
        then((response) => response.json()).
        then((json) => this.setState({ usuarios: [...this.state.usuarios, json]})).
        catch((error) => console.log(error));  
        
    }

    render() {
        return (
            <>
                <Formulario agregarUsuario={this.agregarUsuarioArreglo} />
                {this.state.usuarios.map((e) =>
                    <Usuario
                        key={e.id}
                        id={e.id}
                        email={e.email}
                        first_name={e.first_name}
                        last_name={e.last_name}
                        avatar={e.avatar}


                    />

                )}
            </>

        );
    }
}

export default App;