package day12;

public class ArrayCopyByForEx {
    public static void main(String[] args) {
        int[] oldIntArray = {1, 2, 3};
        int[] newIntArray = new int[5];
        int[] newIntArray2 = new int[5];

        // 1. for문 사용 방식
        for(int i = 0; i < oldIntArray.length; i++){
            newIntArray[i] = oldIntArray[i];
        }

        for (int i : newIntArray) {
            System.out.println(i + " ");
        }

        // 2. System Class 사용 방식
        System.arraycopy(oldIntArray, 0, newIntArray2, 0, oldIntArray.length);

        for (int i : newIntArray2) {
            System.out.println(i + " ");
        }


        // code summary : 길이가 3인 배열의 인덱스를 길이가 5인 배열의 인덱스로 이전하는 코드 (배열의 값 복사)


    }
}
