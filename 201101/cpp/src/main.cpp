#include <string>
#include <iostream>
using namespace std;
const int N=35;
char a[N],b[N],c[N];
string dp[N][N][N];    //易错点，不是使用int定义的三维数组
int main(){
    cin>>(a+1)>>(b+1)>>(c+1);
    //注意需要先求一下字串长度
    int len1=strlen(a+1);
    int len2=strlen(b+1);
    int len3=strlen(c+1);
    //边界
    for(int i=0;i<=len1;i++){
        for(int j=0;j<=len2;j++){
            for(int k=0;k<=len3;k++){
            //初试化
                dp[i][j][0]="";
                dp[i][0][k]="";
                dp[0][j][k]="";
            }
        }
    }
    //状态转移方程
    for(int i=1;i<=len1;i++){
        for(int j=1;j<=len2;j++){
            for(int k=1;k<=len3;k++){
                if(a[i]==b[j]&&a[i]==c[k]){
                    dp[i][j][k]=dp[i-1][j-1][k-1]+a[i];
                }else{
                    int l1=dp[i-1][j][k].length();
                    int l2=dp[i][j-1][k].length();
                    int l3=dp[i][j][k-1].length();
                    if(l1==max(l1,max(l2,l3))){
                        dp[i][j][k]=dp[i-1][j][k];
                    }else if(l2==max(l1,max(l2,l3))){
                        dp[i][j][k]=dp[i][j-1][k];
                    }else{
                        dp[i][j][k]=dp[i][j][k-1];
                    }
                }
            }
        }
    }
    cout<<dp[len1][len2][len3]<<endl;
    return 0;
}

