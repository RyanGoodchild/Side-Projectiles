import React from 'react'
import { GoogleMap, LoadScript, Marker } from '@react-google-maps/api';

function MyComponent( brewery ) {

const containerStyle = {
  width: '400px',
  height: '400px'
};


let lattt = brewery.breweryLocation.latitude;
let longgg = brewery.breweryLocation.longitude;


  const center = {
    lat: (Number(lattt)),
    lng: (Number(longgg))
  };
 
  const z = (Number(3));
  const visible = true;

  return (
    <LoadScript
      googleMapsApiKey="AIzaSyCjb3CIvPRzLkjZGsUsAyvaows91mYO8bo"
    >
      <GoogleMap
      id='details-right'
        mapContainerStyle={containerStyle}
        center={center}
        zoom={16}
        
      >
        <Marker
        position={center}
        zIndex={z}
        visible={visible}
        />
        <></>
      </GoogleMap>
    </LoadScript>
  )
}

export default React.memo(MyComponent)
