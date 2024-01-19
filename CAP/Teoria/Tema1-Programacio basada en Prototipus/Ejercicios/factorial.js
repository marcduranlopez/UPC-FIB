function factorial(n) {
    if (isFinite(n) && n>0 && n==Math.round(n)) {
    if (!(n in factorial))
    factorial[n] = n * factorial(n-1);
    return factorial[n];
    }
    else return NaN;
   }
   factorial[1] = 1;

   print(factorial(5))

