import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
import potholeService from '@/services/PotholeService';

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
    activePothole: 0,
    activeUser: 0,
    currentLat: 0.0,
    currentLon: 0.0,
    isReporting: true,
    token: currentToken || '',
    user: currentUser || {},
    locations: [],
    reportedPothole:
    {
      // Id: "",
      latitude: "",
      longitude: "",
      severity: "",
      reportDate: "",
      inspectionDate: "",
      repairDate: "",
      streetName: "",
      reportedBy: "",
    },
    potholes: [],
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
    },

    UPDATE_TEMP_PIN(state, coords) {
      state.reportedPothole.latitude = coords.lat;
      state.reportedPothole.longitude = coords.lon;

    },

    ADD_POTHOLE(state, pothole) {
      state.potholes.push(pothole)
      
    },

    ADD_LOCATION(state, coords) {
      state.locations.unshift(coords)
      
    },
    SET_LOCATION(state, coords){
      state.locations = coords;
    },

    SET_ACTIVE_POTHOLE(state, potholeID) {
      state.activePothole = potholeID;
    },

    SET_POTHOLES(state, potholes) {
      state.potholes = potholes;
    },
    DELETE_POTHOLE(state, potholeIdToDelete) {
      state.potholes = state.potholes.filter((pothole) =>
      {
          return pothole.id !== potholeIdToDelete;
      });
    },
      UPDATE_POTHOLE(state, pothole){
        for(let i in state.potholes){
          if(state.potholes[i].id === pothole.id){
            state.potholes[i] = pothole;
          }
        }
      }


    
  },
  actions: {
    LOAD_POTHOLES(context)
    {
        potholeService.list()
            .then(response =>
            {
                const potholes = response.data
                context.commit('SET_POTHOLES', potholes)

            })
    },
    LOAD_MARKERS(context){
      potholeService.listCoords()
        .then( response =>{
          const coords = response.data
          context.commit('SET_LOCATION', coords);


        })
    }
  },

  methods: {


    resetReport() {
      this.newPothole = {};
      this.isReporting = false;
    },

    addReportToList() {
      const potholeId = this.$route.params.id;
      this.newPothole.potholeId = potholeId;
      this.$store.state.potholes.unshift(this.newPothole);
      this.resetReport();
    },
  }
})
