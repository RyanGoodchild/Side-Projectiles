import React from 'react'
import { GoogleMap, LoadScript, Marker } from '@react-google-maps/api';

function MyComponent( brewery ) {

const containerStyle = {
  width: '400px',
  height: '400px'
};


let lattt = brewery.breweryLocation.latitude;
let longgg = brewery.breweryLocation.longitude;
console.log(brewery.breweryLocation.latitude);
console.log(brewery.breweryLocation.longitude);
console.log(lattt);
console.log(longgg);


  const center = {
    lat: (Number(lattt)),
    lng: (Number(longgg))
  };
 
  
//   const marker = {
//     LatLng: {center}
//   }
  
//   const marker = {
    
//     // The below line is equivalent to writing:
//     // position: new google.maps.LatLng(-34.397, 150.644)
//     position: { lat: (Number(lattt)), lng: (Number(longgg)) },
  
//   };

  return (
    <LoadScript
      googleMapsApiKey="AIzaSyCjb3CIvPRzLkjZGsUsAyvaows91mYO8bo"
    >
      <GoogleMap
        mapContainerStyle={containerStyle}
        center={center}
        zoom={16}
        
      >
        { /* Child components, such as markers, info windows, etc. */ }
        <></>
      </GoogleMap>
    </LoadScript>
  )
}

export default React.memo(MyComponent)