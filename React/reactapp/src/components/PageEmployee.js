import React from "react";
import {useState} from 'react'

const PageEmployee = () => {
    const [showListSelection, setshowListSelection] = useState(true)
    const [showListClients, setshowListClients] = useState(false)

    return(
        <>
            { showListSelection && <>
            <div className="box" >
                <h3>List of employees</h3> 
            </div>    
            <div className="box" >
                <h3>List of Clients</h3> 
            </div> </>
            }
            { !showListSelection && <>
                {
                    showListClients  && <>
                    
                    </>
                }
            </>
            }
         </>
           
    )
}

export default PageEmployee;