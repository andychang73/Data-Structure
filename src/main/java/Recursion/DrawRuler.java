package Recursion;

public class DrawRuler {

    public static void drawRuler(int inches, int majorLength){
        drawLine(majorLength, 0);
        for(int i = 1; i <= inches; i++){
            drawInterval(majorLength);
            drawLine(majorLength, i);
        }
    }

    private static void drawInterval(int tickLength){
        if(tickLength >= 1){
            drawInterval(tickLength-1);
            drawLine(tickLength);
            drawInterval(tickLength-1);
        }
    }

    private static void drawLine(int tickLength, int tickLabel){
        for(int i = 0 ; i < tickLength; i++){
            System.out.print("-");
        }
        if(tickLabel >= 0){
            System.out.print(" " + tickLabel);
        }
        System.out.println();
    }

    private static void drawLine(int tickLength){
        drawLine(tickLength, -1);
    }

    public static void main(String[] args) {
        drawRuler(2, 3);
    }
}
