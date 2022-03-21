package com.example.studentManagement

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import javax.annotation.PostConstruct

@Configuration
class FirebaseInitializer {
    @Value("\${app.firebase-config}")
    lateinit var firebaseConfigFileName: String

    @PostConstruct
    fun initFirebase() {
        val options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(ClassPathResource(firebaseConfigFileName).inputStream))
            .build();
        FirebaseApp.initializeApp(options);
    }
    @Bean
    fun initFireStore(): Firestore {
        return FirestoreClient.getFirestore()
    }
}