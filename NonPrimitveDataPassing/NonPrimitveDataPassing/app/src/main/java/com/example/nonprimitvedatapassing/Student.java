package com.example.nonprimitvedatapassing;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Student implements Parcelable {

    private String name;
    private long rollNum;
    private ArrayList<String> subjects;

    protected Student(Parcel in) {
        name = in.readString();
        rollNum = in.readLong();
        subjects = in.createStringArrayList();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    Student(String name, long rollNum, ArrayList<String> subjectList) {
        this.name = name;
        this.rollNum = rollNum;
        this.subjects = subjectList;
    }

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    long getRollNum() {
        return rollNum;
    }

    public void setRollNum(long rollNum) {
        this.rollNum = rollNum;
    }

    ArrayList<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeLong(rollNum);
        dest.writeStringList(subjects);
    }
}
