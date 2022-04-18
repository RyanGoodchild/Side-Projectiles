import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if (currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    graphicsCards: [
      {
        id: 1,
        brand: 'AMD',
        model: 'RX 5500 XT',
        speed: 27.65,
        usedPrice: 250.00,
        newPrice: 345.00,
        powerUse: 65,
        dailyCost: 0.16,
        dailyEarn: 1.08,
        // dailyProfit: this.dailyEarn - this.dailyCost,
      },
      {
        id: 2,
        brand: 'AMD',
        model: 'RX 5500 XT',
        speed: 27.65,
        usedPrice: 250.00,
        newPrice: 345.00,
        powerUse: 65,
        dailyCost: 0.15,
        dailyEarn: 1.08,
        // dailyProfit: this.dailyEarn - this.dailyCost,
      },
      {
        id: 3,
        brand: 'AMD',
        model: 'RX 5500 XT',
        speed: 27.65,
        usedPrice: 250.00,
        newPrice: 345.00,
        powerUse: 65,
        dailyCost: 0.15,
        dailyEarn: 1.08,
        // dailyProfit: this.dailyEarn - this.dailyCost,
      },
    ],
  },

  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user', JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    }
  }
})
