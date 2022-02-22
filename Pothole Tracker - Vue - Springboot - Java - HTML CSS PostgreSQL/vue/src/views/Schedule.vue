<template>
<div class="holder">
    
    <div class="schedule">
        <h1>Inspect A Pothole and Schedule Repair Date</h1>
        <schedule-pothole/>
    </div> 
</div>
</template>

<script>
import SchedulePothole from '../components/SchedulePothole.vue'

export default {
    name: "schedule",
    components: { 
        SchedulePothole,
    },

};
</script>

<style scoped>

div.schedule {
  display: flex;
  flex-direction: column;
  align-items: center;
}
/* 
h1 {
    
  border: solid #fbb958ff 5px;
  outline: dashed black 5px;
  outline-offset: -5px;
  border-radius: 10px;
 width: 60vh;

  background-color: #b7b7b7ff;
} */

.holder {
    display: flex;
    justify-content: center;
 
    
}

.schedule {
      border: solid #fbb958ff 10px;
  outline: dashed black 10px;
  outline-offset: -10px;
  border-radius: 10px;
 width: 80vw;

  background-color: #b7b7b7ff;
  padding-bottom: 50px;
  margin-top: 100px;

display: flex;
/* align-self: center; */
/* align-items: center; */
/* align-content: center; */
}

</style>