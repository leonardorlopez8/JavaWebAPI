import React from "react";

export default class Clases extends React.Component {
     state = {
          contador: 1
     }

     render() {
          return (<div>
               {this.props.descripcion}
               {this.state.contador}
               <div>
                    <button onClick={() => { 
                         this.setState({ contador: this.state.contador + 1 }); 
                         console.log(this.state.contador); 
                         }}>Aumentar</button>

               </div>
          </div>);
     }
}

