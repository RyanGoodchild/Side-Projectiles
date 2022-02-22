<template>
  <div id="reportForm">
      <router-link>Back to Map</router-link>
      <h2>Edit A Pothole</h2><br/>

      <form v-on:submit.prevent="updatePothole" >
          <label >Latitude: </label>
          <input disabled v-model="pothole.latitude" /><br/>
          <label>Longitude: </label>
          <input disabled v-model="pothole.longitude" /><br/>
          <label> Severity? (Left is low)</label>
            <input
                id="severity"
                name="severity"
                value="3"
                type="range"
                required
                max="5"
                min="1"
                v-model="newPothole.severity"
            />
          
      </form>
  </div>

</template>

<script>
export default {
    computed: {
        created(){

        const activePotholeID = this.$route.params.id;
        return this.$store.commit("SET_ACTIVE_POTHOLE", activePotholeID)

        },
        pothole(){
            return this.$store.state.potholes.find((p) => {
                return p.id == this.$store.state.activePothole
            })
        }
    }
}
</script>

<style>

</style>