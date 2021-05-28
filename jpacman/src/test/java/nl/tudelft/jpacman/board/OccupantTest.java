package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen 
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    //测试断言，一个单位刚开始没有正方形
    @Test
    void noStartSquare() {
        // Remove the following placeholder:
        assertThat(unit).isNotNull();
      //判断是否被占据
        assertThat(unit.hasSquare()).isFalse();
    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    //证明该单位在占领后确实以目标方为基地
    //如果一个单位被另一个基本方块占领，那么一个单位应该包含另一个
    @Test
    void testOccupy() {
    	 Square square = new BasicSquare();
         //产生关系
         unit.occupy(square);

         //双向的
         //判断占据的是不是游戏单元
         assertThat(unit.getSquare()).isEqualTo(square);
         //判断这个单元是否被游戏单元包含
         assertThat(square.getOccupants()).contains(unit);
    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    //验证该单位确实有目标方作为其基地后，双重占领
    //如果该单元被另一个正方形重新占用，会发生什么情况？
    @Test
    void testReoccupy() {
        // Remove the following placeholder:
        //assertThat(unit).isNotNull();
    	
    	 //arrange: GIVEN
        Square square = new BasicSquare();

        //act: WHEN
        unit.occupy(square);
        unit.occupy(square);

        //assert: THEN
        assertThat(unit.getSquare()).isEqualTo(square);
        assertThat(square.getOccupants()).contains(unit).containsOnlyOnce(unit);
    }
}
