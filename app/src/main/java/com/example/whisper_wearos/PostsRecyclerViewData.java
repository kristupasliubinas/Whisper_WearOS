package com.example.whisper_wearos;

public class PostsRecyclerViewData {

    private String userId;
    private String whisper;

    public PostsRecyclerViewData(String userId, String whisper) {
        this.userId = userId;
        this.whisper = whisper;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getWhisper() {
        return whisper;
    }

    public void setWhisper(String whisper) {
        this.whisper = whisper;
    }
}
