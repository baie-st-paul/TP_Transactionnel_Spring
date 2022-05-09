
import {useState} from 'react'


const ClientForm = () => {
    const [firstName, setFirstName] = useState('')
    const [lastName, setLastName] = useState('')
    const [email, setEmail] = useState('')
    const [address, setAddress] = useState('')
    const [postalCode, setPostalCode] = useState('')

    
    const createClient = async (client) => {
        const res = await fetch('http://localhost:8082/clients',
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({firstName:client.firstName,
                                  lastName:client.lastName,
                                  address:client.address ,
                                  mail:client.email,
                                  postalCode:client.postalCode})
        }
        )
    }

    const onSubmit = (e) => {
        e.preventDefault()

        createClient({firstName,lastName,email,address,postalCode})
        
        setFirstName('')
        setLastName('')
        setAddress('')
        setEmail('')
        setPostalCode('')
        
    }

    return(
        <form className='add-form' onSubmit={onSubmit}>
            <div className='form-control'>
                <label>FirstName</label>
                <input type='firstName' placeholder='FirstName'
                value={firstName} 
                onChange={(e) => setFirstName(e.target.value)} />
            </div>
            <div className='form-control'>
                <label>LastName</label>
                <input type='lastName' placeholder='LastName'
                value={lastName} 
                onChange={(e) => setLastName(e.target.value)} />
            </div>
            <div className='form-control'>
                <label>eMail</label>
                <input type='email' placeholder='eMail'
                value={email} 
                onChange={(e) => setEmail(e.target.value)} />
            </div>
            <div className='form-control'>
                <label>address</label>
                <input type='address' placeholder='address'
                value={address} 
                onChange={(e) => setAddress(e.target.value)} />
            </div>
            <div className='form-control'>
                <label>postalCode</label>
                <input type='postalCode' placeholder='postalCode'
                value={postalCode} 
                onChange={(e) => setPostalCode(e.target.value)} />
            </div>
            <input type='submit' value='Save Task' className='btn btn-block'/>
        </form>
    )
}

export default ClientForm;