package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingPojo {

    //1) Tüm keyler için private variable 'lar oluşturuyoruz.
    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private BookingDatesPojo bookingdates;
    private String additinalneeds;

    public BookingPojo(String firstname, String lastname, Integer totalprice, Boolean depositpaid, BookingDatesPojo bookingdates, String additinalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additinalneeds = additinalneeds;
    }

    public BookingPojo() {

    }
    //3) Getters ve Setters'larımızı oluşturuyoruz.

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public Boolean getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public BookingDatesPojo getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDatesPojo bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditinalneeds() {
        return additinalneeds;
    }

    public void setAdditinalneeds(String additinalneeds) {
        this.additinalneeds = additinalneeds;
    }

        //4) toString() methodumuzu oluşturuyoruz.

    @Override
    public String toString() {
        return "BookingPojo{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                ", additinalneeds='" + additinalneeds + '\'' +
                '}';
    }
}
