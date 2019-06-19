package BadDriving;

import com.google.cloud.firestore.*;

import javax.annotation.Nullable;


public class Car {


    /**
     * variable used to represent firebasefirestore database
     */
    Firestore db;

    /**
     * variable used to represent the stringified JSON Object coming from the android controller telling the car which direction to go
     */
    String direction;

    /**
     * the method on Receiver which connects with firebase, accesses the firestore database and finds the correct Project, locates the necessary collection and document, and listens on that document for changes.
     * When changes are heard, it gets the new value of direction off the document car in firebase, and sets that to the String direction in this app.
     */
    public void getDB() {
        //get instance of firebase firestore database from the project a-car-you-can-only-drive-badly
        FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder().setProjectId("a-car-you-can-only-drive-badly").build();
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
                System.out.println("Value in Car at 45" + value.get("direction"));

                Steering steering = new Steering();

                steering.steeringButtonDepressed(direction);
                steering.steeringButtonReleased(direction);

            }
        });
    }
}

