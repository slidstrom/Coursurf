class Course {
	subject
	courseId
	courseName
	newAssignments
	grade
	constructor(subject, courseId, courseName, newAssignments, grade) {
		this.subject = subject
		this.courseId = courseId
		this.courseName = courseName
		this.newAssignments = newAssignments
		this.grade = grade
	}
}

// DYNAMIC CODE BELOW

/*
create a <script> tag on the server
the first line must be
	var courses = new Array()

add a courses.push for each course you want to add, filling in each field with values from the database
courses.push(
	new Course(
		"Math",
		1,
		"Pre-Algebra",
		2,
		80
	)
)

demo below
*/

var courses = new Array()

courses.push(
	new Course(
		"Math",
		1,
		"Pre-Algebra",
		2,
		80
	)
)

courses.push(
	new Course("Math", 2, "Algebra I", 5, 75)
)

courses.push(
	new Course("English", 3, "Intro to Shakespeare", 1, 90)
)

courses.push(
	new Course("English", 4, "Composition and Rhetoric", 0, 100)
)

// END DYNAMIC CODE

// run onload so that courses can be defined in a script tag anywhere in the document


onload = function() {
	
	var subjectNames = new Array()
	var subjects = new Array()
	for (c of courses) {
		// group elements by subject
		// check if this index already exists
		if ( subjects[c.subject] == undefined ) {
			subjects[c.subject] = new Array()
			subjectNames.push(c.subject)
		}
		subjects[c.subject].push(c)
	}
	
	// create sections
	for (s of subjectNames) {
		var subjectHeader = document.createElement("h3")
		subjectHeader.className = "subjectHeader"
		subjectHeader.textContent = s
		
		var subjectContainer = document.createElement("div")
		subjectContainer.className = "subjectContainer"
		subjectContainer.id = s
		
		// append to document
		var main = document.getElementsByTagName("main")[0]
		main.appendChild(subjectHeader)
		main.appendChild(subjectContainer)
	}
	
	// populate sections
	for (subjectName of subjectNames) {
		// iterate through subjects
		for ( c of subjects[subjectName] ) {
			// iterate through courses
			// create element
			// must use cloneNode(true) to copy all children
			var course = document.getElementById("courseTemplate").cloneNode(true)
			// change ID
			course.id = "course" + c.courseId
			// set link to course
			course.href = "course.html"
			// set course name
			course.getElementsByClassName("courseTitle")[0].textContent = c.courseName
			// set number of new assignments
			var newAssignmentsMessage
			switch (c.newAssignments) {
				case 0:
					newAssignmentsMessage = "No New Assignments"
					break
				case 1:
					newAssignmentsMessage = c.newAssignments + " New Assignment"
					break
				default:
					newAssignmentsMessage = c.newAssignments + " New Assignments"
			}
			
			course.getElementsByClassName("courseNewAssignments")[0].textContent = newAssignmentsMessage
			course.getElementsByClassName("grade")[0].textContent = c.grade + "%"
			// append to document
			document.getElementById(c.subject).appendChild(course)
		}
	}
}