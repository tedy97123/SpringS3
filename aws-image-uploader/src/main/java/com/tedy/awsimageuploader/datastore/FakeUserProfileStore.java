package com.tedy.awsimageuploader.datastore;

import com.tedy.awsimageuploader.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileStore {

    private  static final List<UserProfile> USER_PROFILE = new ArrayList<>();

    static {
        USER_PROFILE.add(new UserProfile(UUID.randomUUID(),  "Janet Jones",  null));
        USER_PROFILE.add(new UserProfile(UUID.randomUUID(),   "Alex Jones",   null));
    }
}
