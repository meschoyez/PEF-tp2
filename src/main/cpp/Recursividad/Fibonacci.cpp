#include <iostream>
#include <cstdlib>

using namespace std;

int Fibonacci (int n);

int main (int argc, char* argv[]) {
  int n = 0, f = 0;

  if (argc != 2) {
    cout << "Uso: " << argv[0] << " valor" << endl;
    return 1;
  }

  n = atoi(argv[1]);
  f = Fibonacci(n);

  cout << "F(" << n << ") = " << f << endl;

  return 0;
}


int Fibonacci (int n) {
  int f = 1;
  if (n < 0)
    f = -1;
  else if (n > 2)
    f = Fibonacci(n - 2) + Fibonacci(n - 1);
  return f;
}

