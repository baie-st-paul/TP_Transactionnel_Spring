import React, {useEffect, useState} from 'react';
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
          return await res.json()
      }

      const fetchCds = async () => {
        const res = await fetch('http://localhost:8082/cds')
          return await res.json()
      }

      const fetchDvds = async () => {
        const res = await fetch('http://localhost:8082/dvds')
          return await res.json()
      }

      const addBook = async (book) => {
          await fetch('http://localhost:8082/clients/loanbook',
              {
                  method: 'POST',
                  headers: {
                      'Content-Type': 'application/json'
                  },
                  body: JSON.stringify({clientId:client.id, documentId:book.id})
              }
          );
      }

    const addCd = async (cd) => {
        await fetch('http://localhost:8082/clients/loancd',
            {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({clientId:client.id, documentId:cd.id})
            }
        );
    }
    const addDvd = async (dvd) => {
        await fetch('http://localhost:8082/clients/loandvd',
            {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({clientId:client.id, documentId:dvd.id})
            }
        );
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