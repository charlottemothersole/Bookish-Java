package com.bookishjava.models.database;

import jakarta.persistence.*;

@Entity
public class Member {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String name;


    public Member() {

    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((id == null) ? 0 : id.hashCode());
//        result = prime * result + ((title == null) ? 0 : title.hashCode());
//        return result;
//    }
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (obj == null)
//            return false;
//        if (getClass() != obj.getClass())
//            return false;
//        Book other = (Book) obj;
//        if (id == null) {
//            if (other.id != null)
//                return false;
//        } else if (!id.equals(other.id))
//            return false;
//        if (title == null) {
//            if (other.title != null)
//                return false;
//        } else if (!title.equals(other.title))
//            return false;
//        return true;
//    }
}
