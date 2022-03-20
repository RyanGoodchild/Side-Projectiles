import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {

    employees: [
       {
        employeeID: "1",
        firstName: "Jane",
        middleInitial: "G",
        lastName: "Doe",
        gender: "Female",
        email: "janed@gmail.com",
      
      },
       {
        employeeID: "2",
        firstName: "John",
        middleInitial: "H",
        lastName: "Doe",
        gender: "Male",
        email: "johnd@gmail.com",
      },
    ],
 
  },
  getters: {
  },
  mutations: {
    ADD_EMPLOYEE(state, employee) {
      state.employees.push(employee)
    },
    UPDATE_EMPLOYEE(state, targetEmployee) {
      state.employees.forEach((employee) => {
        if (employee.employeeID == targetEmployee.employeeID) {
          employee.employeeID = targetEmployee.employeeID;
          employee.firstName = targetEmployee.firstName;
          employee.middleInitial = targetEmployee.middleInitial;
          employee.lastName = targetEmployee.lastName;
          employee.gender = targetEmployee.gender;
          employee.email = targetEmployee.email;
        }
      });
    }
  },
  actions: {
  },
  modules: {
  }
})
