function BreweryCard({ brewery }) {
    return (
        <>
            <div>
                <h2 id="brew-name">{brewery.name}</h2>
                <p class="address-shortener">{brewery.street ? brewery.street + ',' : ""}  {brewery.city}, {brewery.state}, {brewery.postal_code}</p>
                <div id="card-spacer">
                    <span className="text-handler" >Brewery Type: {brewery.brewery_type}</span>
                    <a className="text-handler" target="_blank_" href={brewery.website_url}>{brewery.website_url ? "Visit Website" : "No Website"} </a>
                </div>
                <p></p>
            </div>
        </>
    );
}

export default BreweryCard;