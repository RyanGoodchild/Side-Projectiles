import React, { useCallback, useEffect, useState } from 'react';
import GoogleMap from './GoogleMap';

function BreweryDetail({ brewery }) {


    return (
        <>
            <div id='details-left'>
                <h1>Brewtastic!</h1>
                <h3>Brewery details page.</h3>
                <p>{brewery.id}</p>
                <p>{brewery.street ? brewery.street + ',' : ""}  {brewery.city}, {brewery.state}, {brewery.postal_code}</p>
            </div>
            {/* <div id='details-right'>
<GoogleMap breweryLocation={brewery.latitude} />
            </div> */}
        </>
    );
}
export default BreweryDetail;