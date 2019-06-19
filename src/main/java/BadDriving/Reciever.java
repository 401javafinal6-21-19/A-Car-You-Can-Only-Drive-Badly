package BadDriving;
import com.google.cloud.firestore.*;

import javax.annotation.Nullable;


public class Reciever {

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
     * When changes are heard, it gets the new value of direction off the document car in firebase, and sets that to the String direction in this app
     */
    public void getDB() {
    FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder().setProjectId("a-car-you-can-only-drive-badly").build();
    db = firestoreOptions.getService();
    db.collection("driving").document("car").addSnapshotListener(new EventListener<DocumentSnapshot>() {
        @Override
        public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirestoreException error) {
            direction = value.get("direction").toString();
            System.out.println(value.get("direction"));
        }
    });

}

}
