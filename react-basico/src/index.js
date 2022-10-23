import React from 'react';
import ReactDOM from 'react-dom/client';
import Clases from './Clases';
import Funciones from './Funciones'


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(

<React.StrictMode>
      <Funciones titulo="Java Web API" subtitulo="Curso de Java" parrafo="Inscribete Ya..."/>
      
      <Clases descripcion="Hola una propiedad desde una clase"/>

</React.StrictMode>


);

