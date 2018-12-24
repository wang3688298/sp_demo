package com.wk.bo;

import java.io.Serializable;

public class Teacher implements Serializable {

    private String tid;

    private String tame;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTame() {
        return tame;
    }

    public void setTame(String tame) {
        this.tame = tame;
    }
}
