package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
//Farklı key-value ikililerin uyuşmazlığını @JsonIgnoreProperties(ignoreUnknown = true)
// anotation'ını Pojo Class'ımızın başına yazarak çözebiliriz.


public class JsonPlaceHolderPojo {

    /*
    1. Tum key'ler icin private veriable'lar olusturuyoruz
    2. Tum parametrelerle ve parametresiz cons.'larimizi olusturuyoruz.
    3. Getters ve Setters'larimizi olusturuyoruz.
    4. toString() methodumuzu olusturuyoruz.
    */


    // 1. Tum key'ler icin private veriable'lar olusturuyoruz
     private Integer userId;
     private String title;
     private Boolean completed;


    //2. Tum parametrelerle ve parametresiz cons.'larimizi olusturuyoruz.


    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public JsonPlaceHolderPojo(){
    }

    //3. Getters ve Setters'larimizi olusturuyoruz.


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    //4. toString() methodumuzu olusturuyoruz.

    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
