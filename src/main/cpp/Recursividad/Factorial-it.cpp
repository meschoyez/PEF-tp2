#include <iostream>
#include <cstdlib>

using namespace std;

int Factorial (int n);

int main (int argc, char* argv[]) {
  int n = 0, f = 0;

  if (argc != 2) {
    cout << "Uso: " << argv[0] << " valor" << endl;
    return 1;
  }

  n = atoi(argv[1]);
  f = Factorial(n);

  cout << n << "! = " << f << endl;

  return 0;
}


int Factorial (int n) {
  int f = 1;
  if (n < 0)
    f = 0;
  else if (n > 1)
    for (int i = 2; i <= n; i++)
      f *= i;
  return f;
}

