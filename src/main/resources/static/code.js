const apiUrl = "http://localhost:8090";

const studentForm = document.getElementById("student-form");
studentForm.addEventListener("submit", async (event) => {
    event.preventDefault();
    const formData = new FormData(studentForm);
    const response = await fetch(`${apiUrl}/students`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(Object.fromEntries(formData))
    });
    if (response.ok) {
        alert("Oppilas lisätty onnistuneesti!");
        studentForm.reset();
    } else {
        const data = await response.json();
        alert(`Virhe: ${data.message}`);
    }
});

const courseForm = document.getElementById("course-form");
courseForm.addEventListener("submit", async (event) => {
    event.preventDefault();
    const formData = new FormData(courseForm);
    const response = await fetch(`${apiUrl}/courses`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(Object.fromEntries(formData))
    });
    if (response.ok) {
        alert("Kurssi lisätty onnistuneesti!");
        courseForm.reset();
    } else {
        const data = await response.json();
        alert(`Virhe: ${data.message}`);
    }
});

const enrollmentForm = document.getElementById("enrollment-form");
enrollmentForm.addEventListener("submit", async (event) => {
    event.preventDefault();
    const formData = new FormData(enrollmentForm);
    const courseId = formData.get("courseId");
    const studentId = formData.get("studentId");
    const response = await fetch(`${apiUrl}/enrollments/${courseId}/students/${studentId}`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        }       
    });
    if (response.ok) {
        alert("Kurssille ilmottautuminen onnistui!");
        enrollmentForm.reset();
    } else {
        const data = await response.json();
        alert(`Virhe: ${data.message}`);
    }
});

const studentsTable = document.getElementById("students-table");

async function getStudents() {
  const response = await fetch(`${apiUrl}/students`);
  if (response.ok) {
    const students = await response.json();
    const tbody = studentsTable.querySelector("tbody");
    tbody.innerHTML = "";
    students.forEach((student) => {
      const tr = document.createElement("tr");
      const idTd = document.createElement("td");
      const nameTd = document.createElement("td");
      const emailTd = document.createElement("td");

        idTd.textContent = student.id;
      nameTd.textContent = student.name;
      emailTd.textContent = student.email;

      tr.appendChild(idTd);
      tr.appendChild(nameTd);
      tr.appendChild(emailTd);

      tbody.appendChild(tr);
    });
  } else {
    const data = await response.json();
    alert(`Virhe: ${data.message}`);
  }
}

getStudents();

const coursesTable = document.getElementById("courses-table");

async function getCourses() {
  const response = await fetch(`${apiUrl}/courses`);
  if (response.ok) {
    const courses = await response.json();
    const tbody = coursesTable.querySelector("tbody");
    tbody.innerHTML = "";
    courses.forEach((course) => {
      const tr = document.createElement("tr");
      const idTd = document.createElement("td");
      const nameTd = document.createElement("td");
      const creditsTd = document.createElement("td");
      const textTd = document.createElement("td");

      idTd.textContent = course.id;
      nameTd.textContent = course.name;
      creditsTd.textContent = course.credits;
      textTd.textContent = " op";

      tr.appendChild(idTd);
      tr.appendChild(nameTd);
      tr.appendChild(creditsTd);
      tr.appendChild(textTd);

      tbody.appendChild(tr);
    });
  } else {
    const data = await response.json();
    alert(`Virhe: ${data.message}`);
  }
}

getCourses();

const enrollmentsTable = document.getElementById("enrollments-table");

async function getEnrollments() {
  const response = await fetch(`${apiUrl}/enrollments`);
  if (response.ok) {
    const enrollments = await response.json();
    const tbody = enrollmentsTable.querySelector("tbody");
    tbody.innerHTML = "";
    const courses = {};
    enrollments.forEach((enrollment) => {
      const courseId = enrollment.course.id;
      const courseName = enrollment.course.name;
      const studentName = enrollment.student.name;
      if (courseId in courses) {
        courses[courseId].students.push(studentName);
      } else {
        courses[courseId] = {
          name: courseName,
          students: [studentName],
        };
      }
    });
    Object.values(courses).forEach((course) => {
      const tr = document.createElement("tr");
      const nameTd = document.createElement("td");
      const studentsTd = document.createElement("td");
      nameTd.textContent = course.name;
      studentsTd.textContent = course.students.join(", ");
      tr.appendChild(nameTd);
      tr.appendChild(studentsTd);
      tbody.appendChild(tr);
    });
  } else {
    const data = await response.json();
    alert(`Error: ${data.message}`);
  }
}

getEnrollments();