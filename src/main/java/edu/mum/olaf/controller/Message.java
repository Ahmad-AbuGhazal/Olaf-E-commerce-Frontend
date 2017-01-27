package edu.mum.olaf.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by ahmad on 02/06/2016.
 */

public class Message {

    String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
