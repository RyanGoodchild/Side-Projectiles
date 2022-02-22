<template>
  <div>
    <div class="trackerHeading">
      <h1>Pothole Tracker Map</h1>
     
      
          </div>
    <gmap-map
      id="map"
      :center="center"
      :zoom="15"
      @click="mark"
      style="width: 90vw; height: 70vh"
    >
   
      <gmap-marker
        id="marker"
        :key="index"
        v-for="(gmp, index) in locations"
        :position="gmp"
        :clickable="true"
        @click="popupWindow"
      >
      </gmap-marker>
      <gmap-info-window
        id="popup"
        :options="{
          maxWidth: 300,
          pixelOffset: { width: 0, height: -35 },
          
        }"
        :position="popupInfo.position"
        :opened="popupInfo.open"
        @closeclick="deleteMark"
      >
        <button>
          <router-link v-bind:to="{ name: 'report' }"
            >Report Pothole</router-link
          >
        </button>
        <br />
        <br />
        <button v-on:click="deleteMark" v-on:change="deleteMark($event)">
          <router-link v-bind:to="{ name: 'home' }" />
          Cancel
        </button>

      </gmap-info-window>
    </gmap-map>
  </div>
</template>

<script>
import potholeService from "@/services/PotholeService.js";

export default {
  name: "AddGoogleMap",

  computed: {
    allPotholes(){
      return this.$store.state.locations;
    }
  },
  data() {
    return {
      currentPlace: null,
      markerCoords: {
        label: "",
        lat: 0,
        lon: 0,
      },
      center: {
        lat: 39.7837304,
        lng: -100.4458825,
      },
      locations: [],
      currentLocation: null,
      popupInfo: {
        position: { lat: 0, lng: 0 },
        open: false,
        template: "",
      },
    };
  },

  watch: {
    allPotholes(){
      this.locations.splice(0, this.locations.length)
      
      for(let location of this.$store.state.locations){
        this.locations.push(location);
      }
    }
  },

  mounted() {
    this.$store.dispatch('LOAD_MARKERS')
   
    this.geolocate();

  },


  methods: {

    geolocate: function() {
      navigator.geolocation.getCurrentPosition((position) => {
        this.center = {
          lat: position.coords.latitude,
          lng: position.coords.longitude,
        };
      });
    },
 
    
    deleteMark(event) {
      
      if (event.target.clicked) {
        this.pothole = {
          id: event.target.id,
        };
        potholeService.delete(this.pothole);
      }
      this.popupInfo.open = false;
    },

    mark(event) {
      this.markerCoords.label = "";
      this.markerCoords.lat = event.latLng.lat();
      this.markerCoords.lon = event.latLng.lng();

      this.$store.commit("UPDATE_TEMP_PIN", this.markerCoords);

      const marker = {
        lat: event.latLng.lat(),
        lng: event.latLng.lng(),
        label: "Pothole Marker",
      };

      this.$store.commit("ADD_LOCATION", marker);

    },

    popupWindow(event) {

      this.popupInfo.position = {
        lat: event.latLng.lat(),
        lng: event.latLng.lng(),
        label: "Popup Window",
      };
      this.popupInfo.template = "testPopup";
      this.popupInfo.open = true;
    },

    setPlace(place) {
      this.currentPlace = place;
    },

  
  },

};
</script>


<style scoped>
h1 {
  background-color: #b7b7b7ff;
  width: 40vh;
  border: solid #fbb958ff 10px;
  border-radius: 10px;
  outline: dashed black 10px;
  outline-offset: -10px;
  display: flex;
  justify-content: center;
}
.trackerHeading {
  display: flex;
  justify-content: center;
}

#map {

  width: 75%;
  height: 555px;
  padding: 20px;
  border-radius: 10px 40px;

margin: auto;

 border: #fbb958ff solid 10px;
  outline: dashed black 10px;
  outline-offset: -10px;
  border-radius: 20px 20px;


}

#marker {
  /* background-image: url('');
  background-size: cover;
  width: 50px;
  height: 50px;
  border-radius: 50%;
  cursor: pointer; */
}

#popup {
  /* display: flex;
  flex-direction: column;

  width: 80%; */
  background-color: blue;
}

.pac-container {
  z-index: auto;
}
</style>