package com.CoachPlan.service;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.CoachPlan.dto.CoachDTO;
import com.CoachPlan.dto.IData;
import com.CoachPlan.dto.StudentDTO;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.Query.Direction;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseService {
	
	public String saveUserDetails(IData user) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("Users").document(user.getEmail()).set(user);
		return collectionApiFuture.get().getUpdateTime().toString();
	}
	
	public String getNextId() throws InterruptedException, ExecutionException {
		String maxValue = "0";
		String nextId;
		
		CollectionReference collectionRef = FirestoreClient.getFirestore().collection("Users");
		Query query = collectionRef.orderBy("coachID", Direction.DESCENDING).limit(1);
		ApiFuture<QuerySnapshot> future = query.get();
		
		for (DocumentSnapshot document : future.get().getDocuments()) {
			maxValue = document.getString("coachID");
		}
		
		int change = Integer.parseInt(maxValue);
		change += 1;
		nextId = Integer.toString(change);
		
		return nextId;
		
	}
	
	public String getUserId(String email) throws InterruptedException, ExecutionException {
		String sessionId = "";
		
		CollectionReference collectionRef = FirestoreClient.getFirestore().collection("Users");
		Query query = collectionRef.whereEqualTo("email", email);
		ApiFuture<QuerySnapshot> future = query.get();
		
		for (DocumentSnapshot document : future.get().getDocuments()) {
			sessionId = document.getString("coachID");
		}
		
		return sessionId;
	}
	
	public String getUserName(String email) throws InterruptedException, ExecutionException {
		String sessionName = "";
		
		CollectionReference collectionRef = FirestoreClient.getFirestore().collection("Users");
		Query query = collectionRef.whereEqualTo("email", email);
		ApiFuture<QuerySnapshot> future = query.get();
		
		for (DocumentSnapshot document : future.get().getDocuments()) {
			sessionName = document.getString("userName");
		}
		
		return sessionName;
	}
	
	public CoachDTO getCoach(String sessionName, String sessionId) throws InterruptedException, ExecutionException {
		String title = "";
		String email = "";
		String userName = "";
		String password = "";
		String coachId = "";
		
		CollectionReference collectionRef = FirestoreClient.getFirestore().collection("Users");
		Query query = collectionRef.whereEqualTo("userName", sessionName).whereEqualTo("coachID", sessionId);
		ApiFuture<QuerySnapshot> future = query.get();
		
		for (DocumentSnapshot document : future.get().getDocuments()) {
			title = document.getString("title");
			email = document.getString("email");
			userName = document.getString("userName");
			password = document.getString("password");
			coachId = document.getString("coachID");
		}
		
		CoachDTO currentUser = new CoachDTO(title, email, userName, password, coachId);
		
		return currentUser;
	}
	
	public ArrayList<StudentDTO> getStudentList(String sessionId) throws InterruptedException, ExecutionException {
		ArrayList<StudentDTO> studentList = new ArrayList<StudentDTO>();
		
		String title = "";
		String email = "";
		String userName = "";
		String password = "";
		String coachId = "";
		
		CollectionReference collectionRef = FirestoreClient.getFirestore().collection("Users");
		Query query = collectionRef.whereEqualTo("title", "2").whereEqualTo("coachID", sessionId);
		ApiFuture<QuerySnapshot> future = query.get();
		
		for (DocumentSnapshot document : future.get().getDocuments()) {
			title = document.getString("title");
			email = document.getString("email");
			userName = document.getString("userName");
			password = document.getString("password");
			coachId = document.getString("coachID");
			
			StudentDTO student = new StudentDTO(title, email, userName, password, coachId);
			
			studentList.add(student);
			
		}
		
		return studentList;
	}
	
	public IData getUserDetails(String email) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection("Users").document(email);
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		
		DocumentSnapshot document = future.get();
		
		IData user = null;
		
		
		if(document.exists()) {
			user = document.toObject(IData.class);
			return user;
		} else {
			return null;
		}		
	}
	
	//we should also write a getUserWorkoutDetails() to fetch workouts from database
}
