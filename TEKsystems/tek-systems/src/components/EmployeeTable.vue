<template>
  <div v-bind:class=" {bigContainer: myModal}">
    <div>
      <table>
        <thead>
          <tr>
            <th>Employee ID</th>
            <th>Employee Name</th>
            <th>Email ID</th>
          </tr>
        </thead>
        <tbody>
          <!-- <tr v-for="employee in this.$store.state.employees"       :key="employee.employeeID"        > -->
          <tr
            v-for="(employee, index) in this.$store.state.employees"
            :key="index"
          >
            <td class="idLink" @click="openModal" value="employee">
              {{ employee.employeeID }}
            </td>
            <td value="employee">
              {{ employee.firstName }} {{ employee.middleInitial }}
              {{ employee.lastName }}
            </td>
            <td value="employee">{{ employee.email }}</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div v-if="myModal">
      <transition name="modal">
        <div class="modal-cover">
          <div class="modal-wrapper">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <div class="modal-body">
                    <div class="form-group, addEmpForm">
                      <form v-on:submit.prevent="updateEmployee">
                        <p class="styledHeader">
                          <strong>Employee ID: {{ targetEmployeeId }} </strong>
                        </p>

                        <div class="formInfoTop">
                          <!-- FIRST NAME SECTION -->
                          <div class="formUnit">
                            <label
                              v-bind:class="{ asterisk: missingInfo }"
                              for="firstName"
                              ><strong>First Name</strong></label
                            >
                            &nbsp;&nbsp;
                            <div class="form-field">
                              <input
                                type="text"
                                id="firstName"
                                required="true"
                                name="firstName"
                                size="15"
                                v-model="targetEmployee.firstName"
                              />
                              <label
                                v-show="missingInfo == true"
                                class="required"
                                for="firstName"
                                ><strong>required</strong></label
                              >
                            </div>
                          </div>

                          <!-- MIDDLE INITIAL SECTION -->
                          <div class="formUnit">
                            <label for="middleInitial"
                              ><strong>Middle Initial</strong></label
                            >
                            &nbsp;&nbsp;
                            <div class="form-field">
                              <input
                                type="text"
                                id="middleInitial"
                                name="middleInitial"
                                size="1"
                                v-model="targetEmployee.middleInitial"
                              />
                            </div>
                          </div>

                          <!-- LAST NAME SECTION -->
                          <div class="formUnit">
                            <label
                              v-bind:class="{ asterisk: missingInfo }"
                              for="lastName"
                              ><strong>Last Name</strong></label
                            >

                            &nbsp;&nbsp;
                            <div class="form-field">
                              <input
                                type="text"
                                id="lastName"
                                required="true"
                                name="lastName"
                                size="25"
                                v-model="targetEmployee.lastName"
                              />
                              <label
                                v-show="missingInfo == true"
                                class="required"
                                for="lastName"
                                ><strong>required</strong></label
                              >
                            </div>
                          </div>
                        </div>

                        <div class="formInfoBottom">
                          <!-- GENDER SECTION -->
                          <div class="formUnit" id="genderForm">
                            <label
                              v-bind:class="{ asterisk: missingInfo }"
                              for="gender"
                              ><strong>Gender</strong></label
                            >
                            &nbsp;&nbsp;
                            <div class="form-field">
                              <select
                                v-model="targetEmployee.gender"
                                name="gender"
                                id="gender"
                                required="true"
                              >
                                <option></option>
                                <option value="Male">Male</option>
                                <option value="Female">Female</option>
                                <option value="Other">Other</option>
                              </select>
                              <label
                                v-show="missingInfo == true"
                                class="required"
                                for="gender"
                                ><strong>required</strong></label
                              >
                            </div>
                          </div>

                          <!-- EMAIL SECTION -->
                          <div class="formUnit" id="emailForm">
                            <label
                              v-bind:class="{ asterisk: missingInfo }"
                              for="email"
                              ><strong>Email</strong></label
                            >
                            &nbsp;&nbsp;
                            <div class="form-field">
                              <input
                                type="email"
                                id="email"
                                name="email"
                                size="25"
                                required="true"
                                v-model="targetEmployee.email"
                              />
                              <label
                                v-show="missingInfo == true"
                                class="required"
                                for="email"
                                ><strong>required</strong></label
                              >
                            </div>
                          </div>
                        </div>

                        <div class="formButtons">
                          <button
                            @click="myModal = false"
                            type="button"
                            class="close"
                          >
                            <span aria-hidden="true">Cancel</span>
                          </button>

                          <button
                            v-on:click="(missingInfo = true), updateEmployee"
                            type="submit"
                          >
                            Update
                          </button>

                          
                        </div>
                      </form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </transition>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      empCount: this.$store.state.employees.length,
      missingInfo: false,
      myModal: false,
      actionButton: "Update Data",
      targetEmployeeId: "",
      employeeIds: [],
      targetEmployee: {
        employeeID: "",
        firstName: "base value test",
        middleInitial: "",
        lastName: "",
        gender: "",
        email: "",
      },
      employee: {
        employeeID: "",
        firstName: "",
        middleInitial: "",
        lastName: "",
        gender: "",
        email: "",
      },
    };
  },
  methods: {
    openModal(event) {
      //SET ID to find the correct employee
      this.targetEmployeeId = event.target.innerText;

      this.$store.state.employees.forEach((employee) => {
        if (employee.employeeID == this.targetEmployeeId) {
          this.targetEmployee.employeeID = employee.employeeID;
          this.targetEmployee.firstName = employee.firstName;
          this.targetEmployee.middleInitial = employee.middleInitial;
          this.targetEmployee.lastName = employee.lastName;
          this.targetEmployee.gender = employee.gender;
          this.targetEmployee.email = employee.email;
        }
      });

      this.myModal = true;
    },

    updateEmployee() {

        this.$store.commit('UPDATE_EMPLOYEE', this.targetEmployee)

     
      this.myModal = false;
    },
 
  },
};
</script>

<style scoped>

form-group {
display: flex;
}



.idLink {
color: rgb(110, 178, 233);
text-decoration: underline;
}


.bigContainer{
    position: fixed;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    background-color: rgba(0, 0, 0, 0.3);
    display: flex;
    justify-content: center;
    align-items: center;
  }

.modal-body {
 
  vertical-align: middle;


  z-index: 1;
  margin: 15% auto;
  padding: 20px;
  width: 80%;
 

background-color: white;
  position: fixed; 
  z-index: 1; 
  left: 0;
  top: 0;
  width: 100%; 
  overflow: auto; 

}

</style>