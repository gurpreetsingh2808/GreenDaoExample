package com.greendaoexample;

/**
 * Created by Gurpreet on 12/17/2016.
 */

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Entity mapped to table .
 */
@Entity(indexes = {
        @Index(value = "name", unique = true)
})
public class MyObject {

    @Id
    private Long id;

    @NotNull
    private String name;


    @Generated(hash = 448702438)
    public MyObject(Long id, @NotNull String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 91472123)
    public MyObject() {
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

    public void setName(String text) {
        this.name = text;
    }
}
