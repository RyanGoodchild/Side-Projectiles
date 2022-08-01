
import { useState, useEffect, useCallback } from 'react';
import BreweryCard from './BreweryCard';
import BreweryDetail from './BreweryDetail';
import GoogleMap from './GoogleMap';



function Home() {

    let [currentStateLocation, setCurrentStateLocation] = useState("Pennsylvania");
    let [currentCityLocation, setCurrentCityLocation] = useState("");
    let [breweryList, setBreweryList] = useState([]);

    let [selectedBrewery, setSelectedBrewery] = useState(null);



    const fetchBreweries = useCallback(() => {
        fetch(`https://api.openbrewerydb.org/breweries?by_state=${currentStateLocation}&per_page=300`)
            .then((response) => response.json())
            .then(setBreweryList);
    }, [currentStateLocation])

    const fetchBreweriesByCity = useCallback(() => {
        fetch(`https://api.openbrewerydb.org/breweries?by_state=${currentStateLocation}&per_page=300&by_city=${currentCityLocation}`)
            .then((response) => response.json())
            .then(setBreweryList);
    }, [currentCityLocation, currentStateLocation])



    const handleCityChange = event => {
        setCurrentCityLocation(event.target.value);
    }

    const handleStateChange = event => {
        setCurrentStateLocation(event.target.value);
    }



    useEffect(() => {
        fetchBreweriesByCity();
    }, [fetchBreweriesByCity]);


    useEffect(() => {
        fetchBreweries()
    }, [fetchBreweries])

    return (
        <div className="App">




            <div>
                <h1 className='main-header'>Welcome to Brewtastic!</h1>
                <h2>Find local breweries by city and state.</h2>
            </div>
            <div className="state-selector">

                <label className='text-thick' htmlFor="state">Please select your state: </label>
                <select className='text-thick' name="state" id="state" onChange={handleStateChange} value={currentStateLocation}>


                    <option value="Alabama">Alabama</option>
                    <option value="Alaska">Alaska</option>
                    <option value="Arizona">Arizona</option>
                    <option value="Arkansas">Arkansas</option>
                    <option value="California">California</option>
                    <option value="Colorado">Colorado</option>
                    <option value="Connecticut">Connecticut</option>
                    <option value="Delaware">Delaware</option>
                    <option value="District_Of_Columbia">District Of Columbia</option>
                    <option value="Florida">Florida</option>
                    <option value="Georgia">Georgia</option>
                    <option value="Hawaii">Hawaii</option>
                    <option value="Idaho">Idaho</option>
                    <option value="Illinois">Illinois</option>
                    <option value="Indiana">Indiana</option>
                    <option value="Iowa">Iowa</option>
                    <option value="Kansas">Kansas</option>
                    <option value="Kentucky">Kentucky</option>
                    <option value="Louisiana">Louisiana</option>
                    <option value="Maine">Maine</option>
                    <option value="Maryland">Maryland</option>
                    <option value="Massachusetts">Massachusetts</option>
                    <option value="Michigan">Michigan</option>
                    <option value="Minnesota">Minnesota</option>
                    <option value="Mississippi">Mississippi</option>
                    <option value="Missouri">Missouri</option>
                    <option value="Montana">Montana</option>
                    <option value="nebraska">nebraska</option>
                    <option value="Nevada">Nevada</option>
                    <option value="New_Hampshire">New Hampshire</option>
                    <option value="New_Jersey">New Jersey</option>
                    <option value="New_Mexico">New Mexico</option>
                    <option value="New_York">New York</option>
                    <option value="North_Carolina">North Carolina</option>
                    <option value="North_Dakota">North Dakota</option>
                    <option value="Ohio">Ohio</option>
                    <option value="Oklahoma">Oklahoma</option>
                    <option value="Oregon">Oregon</option>
                    <option value="Pennsylvania">Pennsylvania</option>
                    <option value="Rhode_Island">Rhode Island</option>
                    <option value="South_Carolina">South Carolina</option>
                    <option value="South_Dakota">South Dakota</option>
                    <option value="Tennessee">Tennessee</option>
                    <option value="Texas">Texas</option>
                    <option value="Utah">Utah</option>
                    <option value="Vermont">Vermont</option>
                    <option value="Virginia">Virginia</option>
                    <option value="Washington">Washington</option>
                    <option value="West_Virginia">West Virginia</option>
                    <option value="Wisconsin">Wisconsin</option>
                    <option value="Wyoming">Wyoming</option>

                </select>
                <form>
                    <label className='text-thick' htmlFor='city'>Narrow search by city: </label>
                    <input className='text-thick' type="text" name="city" onChange={handleCityChange} value={currentCityLocation} />

                </form>
                <p className='text-thick'>Click on a brewery card to view more information</p>
            </div>

            <div className='card-list-container'>
                <div id='card-list'>

                
                    {selectedBrewery != null ?
                    <div className='detail-container'>
                        <BreweryDetail brewery={selectedBrewery} />
                        <GoogleMap breweryLocation={selectedBrewery} />
               
                        <button onClick={() => setSelectedBrewery(null)}> Return to List</button>
                    </div> : <></>
}

                    {breweryList
                        .map(brewery => (
                            <div key={brewery.id}>
                                <BreweryCard className='brewery-card' brewery={brewery}
                                />
                                <button onClick={() => setSelectedBrewery(brewery)}>View Details</button>
                            </div>
                        ))}



                </div>
            </div>
        </div>
    );
}

export default Home;
