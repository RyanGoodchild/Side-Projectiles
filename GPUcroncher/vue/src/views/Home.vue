<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <CardList/>
  </div>
</template>

<script>
import CardList from '../components/CardList.vue';
export default {
  components: { CardList },
  name: "home"
};
</script>
