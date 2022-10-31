import React from 'react';
import ReactDOM from 'react-dom/client';
import Usuario from './Componentes/Usuario';
import Avatar from "./recursos/imagenes/avatar.png";
import Usuarios from "./recursos/archivos/usuarios.json";
import Formulario from './Componentes/Formulario';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(

      <React.StrictMode>
            <Formulario/>
            {
                  Usuarios.map((e) => (
                        <Usuario
                              key={e.id}
                              id={e.id}
                              email={e.email}
                              avatar={e.avatar}
                              first_name={e.first_name}
                              last_name={e.last_name}
                        />


                  ))}

      </React.StrictMode>,

);

