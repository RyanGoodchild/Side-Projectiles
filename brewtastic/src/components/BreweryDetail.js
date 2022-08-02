import React from 'react';

function BreweryDetail({ brewery }) {

    return (
        <>
            <div id='details-left'>
                <h1>{brewery.name}</h1>
              <p>Street: {brewery.street ? brewery.street : ""}</p>
              <p>City: {brewery.city ? brewery.city : ""}</p>
              <p>State: {brewery.state ? brewery.state : ""}</p>
              <p>Zip: {brewery.postal_code ? brewery.postal_code : ""}</p>
            </div>
        </>
    );
}
export default BreweryDetail;