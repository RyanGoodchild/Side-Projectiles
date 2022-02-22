<template>
  <div id="reportForm" v-show="$store.state.isReporting === true">
    <h2>Pothole Report Form</h2>
    <br />

    <form v-on:submit="addPothole">
      <div class="container">
        <div class="locationItems">
          <label>Latitude: </label>
          <input disabled v-model="newPothole.latitude" /><br />
          <label>Longitude: </label>
          <input disabled v-model="newPothole.longitude" /><br />
          <label for="street">Street Name: </label>
          <input
            name="street"
            placeholder="Street Name"
            type="text"
            maxlength="50"
            minlength="2"
            required
            v-model="newPothole.streetName"
          />
        </div>
        <div class="dateItems">
          <label>Report Date:</label>
          <input disabled v-model="todaysDate" /><br />
          <label>Date of Inspection</label>
          <input disabled />
          <br />
          <label>Date of Repair</label>
          <input disabled />
        </div>
        <div class="severityItems">
          <div class="slidecontainer">
            <label for="severity">Severity? (Left is low)</label>
            <br />
            <input
              class="slider"
              id="severity"
              name="severity"
              value="3"
              type="range"
              required
              max="5"
              min="1"
              v-model="newPothole.severity"
            />
          </div>

          <br />

          <button>Submit Report</button>
        </div>
      </div>
    </form>
  </div>
</template>

<script>
import potholeService from "@/services/PotholeService.js";

export default {
  computed: {
    returnLat() {
      return this.$store.state.reportedPothole.latitude;
    },
    returnLon() {
      return this.$store.state.reportedPothole.longitude;
    },
    todaysDate() {
      var today = new Date();
      var dd = String(today.getDate()).padStart(2, "0");
      var mm = String(today.getMonth() + 1).padStart(2, "0"); //January is 0!
      var yyyy = today.getFullYear();

      today = yyyy + "-" + mm + "-" + dd;
      return today;
    },
  },
  data() {
    return {
      newPothole: {
        latitude: this.$store.state.reportedPothole.latitude,
        longitude: this.$store.state.reportedPothole.longitude,
        severity: "3",
        reportDate: "",
        inspectionDate: "",
        repairDate: "",
        streetName: "",
        reportedBy: this.$store.state.user.id,
      },
    };
  },
  methods: {
    addPothole() {
      this.newPothole.reportDate = this.todaysDate;

      potholeService.create(this.newPothole);
      this.$store.commit("ADD_POTHOLE", this.newPothole);

      this.$router.push({ path: "/" });
      window.location.reload();

      //blanks out newPothole for next user to input data
      this.newPothole = {};
    },
  },
};
</script>


<style scoped>
.severityItems {
  grid-area: severity;
  display: flex;
  flex-direction: column;
  padding-top: 50px;
  /* border: solid black 5px; */
  width: 80%;
  margin: auto;
  align-items: center;
}
.dateItems {
  display: flex;
  grid-area: dateItems;

  flex-direction: column;
  /* border: solid black 5px; */
  /* width: 80%; */
  justify-content: center;
  align-self: center;
  align-items: center;
  margin: auto;
}
.locationItems {
  margin: auto;
  display: flex;
  grid-area: locationItems;

  flex-direction: column;
  /* align-self: center; */
  /* border: solid black 5px; */
}

.container {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-rows: auto;
  grid-template-areas:
    "locationItems dateItems"
    "severity severity";
}

div #reportForm {
  background-color: rgb(183, 183, 183);
  display: flex;
  flex-direction: column;
  align-items: center;

  border: rgb(251, 185, 88) solid 10px;
  outline: dashed black 10px;
  outline-offset: -10px;
  width: 50%;
  padding-bottom: 40px;
  border-radius: 40px 40px;
}

form {
  display: flex;
  flex-direction: column;

  width: 70%;
}

/* CUSTOM SLIDER BELOW HERE */

input[type="range"].slider {
  width: 100%;
  margin: 5.85px 0;
  background-color: transparent;
  -webkit-appearance: none;
}
input[type="range"].slider:focus {
  outline: none;
}
input[type="range"].slider::-webkit-slider-runnable-track {
  background: #2f740f;
  border: 1.1px solid #18d501;
  border-radius: 1px;
  width: 100%;
  height: 11.3px;
  cursor: pointer;
}
input[type="range"].slider::-webkit-slider-thumb {
  margin-top: -6.95px;
  width: 23px;
  height: 23px;
  background: #fbb958;
  border: 2.5px solid #b7b7b7;
  border-radius: 12px;
  cursor: pointer;
  -webkit-appearance: none;
}
input[type="range"].slider:focus::-webkit-slider-runnable-track {
  background: #368611;
}
input[type="range"].slider::-moz-range-track {
  background: #2f740f;
  border: 1.1px solid #18d501;
  border-radius: 1px;
  width: 100%;
  height: 11.3px;
  cursor: pointer;
}
input[type="range"].slider::-moz-range-thumb {
  width: 23px;
  height: 23px;
  background: #fbb958;
  border: 2.5px solid #b7b7b7;
  border-radius: 12px;
  cursor: pointer;
}
input[type="range"].slider::-ms-track {
  background: transparent;
  border-color: transparent;
  border-width: 8.45px 0;
  color: transparent;
  width: 100%;
  height: 11.3px;
  cursor: pointer;
}
input[type="range"].slider::-ms-fill-lower {
  background: #28620d;
  border: 1.1px solid #18d501;
  border-radius: 2px;
}
input[type="range"].slider::-ms-fill-upper {
  background: #2f740f;
  border: 1.1px solid #18d501;
  border-radius: 2px;
}
input[type="range"].slider::-ms-thumb {
  width: 23px;
  height: 23px;
  background: #fbb958;
  border: 2.5px solid #b7b7b7;
  border-radius: 12px;
  cursor: pointer;
  margin-top: 0px;
}

input[type="range"].slider:focus::-ms-fill-lower {
  background: #2f740f;
}
input[type="range"].slider:focus::-ms-fill-upper {
  background: #368611;
}

/*TODO: Use one of the selectors from https://stackoverflow.com/a/20541859/7077589 and figure out
how to remove the virtical space around the range input in IE*/
@supports (-ms-ime-align: auto) {
  /* Pre-Chromium Edge only styles, selector taken from hhttps://stackoverflow.com/a/32202953/7077589 */
  input[type="range"].slider {
    margin: 0;
    /*Edge starts the margin from the thumb, not the track as other browsers do*/
  }
}
</style>