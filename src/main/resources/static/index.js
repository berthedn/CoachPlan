
var currentEmail;
var currentUserId;	
var currentUserPass;

function login() {
	
	var userEmail = document.getElementById("email_field").value;
	var userPass = document.getElementById("password_field").value;
	
	console.log(userEmail + " " + userPass);
	
	currentEmail = userEmail.toString();
	
	var docRef = firebase.firestore().collection("Users").doc(currentEmail)
	
	docRef.get().then((doc) => {
		if(doc.exists) {
			console.log(doc.data());
			currentUserId = doc.data().title;
			currentUserPass = doc.data().password;
			console.log(currentUserId);
			
			if(currentUserId == 1 && currentUserPass == userPass) {
				window.alert("Signed In");
				location.replace("http://127.0.0.1:8080/athleteList");
				console.log("1");
			}else if(currentUserId == 2 && currentUserPass == userPass) {
				window.alert("Signed In");
				location.replace("http://127.0.0.1:8080/athlete");
				console.log("2");
			} else {
				window.alert("Wrong Email or Password");
				location.replace("http://127.0.0.1:8080/index");
				console.log("3");
			}
		}else {
			console.log("No such document");
		}
	}).catch(function(error) {
		console.log("Error getting document:", error);
	});
		
}

function signOut(){
    
	firebase.auth().signOut();
    alert("Signed Out");
    location.replace("http://127.0.0.1:8080/index");
}

function changePage() {
	firebase.auth().onAuthStateChanged(function(user) {
		firebase.firestore().collection('Users').get().then((snapshot) => {
			snapshot.docs.forEach(doc => {
				if(doc.id == currentEmail) {
					console.log(doc.data());
					currentUserId = doc.data().ID;
				}
			})
		})
		  
		  if (user) {
			    // User is signed in
			  
				if(currentUserId == 1) {
					location.replace("http://127.0.0.1:8080/athleteList");
					console.log("1");
				}else if(currentUserId == 2) {
					location.replace("http://127.0.0.1:8080/athlete");
					console.log("2");
				}
				
		  } else {
			    // User is signed out.
			  location.replace("http://127.0.0.1:8080/index");	
			  console.log("3");
		  }
	});
}

function signUp(){
    
    var email = document.getElementById("email_field").value;
    var password = document.getElementById("password_field").value;
    
    const promise = firebase.auth().createUserWithEmailAndPassword(email, password);
    promise.catch(e => window.alert(e.message));
    
    window.alert("Signed Up");
}

function registerCoach() {
	window.alert("New Coach Registered");
	location.replace("http://127.0.0.1:8080/index");
	console.log("done");
}

function registerAthlete() {
	window.alert("New Athlete Registered");
	location.replace("http://127.0.0.1:8080/athleteList");
	console.log("done");
}