import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();
        for(int i=0;i<T;++i){
            int[] input=new int[5];
            int sum=0;
            for(int index=0;index<5;++index){
                input[index]=sc.nextInt();
                sum+=input[index];
            }

            int mod=sum%10;
            boolean exist=false;
            for(int j=0;j<5;++j){
                for(int k=j+1;k<5;++k){
                    if(exist) break;
                    else if((input[j]+input[k])%10==mod) {
                        exist=true;
                        System.out.println(mod);

                    }
                }
            }
            if(!exist) System.out.println("-1");
        }
    }
}
