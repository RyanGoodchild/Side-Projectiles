<template>
  <div class="aboutus">
    <div class="biocontainer"><img
        class="biopic"
        id="rypic"
        src="../assets/ddheadshot.jpg"
        alt="Daniel's picture"
      />
      <h2>Daniel Diaz</h2>
      <a href="http://www.linkedin.com/in/daniel-diaz1569">
        <img class="linkedin" src="../assets/Linkedinlogo.png" alt="LinkedIn" />
      </a>
      <div class="paracont">
        <p>
          A former Operations Manager turned Software Developer, Daniel’s thirst for knowledge 
          started at a young age. His innate curiosity would lead him to take things apart and 
          figure out how to put them back together. This fostered a problem solving mindset which 
          would continue to grow through experience and inevitable challenges. It comes as no surprise 
          that he later discovered his passion for programming. Eager to utilize the skills set 
          he has developed, he took the initiative to enroll in Tech Elevator. There he was able to 
          use his skills to learn a full stack of programming languages and tools. With this newfound 
          knowledge and the collaboration of a wonderful group of talented developers, the team was 
          able to create the Alley Road Pothole Tracker.
        </p>
      </div></div>
    <div class="biocontainer"><img
        class="biopic"
        id="levipic"
        src="../assets/lwheadshot.jpg"
        alt="Levi's picture"
      />
      <h2>Levi Wolfe</h2>
      <a href="http://www.linkedin.com/in/levi-wolfe">
        <img class="linkedin" src="../assets/Linkedinlogo.png" alt="LinkedIn" />
      </a>
      <div class="paracont">
        <p>
          Levi is a chemical engineer by degree but his passion for computer programming brought him to Tech Elevator! 
          Tech Elevator has helped Levi hone his skills in a whole suite of computer languages and tech frameworks. 
          When Levi is not programming he is most likely at the gym, 
          attending concerts with friends or hanging out with his wife, Meredith and dog, Olaf. After Tech Elevator, 
          Levi will be joining Dick’s Sporting Goods as a Site Reliability Engineer to further grow his automation and 
          operations expertise in the field of Information Technology!
        </p>
      </div></div>
    <div class="biocontainer">
      <img
        class="biopic"
        id="rypic"
        src="../assets/rgheadshot.jpg"
        alt="Ryan's picture"
      />
      <h2>Ryan Goodchild</h2>
      <a href="http://www.linkedin.com/in/rygood">
        <img class="linkedin" src="../assets/Linkedinlogo.png" alt="LinkedIn" />
      </a>
      <div class="paracont">
        <p>
          Ryan is an enthusiastic learner who is constantly investigating his
          curiosities. Initially studying psychology allowed him to better
          understand human behavior and ultimately better understand himself.
          This lead to a desire to help people through medical cannabis and
          ultimately developing a top tier training program to increase his
          outreach by replicating best practices into teams of individuals who demonstrate a patient centered
          approach. The desire to continue to learn and have a hand in creating
          our future has lead Ryan to pursue software development. While
          interested in many avenues of coding, ultimately he wants to design VR
          experiences to effectively treat PTSD.
        </p>
      </div>
    </div>
    <div class="biocontainer"><img
        class="biopic"
        id="brockpic"
        src="../assets/bpheadshot.jpg"
        alt="Brock's picture"
      />
      <h2>Brock Porzio</h2>
      <a href="http://www.linkedin.com/in/bporzio">
        <img class="linkedin" src="../assets/Linkedinlogo.png" alt="LinkedIn" />
      </a>
      <div class="paracont">
        
        <p>
            Brock is a focused and determined individual. Brock enjoys many things in life such as exploring nature and investing relationally with friends and family. At the beginning of his career endeavors he sought and obtained a professional status as a service technician in the highly skilled and highly demanding industry of HVAC. This career enabled the use and growth of many skills. Brock much like everyone else in the world has felt the effects of the COVID 19 pandemic. He used this opportunity to take a step back and rethink what he wants out of life as well as what he wants for his career moving forward. Brock has always had a fascination with the world of technology and believes that it can be used as a positive tool to make big change in the world. Brock is now a web developer and looks forward to growing and learning in an ever changing industry.
        </p>
      </div></div>
  </div>
</template>

<script>
export default {
  name: "AboutUs",
};
</script>

<style  scoped>
.aboutus {
  display: flex;
  /* flex-direction: column; */
  /* align-items: center; */
}

.biocontainer {
  border-radius: 10px 40px;

  height: 75vh;
  width: 22%;

  margin: 3%;
  background-color: #b7b7b7ff;
  border: #fbb958ff solid 10px;
  outline: dashed black 10px;
  outline-offset: -10px;
  border-radius: 20px 20px;

  display: flex;
  flex-direction: column;
  align-items: center;
}

.biopic {
  display: block;

  border-radius: 30%;

  max-width: 80%;
  max-height: 30%;

  width: auto;
  height: auto;

  margin-top: 8%;
  /* margin-bottom: 8%; */
}

.linkedin {
  max-width: 20%;
}
div.paracont {
    margin: 10px;
    /* text-align: left; */
}


p {
  font-size: 0.75vw;
}
.brockpara {
    font-size: 0.6vw;
}
</style>