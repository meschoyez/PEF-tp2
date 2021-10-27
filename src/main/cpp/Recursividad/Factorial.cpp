#include <iostream>
#include <cstdlib>

using namespace std;

unsigned long int Factorial (unsigned long int n);

int main (int argc, char* argv[]) {
  int n = 0;
  unsigned long int f = 0;

  if (argc != 2) {
    cout << "Uso: " << argv[0] << " valor" << endl;
    return 1;
  }

  n = atoi(argv[1]);
  f = Factorial(n);

  cout << n << "! = " << f << endl;

  return 0;
}


unsigned long int Factorial (unsigned long int n) {
  unsigned long int f = 0;
  if ((n == 0) || (n == 1))
    f = 1;
  else if (n > 1)
    f = n * Factorial(n - 1);
  return f;
}

