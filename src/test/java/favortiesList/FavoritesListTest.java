package favortiesList;

import Iterator.Iterator;
import favoritesList.FavoritesList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FavoritesListTest {

    private FavoritesList<String> list;

    @Before
    public void init(){
        list = new FavoritesList<>();
    }

    @Test
    public void testAccessSuccess_AccessSameItem(){
        list.access("A");
        list.access("A");

        Assert.assertEquals(1, list.size());
    }

    @Test
    public void testAccessSuccess_TwoNewItems(){
        list.access("A");
        list.access("B");

        Assert.assertEquals(2, list.size());
    }

    @Test
    public void testRemoveSuccess_RemoveA(){
        list.access("A");
        list.access("B");
        list.remove("A");

        Assert.assertEquals(1, list.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetFavoritesFailed_WhenOutOfBound(){
        list.access("A");
        list.access("A");
        list.access("A");
        list.access("A");

        Iterator<String> iterator = list.getFavorites(2).iterator();
    }

    @Test
    public void testGetFavoritesSuccess(){
        list.access("A");
        list.access("A");
        list.access("A");
        list.access("A");
        list.access("B");
        list.access("B");
        list.access("B");
        list.access("C");
        list.access("C");
        list.access("D");

        Assert.assertEquals(4, list.size());

        Iterator<String> iterator = list.getFavorites(3).iterator();

        String[] favorites = new String[]{"A","B","C"};
        int count = 0;
        while(iterator.hasNext()){
            Assert.assertEquals(iterator.next(), favorites[count++]);
        }
    }
}
