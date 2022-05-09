const Book = ({book, onAddToLoan}) => {
    return(

        <div className="box" onClick={() =>onAddToLoan(book)} >
            <h3 >{book.title} {book.author} {book.editor} {book.publicationYear} {book.genre} {book.nbPages} {book.nbCopies}</h3> 
        </div>
    )
}

export default Book;