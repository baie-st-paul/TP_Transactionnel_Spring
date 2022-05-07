import React from "react";
import { Link } from "react-router-dom";


const LandingPage = () => {
    return(
        <div>
            <Link to="/clients" style={{textDecoration:"none", color: "black"}}>
                <div className={'box '}>               
                    <h3>
                        Clients
                    </h3>  
                </div>
            </ Link>
            <Link to="/employe" style={{textDecoration:"none", color: "black"}}>
                <div className={'box '}>               
                    <h3>
                     Employees
                    </h3>  
                </div>
            </ Link>
        </div>
    )
}
export default LandingPage;