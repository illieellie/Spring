package hello.hellospring.controller;

import hello.hellospring.domain.Member;

public class MemberForm {
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
