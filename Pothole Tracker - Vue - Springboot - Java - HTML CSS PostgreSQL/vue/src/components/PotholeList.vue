<template>
<div>
    <ul>
        <li v-for="pothole in this.$store.state.potholes" v-bind:key="pothole.id">
          <input type="checkbox" :id="potholeSelect" :value="pothole" v-model="selectedPotholes" v-on:click="setId" 
          @change="handlePotholes(pothole)">
          <label for="potholeSelect">           
            {{ pothole.id }}
            {{ pothole.latitude }}
            {{ pothole.longitude }}
            {{ pothole.severity }}
            {{ pothole.reportDate }}
            {{ pothole.inspectionDate }}
            {{ pothole.repairDate }}
            {{ pothole.streetName }}
            {{ pothole.reportedBy }}
           </label>
        </li>
    </ul>


</div>
</template>

<script>

import potholeService from "../services/PotholeService"
export default {

    name: "pothole-list",
    

    created() {
      this.$store.dispatch('LOAD_POTHOLES')
        
    },
    methods: {
      deletePothole(){
        potholeService.delete(this.id)
        this.$store.commit('DELETE_POTHOLE', this.id)
      },
      setId() {
          this.id = this.pothole.id;
      }
    }
  }

</script>

<style>

</style>