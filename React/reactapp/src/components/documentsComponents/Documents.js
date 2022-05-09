import React, { useState, useEffect } from 'react';
import Book from './Book'
import Cd from './Cd'
import Dvd from './Dvd'
const Documents = ({isEmployee, client}) => {
    const [Books, setBooks] = useState([])
    const [Cds, setCds] = useState([])
    const [Dvds, setDvds] = useState([])

    useEffect(() => {
        const getBooks = async () => {
          const booksFromServer = await fetchBooks()
          setBooks(booksFromServer)
        }
        getBooks()
        const getCds = async () => {
            const CdsFromServer = await fetchCds()
            setCds(CdsFromServer)
          }
          getCds()
        const getDvds = async () => {
        const DvdsFromServer = await fetchDvds()
        setDvds(DvdsFromServer)
        }
        getDvds()
      }, [])

      const fetchBooks = async () => {
        const res = await fetch('http://localhost:8082/books')
        const data = await res.json()
        return data
      }

      const fetchCds = async () => {
        const res = await fetch('http://localhost:8082/cds')
        const data = await res.json()
        return data
      }

      const fetchDvds = async () => {
        const res = await fetch('http://localhost:8082/dvds')
        const data = await res.json()
        return data
      }

      const addBook = async (book) => {
        

        const res = await fetch('http://localhost:8082/clients/loanbook',
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({clientId:client.id, documentId:book.id})
        }
        )
        
        
      }

      const addCd = async (cd) => {
        

        const res = await fetch('http://localhost:8082/clients/loancd',
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({clientId:client.id, documentId:cd.id})
        }
        )
        
        
      }
      const addDvd = async (dvd) => {
        

        const res = await fetch('http://localhost:8082/clients/loandvd',
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({clientId:client.id, documentId:dvd.id})
        }
        )
        
        
      }
    return(
        <>
            { !isEmployee &&
                <>
                {Books.map((book) =>(
                    <Book key={book.id}
                    book={book}
                    onAddToLoan={addBook}
                    />
                ))}
                {Cds.map((cd) =>(
                    <Cd key={cd.id}
                    cd={cd}
                    onAddToLoan={addCd}
                    />
                ))}
                {Dvds.map((dvd) =>(
                    <Dvd key={dvd.id}
                    dvd={dvd}
                    onAddToLoan={addDvd}
                    />
                ))}</>
            }

        </>
    )
}

export default Documents;