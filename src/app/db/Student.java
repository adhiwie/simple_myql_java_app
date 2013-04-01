package app.db;
/** *
 * @author Ekozul
*/
public class Student {
    private String nim;
    private String name;
    private String address;
    private String email;
    public Student() {
    }
    public String getAddress() {
        return address;
    }
public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
}
public void setName(String name) { this.name = name;
}
    public String getNim() {
        return nim;
}
    public void setNim(String nim) {
        this.nim = nim;
}
}