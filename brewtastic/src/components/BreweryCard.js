
// import { useEffect } from 'react';

// import { useState } from "react";



function BreweryCard({ brewery }) {

   


    return (
        <>
           
            <div className='brewery-card' >

                <h2>{brewery.name}</h2>
                <p>Brewery Type: {brewery.brewery_type}</p>
                <p>{brewery.street ? brewery.street + ',' : ""}  {brewery.city}, {brewery.state}, {brewery.postal_code}</p>
                <a target="_blank_" href={brewery.website_url}>{brewery.website_url ? brewery.website_url : "No Website"} </a>
                {/* <button onClick={testerTwo}>View Details</button> */}
                <p></p>

            </div>
        </>
    );
}

export default BreweryCard;