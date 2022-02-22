<template>
  <div class="home">
    <!-- <h1>Home</h1> -->
    <!-- <p>You must be authenticated to see this</p> -->
    <AddGoogleMap />
 
  </div>
</template>

<script>
import AddGoogleMap from "../components/AddGoogleMap.vue";

export default {
  name: "home",
  components: {
    AddGoogleMap,
   
  }
};
</script>

<style  scoped>
div.report {
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>