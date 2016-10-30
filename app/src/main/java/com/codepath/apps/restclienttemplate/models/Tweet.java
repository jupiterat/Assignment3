package com.codepath.apps.restclienttemplate.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Tweet implements Parcelable {
    public static final Creator<Tweet> CREATOR = new Creator<Tweet>() {
        @Override
        public Tweet createFromParcel(Parcel source) {
            Tweet var = new Tweet();
            var.id_str = source.readString();
            var.created_at = source.readString();
            var.favorite_count = source.readInt();
            var.id = source.readLong();
            var.text = source.readString();
            var.retweet_count = source.readInt();
            var.favorited = source.readByte() != 0;
            var.retweeted = source.readByte() != 0;
            return var;
        }

        @Override
        public Tweet[] newArray(int size) {
            return new Tweet[size];
        }
    };
    private String id_str;
    private String created_at;
    private int favorite_count;
    private long id;
    private String text;
    private int retweet_count;
    private boolean favorited;
    private boolean retweeted;

    public User getUser() {
        return user;
    }

    private User user;

    public String getId_str() {
        return this.id_str;
    }

    public void setId_str(String id_str) {
        this.id_str = id_str;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getFavorite_count() {
        return this.favorite_count;
    }

    public void setFavorite_count(int favorite_count) {
        this.favorite_count = favorite_count;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRetweet_count() {
        return this.retweet_count;
    }

    public void setRetweet_count(int retweet_count) {
        this.retweet_count = retweet_count;
    }

    public boolean getFavorited() {
        return this.favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public boolean getRetweeted() {
        return this.retweeted;
    }

    public void setRetweeted(boolean retweeted) {
        this.retweeted = retweeted;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id_str);
        dest.writeString(this.created_at);
        dest.writeInt(this.favorite_count);
        dest.writeLong(this.id);
        dest.writeString(this.text);
        dest.writeInt(this.retweet_count);
        dest.writeByte(favorited ? (byte) 1 : (byte) 0);
        dest.writeByte(retweeted ? (byte) 1 : (byte) 0);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
