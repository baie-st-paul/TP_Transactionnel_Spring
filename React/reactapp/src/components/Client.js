import { Link } from "react-router-dom";


const Client = ({client, onSelectClient}) => {
    return (  
      <div className="box" onClick={()=> onSelectClient(client)}>
            <h3>{client.firstName} {client.lastName}</h3> 
        </div>
    )
}  

export default Client;