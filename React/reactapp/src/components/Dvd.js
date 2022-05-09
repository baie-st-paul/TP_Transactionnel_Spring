const Dvd = ({dvd, onAddToLoan}) => {
    return(
        <div className="box"  onClick={() =>onAddToLoan(dvd) }>
           <h3>{dvd.title} {dvd.author} {dvd.editor} {dvd.publicationYear} {dvd.genre} {dvd.nbScenes} {dvd.nbCopies}</h3> 
        </div>
    )
}

export default Dvd;