package marvin.genetic.algorithm;

import java.util.Arrays;

public class Chromosome {

    byte[][] newState = new byte[16][4];
    byte[][] whatToDo = new byte[16][4];

    public void randomize() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j <= 3; j++) {
                newState[i][j] = (byte) (Math.random() * 16);
                whatToDo[i][j] = (byte) (Math.random() * 4);
            }
        }
    }

    public void crossWith(Chromosome c) {
        int crossPoint = (int) (Math.random() * 128);
        byte temp;
        int ct = 0;
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 4; j++) {
                if (ct > crossPoint) {
                    temp = newState[i][j];
                    newState[i][j] = c.newState[i][j];
                    c.newState[i][j] = temp;
                }
                ct++;
                if (ct > crossPoint) {
                    temp = whatToDo[i][j];
                    whatToDo[i][j] = c.whatToDo[i][j];
                    c.whatToDo[i][j] = temp;
                }
                ct++;
            }
        }
    }

    public Chromosome copy() {
        Chromosome c = new Chromosome();
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 4; j++) {
                c.whatToDo[i][j] = whatToDo[i][j];
                c.newState[i][j] = newState[i][j];
            }
        }
        return c;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("---")
          .append(super.toString())
          .append("---")
          .append("\n\t").append(Arrays.toString(this.newState))
          .append("\n\t").append(Arrays.toString(this.whatToDo));
          
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Chromosome c = new Chromosome();
        
        System.out.println(c);
    }
}
