import React from "react";
import {useState} from 'react'
import ClientForm from "./clientsComponents/ClientForm"
import Button from "./miscComponents/Button";
import DocumentForm from "./documentsComponents/DocumentForm";

const PageEmployee = () => {
    const [showClientForm, setShowClientForm] = useState(false);
    const [docType, setDocType] = useState('book');

    const openDocForm = (type) => {
        setDocType(type);
        setShowClientForm(false);
        
    }

    return(
        <>
            <div>
                <Button color="green" text="Show client form" onClick={setShowClientForm} />
                <Button color="green" text="Show book form" onClick={() => openDocForm('book')} />
                <Button color="green" text="Show cd form" onClick={() => openDocForm('cd')} />
                <Button color="green" text="Show dvd form" onClick={() => openDocForm('dvd')} />

            </div>
            {
                showClientForm && 
                <ClientForm/>
            }
            {
                !showClientForm &&
                <DocumentForm type={docType} />
            }
        </>
    )
}

export default PageEmployee;