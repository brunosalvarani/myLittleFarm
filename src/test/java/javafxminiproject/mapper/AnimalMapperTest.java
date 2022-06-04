package test.java.javafxminiproject.mapper;

import main.java.javafxminiproject.mapper.AnimalMapper;
import main.java.javafxminiproject.model.Animal;
import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

class AnimalMapperTest {

    public static void callTests() {
        try {
            testToModelList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public static void testToModelList() throws SQLException {
        ResultSet rs = MockResultSet.create(
                new String[] { "TAG", "PARENTTAG", }, //TODO substituir com colunas do banco
                new Object[][] { // data
                        { "123",null, "2000-10-22", "F", "Cow", false },
                        { "124","123", "1999-10-21", "M", "BigCow", true }
                });

        List<Animal> animalList = AnimalMapper.toModelList(rs);

        Animal expectedAnimal = new Animal("123",null, "2000-10-22", "F", "Cow", false);

        Assert.assertEquals(0,animalList.size());
        Assert.assertEquals(expectedAnimal, animalList.get(0));
    }
}