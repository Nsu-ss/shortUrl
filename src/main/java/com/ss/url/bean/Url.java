package com.ss.url.bean;


public class Url {


    private Integer Url_id ;

    private String url;

    private String shortKey;

    private Integer type = 0;

    private Integer count;

    private String key = "ss";

    public Integer getUrl_id() {
        return Url_id;
    }

    public void setUrl_id(Integer url_id) {
        Url_id = url_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortKey() {
        return shortKey;
    }

    public void setShortKey(String shortKey) {
        this.shortKey = shortKey;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


    @Override
    public String toString() {
        return "Url{" +
                "Url_id=" + Url_id +
                ", url='" + url + '\'' +
                ", shortKey='" + shortKey + '\'' +
                ", type=" + type +
                ", count=" + count +
                ", key='" + key + '\'' +
                '}';
    }
}
