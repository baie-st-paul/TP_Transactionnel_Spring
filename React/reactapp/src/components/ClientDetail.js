import React from 'react';
import Loan from './Loan';

const ClientDetail = ({client}) => {

    return (
    <>
        <div className="box" >
            <h3>{client.firstName} {client.lastName}   Total Fees = {client.total}</h3> 

        </div>
        
            {client.docLoanDTOList.map((loan) =>(
                <Loan key={loan.id}
                loan={loan}/>
            ))}
        </>
    )
}

export default ClientDetail;