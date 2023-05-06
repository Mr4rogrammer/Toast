package com.mrprogrammer.Utils.Interface;

import com.google.firebase.auth.FirebaseUser;

public interface LoginCompleteHandler {
    void onSuccess(FirebaseUser Message);
    void onFailure(String e);
}
