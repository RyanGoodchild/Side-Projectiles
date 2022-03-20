<template>
  <div class="pageContainer">
    <div class="heading">
      <h2>Employee Information</h2>
    </div>

    <div class="newOldChooser">
      <form id="newChecker">
        <p><strong>Is New Employee?</strong></p>
        <div class="options">
          <input
            type="radio"
            id="newEmpYes"
            name="newOldPicker"
            value="Yes"
            checked="true"
            v-model="newEmployee"
          />
          <label for="newEmpYes">Yes</label>
          <input
            v-model="newEmployee"
            type="radio"
            id="newEmpNo"
            name="newOldPicker"
            value="No"
            
          />
          <label for="newEmpNo">No</label>
        </div>
      </form>
    </div>

    <add-employee-form v-if="this.newEmployee == 'Yes'" />
    <employee-table  v-if="this.newEmployee == 'No'" />
  </div>
</template>

<script>
import AddEmployeeForm from "./AddEmployeeForm.vue";
import EmployeeTable from "./EmployeeTable.vue";

export default {
  components: { AddEmployeeForm, EmployeeTable },
  data() {
    return {
      
      missingInfo: false,
      newEmployee: "Yes",
    };
  },
  methods: {
    
  },
};
</script>

<style>
.pageContainer {
  display: flex;
  flex-direction: column;
}

#newChecker {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  margin-left: 10%;
}
.options {
  margin-bottom: 20px;
}

.pageContainer {
  border: 2px solid black;
  margin: 5%;
}

.addEmpForm {
  border: 2px solid rgb(110, 178, 233);
  /* width: 60%; */
  display: flex;
  flex-direction: column;
  margin-left: 10%;
  margin-right: 10%;
  margin-bottom: 5%;
}
.styledHeader {
  color: rgb(110, 178, 233);
  display: flex;
  align-self: flex-start;
  margin-left: 3%;
}

button {
  background-color:rgb(110, 178, 233);
  border-radius: 5px;
  color: white;
  padding-left: 10px;
  padding-right: 10px;
  padding-top: 5px;
  padding-bottom: 5px;
}

.asterisk:after {
  content: " *";
  color: red;
}

.form-field {
  display: flex;
  flex-direction: column;
}

.formUnit {
  display: flex;
}

.formInfoBottom {
  display: flex;
  /* flex-wrap: nowrap; */
  max-width: 90%;
  justify-content: space-between;
  margin: auto;
  
}
.formInfoTop {
  display: flex;
  /* flex-wrap: nowrap; */
  max-width: 90%;
  justify-content: space-between;
  margin: auto;
  padding-bottom: 3%;
  padding-top: 2%;
}

/* 
.formInfoTop.form-unit {

    margin-left: 50px;
} */

.formButtons {
  display: flex;
  justify-content: flex-end;
  margin: 3%;
}
.formButtons button {
  margin-left: 10px;
}

/* select {
  width: 300%;
} */

label.required {
  color: red;
  align-self: flex-end;
  font-size: 10px;
}

/* TABLE FORMATTING BELOW */
th {
    /* background-color: rgb(100, 189, 219); */
    background-color:rgb(110, 178, 233);
    border: darkblue solid 2px;
    color: white;
    font-size: 80%;
    font-weight: 100;
    padding: 5px;
    padding-left: 50px;
    padding-right: 50px;
}

td {
     border: darkblue solid 2px;
}

table {
    margin: auto;
    margin-bottom: 5%;
}

</style>