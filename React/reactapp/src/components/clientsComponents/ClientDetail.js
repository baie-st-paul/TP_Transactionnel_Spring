import React from 'react';
import Loan from './Loan';
import { useState } from 'react';
import Documents from '../documentsComponents/Documents';
import Button from '../miscComponents/Button';
const ClientDetail = ({client}) => {
    const [showListSelection, setshowListSelection] = useState(false)

    const returnDoc = async (loan) => {
        
        if(loan.docType === "Book"){
            await fetch('http://localhost:8082/clients/returnbook',
                {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({loanId:loan.id})
                }
            );
        }

        if(loan.docType === "Cd"){
            await fetch('http://localhost:8082/clients/returncd',
                {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({loanId:loan.id})
                }
            );
        }
        if(loan.docType === "Dvd"){
            await fetch('http://localhost:8082/clients/returndvd',
                {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({loanId:loan.id})
                }
            );
        }



    }

    return (
    <>  
        <Button color='green' text='show Documents' onClick={setshowListSelection}/>
        <div className="box" >
            <h3>{client.firstName} {client.lastName}   Total Fees = {client.total}</h3> 

        </div>
        
            {client.docLoanDTOList.map((loan) =>(
                <Loan key={loan.id}
                loan={loan}
                onReturnLoan={returnDoc}
                />
            ))}

        { showListSelection &&  
            <Documents isEmployee={false}  client={client}/>
        }
        </>

    )
}

export default ClientDetail;