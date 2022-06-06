package test.java.javafxminiproject.mapper;

import main.java.javafxminiproject.mapper.AnimalMapper;
import main.java.javafxminiproject.model.Animal;
import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

class AnimalMapperTest {

    public void callTests() {
        try {
            testToModelList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
        It isn't good practice to Test static methods, so I made it non-static
        not sure if this is beneficial or not tho ...
     */
    @Test
    public void testToModelList() throws SQLException {
        ResultSet rs = MockResultSet.create(
                new String[] { "TAG", "PARENTTAG", "BIRTHDATE", "GENDER", "RACE", "ISNATIVE"},
                new Object[][] { // data
                        { "123", null, "2000-10-22", "F", "Cow", "N" },
                        { "124","123", "1999-10-21", "M", "BigCow", "Y" }
                });

        List<Animal> animalList = AnimalMapper.toModelList(rs);

        Animal expectedAnimal0 = new Animal("123",null, "2000-10-22", "F", "Cow", false);
        Animal expectedAnimal1 = new Animal("124","123", "1999-10-21", "M", "BigCow", true);

        Assert.assertEquals(2,animalList.size());
        Assert.assertEquals(expectedAnimal0, animalList.get(0));
        Assert.assertEquals(expectedAnimal1, animalList.get(1));

    }
}