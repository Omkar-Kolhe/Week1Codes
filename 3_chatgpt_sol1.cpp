#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int M;
    cin >> M;

    vector<pair<int,int>> fac;
    int t = M;
    for (int p = 2; p * p <= t; p++) {
        if (t % p == 0) {
            int c = 0;
            while (t % p == 0) {
                t /= p;
                c++;
            }
            fac.push_back({p, c});
        }
    }
    if (t > 1) fac.push_back({t, 1});

    int k = fac.size();

    vector<int> mult(k);
    int states = 1;
    for (int i = 0; i < k; i++) {
        mult[i] = states;
        states *= (fac[i].second + 1);
    }

    vector<vector<int>> vec(states, vector<int>(k));

    for (int id = 0; id < states; id++) {
        int x = id;
        for (int i = 0; i < k; i++) {
            int lim = fac[i].second + 1;
            vec[id][i] = x % lim;
            x /= lim;
        }
    }

    auto encode = [&](const vector<int> &v) {
        int id = 0;
        for (int i = 0; i < k; i++)
            id += v[i] * mult[i];
        return id;
    };

    int FULL = states - 1;

    vector<vector<int>> add(states, vector<int>(states));

    for (int a = 0; a < states; a++) {
        for (int b = 0; b < states; b++) {
            vector<int> c(k);
            for (int i = 0; i < k; i++)
                c[i] = min(fac[i].second,
                           vec[a][i] + vec[b][i]);
            add[a][b] = encode(c);
        }
    }

    vector<int> valState(M);

    for (int v = 1; v < M; v++) {
        vector<int> c(k);
        int x = v;
        for (int i = 0; i < k; i++) {
            while (x % fac[i].first == 0) {
                c[i]++;
                x /= fac[i].first;
            }
        }
        valState[v] = encode(c);
    }

    unordered_map<long long,bool> memo;

    function<bool(int,int)> solve = [&](int A,int B)->bool{
        long long key=((long long)A<<32)|B;
        if(memo.count(key)) return memo[key];

        int C=add[A][B];
        if(C==FULL) return memo[key]=true;
        if(C==B) return memo[key]=false;

        return memo[key]=solve(B,C);
    };

    long long ans=0;

    for(int x=1;x<M;x++)
        for(int y=1;y<M;y++)
            if(solve(valState[x],valState[y]))
                ans++;

    cout<<ans<<"\n";
}
