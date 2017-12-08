package testing;

import laba7.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;


public class PersonTest {

    private static Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void phoneIsNull() {
        Person person = new Person(0001,
                "loshka",
                "123456",
                "lol54321@gmail.com",
                "Klavdiy Oleh",
                25,
                null,
                997114,
                3,
                new String[]{"Playing piano", "Cooking", "Drawing"});
        Set<ConstraintViolation<Person>> constraintViolations =
                validator.validate( person );

        Assert.assertEquals( 1, constraintViolations.size() );
        Assert.assertEquals(
                "must not be null",
                constraintViolations.iterator().next().getMessage()
        );
    }

    @Test
    public void test2() {
        Person person = new Person(0001,
                "loshka",
                "123456",
                "lol54321@gmail.com",
                "Klavdiy Oleh",
                25,
                "+805-426-4917",
                997114,
                -129959,
                new String[]{"Playing piano", "Cooking", "Drawing"});
        Set<ConstraintViolation<Person>> constraintViolations =
                validator.validate( person );

        Assert.assertEquals( 1, constraintViolations.size() );
        Assert.assertEquals(
                "must be greater than 0",
                constraintViolations.iterator().next().getMessage()
        );
    }


    @Test
    public void test3() {
        Person person = new Person(0001,
                "loshka",
                "123457",
                "lol54321@gmail.com",
                "Klavdiy Oleh",
                25,
                "+805-426-4917",
                -1,
                4,
                new String[]{"Playing piano", "Cooking", "Drawing"});
        Set<ConstraintViolation<Person>> constraintViolations =
                validator.validate( person );

        Assert.assertEquals( 1, constraintViolations.size() );
        Assert.assertEquals(
                "must be greater than 0",
                constraintViolations.iterator().next().getMessage()
        );
    }


    @Test
    public void test4() {
        Person person = new Person(0001,
                "loshka",
                "123456",
                "lol54321@gmail.com",
                "Klavdiy Oleh",
                25,
                "+805-426-4917",
                997114,
                5,
                new String[]{"Playing piano", "Cooking", "Drawing"});

        person.setId(person.getId() + 1);
        person.setPassword(person.getPassword() + "7");
        person.setEmail(person.getEmail().replace('l', 'k'));
        person.setFullName(null);
        person.setAge(person.getAge() + 1);
        person.setPhone(person.getPhone().replace('5','6'));
        person.setMoney(person.getMoney() + 15000);
        person.setNumVisit(person.getNumVisit() + 10);
        Set<ConstraintViolation<Person>> constraintViolations =
                validator.validate( person );

        Assert.assertEquals( 1, constraintViolations.size() );
        Assert.assertEquals(
                "must not be null",
                constraintViolations.iterator().next().getMessage()
        );
    }




}