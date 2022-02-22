<template>
  <div id="app">
    <div id="nav">
     
      <img id="headerLogo" src="./assets/alleyroad.png" alt=" Missing Header Logo"/>
   <!-- google test here -->
<!-- <input class="searchbar" id="autocomplete" placeholder="Enter a place" type="text" /> -->
 
   <!-- google test here -->
      <!-- <input
        id="searchbar"
        type="search"
        name="searchWord"
        placeholder="Enter a street here to search"
      /> -->

<div class="spacer">&nbsp;</div>
      <div id="buttons">
        <button>
          <!-- <img class="coneback" src="https://media.istockphoto.com/photos/barrel-traffic-barrier-picture-id182243296?k=20&m=182243296&s=612x612&w=0&h=d7f6-N-jZjwI27jnRLCTT1qXuGIe_Dyt0tRljkGKsOc=" alt=""> -->
          <router-link v-bind:to="{ name: 'home' }">Home</router-link>
          
        </button>

        <!-- <button>
          <router-link v-bind:to="{ name: 'report' }"
            >Report Pothole</router-link>
        </button> -->

        <button id="viewbutton">
          <!-- <img class="coneback" src="https://media.istockphoto.com/photos/barrel-traffic-barrier-picture-id182243296?k=20&m=182243296&s=612x612&w=0&h=d7f6-N-jZjwI27jnRLCTT1qXuGIe_Dyt0tRljkGKsOc=" alt=""> -->
          <router-link v-bind:to="{ name: 'schedule' }">View Potholes</router-link>
        </button>

        <button id="aboutusbutton">
          <!-- <img class="coneback" src="https://media.istockphoto.com/photos/barrel-traffic-barrier-picture-id182243296?k=20&m=182243296&s=612x612&w=0&h=d7f6-N-jZjwI27jnRLCTT1qXuGIe_Dyt0tRljkGKsOc=" alt=""> -->
          <router-link v-bind:to="{ name: 'aboutus' }">About Us</router-link>
        </button>

          <button v-if="$store.state.token == ''">
          <!-- <img class="coneback" src="https://media.istockphoto.com/photos/barrel-traffic-barrier-picture-id182243296?k=20&m=182243296&s=612x612&w=0&h=d7f6-N-jZjwI27jnRLCTT1qXuGIe_Dyt0tRljkGKsOc=" alt=""> -->
          <router-link
            v-bind:to="{ name: 'login' }"
            v-if="$store.state.token == ''"
            >Login</router-link
          >
        </button>

        <button v-if="$store.state.token != ''">
          <!-- <img class="coneback" src="https://media.istockphoto.com/photos/barrel-traffic-barrier-picture-id182243296?k=20&m=182243296&s=612x612&w=0&h=d7f6-N-jZjwI27jnRLCTT1qXuGIe_Dyt0tRljkGKsOc=" alt=""> -->
          <router-link
            v-bind:to="{ name: 'logout' }"
            v-if="$store.state.token != ''"
            >Logout</router-link
          >
        </button>
      </div>
    </div>
    
    <router-view />
    <!-- <AddGoogleMap /> -->
  </div>

  
</template>

<script>
// import AddGoogleMap from "./components/AddGoogleMap";
//  let autocomplete: 
//  function initAutocomplete() {
//    autocomplete = new google.maps.places.Autocomplete(
//    document.getElementById('autocomplete'),
//    {
//      types: ['establishment'],
//      componentRestrictions: {'country': ['AU']},
//      fields: ['place_id', 'geometry', 'name']
//    });
//    }
 
export default {
  name: 'App',
  // components: {
  //   AddGoogleMap
  // }
}
</script>
 
<style>

#headerLogo{
  max-height: 65px;
 
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #000000;
  margin-top: 50px;
}
#nav {
  background-color: rgb(47, 116, 15) ;
  height: 75px;
  display: flex;
  justify-content: center;
  align-items: center;
 border-radius: 30px;
  
}
a{
  color: black ;
  font-size: 16px;

}

#nav button {
  margin: 10px 10px;
  padding: 5px;
  margin-right: 50px;
border-radius: 5px;

align-items: center;

 height: 55px;

  border: solid #fbb958ff 5px;
  outline: dashed black 5px;
  outline-offset: -5px;
  border-radius: 10px;
  display: flex;
  background-color: #b7b7b7ff;
 
 /* justify-content: center; */
}

/* h2 {
  background-color: #b7b7b7ff;
  width: 40vh;



/* The below needs to be fixed - not connecting with pic */
/* img.coneback {
 max-width: 20px;
} */

#buttons {
  display: flex;
  }

.viewbutton {
  display: flex;

}

.searchbar {
  width: 35%;
  height: 60%;
  margin-right: 100px;
  margin-left: 100px;
  flex-basis: 50%;
  border-radius: 20px;
}

.spacer {
  flex-grow: 2;
}


body {
  /* background-image:  url('https://i2-prod.birminghammail.co.uk/incoming/article21701666.ece/ALTERNATES/s810/0_pots-of-cash-ca-473578.jpg'); */
  background-image: url('./assets/alleyroad.png') ;
  

  background-attachment: fixed;
  background-size: 70%;
  background-position: center;
  background-repeat:no-repeat;
  
}

</style>
