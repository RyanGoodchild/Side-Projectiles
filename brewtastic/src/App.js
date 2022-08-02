import './App.css';
import Home from './components/Home';
import React from 'react';
import image from "./images/beerbg.jpg";


function App() {




  return (
    <div className="App" style={{
      backgroundImage: `url(${image})`,
      backgroundRepeat: "no-repeat",
      backgroundAttachment: 'fixed',   
      backgroundSize: 'cover',
    }}>

      <Home />
    </div>
  

  );
}

export default App;
