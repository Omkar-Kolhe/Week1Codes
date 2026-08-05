#include <iostream>

using namespace std;

long long calculateGreatestCommonDivisor(long long a, long long b) {
    while (b != 0) {
        long long remainder = a % b;
        a = b;
        b = remainder;
    }
    return a;
}

int main() {
    long long modulus;
    if (cin >> modulus) {
        long long remainingValue = modulus;
        long long squareFreeProduct = 1;

        for (long long divisor = 2; divisor * divisor <= remainingValue; ++divisor) {
            if (remainingValue % divisor == 0) {
                squareFreeProduct *= divisor;
                while (remainingValue % divisor == 0) {
                    remainingValue /= divisor;
                }
            }
        }
        
        if (remainingValue > 1) {
            squareFreeProduct *= remainingValue;
        }

        long long cursedPairCount = 0;
        for (long long startX = 1; startX < modulus; ++startX) {
            long long currentGcd = calculateGreatestCommonDivisor(startX, squareFreeProduct);
            long long requiredYFactor = squareFreeProduct / currentGcd;
            cursedPairCount += (modulus - 1) / requiredYFactor;
        }

        cout << cursedPairCount << "\n";
    }
    return 0;
}
