package Day45.exercise1;

import java.io.Serializable;

/**
 * @ClassName: Creature
 * @Description:
 * @Author: TianXing.Xue
 * @Date: 2021/8/10 11:13
 **/

public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breathe() {
        System.out.println("生物呼吸");
    }

    public void eat() {
        System.out.println("生物吃东西");
    }
}
