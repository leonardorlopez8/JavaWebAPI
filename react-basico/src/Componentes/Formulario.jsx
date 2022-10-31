import React from "react";

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
    asignarValoresFormularioOld=(propiedad, valor)=>{ //llamada: asignarValoresFormulario(first_name, octavio)
        let estado = {}
        estado[propiedad] = valor;
        this.setState(estado);
    }

    asignarValoresFormulario=(event)=>{ 
      this.setState({
        [event.target.name]: event.target.value
      })
    }

    render() {
        return (
            <>
                <form>
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
                        <button type="submit">Agregar Usuario</button>
                        <button type="reset">Limpiar Formulario</button>
                    </div>

                </form>
            </>

        );

    }

}