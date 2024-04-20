import React from 'react'

interface Book {
    title: string;
    author: string;
    image: string;
}

const UsersPage = async () => {
    const res = await fetch('http://localhost:8080/api/books', { next: { revalidate: 10 }});
    const books: Book[] = await res.json();

  return (
    <>
        <h1>Users</h1>
        <p>{new Date().toLocaleTimeString()}</p> 
        <ul>
            {books.map((book, index) => {
                return (
                    <li key={index}>{book.title}</li>
                )
            })}
        </ul>
    </>
  )
}

export default UsersPage