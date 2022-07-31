import './App.css';
import Home from './components/Home';
import React from 'react';
import image from "./images/beerbg.jpg";


function App() {




  return (
    // <div className="App">
    <div className="App" style={{
      backgroundImage: `url(${image})`,
      backgroundRepeat: "no-repeat",
      backgroundAttachment: 'fixed',
      // height: '100vh',
   
      backgroundSize: 'cover',
    }}>


      <Home />
    </div>
    // </div>

  );
}

export default App;
