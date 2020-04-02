package app;
import java.util.Map.Entry;
import java.util.*;

import org.w3c.dom.css.Counter;

/*
ボールが N個あり、 i番目のボールには整数 
Aiが書かれています。
k=1,2,...,N
 に対して以下の問題を解いて、答えをそれぞれ出力してください。

k 番目のボールを除いた 
N−1 個のボールから、書かれている整数が等しいような異なる 
2 つのボールを選び出す方法の数を求めてください。選ぶ順序は考慮しません。
*/



public class App {
    public static void main(final String[] args){
        //スキャン
        final Scanner s = new Scanner(System.in);
        //N
        int N = s.nextInt();
        //重複カウンター（重複対象、重複回数）
        HashMap<Integer,Long> counter = new HashMap<>();
        //実際の玉の様子
        final int[] As = new int[N];

        //入力を取得して玉の様子を取る
        for(int i = 0;i<=N-1;i++){
            //玉の様子
            As[i] = s.nextInt();
            //ついでに重複数もカウント
            if(!counter.containsKey(As[i])){
                //初登場の場合
                counter.put(As[i], (long) 1);
            }else{
                //二回目以降の場合
                counter.put(As[i],counter.get(As[i])+1);
            }
        }
        s.close();
        
        //全組み合わせ計算
        Long allnum =0L;
        //重複カウンターを全部計算(Entry速い、良い)
        for(Entry<Integer,Long> entry :counter.entrySet()){
            Long param = entry.getValue();
            allnum += param*(param-1)/2;
        }

        //ｋの選択パターンを網羅
        for(int k = 0;k<=N-1;k++){
            //選ばれたkと同じ値は減衰させる
            if(counter.containsKey(As[k])){
                //減衰前と減衰後は(n+1)*nとn*(n-1)って感じ
                //だから2n引けば減衰状態を表現できる
                System.out.println(allnum - counter.get(As[k])+1);
            }else{
                //ありえないけど、kが存在しなかったとき
            System.out.println(allnum);
            }
        }
    }
}
