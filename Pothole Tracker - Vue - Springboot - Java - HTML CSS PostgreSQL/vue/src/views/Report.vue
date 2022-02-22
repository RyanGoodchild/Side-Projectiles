<template>
  <div class="report">
    <h1>File a Report</h1>
    <pothole-report />
  </div>
</template>

<script>
import PotholeReport from "../components/PotholeReport.vue";

export default {
  name: "report",
  components: {
    PotholeReport,
  },
};
</script>

<style scoped>
div.report {
  display: flex;
  flex-direction: column;
  align-items: center;
}

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

</style>
