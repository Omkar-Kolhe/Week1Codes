#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

bool compareNumbers(const string& first, const string& second) {
    return first + second > second + first;
}

int main() {
    int testCases;
    if (!(cin >> testCases)) return 0;
    
    while (testCases > 0) {
        int arraySize;
        cin >> arraySize;
        
        vector<string> numbers(arraySize);
        for (int i = 0; i < arraySize; i++) {
            cin >> numbers[i];
        }
        
        sort(numbers.begin(), numbers.end(), compareNumbers);
        
        long long finalResult = 0;
        long long moduloValue = 998244353;
        
        for (const string& numberStr : numbers) {
            long long multiplier = 1;
            long long currentValue = 0;
            
            for (char digit : numberStr) {
                multiplier = (multiplier * 10) % moduloValue;
                currentValue = (currentValue * 10 + (digit - '0')) % moduloValue;
            }
            
            finalResult = (finalResult * multiplier % moduloValue + currentValue) % moduloValue;
        }
        
        cout << finalResult << "\n";
        testCases--;
    }
    
    return 0;
}
