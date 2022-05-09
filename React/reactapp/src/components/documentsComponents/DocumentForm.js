import {useState} from 'react'


const DocumentForm = ({type}) => {

    const [title, setTitle] = useState('')
    const [author, setAuthor] = useState('')
    const [editor, setEditor] = useState('')
    const [publicationYear,setPublicationYear] = useState('')
    const [genre, setGenre] = useState('')
    const [nb, setNb] = useState(0)
    
    const createBook = async (doc) => {
        const res = await fetch('http://localhost:8082/books',
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({title: doc.title, author: doc.author, editor: doc.editor, publicationYear: doc.publicationYear, genre: doc.genre, nbPages: doc.nb})
        }
        )
    }

    const createCd = async (doc) => {
        const res = await fetch('http://localhost:8082/cds',
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({title: doc.title, author: doc.author, editor: doc.editor, publicationYear: doc.publicationYear, genre: doc.genre, nbScenes: doc.nb})
        }
        )
    }

    const createDvd = async (doc) => {
        const res = await fetch('http://localhost:8082/dvds',
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({title: doc.title, author: doc.author, editor: doc.editor, publicationYear: doc.publicationYear, genre: doc.genre, nbScenes: doc.nb})
        }
        )
    }

    const onSubmit = (e) => {
        e.preventDefault()
        if(type == 'book'){
            createBook({title, author, editor, publicationYear, genre, nb})
        }
        if(type == 'cd'){
            createCd({title, author, editor, publicationYear, genre, nb})
        }
        if(type == 'dvd'){
            createDvd({title, author, editor, publicationYear, genre, nb})
        }
        
        
    }

    return(
        <form className='add-form' onSubmit={onSubmit}>
            <div className='form-control'>
                <label>title</label>
                <input type='title' placeholder='title'
                value={title} 
                onChange={(e) => setTitle(e.target.value)} />
            </div>
            <div className='form-control'>
                <label>author</label>
                <input type='author' placeholder='author'
                value={author} 
                onChange={(e) => setAuthor(e.target.value)} />
            </div>
            <div className='form-control'>
                <label>editor</label>
                <input type='editor' placeholder='editor'
                value={editor} 
                onChange={(e) => setEditor(e.target.value)} />
            </div>
            <div className='form-control'>
                <label>publicationYear</label>
                <input type='publicationYear' placeholder='publicationYear'
                value={publicationYear} 
                onChange={(e) => setPublicationYear(e.target.value)} />
            </div>
            <div className='form-control'>
                <label>genre</label>
                <input type='genre' placeholder='genre'
                value={genre} 
                onChange={(e) => setGenre(e.target.value)} />
            </div>
            {
                type === 'book' &&
                <div className='form-control'>
                    <label>number of pages</label>
                    <input type='number' placeholder='number of pages'
                    value={nb} 
                    onChange={(e) => setNb(e.target.value)} />
                 </div>
            }
            {
                type !== 'book' &&
                <div className='form-control'>
                    <label>number of Scenes</label>
                    <input type='number' placeholder='number of scenes'
                    value={nb} 
                    onChange={(e) => setNb(e.target.value)} />
                 </div>
            }
            <input type='submit' value='Save Task' className='btn btn-block'/>
        </form>
    )
}

export default DocumentForm;