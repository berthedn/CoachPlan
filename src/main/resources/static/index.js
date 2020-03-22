// Your web app's Firebase configuration
var firebaseConfig = {
	apiKey: "AIzaSyAi82LSIrKJhE-Hi2lDij_ATDq5yD52mIk",
	authDomain: "localhost",
	databaseURL: "https://coachplan-bcb7e.firebaseio.com",
	projectId: "coachplan-bcb7e",
	storageBucket: "coachplan-bcb7e.appspot.com",
	messagingSenderId: "975486007303",
	appId: "1:975486007303:web:208eae0def4e2fad1ed2a2",
	measurementId: "G-ZBG24TF978"
};
	  
// Initialize Firebase
firebase.initializeApp(firebaseConfig);

var currentEmail;
var currentUserId;

function login() {
	
	var userEmail = document.getElementById("email_field").value;
	var userPass = document.getElementById("password_field").value;
		
	firebase.auth().signInWithEmailAndPassword(userEmail, userPass).catch(function(error) {
		  // Handle Errors here.
		  var errorCode = error.code;
		  var errorMessage = error.message;
		  
		  window.alert("Error: " + errorMessage);
		});
	
	window.alert("Signed in");
	currentEmail = userEmail;
	changePage();
	
}

function signOut(){
    
	firebase.auth().signOut();
    alert("Signed Out");
    changePage();
}

function changePage() {
	firebase.auth().onAuthStateChanged(function(user) {
		  console.log(user);
		  
		  firebase.firestore().collection('Users').get().then((snapshot) => {
				snapshot.docs.forEach(doc => {
					if(doc.id == currentEmail) {
						currentUserId = doc.data().ID;
					}
				})
			})
		  
		  if (user) {
			    // User is signed in
				if(currentUserId == 1) {
					location.replace("http://127.0.0.1:8080/athleteList");
				}else if(currentUserId == 2) {
					location.replace("http://127.0.0.1:8080/athlete");
				}
				
		  } else {
			    // User is signed out.
			  location.replace("http://127.0.0.1:8080/index");	
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
