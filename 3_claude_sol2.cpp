#include <bits/stdc++.h>
using namespace std;

int main(){
    int m;
    cin >> m;

    int temp = m;
    vector<int> pf;
    for(int i = 2; i * i <= temp; i++){
        if(temp % i == 0){
            pf.push_back(i);
            while(temp % i == 0){
                temp /= i;
            }
        }
    }
    if(temp > 1){
        pf.push_back(temp);
    }

    long long ans = 0;
    for(int x = 1; x < m; x++){
        for(int y = 1; y < m; y++){
            bool cursed = true;
            for(int i = 0; i < pf.size(); i++){
                if(x % pf[i] != 0 && y % pf[i] != 0){
                    cursed = false;
                    break;
                }
            }
            if(cursed){
                ans++;
            }
        }
    }

    cout << ans << "\n";
}
