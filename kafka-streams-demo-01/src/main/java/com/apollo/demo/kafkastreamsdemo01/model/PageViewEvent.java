package com.apollo.demo.kafkastreamsdemo01.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class PageViewEvent {

    private String userName, pageName;
    private long duration;

    public PageViewEvent() {
    }

    public PageViewEvent(String userName , String pageName , long duration) {
        this.userName = userName;
        this.pageName = pageName;
        this.duration = duration;
    }
}
