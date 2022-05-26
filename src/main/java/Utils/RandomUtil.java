package Utils;

public class RandomUtil {

    public static int generate(int min, int max){
        return (int)(Math.random() * (max - min + 1) + min);
    }

    public static int[] generateRandomArray(int[] data, int min, int max){
        for(int i = 0; i < data.length; i++){
            data[i] = generate(min, max);
        }
        return data;
    }
}
