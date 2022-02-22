<template>
  <div class="potholes">
      <div id="input-section">
          <form v-on:submit.prevent="addPothole">
              Pothole ID: <input id="pothole-id" /> 
              Latitude: <input id="latitude" />
              Longitude: <input id="longitude" />
              Severity: <input id="severity" /> 
              
              </form>
      </div>
      
        
    </div>


</template>

<script>
export default {

}
</script>

<style>

</style>