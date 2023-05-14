import React, { useEffect } from "react";

export const Pagination = ({ numPages, currentPage, setCurrentPage }) => {

  const pageNumbers = [...Array(numPages + 1).keys()].slice(1)

  const nextPage = () => {
          if(currentPage !== numPages) setCurrentPage(currentPage + 1)
  }
  const prevPage = () => {
      if(currentPage !== 1) setCurrentPage(currentPage - 1)
  }
  return (
      <nav>
          <ul className='pagination justify-content-center'>
              <li className="page-item">
                  <a className="page-link" 
                      onClick={prevPage} 
                      href='#'>
                      
                      Previous
                  </a>
              </li>
              {pageNumbers.map(pgNumber => (
                  <li key={pgNumber} 
                      className= {`page-item ${currentPage == pgNumber ? 'active' : ''} `} >

                      <a onClick={() => setCurrentPage(pgNumber)}  
                          className='page-link' 
                          href='#'>
                          
                          {pgNumber}
                      </a>
                  </li>
              ))}
              <li className="page-item">
                  <a className="page-link" 
                      onClick={nextPage}
                      href='#'>
                      
                      Next
                  </a>
              </li>
          </ul>
      </nav>
  )
}