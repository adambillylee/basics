package builderExample;

/**
 * Created by adamli on 4/2/16.
 */
public class User {
    private final String firstName;
    private final String lastName;
    private int age;
    private String phone;
    private String address;

    private User(Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        setAge(builder.age);
        setPhone(builder.phone);
        setAddress(builder.address);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static final class Builder {
        private String firstName;
        private String lastName;
        private int age = 0;
        private String phone = "";
        private String address;

        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder firstName(String val) {
            firstName = val;
            return this;
        }

        public Builder lastName(String val) {
            lastName = val;
            return this;
        }

        public Builder age(int val) {
            age = val;
            return this;
        }

        public Builder phone(String val) {
            phone = val;
            return this;
        }

        public Builder address(String val) {
            address = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
