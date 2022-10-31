const Imagen = () => <img src="https://static.educacionit.com/partners/github/logo-color.svg" alt=""></img>

function Funciones(props) {
    let contador = 1;

    return (
        <div>
            <h1>{props.titulo} {contador}</h1>
            <h2>{props.subtitulo}</h2>
            <h3>{props.parrafo}</h3>
            <Imagen />
            <button onClick={() => { contador++; console.log("Pulsando boton " + contador)  } }>Aumentar</button>
        </div>
    );
}

export default Funciones;
