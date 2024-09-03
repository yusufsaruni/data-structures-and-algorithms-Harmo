package harmo.projects.linearStructures;

import Harmo.customConsole.Colour;

public class DutchNationalFlag {

    private static final Colour system = new Colour();
    public static void main(String[] args) {
        system.setUser("HarmoKE");

        int[] arrays = {1, 1, 0, 2, 2, 1};
        DutchNationalFlag dutchNationalFlag = new DutchNationalFlag();
        dutchNationalFlag.threeNumberSort(arrays);
        dutchNationalFlag.printArray(arrays);
    }

    private  void printArray(int[] array){
        for(var integer : array){
            system.printMagenta(integer + " ", false);
        }
    }
    public void threeNumberSort(int[] array){
        int i = 0;
        int j = 0;
        int k = array.length - 1;
        while (i <= k){
            if(array[i] == 0){
                //swap with j(to take it at the 'beginning'
                swap(array, i, j);
                j++;
                i++;
            }else if(array[i] == 1){
                i++;
            }else if(array[i] == 2){
                swap(array, i , k);
                k --;
            }
        }
    }

    private  void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
