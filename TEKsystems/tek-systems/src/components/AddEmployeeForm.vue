<template>
  <div class="addEmpForm" v-if="this.newEmployee == 'Yes'">
    <form v-on:submit.prevent="addEmployee">
      <p class="styledHeader"><strong>Add New Employee</strong></p>

      <div class="formInfoTop">
        <!-- FIRST NAME SECTION -->
        <div class="formUnit">
          <label v-bind:class="{ asterisk: missingInfo }" for="firstName"
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
              v-model="employee.firstName"
            />
            <label v-show="missingInfo == true" class="required" for="firstName"
              ><strong>required</strong></label
            >
          </div>
        </div>

        <!-- MIDDLE INITIAL SECTION -->
        <div class="formUnit">
          <label for="middleInitial"><strong>Middle Initial</strong></label>
          &nbsp;&nbsp;
          <div class="form-field">
            <input
              type="text"
              id="middleInitial"
              name="middleInitial"
              size="1"
              v-model="employee.middleInitial"
            />
          </div>
        </div>

        <!-- LAST NAME SECTION -->
        <div class="formUnit">
          <label v-bind:class="{ asterisk: missingInfo }" for="lastName"
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
              v-model="employee.lastName"
            />
            <label v-show="missingInfo == true" class="required" for="lastName"
              ><strong>required</strong></label
            >
          </div>
        </div>
      </div>

      <div class="formInfoBottom">
        <!-- GENDER SECTION -->
        <div class="formUnit" id="genderForm">
          <label v-bind:class="{ asterisk: missingInfo }" for="gender"
            ><strong>Gender</strong></label
          >
          &nbsp;&nbsp;
          <div class="form-field">
            <select
              v-model="employee.gender"
              name="gender"
              id="gender"
              required="true"
            >
              <option></option>
              <option value="Male">Male</option>
              <option value="Female">Female</option>
              <option value="Other">Other</option>
            </select>
            <label v-show="missingInfo == true" class="required" for="gender"
              ><strong>required</strong></label
            >
          </div>
        </div>

        <!-- EMAIL SECTION -->
        <div class="formUnit" id="emailForm">
          <label v-bind:class="{ asterisk: missingInfo }" for="email"
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
              v-model="employee.email"
            />
            <label v-show="missingInfo == true" class="required" for="email"
              ><strong>required</strong></label
            >
          </div>
        </div>
      </div>

      <div class="formButtons">
        <button v-on:click="clearFields" type="cancel">Cancel</button>
        <button v-on:click="(missingInfo = true), addEmployee" type="submit">
          Save Data
        </button>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      missingInfo: false,
      newEmployee: "Yes",

      employee: {
        employeeID: this.$store.state.employees.length + 1,
        firstName: "",
        middleInitial: "",
        lastName: "",
        gender: "",
        email: "",
      },
    };
  },
  methods: {
    addEmployee() {
      //   this.targetEmployee.employeeID = this.$state.store.employees.length + 1;

      this.$store.commit("ADD_EMPLOYEE", this.employee);

      this.employee = {
        employeeID: this.$store.state.employees.length + 1,
        firstName: "",
        middleInitial: "",
        lastName: "",
        gender: "",
        email: "",
      };
      this.missingInfo = false;
    },
    clearFields() {
      this.employee.employeeID = "";
      this.employee.firstName = "";
      this.employee.middleInitial = "";
      this.employee.lastName = "";
      this.employee.gender = "";
      this.employee.email = "";
    },
  },
};
</script>

<style>
</style>