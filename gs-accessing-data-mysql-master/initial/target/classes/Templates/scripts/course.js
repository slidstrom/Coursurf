class Course {
	constructor(subject, courseId, courseName, newAssignments, grade) {
		this.subject = subject
		this.courseId = courseId
		this.courseName = courseName
		this.newAssignments = newAssignments
		this.grade = grade
	}
}

class Module {
	constructor(unit, id, number, type, name, moduleStatus) {
		this.unit = unit
		this.id = id
		this.number = number
		this.type = type
		this.name = name
		this.moduleStatus = moduleStatus
	}
}

// DYNAMIC CODE BELOW

/*
create a <script> tag on the server
the first line must be
	var modules = new Array()

add a modules.push for each module you want to add, filling in each field with values from the database
modules.push(
	new Module(
		"Unit 1: Properties of Operations",
		1,
		"1.1",
		"Video",
		"What is Algebra?",
		"Watched"
	)
)

demo below
*/

var modules = new Array()

var courseName = "Pre-Algebra"

modules.push(
	new Module(
		"Unit 1: Properties of Operations",
		1,
		"1.1",
		"Video",
		"What is Algebra?",
		"Watched"
	)
)

modules.push(
	new Module(
		"Unit 1: Properties of Operations",
		2,
		"1.2",
		"Lesson",
		"Properties of Addition",
		"Read"
	)
)

modules.push(
	new Module(
		"Unit 1: Properties of Operations",
		3,
		"1.3",
		"Practice",
		"Properties of Addition",
		"Submitted"
	)
)

modules.push(
	new Module(
		"Unit 1: Properties of Operations",
		4,
		"1.4",
		"Homework",
		"Properties of Addition",
		"Graded"
	)
)

modules.push(
	new Module(
		"Unit 2: Equations",
		5,
		"2.1",
		"Video",
		"What are Equations?",
		"Unwatched"
	)
)

// END DYNAMIC CODE

// run onload so that courses can be defined in a script tag anywhere in the document


onload = function() {
	
	// update page title
	document.head.title = courseName
	
	// update course name
	document.getElementById("courseName").textContent = courseName
	
	var unitNames = new Array()
	var units = new Array()
	for (m of modules) {
		// group modules by unit
		// check if this index already exists
		if ( units[m.unit] == undefined ) {
			units[m.unit] = new Array()
			unitNames.push(m.unit)
		}
		units[m.unit].push(m)
	}
	
	// create units
	for (u of unitNames) {
		var unitHeader = document.createElement("h3")
		unitHeader.className = "unitHeader"
		unitHeader.textContent = u
		
		var unit = document.createElement("div")
		unit.className = "unit"
		unit.id = u
		
		// append to document
		var main = document.getElementsByTagName("main")[0]
		main.appendChild(unitHeader)
		main.appendChild(unit)
	}
	
	// populate units
	for (unitName of unitNames) {
		// iterate through subjects
		for ( m of units[unitName] ) {
			// iterate through courses
			// create element
			// must use cloneNode(true) to copy all children
			var module = document.getElementById("moduleTemplate").cloneNode(true)
			// change ID
			module.id = "course" + m.id
			// set link to module
			module.href = "#"
			// set module name
			module.getElementsByClassName("moduleName")[0].textContent = 
				m.number +
				" " +
				m.type +
				": " +
				m.name
			// set module status
			module.getElementsByClassName("moduleStatus")[0].textContent = m.moduleStatus
			
			// append to document
			document.getElementById(m.unit).appendChild(module)
		}
	}
}