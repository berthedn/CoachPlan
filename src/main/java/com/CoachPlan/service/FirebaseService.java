package com.CoachPlan.service;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.CoachPlan.dto.IData;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseService {
	
	public String saveUserDetails(IData user) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("Users").document(user.getEmail()).set(user);
		return collectionApiFuture.get().getUpdateTime().toString();
	}
	
	public IData getUserDetails(String email) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection("Users").document(email);
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		
		DocumentSnapshot document = future.get();
		
		IData user = null;
		
		
		//surround instead with a try catch block instead? Remove if(document.exists)
		if(document.exists()) {
			user = document.toObject(IData.class);
			return user;
		} else {
			return null;
		}		
	}
	
	//we should also write a getUserWorkoutDetails() to fetch workouts from database
}
