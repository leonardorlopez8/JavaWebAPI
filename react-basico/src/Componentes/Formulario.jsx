import React from "react";
import '../recursos/CSS/form.css';
import '../recursos/CSS/button.css';

export default class Formulario extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            first_name: "",
            last_name: "",
            email: ""
        }
    }

    //la funcion puede recibir una propiedad y un valor
    asignarValoresFormularioOld = (propiedad, valor) => { //llamada: asignarValoresFormulario(first_name, octavio)
        let estado = {}
        estado[propiedad] = valor;
        this.setState(estado);
    }

    asignarValoresFormulario = (event) => {
        this.setState({
            [event.target.name]: event.target.value
        })
    }

    enviarValoresFormulario = (event) => {
        event.preventDefault();
        //recibe una propiedad con una funcion
        this.props.agregarUsuario(this.state.email, this.state.first_name, this.state.last_name);
        this.limpiarValoresFormulario();
    }

    limpiarValoresFormulario=()=>{
        this.setState({
            first_name: "",
            last_name: "",
            email: ""
        });
    }

    render() {
        return (
            <>
                <form onSubmit={this.enviarValoresFormulario}>
                    <input
                        id="first_name"
                        name="first_name"
                        type="text"
                        placeholder="Ingresa el nombre"
                        required={true}
                        value={this.state.first_name}
                        //llamada a la funcion asignarValoresFormulario()
                        //recibe un evento y voy a invocar a 
                        onChange={this.asignarValoresFormulario}

                    />
                    <input
                        id="last_name"
                        name="last_name"
                        type="text"
                        placeholder="Ingresa el apellido"
                        required={true}
                        value={this.state.last_name}
                        onChange={this.asignarValoresFormulario}

                    />
                    <input
                        id="email"
                        name="email"
                        type="email"
                        placeholder="usuario@dominio.extension"
                        required={true}
                        value={this.state.email}
                        onChange={this.asignarValoresFormulario}

                    />

                    <div>
                        <button className="success" type="submit">Agregar Usuario</button>
                        <button className="warning"  onClick={this.limpiarValoresFormulario} type="reset">Limpiar Formulario</button>
                    </div>

                </form>
            </>

        );

    }

}