package favortiesList;


import Iterator.Iterator;
import favoritesList.FavoriteListMTF;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FavoritesListMTFTest {

    private FavoriteListMTF<String> list;

    @Before
    public void init(){
        list = new FavoriteListMTF<>();
    }

    @Test
    public void testGetFavorites(){
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

        Iterator<String> iterator = list.getFavorites(3).iterator();
        String[] result = new String[]{"A","B","C"};
        int count = 0;
        while(iterator.hasNext()){
            Assert.assertEquals(iterator.next(), result[count++]);
        }
    }
}
