<template>
  <div id="app">
  
    <employee-register/>
  </div>
</template>

<script>
import EmployeeRegister from './components/EmployeeRegister.vue'


export default {
  name: 'App',
  components: {
  
    EmployeeRegister
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
