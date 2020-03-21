package app;
import java.util.*;

/*
N+1個の街があり、
i番目の街は 
Ai体のモンスターに襲われています。

N人の勇者が居て、
i番目の勇者は 
i番目または 
i+1番目の街を襲っているモンスターを合計で 
Bi体まで倒すことができます。

N人の勇者がうまく協力することで、合計して最大で何体のモンスターを倒せるでしょうか。
*/



public class App {
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        //町の数
        int[] citys = new int[s.nextInt() +1]; 

        //各町のモンスター数
        int[] monsters = new int[citys.length];
        for(int i = 0 ; i < citys.length ; i++){
            monsters[i] = s.nextInt();
        }

        //各町のヒーロパワー
        int[] heros = new int[citys.length -1];
        //TODO　情けない処理を書きやがって
        for(int i = 0 ; i <citys.length - 1 ; i++){
            heros[i] = s.nextInt();
        }

        //各町の撃破モンスター数
        int killCount = 0;
        for(int i = 0 ; i <citys.length -1 ; i++){
            //ヒーロがモンスタ以下であるとき
            if( heros[i] <= monsters[i]){
                killCount += heros[i];
            }
            //ヒーロがモンスタ以上であるとき
            else if(heros[i] >= monsters[i]){
            
                    //隣町のモンスターとの合計と、ヒーロー、低い方をカウントに足す
                    //TODO 正直、ここのmaxの使い方は他の人の回答真似た
                    killCount += Math.min(monsters[i+1]+monsters[i],heros[i]-monsters[i]);
                    //隣町のモンスターを減らす
                    //TODO　情けない処理を書きやがって
                    monsters[i+1] -= Math.min(monsters[i+1],heros[i]-monsters[i]);
            }
        }
        System.out.println(killCount);
    }
}