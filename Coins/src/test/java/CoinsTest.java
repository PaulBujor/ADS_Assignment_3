import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoinsTest {

  private List<Integer> coinsList;
  private Coins coins;

  @BeforeEach
  void setup(){
    coinsList = new ArrayList<>();
    coins = new Coins();
  }
  @Test
  void tearDown(){
    coinsList = null;
  }

  private void insertCoins(){
    coinsList.add(1);
    coinsList.add(7);
    coinsList.add(10);
    coinsList.add(22);
  }

  @Test
  void findMin0(){
    insertCoins();
    assertEquals(0,coins.findMin(coinsList,0));
  }
  @Test
  void findMin8(){
    insertCoins();
    assertEquals(2,coins.findMin(coinsList,8));
  }
  @Test
  void findMin31(){
    insertCoins();
    assertEquals(4,coins.findMin(coinsList,31));
  }
  @Test
  void findMin40(){

    insertCoins();
    assertEquals(4,coins.findMin(coinsList,40));
  }



}
