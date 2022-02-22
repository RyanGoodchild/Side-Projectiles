<template>
  <div class="CalendarContainer">
    <h2 v-if="$store.state.user.authorities[0] == 'ROLE_ADMIN'">Please select pothole to modify</h2>
    <ul id="scheduleForm">
      <li v-for="pothole in this.$store.state.potholes" v-bind:key="pothole.id">
        <img id="conebullet" src="../assets/conebullet.png" />

        <label>
          <input v-show="$store.state.user.authorities[0].name === 'ROLE_ADMIN'"
            type="checkbox"
            :value="pothole"
            v-model="selectedPotholes"
            v-on:change="startingSeverity"
          />
        
          Severity: {{ pothole.severity }} || Report Date:
         {{ pothole.reportDate }}
          || Inspection Date: {{ pothole.inspectionDate }}
          || Repair Date: {{ pothole.repairDate }}
          || Street Name: {{ pothole.streetName }} || Reported By:
          {{ pothole.reportedBy }}
        </label>
        <img id="conebullet" src="../assets/conebullet.png" />
      </li>
    </ul>
<div  v-on:click="modifyShow = true" v-if="$store.state.user.authorities[0].name === 'ROLE_ADMIN'" v-show="this.selectedPotholes.length > 0">
    <button class="modifyPothole" v-on:click="modifyShow = true" v-if="$store.state.user.authorities[0].name === 'ROLE_ADMIN'" v-show="this.selectedPotholes.length > 0">
      Modify Pothole
    </button>
    <br />
    <div v-show="modifyShow" id="modifyForm">
      <div class="modify">
      <div id="inspection">
        <label for="inspectCalender"> Inspection Date: </label>
        <Datepicker
          name="inspectCalender"
          placeholder="Select Inspection Date"
          v-model="form.inspectionDate" >
        </Datepicker>
      </div>

      <br />
      <div id="repair">
        <label for="repairCalender"> Repair Date: </label>
        <Datepicker
          id="datepicker"
          name="repairCalender"
          placeholder="Select Repair Date"
          v-model="form.repairDate">
        </Datepicker>
      </div>

      <div class="slidecontainer">
          <label id="sevlab" for="severity" v-show=true>{{form.severity}}</label>
          <br>
          <input
          class="slider"
            id="severity"
            name="severity"
            value=""
            type="range"
            required
            max="5"
            min="1"
            v-model="form.severity"
       
          />
         
      </div>


<div class="botbuttons">
      <button
        class="updatePothole"
        v-on:click="updatePothole"
        
      >
        Update Pothole
      </button>
      <button
        class="deletePothole"
        v-on:click="deletePothole"
        
      >
        Delete Pothole
      </button>
      </div>
      </div>
    </div>
  </div>
  </div>
</template>

<script>
import Datepicker from "vuejs-datepicker";
import potholeService from "@/services/PotholeService.js";

export default {
  computed:{

    chosenInspectionDate() {
      var inspection = new Date(this.form.inspectionDate);
      var dd = String(inspection.getDate()).padStart(2, "0");
      var mm = String(inspection.getMonth() + 1).padStart(2, "0"); //January is 0!
      var yyyy = inspection.getFullYear();


      inspection = yyyy + '-' + mm + '-' + dd;
       return inspection
    },
    chosenRepairDate() {
      var repair = new Date(this.form.repairDate);
      var dd = String(repair.getDate()).padStart(2, "0");
      var mm = String(repair.getMonth() + 1).padStart(2, "0"); //January is 0!
      var yyyy = repair.getFullYear();

      repair = yyyy + '-' + mm + '-' + dd;
      return repair
    },
  },
  data() {
    return {
      form :{
        inspectionDate:'',
        repairDate:'',
        severity: "3"
      },

      checkAll: false,
      modifyShow: false,
      potholes: "",
      selectedPotholes: [],
      pothole: {
        latitude: this.$store.state.latitude,
        longitude: this.$store.state.longitude,
        severity: this.$store.state.severity,
        reportDate: this.$store.state.reportDate,
        inspectionDate: "",
        repairDate: "",
        streetName: this.$store.state.streetName,
        reportedBy: this.$store.state.user.id,
      },
      sliderValue: ""
    };
  },
  name: "schedule-pothole",
  components: {
    Datepicker,
  },

  methods: {


    startingSeverity() {
      for (let i in this.selectedPotholes) {
        this.form.severity =  this.selectedPotholes[i].severity;
      }

    },

  
   

    deletePothole() {
      for (let i in this.selectedPotholes) {
        potholeService
          .delete(this.selectedPotholes[i].id)
          .then((response) => {
            if (response.status === 200) {
              alert("pothole deleted successfully");
              this.$store.commit("DELETE_POTHOLE", this.selectedPotholes[i].id);
            }
          })
          .catch((error) => {
            if (error.response) {
              this.errorMsg =
                "Error deleting board. Response received was '" +
                error.response.statusText +
                "'.";
            } else if (error.request) {
              this.errorMsg =
                "Error deleting board. Server could not be reached.";
            } else {
              this.errorMsg =
                "Error deleting board. Request could not be created.";
            }
          });
      }
    },

    updatePothole() {
    for (let i in this.selectedPotholes) {
        this.selectedPotholes[i].repairDate = this.chosenRepairDate;
        this.selectedPotholes[i].inspectionDate = this.chosenInspectionDate;

        this.selectedPotholes[i].severity = this.form.severity
      
      potholeService
            .update(this.selectedPotholes[i])
            .then(response => {
              if(response.status === 200 ) {
                alert("pothole updated successfully")
                this.$store.commit("UPDATE_POTHOLE", this.selectedPotholes[i])

              }
              })
              .catch((error) => {
        if (error.response) {
          this.errorMsg =
            "Error updating pothole. Response received was '" +
            error.response.statusText +
            "'.";
        } else if (error.request) {
          this.errorMsg =
            "Error updating pothole. Server could not be reached.";
        } else {
          this.errorMsg =
            "Error updating pothole. Request could not be created.";
        } 
      });
    }
    },
  },
  created() {
    this.$store.dispatch("LOAD_POTHOLES");
    this.startingSeverity;
  },
  
};
</script>

<style >

#sevlab{
  font-size: 50px;
  font-weight: bold;

  
}

.slidecontainer {
  margin: 35px;
  width: 200px;
}

div.CalendarContainer {
  width: 90%;
  display: flex;
  flex-direction: column;
  align-items: center;
}
#scheduleForm {

  list-style: none;
}

#conebullet {
  width: 40px;
  margin-right: 45px;
  margin-left: 45px;
}

#datepicker {
  display: flex;
}
.modify {
  display: flex;
  flex-direction: column;
  align-items: center;
}

li {
  font-size: 22px;
  font-weight: bold;
  
}


input[type=range].slider {
  width: 100%;
  margin: 5.85px 0;
  background-color: transparent;
  -webkit-appearance: none;
  
}
input[type=range].slider:focus {
  outline: none;
}
input[type=range].slider::-webkit-slider-runnable-track {
  background: #2f740f;
  border: 1.1px solid #18d501;
  border-radius: 1px;
  width: 100%;
  height: 11.3px;
  cursor: pointer;
}
input[type=range].slider::-webkit-slider-thumb {
  margin-top: -6.95px;
  width: 23px;
  height: 23px;
  background: #fbb958;
  border: 2.5px solid #b7b7b7;
  border-radius: 12px;
  cursor: pointer;
  -webkit-appearance: none;
}
input[type=range].slider:focus::-webkit-slider-runnable-track {
  background: #368611;
}
input[type=range].slider::-moz-range-track {
  background: #2f740f;
  border: 1.1px solid #18d501;
  border-radius: 1px;
  width: 100%;
  height: 11.3px;
  cursor: pointer;
}
input[type=range].slider::-moz-range-thumb {
  width: 23px;
  height: 23px;
  background: #fbb958;
  border: 2.5px solid #b7b7b7;
  border-radius: 12px;
  cursor: pointer;
}
input[type=range].slider::-ms-track {
  background: transparent;
  border-color: transparent;
  border-width: 8.45px 0;
  color: transparent;
  width: 100%;
  height: 11.3px;
  cursor: pointer;
}
input[type=range].slider::-ms-fill-lower {
  background: #28620d;
  border: 1.1px solid #18d501;
  border-radius: 2px;
}
input[type=range].slider::-ms-fill-upper {
  background: #2f740f;
  border: 1.1px solid #18d501;
  border-radius: 2px;
}
input[type=range].slider::-ms-thumb {
  width: 23px;
  height: 23px;
  background: #fbb958;
  border: 2.5px solid #b7b7b7;
  border-radius: 12px;
  cursor: pointer;
  margin-top: 0px;
  /*Needed to keep the Edge thumb centred*/
}
input[type=range].slider:focus::-ms-fill-lower {
  background: #2f740f;
}
input[type=range].slider:focus::-ms-fill-upper {
  background: #368611;
}
/*TODO: Use one of the selectors from https://stackoverflow.com/a/20541859/7077589 and figure out
how to remove the virtical space around the range input in IE*/
@supports (-ms-ime-align:auto) {
  /* Pre-Chromium Edge only styles, selector taken from hhttps://stackoverflow.com/a/32202953/7077589 */
  input[type=range].slider {
    margin: 0;
    /*Edge starts the margin from the thumb, not the track as other browsers do*/
  }
}

</style>
