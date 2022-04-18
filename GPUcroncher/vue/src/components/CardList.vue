<template>
  <div class="container">
      <div class="cardFilters">

      </div>
      <div class="cardList">
          <div v-for="card in this.$store.state.graphicsCards"  v-bind:key="card.id">
{{ card.brand }} |
{{ card.model }}
{{ card.speed }}
{{ card.usedPrice }}
{{ card.newPrice }}
{{ card.powerUse }}
{{ card.dailyEarn }}
{{ card.dailyCost }}
{{ dailyProfit(card) }}



          </div>
      </div>
  </div>
</template>

<script>
export default {
methods: {
  dailyProfit(card) {
return card.dailyEarn - card.dailyCost;
  },
}

}
</script>

<style>

</style>