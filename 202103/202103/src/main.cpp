#include <iostream>
#include <cstdlib>
using namespace std;
int arr[10005];
long dp[10005][10005];
int main(int argc, char **argv)
{
    int n;
    scanf("%d", &n);
    int sum = 0;

    for (int i = 0; i < n; ++i)
    {
        int item;
        scanf("%d", &item);
        sum += item;
        arr[i] = item;
    }
    int target;
    scanf("%d", &target);
    if (target < -sum || target > sum)
    {
        printf("0");
        return 0;
    }
    else if ((target + sum) % 2 != 0)
    {
        printf("0");
        return 0;
    }
    int left = (target + sum) / 2;
    long mod = 1e9 + 7;
    dp[0][0] = 1;
    if (arr[0] <= left)
        dp[0][arr[0]]++;
    for (int i = 1; i < n; ++i)
    {
        for (int j = 0; j <= left; ++j)
        {
            dp[i][j] += dp[i - 1][j];
            if (j - arr[i] >= 0)
            {
                dp[i][j] += dp[i - 1][j - arr[i]];
            }
        }
    }
    printf("%d", dp[n - 1][left] % mod);
    return 0;
}
