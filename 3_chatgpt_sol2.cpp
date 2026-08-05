#include <bits/stdc++.h>
using namespace std;

vector<pair<int, int>> primeFactors;
int factorCount;
vector<int> stateMultiplier;
vector<vector<int>> stateValues;
vector<vector<int>> mergedState;
unordered_map<long long, bool> dp;
int totalStates;

int encodeState(const vector<int> &exponents) {
    int id = 0;

    for (int i = 0; i < factorCount; i++) {
        id += exponents[i] * stateMultiplier[i];
    }

    return id;
}

bool isCursed(int firstState, int secondState) {

    long long key = ((long long) firstState << 32) | secondState;

    if (dp.count(key))
        return dp[key];

    int nextState = mergedState[firstState][secondState];

    if (nextState == totalStates - 1)
        return dp[key] = true;

    if (nextState == secondState)
        return dp[key] = false;

    return dp[key] = isCursed(secondState, nextState);
}

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int M;
    cin >> M;

    int temp = M;

    for (int p = 2; p * p <= temp; p++) {

        if (temp % p != 0)
            continue;

        int exponent = 0;

        while (temp % p == 0) {
            temp /= p;
            exponent++;
        }

        primeFactors.push_back({p, exponent});
    }

    if (temp > 1)
        primeFactors.push_back({temp, 1});

    factorCount = primeFactors.size();

    stateMultiplier.resize(factorCount);

    totalStates = 1;

    for (int i = 0; i < factorCount; i++) {
        stateMultiplier[i] = totalStates;
        totalStates *= (primeFactors[i].second + 1);
    }

    stateValues.assign(totalStates, vector<int>(factorCount));

    for (int state = 0; state < totalStates; state++) {

        int value = state;

        for (int i = 0; i < factorCount; i++) {

            int limit = primeFactors[i].second + 1;

            stateValues[state][i] = value % limit;
            value /= limit;
        }
    }

    mergedState.assign(totalStates, vector<int>(totalStates));

    for (int stateA = 0; stateA < totalStates; stateA++) {

        for (int stateB = 0; stateB < totalStates; stateB++) {

            vector<int> combined(factorCount);

            for (int i = 0; i < factorCount; i++) {

                combined[i] = min(
                    primeFactors[i].second,
                    stateValues[stateA][i] + stateValues[stateB][i]
                );
            }

            mergedState[stateA][stateB] = encodeState(combined);
        }
    }

    vector<int> numberState(M);

    for (int number = 1; number < M; number++) {

        int value = number;
        vector<int> exponents(factorCount, 0);

        for (int i = 0; i < factorCount; i++) {

            int prime = primeFactors[i].first;

            while (value % prime == 0) {
                exponents[i]++;
                value /= prime;
            }
        }

        numberState[number] = encodeState(exponents);
    }

    long long answer = 0;

    for (int x = 1; x < M; x++) {

        for (int y = 1; y < M; y++) {

            if (isCursed(numberState[x], numberState[y]))
                answer++;
        }
    }

    cout << answer << "\n";

    return 0;
}
