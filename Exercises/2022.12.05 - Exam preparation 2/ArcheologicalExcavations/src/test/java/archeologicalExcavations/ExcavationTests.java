package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExcavationTests {
    private Archaeologist archaeologist;
    private Excavation excavation;

    @Before
    public void setUp() {
        this.archaeologist = new Archaeologist("Sasho", 100);
        this.excavation = new Excavation("Pernik", 10);
    }

    @Test
    public void testInvokeConstructorShouldCreateExcavation() {
        Assert.assertEquals("Pernik", excavation.getName());
        Assert.assertEquals(10, excavation.getCapacity());
        Assert.assertEquals(0, excavation.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorShouldThrowWithNullName() {
        Excavation excavation = new Excavation(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorShouldThrowWithEmptyName() {
        Excavation excavation = new Excavation("", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorShouldThrowWithNegativeCapacity() {
        Excavation excavation = new Excavation("Pesho", -1);
    }

    @Test
    public void testAddArcheologistShouldAdd() {
        Assert.assertEquals(0, excavation.getCount());
        excavation.addArchaeologist(archaeologist);
        Assert.assertEquals(1, excavation.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArcheologistShouldThrowWhenNoCapacityLeft() {
        Excavation excavation = new Excavation("Pernik",0);
        excavation.addArchaeologist(archaeologist);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArcheologistWhoAlreadyExistShouldThrow() {
        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(archaeologist);
    }

    @Test
    public void testRemoveArcheologistShouldRemove() {
        excavation.addArchaeologist(archaeologist);
        Archaeologist archaeologist2 = new Archaeologist("Pesho", 100);
        excavation.addArchaeologist(archaeologist2);
        Assert.assertTrue(excavation.removeArchaeologist(archaeologist.getName()));
        Assert.assertEquals(1, excavation.getCount());
    }

    @Test
    public void testRemoveArcheologistWhoIsMissingShouldThrow() {
        excavation.addArchaeologist(archaeologist);
        Archaeologist archaeologist2 = new Archaeologist("Pesho", 100);
        excavation.addArchaeologist(archaeologist2);
        Assert.assertFalse(excavation.removeArchaeologist("MissingName"));
        Assert.assertEquals(2, excavation.getCount());
    }
}
