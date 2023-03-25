
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Write a description of CharactersInPlayTest here.
 * @author (Aymar NAHUM) 
 * @version (V2  04.01.2023)
 */
public class CharactersInPlayTest {
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    
    @Before
    public void setUp() {
        
    }
    
    @Test
    public void mainTest(){
         CharactersInPlay  charactersInPlay = new CharactersInPlay();
         charactersInPlay.findAllCharacters();
        
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }

  
}
