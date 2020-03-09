package com.CoachPlan.service;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.CoachPlan.dto.UserDTO;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseService {
	public String saveUserDeatails(UserDTO user) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("users").document(user.getName()).set(user);
		return collectionApiFuture.get().getUpdateTime().toString();
	}

}
