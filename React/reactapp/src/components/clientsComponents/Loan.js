import React from 'react';
import { FaTimes} from 'react-icons/fa'

const Loan = ({loan, onReturnLoan}) => {
    return(
            
        <div className="box" >
            <h3>{loan.title} {loan.returnDate} <FaTimes 
            style={{color: 'red', cursor: 'pointer'}}
            onClick={()=>onReturnLoan(loan)}/></h3> 
        </div>
    )
}

export default Loan;