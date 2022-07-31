

import { useNavigate } from "react-router-dom";


function BreweryCard({ brewery }) {

    let navigate = useNavigate;
    const testFunct = (event, { brewery }) => {

        console.log(event.target)
        console.log(brewery)
        navigate("/detail")
        
    };



    return (
        <div className='brewery-card' onClick={event => testFunct(event, { brewery })}>
       
            <h2>{brewery.name}</h2>
            <p>Brewery Type: {brewery.brewery_type}</p>
            <p>{brewery.street ? brewery.street + ',' : ""}  {brewery.city}, {brewery.state}, {brewery.postal_code}</p>
            <a target="_blank_" href={brewery.website_url}>{brewery.website_url ? brewery.website_url : "No Website"} </a>
            <p></p>

        </div>
    );
}

export default BreweryCard;