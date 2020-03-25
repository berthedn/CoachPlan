
var currentEmail;
var currentUserId;	 

/*firebase.auth().onAuthStateChanged(function(user) {
	console.log(user);
})*/

function login() {
	
	var userEmail = document.getElementById("email_field").value;
	var userPass = document.getElementById("password_field").value;
	
	console.log(userEmail + " " + userPass);
	
	window.alert("Signed In");
	currentEmail = userEmail.toString();
	//changePage();
	
	/*firebase.firestore().collection('Users').get().then((snapshot) => {
		snapshot.docs.forEach(doc => {
			console.log(doc.data());
			if(doc.id == currentEmail) {
				console.log(doc.data());
				currentUserId = doc.data().ID;
			}
		})
	})*/
	
	var docRef = firebase.firestore().collection("Users").doc(currentEmail)
	
	docRef.get().then(function(doc){
		if(doc.exists) {
			console.log(doc.data());
			currentUserId = doc.data().ID;
			console.log(currentUserId);
			
			if(currentUserId == 1) {
				location.replace("http://127.0.0.1:8080/athleteList");
				console.log("1");
			}else if(currentUserId == 2) {
				location.replace("http://127.0.0.1:8080/athlete");
				console.log("2");
			} else {
				location.replace("http://127.0.0.1:8080/index");	
				console.log("3");
			}
		}else {
			console.log("No such document");
		}
	}).catch(function(error) {
		console.log("Error getting document:", error);
	});
	
		
	firebase.auth().signInWithEmailAndPassword(userEmail, userPass).catch(function(error) {
		  // Handle Errors here.
		  var errorCode = error.code;
		  var errorMessage = error.message;
		  // ...
		  
		  window.alert("Error: " + errorMessage);
		});
	
		/*window.alert("Signed In");
		currentEmail = userEmail.toString();
		changePage();*/
		
}

function signOut(){
    
	firebase.auth().signOut();
    alert("Signed Out");
    location.replace("http://127.0.0.1:8080/index");
    //changePage();
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
