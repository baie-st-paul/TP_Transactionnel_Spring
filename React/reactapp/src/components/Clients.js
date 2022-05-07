import React, { useState, useEffect } from 'react';
import Client from './Client';


const Clients = () => {
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
        const data = await res.json()
        return data
      }

    return(
        <>
            {clients.map((client) =>(
                <Client key={client.id}
                client={client}
                 />
            ))}
        </>
    )
}

export default Clients;