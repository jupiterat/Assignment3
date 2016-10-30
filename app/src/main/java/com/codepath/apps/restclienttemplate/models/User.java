package com.codepath.apps.restclienttemplate.models;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            User var = new User();
            var.friends_count = source.readInt();
            var.profile_image_url_https = source.readString();
            var.listed_count = source.readInt();
            var.profile_background_image_url = source.readString();
            var.favourites_count = source.readInt();
            var.description = source.readString();
            var.created_at = source.readString();
            var.is_translator = source.readByte() != 0;
            var.profile_image_url = source.readString();
            var.url = source.readString();
            var.contributors_enabled = source.readByte() != 0;
            var.profile_background_tile = source.readByte() != 0;
            var.profile_background_image_url_https = source.readString();
            var.screen_name = source.readString();
            var.id_str = source.readString();
            var.followers_count = source.readInt();
            var.name = source.readString();
            var.is_translation_enabled = source.readByte() != 0;
            var.location = source.readString();
            var.profile_background_color = source.readString();
            return var;
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
    private int friends_count;
    private String profile_image_url_https;
    private int listed_count;
    private String profile_background_image_url;
    private int favourites_count;
    private String description;
    private String created_at;
    private boolean is_translator;
    private String profile_image_url;
    private String url;
    private boolean contributors_enabled;
    private boolean profile_background_tile;
    private String profile_background_image_url_https;
    private String screen_name;
    private String id_str;
    private int followers_count;
    private String name;
    private boolean is_translation_enabled;
    private String location;
    private String profile_background_color;

    public int getFriends_count() {
        return this.friends_count;
    }

    public void setFriends_count(int friends_count) {
        this.friends_count = friends_count;
    }

    public String getProfile_image_url_https() {
        return this.profile_image_url_https;
    }

    public void setProfile_image_url_https(String profile_image_url_https) {
        this.profile_image_url_https = profile_image_url_https;
    }

    public int getListed_count() {
        return this.listed_count;
    }

    public void setListed_count(int listed_count) {
        this.listed_count = listed_count;
    }

    public String getProfile_background_image_url() {
        return this.profile_background_image_url;
    }

    public void setProfile_background_image_url(String profile_background_image_url) {
        this.profile_background_image_url = profile_background_image_url;
    }

    public int getFavourites_count() {
        return this.favourites_count;
    }

    public void setFavourites_count(int favourites_count) {
        this.favourites_count = favourites_count;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public boolean getIs_translator() {
        return this.is_translator;
    }

    public void setIs_translator(boolean is_translator) {
        this.is_translator = is_translator;
    }

    public String getProfile_image_url() {
        return this.profile_image_url;
    }

    public void setProfile_image_url(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean getContributors_enabled() {
        return this.contributors_enabled;
    }

    public void setContributors_enabled(boolean contributors_enabled) {
        this.contributors_enabled = contributors_enabled;
    }

    public boolean getProfile_background_tile() {
        return this.profile_background_tile;
    }

    public void setProfile_background_tile(boolean profile_background_tile) {
        this.profile_background_tile = profile_background_tile;
    }

    public String getProfile_background_image_url_https() {
        return this.profile_background_image_url_https;
    }

    public void setProfile_background_image_url_https(String profile_background_image_url_https) {
        this.profile_background_image_url_https = profile_background_image_url_https;
    }

    public String getScreen_name() {
        return this.screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getId_str() {
        return this.id_str;
    }

    public void setId_str(String id_str) {
        this.id_str = id_str;
    }

    public int getFollowers_count() {
        return this.followers_count;
    }

    public void setFollowers_count(int followers_count) {
        this.followers_count = followers_count;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIs_translation_enabled() {
        return this.is_translation_enabled;
    }

    public void setIs_translation_enabled(boolean is_translation_enabled) {
        this.is_translation_enabled = is_translation_enabled;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProfile_background_color() {
        return this.profile_background_color;
    }

    public void setProfile_background_color(String profile_background_color) {
        this.profile_background_color = profile_background_color;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.friends_count);
        dest.writeString(this.profile_image_url_https);
        dest.writeInt(this.listed_count);
        dest.writeString(this.profile_background_image_url);
        dest.writeInt(this.favourites_count);
        dest.writeString(this.description);
        dest.writeString(this.created_at);
        dest.writeByte(is_translator ? (byte) 1 : (byte) 0);
        dest.writeString(this.profile_image_url);
        dest.writeString(this.url);
        dest.writeByte(contributors_enabled ? (byte) 1 : (byte) 0);
        dest.writeByte(profile_background_tile ? (byte) 1 : (byte) 0);
        dest.writeString(this.profile_background_image_url_https);
        dest.writeString(this.screen_name);
        dest.writeString(this.id_str);
        dest.writeInt(this.followers_count);
        dest.writeString(this.name);
        dest.writeByte(is_translation_enabled ? (byte) 1 : (byte) 0);
        dest.writeString(this.location);
        dest.writeString(this.profile_background_color);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
