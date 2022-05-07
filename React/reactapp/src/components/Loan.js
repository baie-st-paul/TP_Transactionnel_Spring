import React from 'react';

const Loan = ({loan}) => {
    return(
            
        <div className="box" >
            <h3>{loan.title} {loan.returnDate}</h3> 
        </div>
    )
}

export default Loan;