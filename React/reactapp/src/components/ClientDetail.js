import React from 'react';
import Loan from './Loan';
import { useState } from 'react';
import Documents from './Documents';
import Button from './Button';
const ClientDetail = ({client}) => {
    const [showListSelection, setshowListSelection] = useState(false)


    
    return (
    <>  
        <Button color='green' text='show Documents' onClick={setshowListSelection}/>
        <div className="box" >
            <h3>{client.firstName} {client.lastName}   Total Fees = {client.total}</h3> 

        </div>
        
            {client.docLoanDTOList.map((loan) =>(
                <Loan key={loan.id}
                loan={loan}/>
            ))}

        { showListSelection &&  
            <Documents isEmployee={false}  client={client}/>
        }
        </>

    )
}

export default ClientDetail;