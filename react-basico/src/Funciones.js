const Imagen= () => <img src="https://static.educacionit.com/partners/github/logo-color.svg" alt=""></img>

function Funciones(props){
    return(
        <div>
            <h1>{props.titulo}</h1>             
            <h2>{props.subtitulo}</h2>            
            <h3>{props.parrafo}</h3>   
            <Imagen/>        
        </div>         
    );
}

export default Funciones;
  