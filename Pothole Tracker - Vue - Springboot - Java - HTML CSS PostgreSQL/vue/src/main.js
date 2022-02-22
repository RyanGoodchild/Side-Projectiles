import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'
import * as VueGoogleMaps from 'vue2-google-maps'


Vue.config.productionTip = false

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;

Vue.use(VueGoogleMaps, {
  load: {
    //fake key below
   key: "AIzaSyDyn6jnUbw9qBWVDJi4dyxYLPLE1pPBLPo",
   libraries: "places"


 
  }
});

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
