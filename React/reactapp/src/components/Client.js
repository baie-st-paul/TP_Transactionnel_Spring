
const Client = ({client}) => {
    return (
        <div className="box">
            <h3>{client.firstName} {client.lastName}</h3> 
        </div>
    )
}  

export default Client;