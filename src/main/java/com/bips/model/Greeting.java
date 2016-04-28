package com.bips.model;

/**
 * Created by ahadcse on 19/03/16.
 */
public class Greeting {

    private long id;
    private String content;
    private String greetingText;

    public Greeting() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setGreetingText(String greetingText) {
        this.greetingText = greetingText;
    }

    public String getGreetingText() {
        return greetingText;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", greetingText='" + greetingText + '\'' +
                '}';
    }
}
