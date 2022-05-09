const Cd = ({cd, onAddToLoan}) => {
    return(
        
        <div className="box" onClick={() =>onAddToLoan(cd) }>
            <h3>{cd.title} {cd.author} {cd.editor} {cd.publicationYear} {cd.genre} {cd.nbScenes} {cd.nbCopies}</h3> 
        </div>
    )
}

export default Cd;