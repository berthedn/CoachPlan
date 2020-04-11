
var currentEmail;
var currentUserId;	
var currentUserPass;
var userName;
var reference;

var userEmail;
var userPass;

function login() {
	
	userEmail = document.getElementById("email_field").value;
	userPass = document.getElementById("password_field").value;
	
	console.log(userEmail + " " + userPass);
	
	currentEmail = userEmail.toString();
	
	var docRef = firebase.firestore().collection("Users").doc(currentEmail);

	docRef.get().then((doc) => {
		if(doc.exists) {
			console.log(doc.data());
			currentUserId = doc.data().title;
			currentUserPass = doc.data().password;
			userName = doc.data().userName;
			console.log(currentUserId);
			
			//put needed variables in local storage
			localStorage.setItem("name",userName);
			localStorage.setItem("pass", currentUserPass);
			localStorage.setItem("email", currentEmail);
			
			if(currentUserId == 1 && currentUserPass == userPass) {
				//window.alert("Signed In");
				location.replace("http://127.0.0.1:8080/athleteList");
				console.log("1");
			}else if(currentUserId == 2 && currentUserPass == userPass) {
				//window.alert("Signed In");
				location.replace("http://127.0.0.1:8080/athlete");
				//addWorkout();
				console.log("2");
			} else {
				window.alert("Wrong Email or Password");
				location.replace("http://127.0.0.1:8080/index#");
				console.log("3");
			}
		}else {
			console.log("No such document");
		}
	}).catch(function(error) {
		console.log("Error getting document:", error);
	});
		
}

function addWorkout() {
	
	//setTimeout(() => {
		var name = localStorage.getItem("name");
		var pass = localStorage.getItem("pass");
		var email = localStorage.getItem("email");
		
		var athleteID = name + " " + pass;
		console.log(athleteID);
		
		var docRef = firebase.firestore().collection("Workouts").doc(email);
		
		docRef.get().then((doc) => {
			if(doc.exists) {
				console.log(doc.data());
				console.log(doc.data().monday);
				document.getElementById("monday").innerHTML = doc.data().monday;
				document.getElementById("tuesday").innerHTML = doc.data().tuesday;
				document.getElementById("wednesday").innerHTML = doc.data().wednesday;
				document.getElementById("thursday").innerHTML = doc.data().thursday;
				document.getElementById("friday").innerHTML = doc.data().friday;
				document.getElementById("saturday").innerHTML = doc.data().saturday;
				document.getElementById("sunday").innerHTML = doc.data().sunday;
			}else {
				console.log("No such document");
			}
		}).catch(function(error) {
			console.log("Error getting document:", error);
		});
	//}, 5000);
}

function signOut(){
    
	firebase.auth().signOut();
    alert("Signed Out");
    location.replace("http://127.0.0.1:8080/index");
}

function registerCoach() {
	window.alert("New Coach Registered");
	location.replace("http://127.0.0.1:8080/index#");
	console.log("done");
}

function registerAthlete() {
	window.alert("New Athlete Registered");
	location.replace("http://127.0.0.1:8080/athleteList");
	console.log("done");
}