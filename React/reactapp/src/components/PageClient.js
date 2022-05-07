import React from "react";
import {useState} from 'react'
import Clients from "./Clients";
import ClientDetail from "./ClientDetail";
import { bool } from "prop-types";

const PageClient = () => {
    const [showClientDetail, setShowClientDetail] = useState(false)
    const [client, setClient] = useState();

    const onSelectClient = (client) => {
            
            setClient(client);
            console.log(client);
            setShowClientDetail(true);
    }

    return(
        <>
            {!showClientDetail && <Clients onSelectClient={onSelectClient} />}
            {showClientDetail && <ClientDetail client={client} />}
        </>
    )

}
export default PageClient;