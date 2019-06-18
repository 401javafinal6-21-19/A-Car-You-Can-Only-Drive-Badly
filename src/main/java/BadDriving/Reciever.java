package BadDriving;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;

import javax.annotation.Nullable;


public class Reciever {
    Firestore db;
    String direction;

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
