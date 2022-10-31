import React, { Component } from "react";
import "../recursos/CSS/usuario.css"
/*
  "id": 1,
        "email": "george.bluth@reqres.in",
        "first_name": "George",
        "last_name": "Bluth",
        "avatar": "https://reqres.in/img/faces/1-image.jpg"
*/

//creamos un objeto el cual contiene atributos
const imagenCSS = {
    width: "150px",
    height: "150px",
    borderRadius: "10%",
}

export default class Usuario extends Component {
    constructor(props) {
        super(props)
        this.state = {
            id: this.props.id,
            email: this.props.email,
            first_name: this.props.first_name,
            last_name: this.props.last_name,
            user_name: this.props.email,
            avatar: this.props.avatar,
            mostrarEmail: true
        }
    }

    //creo la funcion
    CambiarUserName = () => {
        this.setState({

            user_name: this.state.mostrarEmail ? (this.state.first_name + ' ' + this.state.last_name) : this.state.email,
            mostrarEmail: !this.state.mostrarEmail
        });
    }

    render() {
        return (
            <div className="tarjeta">

                <img src={this.state.avatar}  style={
                    {
                        boxShadow: this.state.mostrarEmail?"0 5px 10px lightblue":"0 5px 10px blue",
                        width: "60%"
                    }

                } />
                <div>
                    <h2>{this.state.user_name}</h2>
                    <button className="boton" onClick={this.CambiarUserName}>Mostrar {this.state.mostrarEmail ? "Nombre" : "Email"}</button>
                </div>
            </div>
        );
    }
}