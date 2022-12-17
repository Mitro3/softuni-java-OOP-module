package gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GiftFactoryTests {

    private GiftFactory giftFactory;

    @Before
    public void setUp() {
        this.giftFactory = new GiftFactory();
    }

    @Test
    public void testCreatingGiftShouldIncreaseCollection() {
        Assert.assertEquals(0, giftFactory.getCount());
        Gift giftRing = new Gift("Ring", 10.00);
        giftFactory.createGift(giftRing);
        Assert.assertEquals(1, giftFactory.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreatingExistingGiftShouldThrow() {
        Gift giftRing = new Gift("Ring", 10.00);
        Gift giftEarrings = new Gift("Earrings", 5.00);

        giftFactory.createGift(giftRing);
        giftFactory.createGift(giftEarrings);
        giftFactory.createGift(giftRing);
    }

    @Test
    public void testRemoveExistingGiftShouldDecreaseCollectionSize() {
        Gift giftRing = new Gift("Ring", 10.00);
        Gift giftEarrings = new Gift("Earrings", 5.00);

        giftFactory.createGift(giftRing);
        giftFactory.createGift(giftEarrings);
        Assert.assertEquals(2, giftFactory.getCount());
        giftFactory.removeGift(giftRing.getType());
        String removedGiftType = giftRing.getType();
        Assert.assertEquals(1, giftFactory.getCount());
        boolean isMissing = giftFactory.getPresents().stream().anyMatch(p -> p.getType().equals(removedGiftType));
        Assert.assertFalse(isMissing);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveGiftWithNullNameShouldThrow() {
        Gift invalidGift = new Gift(null, 2.00);

        giftFactory.removeGift(invalidGift.getType());
    }

    @Test
    public void testGetGiftWithLeastMagicShouldReturnCorrectGift() {
        getGiftRepositoryWithThreeGifts(giftFactory);

        Gift gift = giftFactory.getPresentWithLeastMagic();
        Assert.assertEquals("Bracelet", gift.getType());
    }

    @Test
    public void testGetGiftShouldReturnCorrectGift() {
        getGiftRepositoryWithThreeGifts(giftFactory);

        Gift gift = giftFactory.getPresent("Earrings");
        Assert.assertEquals("Earrings", gift.getType());
    }

    private void getGiftRepositoryWithThreeGifts(GiftFactory giftFactory) {
        Gift giftRing = new Gift("Ring", 10.00);
        Gift giftEarrings = new Gift("Earrings", 5.00);
        Gift giftBracelet = new Gift("Bracelet", 2.00);

        giftFactory.createGift(giftRing);
        giftFactory.createGift(giftBracelet);
        giftFactory.createGift(giftEarrings);
    }
}
