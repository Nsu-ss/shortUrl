package com.ss.url.bean;

public class url {

    private Integer id ;

    private String url;

    private String shortKey;

    private Integer type;

    private Integer count;

    private String key;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return "url{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", shortKey='" + shortKey + '\'' +
                ", type=" + type +
                ", count=" + count +
                ", key='" + key + '\'' +
                '}';
    }
}
