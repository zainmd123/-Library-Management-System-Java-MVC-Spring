package com.verinon.lbm.pojos;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User
{
    @Id
    @GeneratedValue
    int user_id;
    String user_name;
    

    public int getMember_id() {
        return user_id;
    }

    public void setMember_id(int member_id) {
        this.user_id = member_id;
    }

    public String getMember_name() {
        return user_name;
    }

   
    public User(int user_id, String user_name) {
        this.user_id = user_id;
        this.user_name =user_name;
    }


    @Override
    public String toString() {
        return "MemberPojo{" +
                "member_id=" + user_id +
                ", member_name='" + user_name + '\'' +
                '}';
    }


    public User()
    {

    }
}
