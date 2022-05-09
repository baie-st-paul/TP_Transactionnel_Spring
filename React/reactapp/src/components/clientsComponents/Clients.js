import React, {useEffect, useState} from 'react';
import Client from './Client';


const Clients = ({onSelectClient}) => {
    const[clients, setClients] = useState([])

    useEffect(() => {
        const getClients = async () => {
          const clientsFromServer = await fetchClients()
          setClients(clientsFromServer)
        }
        getClients()
      }, [])

      const fetchClients = async () => {
        const res = await fetch('http://localhost:8082/clients')
          return await res.json()
      }

    return(
        <>
            {clients.map((client) =>(
                <Client key={client.id}
                client={client}
                onSelectClient={onSelectClient}
                 />
            ))}
        </>
    )
}

export default Clients;