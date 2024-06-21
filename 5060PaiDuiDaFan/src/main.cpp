#include <iostream>

using namespace std;

int a[ 100005 ], t[ 100005 ], b[ 100005 ];
int n;
int main( int argc, char **argv ) {
    scanf( "%d", &n );
    for ( int i = 0; i < n; ++i ) {
        scanf( "%d %d %d", &a[ i ], &t[ i ], &b[ i ] );
    }

    long long time = 0;

    for ( int i = 0; i < n; ++i ) {
        if ( time > a[ i ] + b[ i ] ) {
            printf( "-1 " );
            continue;
        } else {
            if ( a[ i ] > time ) {
                time = (long long) a[ i ];
            }
            printf( "%lld ", time );
            time += t[ i ];
        }
    }

    return 0;
}
