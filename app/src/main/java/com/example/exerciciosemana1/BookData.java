package com.example.exerciciosemana1;

import android.os.Parcel;
import android.os.Parcelable;

public class BookData implements Parcelable {

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    private int imageResourceId = -1;

    protected BookData(Parcel in) {
        imageResourceId = in.readInt();
        title = in.readString();
        author = in.readString();
        yearPublished = in.readInt();
        isFiction = in.readByte() != 0;
    }

    public static final Creator<BookData> CREATOR = new Creator<BookData>() {
        @Override
        public BookData createFromParcel(Parcel in) {
            return new BookData(in);
        }

        @Override
        public BookData[] newArray(int size) {
            return new BookData[size];
        }
    };

    public int getImageResourceId() {
        return imageResourceId;
    }

    private String title;
    private String author;
    private int yearPublished;
    private boolean isFiction;


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public boolean isFiction() {
        return isFiction;
    }

    public Type getType() {
        return type;
    }

    public BookData(int imageResourceId, String title, String author, int yearPublished, boolean isFiction, Type type) {
        this.imageResourceId = imageResourceId;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isFiction = isFiction;
        this.type = type;
    }

    private Type type = Type.Other;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(title);
        dest.writeString(author);
        dest.writeInt(yearPublished);
        dest.writeByte((byte) (isFiction ? 1 : 0));
    }

    public enum Type {
        Drama,
        Thriller,
        Horror,
        SelfHelp,
        Philosofy,
        Other
        };


}
