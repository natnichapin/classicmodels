package sit.int202.classicmodels;

import at.favre.lib.crypto.bcrypt.BCrypt;
import sit.int202.classicmodels.entities.Customer;
import sit.int202.classicmodels.repositories.CustomerRepository;

public class TestBcrypt {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepository();
        Customer user = repository.findByName("Jean King"); //เอา object User
        System.out.println(user.getContactFirstName());
        System.out.println(user.getContactFirstName()+", "+user.getPassword());
        String password = "123abc" ;
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(),
                user.getPassword());
        System.out.println("Correct password?"+result.verified); //เทียบรหัสผ่านกับ ใน db โดยใช้ BCrypt ถอดรหัส
         result = BCrypt.verifyer().verify("123abx".toCharArray(),
                user.getPassword());
        System.out.println("Correct password?"+result.verified);
        //hashing แล้วได้ไม่เหมือนเดิม
        System.out.println(BCrypt.withDefaults().hashToString(10,"123abc".toCharArray()));
        System.out.println(BCrypt.withDefaults().hashToString(10,"123abc".toCharArray()));
    }
}
