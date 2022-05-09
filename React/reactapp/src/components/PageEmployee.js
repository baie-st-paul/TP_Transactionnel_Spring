import React from "react";
import {useState} from 'react'
import ClientForm from "./ClientForm"
import Button from "./Button";

const PageEmployee = () => {
    const [showClientForm, setShowClientForm] = useState(false);

    return(
        <>
            <div>
                <Button color="green" text="Show client form" onClick={setShowClientForm} />
            </div>
            {
                showClientForm && 
                <ClientForm/>
            }
        </>
    )
}

export default PageEmployee;