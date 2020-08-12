package com.pzyruo.domain;

public class MyStudent {
    private Integer myId;
    private String myName;
    private String myEmail;
    private Integer age;

    @Override
    public String toString() {
        return "MyStudent{" +
                "myId=" + myId +
                ", myName='" + myName + '\'' +
                ", myEmail='" + myEmail + '\'' +
                ", age=" + age +
                '}';
    }

    public Integer getMyId() {
        return myId;
    }

    public void setMyId(Integer myId) {
        this.myId = myId;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String getMyEmail() {
        return myEmail;
    }

    public void setMyEmail(String myEmail) {
        this.myEmail = myEmail;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
