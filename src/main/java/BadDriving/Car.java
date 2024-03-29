package BadDriving;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;

import javax.annotation.Nullable;
import java.io.FileInputStream;
import java.io.IOException;


public class Car {


    /**
     * variable used to represent firebasefirestore database
     */
    Firestore db;

    /**
     * variable used to represent the stringified JSON Object coming from the android controller telling the car which direction to go
     */
    String direction;

    Steering steering;

    /**
     * the method on Receiver which connects with firebase, accesses the firestore database and finds the correct Project, locates the necessary collection and document, and listens on that document for changes.
     * When changes are heard, it gets the new value of direction off the document car in firebase, and sets that to the String direction in this app.
     */
    public void getDB() throws IOException {
        //get instance of firebase firestore database from the project a-car-you-can-only-drive-badly

        String credentialsUrl = System.getenv("GOOGLE_APPLICATION_CREDENTIALS");

        FileInputStream serviceAccount = new FileInputStream(credentialsUrl);

        steering = new Steering();


        FirestoreOptions firestoreOptions = FirestoreOptions
                                                .getDefaultInstance()
                                                .toBuilder()
                                                .setProjectId("a-car-you-can-only-drive-badly")
                                                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                                                .build();

        System.out.println("firestoreOptions on line 34 of the Car" + firestoreOptions);
        //set the db to the instance from the previous line
        db = firestoreOptions.getService();
        System.out.println("firestore database on line 37 of the Car" + db);
        //create a listener on the car document in the driving collection in the firebase firestore a-car-you-can-only-drive-badly
        db.collection("driving").document("car").addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            //on a change in that document...
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirestoreException error) {
                //...set the json object direction to a string and assign it to the direction variable in this app
                direction = value.get("direction").toString();
                System.out.println("Value in Car at 45 " + value.get("direction"));



                steering.steeringButtonDepressed(direction);


            }
        });
    }
}

